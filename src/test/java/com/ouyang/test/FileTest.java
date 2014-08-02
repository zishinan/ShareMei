package com.ouyang.test;

import java.io.File;

import org.apache.commons.io.FileUtils;

public class FileTest
{
	@org.junit.Test
	public void testName() throws Exception
	{
		String s = FileUtils.getUserDirectoryPath();
		
		System.out.println(s);
		
		File file = FileUtils.getUserDirectory();
		
		System.out.println(file);
		
		System.out.println(FileUtils.getTempDirectoryPath());
		
		
		
	}
}
