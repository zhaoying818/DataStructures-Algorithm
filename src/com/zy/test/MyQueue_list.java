package com.zy.test;
 /**
  * ����ʵ�ֶ���
  *
  */
import java.util.LinkedList;

public class MyQueue_list<E> {
	private LinkedList<E> list = new LinkedList<E>();
	private int size;
	public synchronized void put(E e){
		list.addLast(e);
		size++;
	}
	public synchronized E pop(){
		size--;
		return list.removeFirst();
	}
	public synchronized boolean empty(){
		return size==0;
	}
	public synchronized int size(){
		return size;
	}

}
