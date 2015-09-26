package br.com.estatistica.el;

import java.util.HashMap;
import java.util.Map;

import br.com.estatistica.bean.DefaultFormatter;
import br.com.estatistica.bean.Formatter;
import br.com.estatistica.el.handler.FieldAccessHandler;
import br.com.estatistica.el.handler.FieldHandler;
import br.com.estatistica.reflec.ClassIntrospector;

/**
 * The class to access the field value.
 *
 * @author Marcos Vasconcelos
 */
public class FieldResolver {
	private String fieldName;// The field Name.
	private String name;// A name for this field column.
	private Formatter formatter;
	private FieldAccessHandler method;
	private Class<?> owner;
	private static Class<? extends FieldAccessHandler> defaultHandler;
	private static Class<? extends Formatter> defaultFormatter;

	static {
		defaultHandler = FieldHandler.class;
		defaultFormatter = DefaultFormatter.class;
	}

	public static void setDefaultHandler(Class<? extends FieldAccessHandler> handler) {
		if (handler == null) {
			throw new RuntimeException("Handler can not be null!");
		}
		defaultHandler = handler;
	}

	public static void setDefaultFormatter(Class<? extends Formatter> formatter) {
		if (formatter == null) {
			throw new RuntimeException("Formatter can not be null!");
		}
		defaultFormatter = formatter;
	}

	public FieldResolver(Class<?> clazz, String fieldName, String name) {
		this(clazz, fieldName, name, null);
	}

	public FieldResolver(Class<?> clazz, String fieldName) {
		this(clazz, fieldName, "", null);
	}

	public FieldResolver(Class<?> clazz, String fieldName, FieldAccessHandler handler) {
		this(clazz, fieldName, "", handler);
	}

	public FieldResolver(Class<?> clazz, String fieldName, String name, FieldAccessHandler handler) {
		if (handler == null) {
			try {
				handler = defaultHandler.newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		this.owner = clazz;

		this.fieldName = fieldName;
		this.name = name;

		this.method = handler;
		this.method.resolveField(clazz, fieldName);

		try {
			this.setFormatter(defaultFormatter.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FieldResolver setFormatter(Formatter formatter) {
		if (formatter == null) {
			throw new IllegalArgumentException("Formatter can't be null!");
		}
		this.formatter = formatter;
		return this;
	}

	public void setValue(Object t, Object value) {
		this.method.setValue(t, value, this.formatter);
	}

	public Object getValue(Object t) {
		return this.method.getValue(t, this.formatter);
	}

	public String getName() {
		return this.name;
	}

	public Class<?> getFieldType() {
		Class<?> clazz;
		if (this.formatter instanceof DefaultFormatter) {
			clazz = this.method.getFieldType();
		} else {
			ClassIntrospector instro = new ClassIntrospector(this.formatter.getClass());
			clazz = instro.getMethodReturnClass("format", Object.class);
		}
		if (clazz.isPrimitive()) {
			return primitiveWrapers.get(clazz);
		}
		return clazz;
	}

	public String getFieldName() {
		return this.fieldName;
	}

	public Class<?> getOwnerClass() {
		return this.owner;
	}

	public Formatter getFormatter() {
		return this.formatter;
	}

	public Class<?> getTraceClassAt(int idx) {
		return this.method.getTraceClassAt(idx);
	}

	private static final Map<Class<?>, Class<?>> primitiveWrapers;
	static {
		primitiveWrapers = new HashMap<Class<?>, Class<?>>();
		primitiveWrapers.put(char.class, Character.class);
		primitiveWrapers.put(byte.class, Byte.class);
		primitiveWrapers.put(short.class, Short.class);
		primitiveWrapers.put(int.class, Integer.class);
		primitiveWrapers.put(long.class, Long.class);
		primitiveWrapers.put(float.class, Float.class);
		primitiveWrapers.put(double.class, Double.class);
		primitiveWrapers.put(boolean.class, Boolean.class);
	}
}
