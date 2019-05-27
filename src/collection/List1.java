package collection;

public class List1 {
	private static final int INCRESE_10 = 10; //magic number
	private static final int INIT_10 = 10; //magic number
	private Object[] elements = new Object[INIT_10];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		
		int newSize = size + 1;
		if ( newSize > elements.length) {
			Object[] newElements = new Object[elements.length + INCRESE_10];
			extracted(newElements);
		}
		elements[size] = element;
		size++;
	}

	private void extracted(Object[] newElements) {
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
	}
}
