package collection;

public class List1 {
	private static final int INCREMENT_SIZE = 10; // rename
	private static final int INITIAL_SIZE = 10; // rename
	private Object[] elements = new Object[INITIAL_SIZE];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly) {
			return;
		} else { // add else block
			if (isStoreFull(size + 1)) {
				incrementElementsSize();
			}

			addElementAtEnd(element);
		}
	}

	private void addElementAtEnd(Object element) {
		elements[size] = element;
		size++;
	}

	private void incrementElementsSize() {
		Object[] newElements = new Object[elements.length + INCREMENT_SIZE];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
	}

	private boolean isStoreFull(int size) { // rename
		return size > elements.length;
	}
}
