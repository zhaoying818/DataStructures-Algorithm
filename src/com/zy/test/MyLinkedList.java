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