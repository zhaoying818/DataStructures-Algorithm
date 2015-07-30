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