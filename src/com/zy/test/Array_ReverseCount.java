package com.zy.test;

/**
 * 球数组中的反序对
 *
 */
public class Array_ReverseCount {

	public static void main(String[] args) {
		int a[] = {1,5,3,2,6};
		System.out.println(reverseCount(a));
		
		merge_sort(a,0,a.length-1);
		System.out.println(reverseCount);

	}
	
	/**
	 * 蛮力法
	 * @param a
	 * @return
	 */
	public static int reverseCount(int[] a){
		int count = 0;
		int len = a.length;
		for(int i=0;i<len;i++){
			for(int j=i+1;j<len;j++){
				if(a[j]<a[i])
					count++;
			}
		}
		return count;
	}
	
	/**
	 * 分治归并法
	 */
	public static int reverseCount = 0;
	
	
	public static void merge(int a[],int begin,int mid,int end){
		int i,j,k,n1,n2;
		n1 = mid-begin+1;
		n2 = end-mid;
		int[] L = new int[n1];
		int[] R = new int[n2];
		for(i=0,k=begin;i<n1;i++,k++)
			L[i] = a[k];
		for(i=0,k=mid+1;i<n2;i++,k++)
			R[i] = a[k];
			
		for(k=begin,i=0,j=0;i<n1 && j<n2;k++){
			if(L[i]<R[j])
				a[k] = L[i++];
			else{
				reverseCount += mid-i+1;
				a[k] = R[j++];
			}
		}
		if(1<n1){
			for(j=i;j<n1;j++,k++)
				a[k] = L[j];
		}
		if(j<n2){
			for(i=j;i<n2;i++,k++)
				a[k] = R[i];
		}		 
	}
	public static void merge_sort(int a[],int begin,int end){
		if(begin<end){
			int mid = (begin+end)/2;
			merge_sort(a,begin,mid);
			merge_sort(a,mid+1,end);
			merge(a,begin,mid,end);
		}
	}
	

}
