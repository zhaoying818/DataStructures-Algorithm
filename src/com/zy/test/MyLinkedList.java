package com.zy.test;
public class MyLinkedList {
	
	Node head = null;  //����ͷ������
	/**
	 * �������в�������
	 * @param d�� �������ݵ�����
	 */
	public void addNode(int d){
		Node newNode = new Node(d);
		if(head == null){
			head = newNode;
			return;
		}
		Node tmp = head;
		while(tmp.next != null){
			tmp= tmp.next;
		}
		//add node to the end
		tmp.next = newNode;
	}
	
	/**
	 * ɾ����index�ڵ�
	 * @param index ����Ҫ��ɾ���Ľڵ�
	 * @return �� �ɹ�����true��ʧ�ܷ���false
	 */
	public Boolean deleteNode(int index){
		//ɾ��Ԫ�ص�λ�ò�����
		if(index<1 || index>length()){
			return false;
		}
		//ɾ�������һ��Ԫ��
		if(index==1){
			head= head.next;
			return true;
		}
		int i=1;
		Node preNode = head;
		Node curNode = preNode.next;
		while(curNode!=null){
			if(i==index){
				preNode.next= curNode.next;
				return true;
			}
			preNode = curNode;
			curNode = curNode.next;
			i++;
		}
		return true;
	}
	
	/**
	 * @return ���ؽڵ�ĳ���
	 */
	public int length(){
		int length = 0;
		Node tmp = head;
		while(tmp != null){
			length++;
			tmp = tmp.next;
		}
		return length;
	}
	
	/**
	 * �����������������
	 * @return ����������ͷ���
	 */
	public Node orderList()
	{
		Node nextNode = null;
		int temp = 0;
		Node curNode = head;
		while(curNode.next != null){
			nextNode = curNode.next;
			while(nextNode != null){
				if(curNode.data>nextNode.data){
					temp = curNode.data;
					curNode.data = nextNode.data;
					nextNode.data = temp;
				}
				nextNode = nextNode.next;
			}
			curNode = curNode.next;
		}
		return head;
	}
	
	/**
	 * ��ӡ����
	 */
	public void printList(){
		Node tmp = head;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	/**
	 * ͨ��˫��ѭ������ɾ���������ظ�������
	 * @param head : �����ͷ��� 
	 */
	public void deleDuplecate(Node head){
		Node p = head;
		while(p!=head){
			Node q = p;
			while(q.next!=null){
				if(p.data==q.next.data){
					q.next = q.next.next;
				}
				else
					q = q.next;
			}
			p = p.next;
		}
	}
	
	/**
	 * ���ҵ������еĵ�����K��Ԫ��
	 * ��������ָ�룬һ�����ƶ�k-1����Ȼ��ͬʱ�ƶ���֪����ǰ�ƶ���Ϊ��(null)
	 * @param head
	 * @param k
	 * @return
	 */
	public Node findElem(Node head, int k){
		if(k<1 || k>this.length())
			return null;
		Node p1 = head;
		Node p2 = head;
		for(int i = 0;i<k-1;i++)//ǰ��k-1��
			p1 = p1.next;
		while(p1!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	/**
	 * �ǵݹ鷽��ʵ������ķ�ת
	 */
	public void ReverseIteratively(Node head){
		Node pReverseHead = head;
		Node pNode = head;
		Node pPrev = null;
		while(pNode != null){
			Node pNext = pNode.next;
			if(pNext==null)
				pReverseHead = pNode;
			pNode.next = pPrev;
			pPrev = pNode;
			pNode = pNext;
		}
		this.head = pReverseHead;
	}
	
	/**
	 * ���õݹ鷽��ʵ�ַ��������������β��ͷ��
	 * ������ÿ�η��ʵ�һ���ڵ㣬�صݹ����������Ľ�㣬������ý������
	 * @param pListHead: ͷ���
	 */
	public void printListReversely(Node pListHead){
		if(pListHead!=null){
			printListReversely(pListHead.next);
			System.out.println(pListHead.data);
		}
	}
	
	/**
	 *  ���ҵ������м���
	 *  ��������ָ�룬ͬʱ������һ������Ϊ1��һ������Ϊ2
	 */
	public Node SearchMidNode(Node head){
		Node p1 = this.head;
		Node p2 = this.head;
		while(p2!=null && p2.next!=null && p2.next.next!=null){
			p1 = p1.next;
			p2= p2.next.next;
		}
		return p1;
	}
	
	/**
	 * ���һ�������Ƿ��л�
	 * @param head
	 * @return
	 */
	public boolean isLoop(Node head){
		Node fast = head;
		Node slow = head;
		if(fast==null){
			return false;
		}
		while(fast!=null && fast.next!=null){
			fast = fast.next.next;
			slow = slow.next;
			if(fast==slow){
				return true;
			}
		}
		return !(fast==null || fast.next==null);
	}
	//���������ڻ����ҵ�������ڵ�
	public Node findLoopPort(Node head){
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow==fast)
				break;
		}
		if(fast==null ||fast.next==null)
			return null;
		slow = head;
		while(slow!=fast){
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
	
	/**
	 * ��֪��ͷ���������ɾ��ָ�����
	 * @param n:Ҫɾ���Ľ��
	 * @return: ɾ���ɹ�������true�����򣬷���false
	 */
	public boolean deleteNode(Node n){
		if(n==null || n.next==null)
			return false;
		int tmp = n.data;
		n.data = n.next.data;
		n.next.data = tmp;
		n.next = n.next.next;
		return true;
	}
	
	/**
	 * ����ж����������Ƿ��ཻ
	 * @param h1:����h1�Ľ��
	 * @param h2:����h2�Ľ��
	 * @return:�ཻ������true
	 */
	public boolean isIntersect(Node h1, Node h2){
		if(h1==null || h2==null)
			return false;
		Node tail1 = h1;
		//�ҵ�����h1��β���
		while(tail1.next!=null)
			tail1 = tail1.next;
		Node tail2 = h2;
		//�ҵ�����h2��β���
		while(tail2.next!=null){
			tail2 = tail2.next;
		}
		return tail1 == tail2;
	}
	/**
	 * �����������ཻ���ҳ������ཻ�ĵ�һ�����
	 */
	public static Node getFirstMeetNode(Node h1, Node h2 ){
		if(h1==null || h2==null)
			return null;
		Node tail1 = h1;
		int len1 = 1;
		//�ҵ�����h1��β���
		while(tail1.next!=null){
			tail1 = tail1.next;
			len1++;
		}
		Node tail2 = h2;
		int len2 = 1;
		//��������h2��β���
		while(tail2.next!=null){
			tail2 = tail2.next;
			len2++;
		}
		//�������뽻
		if(tail1!=tail2)
			return null;
		Node t1 = h1;
		Node t2 = h2;
		//�ҳ��ϳ��������ȱ���
		if(len1>len2){
			int d = len1-len2;
			while(d!=0){
				t1 = t1.next;
				d--;
			}
		}
		else{
			int d = len2-len1;
			while(d!=0){
				t2 = t2.next;
				d--;
			}
		}
		while(t1!=t2){
			t1 = t1.next;
			t2 = t2.next;
		}
		return t1;
		
	}
	
	
	

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		list.addNode(5);
		list.addNode(3);
		list.addNode(1);
		list.addNode(5);
		System.out.println("ListLen=" + list.length());
		System.out.println("Before order:");
		list.printList();
		list.orderList();
		System.out.println("After order:");
		list.printList();
		list.deleteNode(3);
		System.out.println("delete a Node:");
		list.printList();

	}
		
}
/**
 * ������Ľڵ�
 */
class Node {
	Node next = null;
	int data;
	public Node(int data){
		this.data = data;
	}
}