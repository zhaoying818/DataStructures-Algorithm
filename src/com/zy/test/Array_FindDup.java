package com.zy.test;

public class Array_FindDup {
	
	public static void main(String[] args){
		int a[] ={1,2,3,4,1};
		System.out.println(findDup(a));
		System.out.println(findDup2(a));
		System.out.println(findDup3(a));
		System.out.println(findDup4(a));
		System.out.println(findDup5(a));
	}
	
	
	public static int findDup(int[] a){
		int n = a.length;
		int tmp1 = 0;
		int tmp2 = 0;
		for(int i=0; i<n-1;i++){
			tmp1 += (i+1);
			tmp2 += a[i];
		}
		tmp2 += a[n-1];
		int result = tmp2-tmp1;
		return result;
	}
	
	/**
	 * 异或法
	 */
	public static int findDup2(int[] a){
		int n = a.length;
		int i;
		int result = 0;
		for(i=0;i<n;i++){
			result ^= a[i];
		}
		for(i=1;i<n;i++){
			result ^= i; 
		}
		return result;
	}
	
	/**
	 * 空间换时间
	 */
	public static int findDup3(int[] a){
		int n = a.length;
		boolean[] flag = new boolean[n];
		int i = 1;
		int result = Integer.MAX_VALUE;
		while(i<n){
			flag[i] = false;
			i++;
		}
		for(i=0;i<n;i++){
			if(flag[a[i]]==false)
				flag[a[i]] = true;
			else{
				result = a[i];
			}
		}
		return result;
	}
	
	/**
	 * 取反法
	 */
	public static int findDup4(int[] a){
		int n = a.length;
		int result = Integer.MAX_VALUE;
		for(int i=0;i<n;i++){
			if(a[i]>0){
				a[a[i]] = -a[a[i]];
			}else{
				a[-a[i]] = -a[-a[i]];
			}
		}
		for(int i=1;i<n;i++){
			if(a[i]>0)
				result = i;
			else
				a[i] = -a[i];
		}
		return result;
	}
	
	/**
	 * 类似单链表求环的的入口点
	 */
	public static int findDup5(int[] a){
		int x,y;
		x=y=0;
		do{
			x=a[a[x]];
			y=a[y];
		}while(x!=y);
		x=0;
		do{
			x=a[x];
			y=a[y];
		}while(x!=y);
		return x;
	}

}
