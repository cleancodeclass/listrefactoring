package collection;

public class List1 {
	private static final int INCREMENT_SIZE = 1;
	private static final int INCREMENT_STORE_SIZE = 10;
	private static final int INITIAL_STORE_SIZE = 10;
	private Object[] elements = new Object[INITIAL_STORE_SIZE];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly) {
			return;
		}
		
		if ( isStoreFull(size + INCREMENT_SIZE)) {
			incrementStoreSize();
		}
		addElementAtEnd(element);
	}

	private void addElementAtEnd(Object element) {
		elements[size] = element;
		size++;
	}

	private void incrementStoreSize() {
		Object[] newElements = new Object[elements.length + INCREMENT_STORE_SIZE];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}
		elements = newElements;
	}

	private boolean isStoreFull(int newSize) {
		return newSize > elements.length;
	}
}
