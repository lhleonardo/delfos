package br.com.estatistica.el;

public class NotResolvableFieldException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String fieldName;
	private Class<?> owner;

	public NotResolvableFieldException(String name, Class<?> owner) {
		this.fieldName = name;
		this.owner = owner;
	}

	@Override
	public String getMessage() {
		return "Field '" + this.fieldName + "' can't be resolved for class: " + this.owner.getCanonicalName() + ".";
	}

	public static NotResolvableFieldException create(Throwable stack, String name, Class<?> clazz) {
		NotResolvableFieldException ex = new NotResolvableFieldException(name, clazz);
		if (stack != null) {
			ex.setStackTrace(stack.getStackTrace());
		}
		return ex;
	}
}
