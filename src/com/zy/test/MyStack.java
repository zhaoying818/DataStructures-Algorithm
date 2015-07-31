package com.zy.test;
/**
 * ��������ʵ��ջ
 */
import java.util.Arrays;

public class MyStack<E> {
	private Object[] stack;
	private int size;//�����д洢Ԫ�صĸ���
	public MyStack(){
		stack = new Object[10]; //��ʼ����Ϊ10
	}
	//�ж�ջ�Ƿ�Ϊ��
	public boolean isEmpty(){
		return size == 0;
	}
	//Ѱ��ջ��
	public E peek(){
		if(isEmpty())
			return null;
		return (E)stack[size-1];
	}
	//��ջ
	public E pop(){
		E e= peek();
		stack[size-1] = null;
		size--;
		return e;
	}
	//��ջ
	public E push(E item){
		ensureCapacity(size+1);//�������
		stack[size++] = item;
		return item;
	}
	
	public void ensureCapacity(int size){
		int len = stack.length;
		if(size>len){//��������
			int newLen = 10;//ÿ���������������
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
		System.out.println("ջ��Ԫ�ظ���" + s.size);
		System.out.println("ջ��Ԫ��Ϊ" + s.peek());
		System.out.println("��ջ��Ԫ��Ϊ:" + s.pop());
		System.out.println("һ��Ԫ�س�ջ��ջ��Ԫ�ظ���" + s.size);
		System.out.println("һ��Ԫ�س�ջ��ջ��Ԫ��Ϊ" + s.peek());

	}

}
