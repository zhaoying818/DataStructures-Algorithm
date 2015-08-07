package com.zy.test;

import java.util.Arrays;


/**
 * �ж������ַ��Ƿ�����ͬ���ַ����
 */
public class String_MadeUpWithSameChars {

	public static void main(String[] args) {
		String s1 = "aaaabbc123";
		String s2 = "23abcbaaa1";
		System.out.println(s1 + "��" + s2 + "����ͬ���ַ����:" + compare_sameChars(s1, s2));
		System.out.println(s1 + "��" + s2 + "����ͬ���ַ����:" + compare_sameChars2(s1, s2));
		String b1 = "aaaabbc";
		String b2 = "abcbaab";
		System.out.println(b1 + "��" + b2 + "����ͬ���ַ����:" + compare_sameChars(b1, b2));
		System.out.println(b1 + "��" + b2 + "����ͬ���ַ����:" + compare_sameChars2(b1, b2));

	}
	
	/**
	 * ����:
	 * ʱ�临�Ӷ�O(nlogn)
	 */
	public static boolean compare_sameChars(String s1, String s2){
		byte[] b1 = s1.getBytes();
		byte[] b2 = s2.getBytes();
		Arrays.sort(b1);
		Arrays.sort(b2);
		s1 = new String(b1);
		s2 = new String(b2);
		if(s1.equals(s2))
			return true;
		else
			return false;
	}
	
	/**
	 * �ռ任ʱ��
	 * ʱ�临�Ӷ�O(n)
	 */
	public static boolean compare_sameChars2(String s1, String s2){
		byte[] b1 = s1.getBytes();
		byte[] b2 = s2.getBytes();
		int[] bCount = new int[256];
		for(int i=0;i<256;i++)
			bCount[i] = 0;
		for(int i=0;i<b1.length;i++)
			bCount[b1[i]-'0']++;
		for(int i=0;i<b2.length;i++)
			bCount[b2[i]-'0']--;
		for(int i=0;i<256;i++)
			if(bCount[i]!=0){
				return false;
			}
		return true;
		
	}

}
