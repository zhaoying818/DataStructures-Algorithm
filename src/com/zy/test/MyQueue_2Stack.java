package com.zy.test;

public class MyQueue_2Stack<E> {
	private Stack<E> s1 = new Stack<E>();
	private Stack<E> s2 = new Stack<E>();
	public synchronized void put(E e){
		s1.push(e);
	}
	public synchronized E pop(){
		if(s2.isEmpty())
			while(!s1.isEmpty())
				s2.push(s1.pop());
		return s2.pop();
	}
	public synchronized boolean empty(){
		return s1.isEmpty() && s2.isEmpty();
	}

	public static void main(String[] args) {
		MyQueue_2Stack<Integer> q = new MyQueue_2Stack<Integer>();
		q.put(1);
		q.put(2);
		System.out.println("队列首元素:" + q.pop());
		System.out.println("队列首元素:" + q.pop());

	}

}
