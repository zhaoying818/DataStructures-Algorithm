package com.zy.test;
/**
 * 使用链表的方式实现栈
 */
class Nodes<E>{
	Nodes<E> next = null;
	E data;
	public Nodes(E data){
		this.data = data;
	}
}
public class Stack<E> {
	Nodes<E> top = null;
	public boolean isEmpty(){
		return top ==null;
	}
	public void push(E data){
		Nodes<E> newNode = new Nodes<E>(data);
		newNode.next = top;
		top = newNode;
	}
	public E pop(){
		if(this.isEmpty())
			return null;
		E data = top.data;
		top = top.next;
		return data;
	}
	public E peek(){
		if(isEmpty()){
			return null;
		}
		return top.data;
	}

}
