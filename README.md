
### Centralized VC vs. Distributed VC
![gitfeature](https://user-images.githubusercontent.com/8435910/52028522-ad817800-2552-11e9-8877-c4b91ab2bfd7.GIF)


### Git �귣ġ
![gitbranch](https://user-images.githubusercontent.com/8435910/52028327-f38a0c00-2551-11e9-9458-88961fb5c024.png)

### ������ ��
* Commit �ۼ�
  - Commit�� ���� ��� ������ ����
  - �ڵ帮�並 ����Ͽ� 200LOC ���Ϸ� �ۼ�(10�� �̸��� ����)
  - �ۼ����
   ���� : ���������� �� �ٷ� ���
   ���� : �� ���� ��� ���� ���뿡 ���� ���ذ� ������ �ۼ�
* �ڵ帮��
  - �ذ��ȿ� ���� ��ü���� ���̵�
  - �Ƴ����� Ī��
  - ������ �ڵ忡 ���Ͽ��� ���� ����
 
�� Google�� ���  �ϳ��� PR�� 2���� ���� �����ϰ� �ڵ� ���� ���� 4�ð� �̳��� ���並 ������ 24�ð� �̳��� Merge�� �ϰ� PR�� 7���� Commit�� 10�� �̸��� ����, ��� 12.5���� ���� Comment�� �ۼ��Ѵٰ� �մϴ�.

### ������Ʈ�� �̽� �������ϱ�
* �Ϲ������� ������ ���� ��Ȳ���� �̽��� �ۼ��մϴ�:
  - ������ �ذ��� �� ���� ����
  - ���� ������ ���� �Ǵ� ���̵�� (����. Ŀ�´�Ƽ, ����, ��å) ���
  - ���ο� ����̳� �ٸ� ������Ʈ ���̵�� ����

* �ذ��Ϸ��� �̽��� ���������� ���̸�,
  - �ߺ����� �۾��� ���ɼ��� ���̱� ���� ���� ���� �̽��� �������� ���� �ش�Ǵ� �̽����� �ǰ��� ����.
  - �̽��� ���� ���� ���ȴٸ�, �ٸ� ������ �ذ�Ǿ��ų�, �̹� �ذ�Ǿ��� �� �ֱ� ������ �ش��̽��� ���� �۾��� �����ϱ� ���� Ȯ���� ��û.
  - �̽��� �������� ���߿� ����� �˾� �� ���, ����鿡�� �˸��� �̽��� �ذ��� �� �ֵ��� �̽��� ���� �ǰ��� ���Ͻʽÿ�.

* ����
- [Creating a issue template](http://help.github.com/en/articles/manually-creating-a-single-issue-template-for-your-repository)  
- [Collaborating with issues and pull requests](http://help.github.com/en/categories/collaborating-with-issues-and-pull-requests)

### Pull Request Ȱ���ϱ�
* pull request ����
- ����� ���� ���� ���� (�� : ��Ÿ, ���� ��ũ �Ǵ� �и��� ����)
- �̹� �̽��� �����ų� �̹� ������ ������ �⿩�� �����ϱ�  

pull request�� �Ϸ�� �۾��� ��Ÿ���� �ʾƵ� �˴ϴ�. �Ϲ������� �ʱ⿡ pull request�� ���� �ٸ� ����� ���� ��Ȳ�� ���ų� �ǵ���� �� �� �ֽ��ϴ�.  
���� �ٿ� ��WIP��(�������� �۾�)�̶�� ǥ���Ͻʽÿ�. ���߿� Ŀ���� �� �߰� �� �� �ֽ��ϴ�.

* pull request ���
1. ����Ҹ� ��ũ�ϰ� ���ÿ� Ŭ���մϴ�. 
1. ������ ���� �귣ġ �����ϱ�.
1. ��� �����ִ� �̽� Ȥ�� PR���� �������� ���� �����ϱ� (ex. ��close #37��)
1. ������ ��ũ�� �� �����մϴ�.
1. �������� �׽�Ʈ�մϴ�! 
1. ����� �ɷ��� �ִ��� �����Ͽ� ������Ʈ ��Ÿ�Ͽ� �⿩�Ͻʽÿ�. 

* ����
- [Creating a pull request template](http://help.github.com/en/articles/creating-a-pull-request-template-for-your-repository)
- [Fork a repo](http://help.github.com/en/articles/fork-a-repo)  

### ����
- [About pull request reviews](http://help.github.com/en/articles/about-pull-request-reviews)

### [Git Ȱ�� Tips](git-tip.md)

- [Code Review on GitHub](https://www.youtube.com/watch?v=HW0RPaJqm4g)
- [About pull request reviews](https://help.github.com/en/articles/about-pull-request-reviews)
- [Write better code](https://github.com/features/code-review/)

### Code Smell ã�� ����

<pre><code>
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




* Magic Number
  - Ư�� ���ڰ� ������·� ���ǵǾ� �ִ� �ڵ带 �ǹ��Ѵ�.
  - ����� ���ɼ��� ������ ���� ���� ���ľ� �� �� �ִ�.
  - �ڵ忡�� ��� ó���ǰ� �ִ��� �˾Ƴ��� �����.
  - ������� ����� �̿��Ͽ� �������� ���̰� ������������ ����Ų��.

* ������ �ڵ� ��
  - �������� ���������� �����ϱ� �����.

* ������ if ���ǹ�
  - if ���ǹ����� ������ �����ϴٸ� ������ �ִ� �Լ��� �����ϵ��� �Ѵ�.
  - �ڵ��� �뵵�� ��Ȯ�ϰ� �巯���� ������ �帧�� �����ϱ� ����.

* ������ if ��
  - if ������ ������ �����ϴٸ� ������ �ִ� �Լ��� �����ϵ��� �Ѵ�.
  - �ڵ��� �뵵�� ��Ȯ�ϰ� �巯���� ������ �帧�� �����ϱ� ����.

* ������ if �� ���� ����
  - if �� ���� ������ ������ �����ϴٸ� ������ �ִ� �Լ��� �����ϵ��� �Ѵ�.
  - �ڵ��� �뵵�� ��Ȯ�ϰ� �巯���� ������ �帧�� �����ϱ� ����.

### ���� ���ϰ� ������ ������
* ���߸���
  - �����丵 �귣ġ�� �����Ѵ�.
  - Pull Request�� ���� Merge�� �����Ѵ�.
  - ������ �귣ġ�� �����Ѵ�.
  - ������ �������� Cherry-pick�� �����Ѵ�.
  - ������ ���� ����� �����Ѵ�.

* ������
  - Fork�� �����Ѵ�.
  - Feature �귣ġ�� �����Ѵ�.
  - Pull Request�� �����Ѵ�.(�ٸ� �����ڸ� Reviewer�� �����ϰ� ���߸����� Assigner�� �Ҵ��Ѵ�.)

* �����
  - �����ڰ� ������ Pull Request�� ���Ͽ� �ڵ帮�並 �����Ѵ�.
  
  
  
  
  
  

### [����]�����丵 �����ϱ�
1. ���߸����� �����丵 �귣ġ�� �����մϴ�. �귣ġ���� ����_refactoring_yyyymmdd�� �ۼ��ϰ� master �귣ġ�κ��� �����մϴ�.
![�����丵 �귣ġ �����ϱ�](https://user-images.githubusercontent.com/8435910/51890613-d8978a80-23df-11e9-9b99-3cea2d79aa82.GIF)
2. ������1�� feature �귣ġ�� �����մϴ�.
![feature �귣ġ �����ϱ�](https://user-images.githubusercontent.com/8435910/51891076-5b6d1500-23e1-11e9-90c0-16676f87b897.GIF)
3. ������1�� ���� �������丮�� ���� Git�� clone�մϴ�.
![Git Clone�ϱ�](https://user-images.githubusercontent.com/8435910/51891688-2eb9fd00-23e3-11e9-88e2-22213f2a4156.GIF)
![Git Clone�ϱ�](https://user-images.githubusercontent.com/8435910/51891694-31b4ed80-23e3-11e9-9c3e-bc8b595ae915.GIF)
![Git Clone�ϱ�](https://user-images.githubusercontent.com/8435910/51891697-34174780-23e3-11e9-8522-a3246a8e59b2.GIF)
4. ������1�� �ڵ带 �����մϴ�.
<pre><code>
//������ �ڵ�
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
//������ �ڵ�
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

5. ������1�� ������ �ڵ带 PUSH�մϴ�.
�̶� Commit Message�� �� �ۼ��ϵ��� �մϴ�.
![PUSH�ϱ�](https://user-images.githubusercontent.com/8435910/51955866-ce7d9680-2488-11e9-9929-b3c186bde492.GIF)

6. ������1�� ����� �ڵ带 �ݿ��ϱ� ���Ͽ� Pull Request�� �����մϴ�.(Feature �귣ġ -> refactoring �귣ġ)
![Pull Request ����](https://user-images.githubusercontent.com/8435910/51956017-65e2e980-2489-11e9-90db-32d03750282f.GIF)

7. ������1�� ������ ���� �̽��� �����մϴ�.
�����̽� : #1

8. ������1�� ������ �ڰ� ������ �ǽ��մϴ�.
![selfcheck](https://user-images.githubusercontent.com/8435910/51969438-bf620d00-24b7-11e9-8df4-45e2acd0d295.GIF)

9. Reviewers�� ������2�� �����ϰ� Assignees�� ���߸����� �����մϴ�.
![assign](https://user-images.githubusercontent.com/8435910/51969457-ce48bf80-24b7-11e9-9f8c-737d52594398.GIF)

10. ������2�� ���並 �����ϰ� ���߸����� �� ����� Ȯ���ϰ� Merge �մϴ�.
���䰡 ������� ������ �Ʒ��� ���� Merge ��ư�� ��Ȱ��ȭ�Ǿ� Merge�� �Ұ����մϴ�.
![needreview](https://user-images.githubusercontent.com/8435910/52025478-bc166200-2547-11e9-82a7-4e9c3f25d699.GIF)

������ ����� �ڵ带 Ȯ���Ͽ� �����ǰ��� �Է��ϰ� �Ʒ��� ���� ���� �Ϸ� ó���մϴ�.
![comment](https://user-images.githubusercontent.com/8435910/52025648-84f48080-2548-11e9-8a45-755ec30f355a.GIF)

![completereview](https://user-images.githubusercontent.com/8435910/52025784-051ae600-2549-11e9-9ec3-b5421c7cdba2.GIF)


    


11. ���� �̽����� ������ ������� ������� ������ ���ϴ�.

- ����_If�� �������� ���������� ���� : ������2
<pre><code>
//������ �ڵ�
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
//������ �ڵ�
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

- ����_if�� ���� �޼ҵ� ���� : ������1
<pre><code>
//������ �ڵ�
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
//������ �ڵ�
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


- ����_If�� ���� ���� �޼ҵ� ���� : ������2


<pre><code>
//������ �ڵ�
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
//������ �ڵ�
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

12. ���߸����� Release �귣ġ�� Refactoring �귣ġ�� ������� �����մϴ�.(�귣ġ�� : ����_release_yyyymmdd)

13. Releace ������ ���Ͽ� �׽�Ʈ�� �����ϴ� �� ������ �߰ߵǾ� ��ġ�մϴ�.
    ���� ���� ������� Feature �귣ġ�� �����ϰ� Refactoring �귣ġ�� Merge �մϴ�.(������1 ����)
    
    

<pre><code>
//������ �ڵ�
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
//������ �ڵ�
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

14. ���߸����� ���ÿ��� Chetty Pick ����� �̿��Ͽ� ����� Commit�� Release ������ �ݿ��մϴ�.
    �귣ġ id�� Ŀ�ǵ忡�� ������ɾ �����Ͽ� Ȯ��
    git log --pretty=oneline
<pre><code>
D:\git\listrefactoring>git checkout ����_release_20190201
Switched to a new branch '����_release_20190201'
Branch '����_release_20190201' set up to track remote branch '����_release_20190201' from 'origin'.

D:\git\listrefactoring>git cherry-pick  59eac16
[����_release_20190201 43ffa86] extract method
 Author: Pablo <dongsik2026@naver.com>
 Date: Thu Jan 31 12:42:56 2019 +0900
 1 file changed, 21 insertions(+), 12 deletions(-)
 
 D:\git\listrefactoring>git push
</code></pre>    
 
15. ���߸����� Release���� ���ο� ������ ������ �����մϴ�.
![createrelease](https://user-images.githubusercontent.com/8435910/52030182-f557cd80-2559-11e9-8054-358f9ec02bfd.GIF)
������ ���� ���� �ݿ� ������ Ȯ�ε˴ϴ�.
![releasecomplete](https://user-images.githubusercontent.com/8435910/52030233-3fd94a00-255a-11e9-92da-bd4dab05889a.GIF)
