package com.ouyang.common;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.beanutils.converters.StringConverter;
import org.apache.log4j.Logger;

@WebListener
public class InitServletContextListener implements ServletContextListener
{
	private static final Logger log = Logger.getLogger(InitServletContextListener.class);
	@Override
	public void contextDestroyed(ServletContextEvent paramServletContextEvent)
	{
		
	}

	@Override
	public void contextInitialized(ServletContextEvent paramServletContextEvent)
	{
		IntegerConverter integerConverter = new IntegerConverter(null);
		ConvertUtils.register(integerConverter, Integer.class);
		StringConverter stringConverter = new StringConverter(null);
		ConvertUtils.register(stringConverter, String.class);
		LongConverter longConverter = new LongConverter(null);
		ConvertUtils.register(longConverter, Long.class);
		DateConverter dateConverter = new DateConverter(null);
		ConvertUtils.register(dateConverter, Date.class);
		
		log.debug("注册监听器成功！");
	}

}
