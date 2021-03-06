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
	
	/**
	 * 检测一个链表是否有环
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
	//如果链表存在环，找到环的入口点
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
	 * 不知道头结点的情况下删除指定结点
	 * @param n:要删除的结点
	 * @return: 删除成功，返回true；否则，返回false
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
	 * 如何判断两个链表是否相交
	 * @param h1:链表h1的结点
	 * @param h2:链表h2的结点
	 * @return:相交，返回true
	 */
	public boolean isIntersect(Node h1, Node h2){
		if(h1==null || h2==null)
			return false;
		Node tail1 = h1;
		//找到链表h1的尾结点
		while(tail1.next!=null)
			tail1 = tail1.next;
		Node tail2 = h2;
		//找到链表h2的尾结点
		while(tail2.next!=null){
			tail2 = tail2.next;
		}
		return tail1 == tail2;
	}
	/**
	 * 若两个链表相交，找出他们相交的第一个结点
	 */
	public static Node getFirstMeetNode(Node h1, Node h2 ){
		if(h1==null || h2==null)
			return null;
		Node tail1 = h1;
		int len1 = 1;
		//找到链表h1的尾结点
		while(tail1.next!=null){
			tail1 = tail1.next;
			len1++;
		}
		Node tail2 = h2;
		int len2 = 1;
		//扎到链表h2的尾结点
		while(tail2.next!=null){
			tail2 = tail2.next;
			len2++;
		}
		//两链表不想交
		if(tail1!=tail2)
			return null;
		Node t1 = h1;
		Node t2 = h2;
		//找出较长的链表，先遍历
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
 * 单链表的节点
 */
class Node {
	Node next = null;
	int data;
	public Node(int data){
		this.data = data;
	}
}