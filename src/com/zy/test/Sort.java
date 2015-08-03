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
	
	
	/**
	 * insertSort插入排序
	 * @param a:要排序的数组
	 */
	public static void insertSort(int[] a){
		if(a!=null){
			for(int i=1;i<a.length;i++){
				int temp = a[i];
				int j=i;
				if(a[j-1]>temp){
					while(j>=1 && a[j-1]>temp){
						a[j] = a[j-1];
						j--;
					}
				}
				a[j]=temp;
			}
		}
	}
	/**
	 * BubbleSort 冒泡排序
	 * @param a: 要排序的数组
	 */
	public static void BubbleSort(int[] a){
		int i, j;
		int len = a.length;
		int tmp;
		for(i=0;i<len-1;i++)
			for(j=len-1;j>i;j--)
				if(a[j]<a[j-1]){
					tmp = a[j];
					a[j] = a[j-1];
					a[j-1] = tmp;
				}
	}
	
	/**
	 * MergeSort归并排序
	 */
	public static void MergeSort(int[] a, int p, int r){
		if(p<r){
			int q = (p+r)/2;
			MergeSort(a, p, q);
			MergeSort(a, q+1, r);
			Merge(a, p, q, r);
		}
	}
	public static void Merge(int a[], int p ,int q, int r){
		int i,j,k,n1,n2;
		n1 = q-p+1;
		n2 = r-q;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i=0,k=p;i<n1;i++,k++)
			L[i] = a[k];
		for(i=0,k=q+1;i<n2;i++,k++)
			R[i] = a[k];
		for(k=p,i=0,j=0;i<n1&&j<n2;k++){
			if(L[i]<R[j]){
				a[k] = L[i];
				i++;
			}
			else{
				a[k] = R[j];
				j++;
			}
		}
		if(i<n1){
			for(j=i;j<n1;j++,k++)
				a[k] = L[j];
		}
		if(j<n2){
			for(i=j;i<n2;i++,k++)
				a[k] = R[i];
		}
	}
	
	
	
	
	
	public static void main(String[] args){
		int a[] = {36,25,48,12,25,65,43,57};
		MergeSort(a,0,a.length-1);
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
		System.out.println("\n");
	}
	

}
