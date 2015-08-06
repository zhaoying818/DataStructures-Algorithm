package com.zy.test;

import java.util.Scanner;

public class String_SwapWords {

	public static void main(String[] args) {
		//String str = "how are you";
		Scanner sc = new  Scanner(System.in);
		String str = sc.nextLine();
		System.out.println("����: " + str);
		System.out.println("���: " + new String_SwapWords().swapWords(str));

	}
	
	public String swapWords(String s){
		char[] cArr = s.toCharArray();
		//�������ַ��������ַ���ת����
		swap(cArr,0,cArr.length-1);
		int begin = 0;
		//�Ե������ʽ��з�ת����
		for(int i=1;i<cArr.length;i++){
			if(cArr[i]==' ') {
				swap(cArr,begin,i-1);
				begin = i+1;
			
			}
		}
		swap(cArr,begin,cArr.length-1);
		return new String(cArr);
	}
	
	public void swap(char[] cArr,int front,int end){
		while(front<end){
			char tmp = cArr[end];
			cArr[end] = cArr[front];
			cArr[front] = tmp;
			front++;
			end--;
		}
			
	}

}
