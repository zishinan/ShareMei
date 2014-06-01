package com.ouyang.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Db2Java
{
	private Properties properties;
	public Db2Java()
	{
		properties = new Properties();
		try
		{
			properties.load(Db2Java.class.getClassLoader().getResourceAsStream("db.properties"));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Db2Java db2Java = new Db2Java();
		db2Java.creatEntry("Person");
	}
	
	private void creatEntry(String name)
	{
		String proPath = System.getProperty("user.dir") + "\\src\\main\\java";
		proPath = proPath.replaceAll("\\\\", "\\\\\\\\");
		File file = new File(proPath + "/com/ouyang/entry");
		file.mkdirs();
		try
		{
			File.createTempFile(name, ".java", file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
