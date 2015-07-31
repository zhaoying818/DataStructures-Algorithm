package com.zy.test;
/**
 * 用O(1)的时间复杂度求栈中椎小元素（栈采用的是链表方式实现）
 *
 */
public class MyStack1 {
	MyStack<Integer> elem;
	MyStack<Integer> min;
	public MyStack1(){
		elem = new MyStack<Integer>();
		min = new MyStack<Integer>();
	}
	public void push(int data){
		elem.push(data);
		if(min.isEmpty())
			min.push(data);
		else{
			if(data<min.peek())
				min.push(data);
		}
	}
	public int pop(){
		int topData = elem.peek();
		elem.pop();
		if(topData==this.min())
			min.pop();
		return topData;
	}
	public int min(){
		if(min.isEmpty())
			return Integer.MAX_VALUE;
		else
			return min.peek();
	}
}
