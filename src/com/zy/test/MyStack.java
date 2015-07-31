package com.zy.test;
/**
 * 采用数组实现栈
 */
import java.util.Arrays;

public class MyStack<E> {
	private Object[] stack;
	private int size;//数组中存储元素的个数
	public MyStack(){
		stack = new Object[10]; //初始长度为10
	}
	//判断栈是否为空
	public boolean isEmpty(){
		return size == 0;
	}
	//寻找栈顶
	public E peek(){
		if(isEmpty())
			return null;
		return (E)stack[size-1];
	}
	//出栈
	public E pop(){
		E e= peek();
		stack[size-1] = null;
		size--;
		return e;
	}
	//入栈
	public E push(E item){
		ensureCapacity(size+1);//检查容量
		stack[size++] = item;
		return item;
	}
	
	public void ensureCapacity(int size){
		int len = stack.length;
		if(size>len){//数组已满
			int newLen = 10;//每次数组扩充的容量
			stack = Arrays.copyOf(stack, newLen);
		}
	}
	

	public static void main(String[] args) {
		MyStack<Integer> s = new MyStack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(6);
		s.push(8);
		s.push(7);
		s.push(5);
		System.out.println("栈中元素个数" + s.size);
		System.out.println("栈顶元素为" + s.peek());
		System.out.println("出栈的元素为:" + s.pop());
		System.out.println("一个元素出栈后，栈中元素个数" + s.size);
		System.out.println("一个元素出栈后，栈顶元素为" + s.peek());

	}

}
