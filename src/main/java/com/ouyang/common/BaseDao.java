package com.ouyang.common;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.ouyang.util.DBUtil;

public class BaseDao
{
	QueryRunner queryRunner = new QueryRunner(DBUtil.getDataSoure());
	public BaseDao()
	{
		super();
	}

	/**
	 * 调用queryrunner的query方法执行select语句并捕获异常
	 * @param sql
	 * @param rsh
	 * @param params
	 * @return
	 */
	protected <T> T query(String sql, ResultSetHandler<T> rsh, Object... params)
	{
		try
		{
			return queryRunner.query(sql, rsh, params);
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 调用queryrunner的update方法执行insert update delete语句并捕获异常
	 * @param sql
	 * @param params
	 * @return
	 */
	protected boolean update(String sql, Object... params)
	{
		try
		{
			int n = queryRunner.update(sql,params);
			if(n > 0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}
	

}