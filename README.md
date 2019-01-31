### Code Smell 찾아 보기
* Magic Number
  - 특수한 값을 가지는 숫자를 의미한다.
  - 변경될 가능성이 있으면 여러 곳을 고쳐야 할 수 있다.
  - 코드에서 어떻게 처리되고 있는지 알아내기 힘들다.
  - 상수선언 기능을 이용하여 가독성을 높이고 유지보수성을 향상시킨다.

* 부정형 코드 블럭
  - 부정형은 긍정형보다 이해하기 힘들다.

* 복잡한 if 조건문
  - if 조건문안의 내용이 복잡하다면 가독성 있는 함수로 추출하도록 한다.
  - 코드의 용도가 명확하게 드러나고 로직의 흐름을 이해하기 쉽다.
  
### 팀명 정하고 역할자 나누기
* 개발리더
  - 리팩토링 브랜치를 생성한다.
  - Pull Request에 대한 Merge를 수행한다.
  - 릴리즈를 생성한다.

* 개발자1
  - Feature 브랜치를 생성한다.
  - Pull Request를 생성한다.(개발자2를 Reviewer로 지정하고 개발리더를 Assigner로 할당한다.)
  - 개발자2가 생성한 Pull Request에 대하여 코드리뷰를 수행한다.

* 개발자2
  - Feature 브랜치를 생성한다.
  - Pull Request를 생성한다.(개발자1를 Reviewer로 지정하고 개발리더를 Assigner로 할당한다.)
  - 개발자1가 생성한 Pull Request에 대하여 코드리뷰를 수행한다.

### 리팩토링 수행하기
1. 개발리더는 리팩토링 브랜치를 생성합니다. 브랜치명은 팀명_refactoring_yyyymmdd로 작성하고 master 브랜치로부터 생성합니다.
![리팩토링 브랜치 생성하기](https://user-images.githubusercontent.com/8435910/51890613-d8978a80-23df-11e9-9b99-3cea2d79aa82.GIF)
2. 개발자1은 feature 브랜치를 생성합니다.
![feature 브랜치 생성하기](https://user-images.githubusercontent.com/8435910/51891076-5b6d1500-23e1-11e9-90c0-16676f87b897.GIF)
3. 개발자1은 로컬 리파지토리로 원격 Git을 clone합니다.
![Git Clone하기](https://user-images.githubusercontent.com/8435910/51891688-2eb9fd00-23e3-11e9-88e2-22213f2a4156.GIF)
![Git Clone하기](https://user-images.githubusercontent.com/8435910/51891694-31b4ed80-23e3-11e9-9c3e-bc8b595ae915.GIF)
![Git Clone하기](https://user-images.githubusercontent.com/8435910/51891697-34174780-23e3-11e9-8522-a3246a8e59b2.GIF)
4. 개발자1은 코드를 수정합니다.
<pre><code>
//변경전 코드
package collection;

public class List1 {
	private Object[] elements = new Object[10];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (!readOnly) {
			int newSize = size + 1;
			
			if ( newSize > elements.length) {
				Object[] newElements = new Object[elements.length + 10];
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
</code></pre>
<pre><code>
//변경후 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (!readOnly) {
			int newSize = size + 1;
			
			if ( newSize > elements.length) {
				Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
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
</code></pre>

5. 개발자1은 수정된 코드를 PUSH합니다.
이때 Commit Message를 잘 작성하도록 합니다.
![PUSH하기](https://user-images.githubusercontent.com/8435910/51955866-ce7d9680-2488-11e9-9929-b3c186bde492.GIF)

6. 개발자1은 변경된 코드를 반영하기 위하여 Pull Request를 생성합니다.(Feature 브랜치 -> refactoring 브랜치)
![Pull Request 생성](https://user-images.githubusercontent.com/8435910/51956017-65e2e980-2489-11e9-90db-32d03750282f.GIF)

7. 개발자1은 본문에 관련 이슈를 연결합니다.
관련이슈 : #1

8. 개발자1은 개발자 자가 점검을 실시합니다.
![selfcheck](https://user-images.githubusercontent.com/8435910/51969438-bf620d00-24b7-11e9-8df4-45e2acd0d295.GIF)

9. Reviewers로 개발자2를 지정하고 Assignees로 개발리더를 지정합니다.
![assign](https://user-images.githubusercontent.com/8435910/51969457-ce48bf80-24b7-11e9-9f8c-737d52594398.GIF)

10. 개발자2는 리뷰를 수행하고 개발리더는 그 결과를 확인하고 Merge 합니다.
리뷰가 수행되지 않으면 아래와 같이 Merge 버튼이 비활성화되어 Merge가 불가능합니다.
![needreview](https://user-images.githubusercontent.com/8435910/52025478-bc166200-2547-11e9-82a7-4e9c3f25d699.GIF)

리뷰어는 변경된 코드를 확인하여 리뷰의견을 입력하고 아래와 같이 리뷰 완료 처리합니다.
![comment](https://user-images.githubusercontent.com/8435910/52025648-84f48080-2548-11e9-8a45-755ec30f355a.GIF)

![completereview](https://user-images.githubusercontent.com/8435910/52025784-051ae600-2549-11e9-9ec3-b5421c7cdba2.GIF)


    


11. 다음 이슈들을 동일한 방법으로 순서대로 수행해 봅니다.

- 샘플_If문 부정형을 긍정형으로 변경 : 개발자2
<pre><code>
//변경전 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (!readOnly) {
			int newSize = size + 1;
			
			if ( newSize > elements.length) {
				Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
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
</code></pre>
<pre><code>
//변경후 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		int newSize = size + 1;
		if ( newSize > elements.length) {
			Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		}
		elements[size] = element;
		size++;
	}
}
</code></pre>

- 샘플_if문 안의 메소드 추출 : 개발자3
<pre><code>
//변경전 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		int newSize = size + 1;
		if ( newSize > elements.length) {
			Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		}
		elements[size] = element;
		size++;
	}
}
</code></pre>
<pre><code>
//변경후 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		if ( isElementStoreFull()) {
			Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		}
		elements[size] = element;
		size++;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elements.length;
	}
}
</code></pre>


- 샘플_If절 안의 로직 메소드 추출 : 개발자4


<pre><code>
//변경전 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		if ( isElementStoreFull()) {
			Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
			for (int i = 0; i < size; i++) {
				newElements[i] = elements[i];
			}

			elements = newElements;
		}
		elements[size] = element;
		size++;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elements.length;
	}
}
</code></pre>
<pre><code>
//변경후 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		if ( isElementStoreFull()) {
			increaseElementStore();
		}
		elements[size] = element;
		size++;
	}

	private void increaseElementStore() {
		Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elements.length;
	}
}
</code></pre>

12. 개발리더는 ReleaseCandidate_YYYYMMDD를 작성합니다.

13. Releace 버전에 대하여 테스트를 수행하던 중 결함이 발견되어 조치합니다.
    위와 같은 방법으로 Feature 브랜치를 생성하고 Refactoring 브랜치에 Merge 합니다.(개발자1 수행)
//변경전 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		if ( isElementStoreFull()) {
			increaseElementStore();
		}
		elements[size] = element;
		size++;
	}

	private void increaseElementStore() {
		Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elements.length;
	}
}
</code></pre>
<pre><code>
//변경후 코드
package collection;

public class List1 {
	private static final int STORE_SIZE_INCREMENT = 10;
	private Object[] elements = new Object[STORE_SIZE_INCREMENT];
	private boolean readOnly;
	private int size = 0;

	public void add(Object element) {
		if (readOnly)
			return;
		if ( isElementStoreFull()) {
			increaseElementStore();
		}
		addElementAtEnd(element);
	}

	private void addElementAtEnd(Object element) {
		elements[size] = element;
		size++;
	}

	private void increaseElementStore() {
		Object[] newElements = new Object[elements.length + STORE_SIZE_INCREMENT];
		for (int i = 0; i < size; i++) {
			newElements[i] = elements[i];
		}

		elements = newElements;
	}

	private boolean isElementStoreFull() {
		return size + 1 > elements.length;
	}
}
</code></pre>    

14. 개발리더는 Cherry Pick 기능을 이용하여 Release 브랜치에 해당 Commit을 반영합니다.

15. 개발리더는 Release를 생성합니다.

  

  
  


