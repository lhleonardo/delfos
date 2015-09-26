package br.com.estatistica.el.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.estatistica.bean.DefaultFormatter;
import br.com.estatistica.el.handler.FieldHandler;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Resolvable {
	public String colName() default "";

	public Class<?> formatter() default DefaultFormatter.class;

	public Class<?> accessMethod() default FieldHandler.class;
}
