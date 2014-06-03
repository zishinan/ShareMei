package com.ouyang.common.exception;

public class LogicException extends Exception
{
	private static final long serialVersionUID = 4954249949684215251L;

	public LogicException()
	{
		super("业务逻辑异常");
	}
	
	public LogicException(String message)
	{
		super(message);
	}
}
