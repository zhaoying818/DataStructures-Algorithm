package com.zy.test;
/**
 * 包含了几种常用的排序算法
 *
 */
public class Sort {
	/**
	 * selectSort选择排序
	 * @param a:要排序的数组
	 */
	public static void selectSort(int[] a){
		int i;
		int j;
		int temp = 0;
		int flag = 0;
		int n = a.length;
		for(i=0;i<n;i++){
			temp = a[i];
			flag = i;
			for(j=i+1;j<n;j++){
				if(a[j]<temp){
					temp = a[j];
					flag = j;
				}
			}
			if(flag!=i){
				a[flag]=a[i];
				a[i] = temp;
			}
		}
	}
	
	public static void main(String[] args){
		int a[] = {36,25,48,12,25,65,43,57};
		selectSort(a);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
	

}
