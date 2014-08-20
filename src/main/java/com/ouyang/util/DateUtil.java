package com.ouyang.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil
{
	/**
	 * 格式化日期为String型： yyyy-MM-dd HH:mm:ss
	 * 
	 * @author 阳熙
	 * @param inTime
	 * @return
	 */
	public static String getStringDateTime(Object inTime)
	{
		if (inTime instanceof String)
		{
			inTime = getDateTime((String) inTime);
		}
		SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String outTime = dfTime.format(inTime);
		return outTime;
	}

	/**
	 * 格式化日期为String型： yyyy-MM-dd
	 * 
	 * @author 阳熙
	 * @param inTime
	 * @return
	 */
	public static String getStringDate(Object inTime)
	{
		if (inTime instanceof String)
		{
			inTime = getDateTime((String) inTime);
		}
		SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd");
		String outTime = dfTime.format(inTime);
		return outTime;
	}

	/**
	 * 根据字符串得到yyyy-MM-dd HH:mm:ss格式日期
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date getDateTime(String dateString)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try
		{
			date = df.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到yyyy-MM-dd HH:mm:ss格式日期
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date getDateTime(Object dateTime)
	{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try
		{
			date = df.parse(getStringDateTime(dateTime));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 根据字符串得到yyyy-MM-dd格式日期
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date getDate(String dateString)
	{
		DateFormat dd = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try
		{
			date = dd.parse(dateString);
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 得到指定日期的星期几
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeek(Date date)
	{
		// SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		// String week = sdf.format(date);
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 得到指定日期是当月第几日
	 * 
	 * @author 阳熙
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 将String日期转化为Long型，精确到毫秒值，如果转换失败，则为-1；
	 * 
	 * @param stringDate
	 * @return
	 */
	public static Long getLongDate(String stringDate)
	{
		SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Long longDate = -1L;
		try
		{
			longDate = dfTime.parse(stringDate).getTime();
		}
		catch (ParseException e)
		{
			System.out.println("转换日期格式出错！");
			e.printStackTrace();
		}
		return longDate;
	}

	/**
	 * @param n
	 * @return 当前日期的后n天
	 */
	public static String afterNowDay(int n)
	{
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		c.add(Calendar.DATE, n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * @param n
	 * @return 当前日期的前n天
	 */
	public static String beforNowDay(int n)
	{
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		c.setTime(new Date());
		c.add(Calendar.DATE, -n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 获得指定时间date前n天日期
	 * 
	 * @author 阳熙
	 * @param n
	 * @return
	 */
	public static String beforTheDay(String date, int n)
	{
		Calendar c = Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date tdate = null;
		try
		{
			tdate = df.parse(date);
		}
		catch (ParseException e)
		{
			System.out.println("异常信息：" + "转换时间异常！");
			e.printStackTrace();
		}
		c.setTime(tdate);
		c.add(Calendar.DATE, -n);
		Date d2 = c.getTime();
		String s = df.format(d2);
		return s;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @author 阳熙
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try
		{
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
		}
		catch (ParseException e)
		{
			System.out.println("异常信息：" + "解析为时间失败");
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 字符串的日期格式的计算相差的天数
	 * 
	 * @author 阳熙
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(String smdate, String bdate)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		try
		{
			cal1.setTime(sdf.parse(smdate));
			cal2.setTime(sdf.parse(bdate));
		}
		catch (ParseException e)
		{
			System.out.println("异常信息：" + "解析为时间失败");
			e.printStackTrace();
		}
		long time1 = cal1.getTimeInMillis();
		long time2 = cal2.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

}
