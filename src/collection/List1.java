package collection;

public class List1 {
	private static final int INCREMENT_STORE_SIZE = 10;
	private static final int INITAL_STORE_SIZE = 10;
	
	private Object[] elements = new Object[INITAL_STORE_SIZE];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (!readOnly) {
			int newSize = size + 1;
			
			if ( newSize > elements.length) {
				Object[] newElements = new Object[elements.length + INCREMENT_STORE_SIZE];
				for (int i = 0; i < size; i++) {
					newElements[i] = elements[i];
				}

				elements = newElements;
			}

			elements[size] = element;
			size++;
		}
	}
}
