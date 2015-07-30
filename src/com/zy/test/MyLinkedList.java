package com.zy.test;
public class MyLinkedList {
	
	Node head = null;  //链表头的引用
	/**
	 * 向链表中插入数据
	 * @param d： 插入数据的内容
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
	 * 删除第index节点
	 * @param index ：将要被删除的节点
	 * @return ： 成功返回true，失败返回false
	 */
	public Boolean deleteNode(int index){
		//删除元素的位置不合理
		if(index<1 || index>length()){
			return false;
		}
		//删除链表第一个元素
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
	 * @return 返回节点的长度
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
	 * 对链表进行升序排列
	 * @return 返回排序后的头结点
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
	 * 打印链表
	 */
	public void printList(){
		Node tmp = head;
		while(tmp!=null){
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}
	
	/**
	 * 通过双重循环遍历删除链表中重复的数据
	 * @param head : 链表的头结点 
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
	 * 查找单链表中的倒数第K个元素
	 * 设置两个指针，一个先移动k-1步，然后同时移动，知道先前移动的为空(null)
	 * @param head
	 * @param k
	 * @return
	 */
	public Node findElem(Node head, int k){
		if(k<1 || k>this.length())
			return null;
		Node p1 = head;
		Node p2 = head;
		for(int i = 0;i<k-1;i++)//前移k-1步
			p1 = p1.next;
		while(p1!=null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
	}
	
	/**
	 * 非递归方法实现链表的翻转
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
	 * 采用递归方法实现反向输出单链表（从尾到头）
	 * 方法：每次访问到一个节点，县递归输出它后面的结点，在输出该结点自身
	 * @param pListHead: 头结点
	 */
	public void printListReversely(Node pListHead){
		if(pListHead!=null){
			printListReversely(pListHead.next);
			System.out.println(pListHead.data);
		}
	}
	
	/**
	 *  查找单链表中间结点
	 *  设置两个指针，同时出发，一个步长为1，一个步长为2
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
 * 单链表的节点
 */
class Node {
	Node next = null;
	int data;
	public Node(int data){
		this.data = data;
	}
}