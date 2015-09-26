package br.com.estatistica.el.annotation;

import br.com.estatistica.el.FieldResolver;
import br.com.estatistica.el.handler.FieldAccessHandler;

/**
 * Class to get FieldResolver from the Resolvable annotation.
 *
 * @see com.towel.el.annotation.Resolvable
 * @author Marcos Vasconcelos
 */
public class AnnotationResolver {
	private Class<?> clazz;
	
	public AnnotationResolver(Class<?> clazz) {
		if (clazz == null) {
			throw new IllegalArgumentException("Class can't be null!");
		}
		this.clazz = clazz;
	}
	
	/**
	 * For each String of the given parameter are returned a FieldResolver.
	 *
	 * @param fieldNames
	 *            .
	 * @return The FieldResolvers for the given field names.
	 */
	public FieldResolver[] resolve(String... fieldNames) {
		FieldResolver resolvers[] = new FieldResolver[fieldNames.length];
		if (fieldNames.length == 0) {
			return resolvers;
		}
		
		for (int i = 0; i < fieldNames.length; i++) {
			try {
				String fieldN = fieldNames[i];
				String colName = "";
				int index = fieldN.lastIndexOf(":");
				if (index > -1) {
					colName = fieldN.substring(index + 1);
					fieldN = fieldN.substring(0, index);
				}
				if (fieldN.equals("blank")) {
					resolvers[i] = new FieldResolver(this.clazz, "", colName, new BlankHandler());
					continue;
				}
				if (fieldN.contains(".")) {
					resolvers[i] = this.resolve(fieldN, this.clazz, colName);
				} else {
					Field field = new ClassIntrospector(this.clazz).getField(fieldN);
					if (field.isAnnotationPresent(Resolvable.class)) {
						Resolvable resolvable = field.getAnnotation(Resolvable.class);
						
						resolvers[i] = this.resolve(resolvable, field.getName(), this.clazz, colName);
					} else {
						resolvers[i] = this.resolve(fieldN, this.clazz, colName);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return resolvers;
	}
	
	/**
	 * Give the field names in a one String value. Each name separated by
	 * commas(,) The same as resolve(arg.split("[,]"))
	 */
	public FieldResolver[] resolve(String arg) {
		return this.resolve(arg.split("[,]"));
	}
	
	/**
	 * Return the FieldResolver for the given field name.
	 */
	public FieldResolver resolveSingle(String arg) {
		return this.resolve(arg)[0];
	}
	
	private FieldResolver resolve(String fieldName, Class<?> clazz, String colname) throws InstantiationException, IllegalAccessException,
	        SecurityException, NoSuchFieldException {
		String fields[] = fieldName.split("[.]");
		
		Field last = new ClassIntrospector(clazz).getField(fields[0]);
		for (int i = 1; i < fields.length; i++) {
			last = last.getType().getDeclaredField(fields[i]);
		}
		
		FieldResolver resolver = null;
		Resolvable resolvable = last.getAnnotation(Resolvable.class);
		if (resolvable == null) {
			resolver = new FieldResolver(clazz, fieldName, (colname == null) ? "" : colname);
		} else {
			String colName = resolvable.colName();
			
			if (!colname.isEmpty()) {
				colName = colname;
			} else if (colName.isEmpty()) {
				colName = fieldName;
			} else {
				colName = fieldName.substring(0, fieldName.lastIndexOf(".")).concat(colName);
			}
			
			resolver = new FieldResolver(clazz, fieldName, colName, (FieldAccessHandler) resolvable.accessMethod().newInstance());
			resolver.setFormatter((Formatter) resolvable.formatter().newInstance());
		}
		return resolver;
	}
	
	private FieldResolver resolve(Resolvable resolvable, String fieldName, Class<?> clazz, String colname) throws InstantiationException,
	        IllegalAccessException {
		String colName = resolvable.colName();
		
		if (colName.isEmpty()) {
			if (colname.isEmpty()) {
				colName = fieldName;
			} else {
				colName = colname;
			}
		}
		
		FieldResolver resolver = new FieldResolver(clazz, fieldName, colName, (FieldAccessHandler) resolvable.accessMethod().newInstance());
		resolver.setFormatter((Formatter) resolvable.formatter().newInstance());
		return resolver;
	}
}
