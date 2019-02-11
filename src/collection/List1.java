package collection;

public class List1 {
	
	private Object[] elements = new Object[10];
	private boolean readOnly;
	private int size = 0;
	private static final int STORE_SIZE_INCREMENT = 10;

	public void add(Object element) {
		if (readOnly){
			return;
		}
		
		int newSize = size + 1;
			
		if ( newSize > elements.length) {
			Object[] newElements = new Object[elements.length +  STORE_SIZE_INCREMENT ];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		}

		elements[size] = element;
		size++;
	}
}
