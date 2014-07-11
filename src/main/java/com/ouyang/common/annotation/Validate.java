package com.ouyang.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ouyang.common.form.BaseForm;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Validate
{
	@SuppressWarnings("rawtypes")
	Class formClass();
	
	String errorPath() default "";
	
	String errrorMethod() default "";
}
