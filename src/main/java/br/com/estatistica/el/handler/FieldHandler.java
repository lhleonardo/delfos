package br.com.estatistica.el.handler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import br.com.estatistica.bean.Formatter;
import br.com.estatistica.el.NotResolvableFieldException;

public class FieldHandler implements FieldAccessHandler {
	private List<Class<?>> classesTrace;// A trace to the field
	private List<Field> fields;// The fields trace.

	public FieldHandler() {
		this.classesTrace = new ArrayList<Class<?>>();
		this.fields = new ArrayList<Field>();
	}

	@Override
	public void resolveField(Class<?> clazz, String expression) {
		if (clazz == null || expression == null) {
			throw new IllegalArgumentException("Arguments can't be null!");
		}
		this.classesTrace.add(clazz);
		String[] trace = expression.split("[.]");

		for (String element : trace) {
			this.addField(element);
		}
	}

	@Override
	public Object getValue(Object t, Formatter formatter) {
		if (t == null) {
			return null;
		}
		Object obj = null;
		try {
			obj = t;
			for (int i = 0; i < this.fields.size(); i++) {
				obj = this.fields.get(i).get(obj);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return formatter.format(obj);
	}

	@Override
	public void setValue(Object t, Object value, Formatter formatter) {
		if (t == null) {
			return;
		}
		Object obj = null;
		Field field = null;
		try {
			obj = t;
			int size = this.fields.size() - 1;
			if (size > -1) {
				for (int i = 0; i < size; i++) {
					obj = this.fields.get(i).get(obj);
				}
				field = this.fields.get(this.fields.size() - 1);
			} else {
				field = this.fields.get(0);
			}
			field.set(obj, formatter.parse(value));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private void addField(String fieldName) {
		Class<?> clazz = this.classesTrace.get(this.classesTrace.size() - 1);
		Field f = this.getAcessibleField(clazz, fieldName);
		this.classesTrace.add(f.getType());
		this.fields.add(f);
	}

	private Field getAcessibleField(Class<?> clazz, String fieldName) {
		Field f = null;
		try {
			f = clazz.getDeclaredField(fieldName);
		} catch (NoSuchFieldException e) {
			if (clazz.getSuperclass() == null) {
				NotResolvableFieldException ex = new NotResolvableFieldException(fieldName, clazz);
				ex.setStackTrace(e.getStackTrace());
				throw ex;
			}
			
			return this.getAcessibleField(clazz.getSuperclass(), fieldName);
		}
		f.setAccessible(true);
		return f;
	}

	@Override
	public Class<?> getFieldType() {
		return this.fields.get(this.fields.size() - 1).getType();
	}

	@Override
	public Class<?> getTraceClassAt(int idx) {
		return this.classesTrace.get(idx);
	}

	public Field getField() {
		return this.fields.get(this.fields.size() - 1);
	}

	public Field getField(int idx) {
		return this.fields.get(idx);
	}

	public int getFieldTraceSize() {
		return this.fields.size();
	}
}
