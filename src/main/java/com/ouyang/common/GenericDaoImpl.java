package com.ouyang.common;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;

public class GenericDaoImpl<T> extends BaseDao implements GenericDao<T>
{
	private Class<T> clazz = null;
	
	public GenericDaoImpl()
	{
		//获取子类的对象对应的Class
		Class<? extends GenericDaoImpl> claz = this.getClass();
		//获取泛型化的父类的
		ParameterizedType parameterizedType =  (ParameterizedType) claz.getGenericSuperclass();
		Type[] types = parameterizedType.getActualTypeArguments();
		clazz = (Class<T>) types[0];
	}
	
	/**
	 * 获取对应类型的表名
	 * @return
	 */
	private String getTable()
	{
		return this.clazz.getSimpleName().toLowerCase();
	}
	@Override
	public boolean add(T t)
	{
		StringBuilder insertSql = new StringBuilder("insert into ").append(getTable()).append("(");
		StringBuilder valueSql = new StringBuilder(" values(");
		List<Object> params = new LinkedList<>();
		
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : propertyDescriptors)
			{
				String propertyName = pd.getName();
				if("id".equals(propertyName))
				{
					continue;
				}
				Method getterMethod = pd.getReadMethod();
				Object value = getterMethod.invoke(t);
				
				Class<?> propertyType = pd.getPropertyType();
				if(propertyType.isAnnotationPresent(Entry.class))
				{
					propertyName = propertyName + "_id";
					value = MethodUtils.invokeMethod(value, "getId");
				}
				
				insertSql.append(propertyName).append(",");
				valueSql.append("?,");
				
				params.add(value);
			}
			insertSql.setCharAt(insertSql.length() - 1, ')');
			valueSql.setCharAt(valueSql.length() - 1, ')');
			
		}
		catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		
		String sql = insertSql.append(valueSql.toString()).toString();
		
		return update(sql, params.toArray());
	}

	@Override
	public boolean delete(Long id)
	{
		String sql = "delete from "+getTable()+" where id = ?";
		return update(sql, id);
	}

	@Override
	public boolean update(T t)
	{
		StringBuilder sql = new StringBuilder("update ").append(getTable()).append(" set ");
		
		List<Object> params = new LinkedList<>();
		
		try
		{
			BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
			PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (PropertyDescriptor pd : propertyDescriptors)
			{
				String propertyName = pd.getName();
				if("id".equals(propertyName))
				{
					continue;
				}
				Method getterMethod = pd.getReadMethod();
				Object value = getterMethod.invoke(t);
				
				Class<?> propertyType = pd.getPropertyType();
				if(propertyType.isAnnotationPresent(Entry.class))
				{
					propertyName = propertyName + "_id";
					value = MethodUtils.invokeMethod(value, "getId");
				}
				sql.append(propertyName).append("=?,");
				
				params.add(value);
			}
			sql.deleteCharAt(sql.length() - 1).append(" where id = ?");
			params.add(MethodUtils.invokeMethod(t, "getId"));
			
		}
		catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException e)
		{
			e.printStackTrace();
		}
		
		return update(sql.toString(), params.toArray());
	}

	@Override
	public T getById(Long id)
	{
		String sql = "select * from "+getTable()+" where id = ?";
		List<T> list = query(sql, new MyBeanListHandler<T>(this.clazz), id);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<T> listQuery(String condition,Object[] params, Integer start, Integer max)
	{
		StringBuilder sql = new StringBuilder("select * from ").append(getTable());
		if(StringUtils.isNotBlank(condition))
		{
			sql.append(" where ").append(condition);
		}
				
		if(start != null && max != null && start >= 0 && max > 0)
		{
			sql.append(" limit ?,?");
			params = ArrayUtils.add(params, start);
			params = ArrayUtils.add(params, max);
		}
		return query(sql.toString(), new MyBeanListHandler<T>(this.clazz), params);
	}
	
	class MyBeanListHandler<T> implements ResultSetHandler<List<T>>
	{
		private Class<T> clz;

		public MyBeanListHandler(Class<T> clazz)
		{
			super();
			this.clz = clazz;
		}

		@Override
		public List<T> handle(ResultSet rs) throws SQLException
		{
			List<T> list = new LinkedList<>();
			while (rs.next())
			{
				try
				{
					T t = this.clz.newInstance();
					BeanInfo beanInfo = Introspector.getBeanInfo(this.clz,Object.class);
					PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
					
					Map<String, Object> map = new HashMap<String, Object>();
					for (PropertyDescriptor pd : descriptors)
					{
						String propertyName = pd.getName();
						Class<?> propertyType = pd.getPropertyType();
						if(propertyType.isAnnotationPresent(Entry.class))
						{
							propertyName = propertyName + "_id";
						}
						Object value = rs.getObject(propertyName);
						if(propertyType.isAnnotationPresent(Entry.class))
						{
							value = getObject(value,propertyType);
						}
						map.put(pd.getName(), value);
						
					}
					BeanUtils.copyProperties(t, map);
					list.add(t);
					
				}
				catch (InstantiationException | IllegalAccessException | IntrospectionException | InvocationTargetException e)
				{
					e.printStackTrace();
				}
				
				
			}
			return list;
		}
		
	}

	public Object getObject(Object id, Class propertyType)
	{
		StringBuilder sql = new StringBuilder("select * from ").append(propertyType.getSimpleName().toLowerCase()).append(" where id = ?");
		List<Object> list = query(sql.toString(),new MyBeanListHandler(propertyType), id);
		if(list != null && list.size() > 0)
		{
			return list.get(0);
		}
		return null;
	}
	
}
