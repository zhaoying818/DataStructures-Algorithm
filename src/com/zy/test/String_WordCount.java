package com.zy.test;

/**
 * 统计一行字符中有多少个单词
 * @author ZhaoYing
 */
public class String_WordCount {

	public static void main(String[] args) {

		String s ="I am Ok";
		System.out.println(s);
		System.out.println("单词个数为:" + wordCount(s));
	}
	
	public static int wordCount(String s){
		int word = 0;
		int count =0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==' ')
				word = 0;
			else if(word==0){
				word =1;
				count++;
			}
		}
		return count;
	}

}
