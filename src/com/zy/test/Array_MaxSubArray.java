package com.zy.test;

public class Array_MaxSubArray {

	public static void main(String[] args) {
		int[] arr ={1,-2,4,8,-4,7,-1,-5,8};
		System.out.println("蛮     力     法: " + maxSubArray(arr));
		System.out.println("优化的蛮力法: " + maxSubArray2(arr));
		System.out.println("动 态 规 划法: " + maxSubArray3(arr));
		System.out.println("优化的动态法: " + maxSubArray4(arr));
		System.out.println("优化的动态法: " + maxSubArray5(arr));
		System.out.println("begin=" +  begin + ",end=" + end);

	}
	
	/**
	 * “蛮力法”：找出所有子数组，求和，找最大值
	 */
	public static int maxSubArray(int arr[]){
		int len = arr.length;
		int ThisSum = 0;
		int MaxSum = 0;
		int i,j,k;
		for(i=0;i<len;i++)
			for(j=i;j<len;j++){
				ThisSum = 0;
				for(k=i;k<=j;k++)
					ThisSum += arr[k];
				if(ThisSum>MaxSum)
					MaxSum = ThisSum;
			}
		return MaxSum;
	}
	
	/**
	 * 重复利用已经计算的数组和
	 * @param arr:数组
	 * @return:最大子数组之和
	 */
	public static int maxSubArray2(int arr[]){
		int len = arr.length;
		int maxSum = Integer.MIN_VALUE;
		for(int i=0;i<len;i++){
			int sum=0;
			for(int j=i;j<len;j++){
				sum += arr[j];
				if(sum>maxSum){
					maxSum = sum;
				}
			}
		}
		return maxSum;
	}
	
	/**
	 * 动态规划法
	 */
	public static int maxSubArray3(int arr[]){
		int n = arr.length;
		int End[] = new int[n];
		int All[] = new int[n];
		End[n-1] = arr[n-1];
		All[n-1] = arr[n-1];
		End[0] = All[0] = arr[0];
		for(int i=1;i<n;i++){
			End[i] = max(End[i-1]+arr[i],arr[i]);
			All[i] = max(End[i],All[i-1]);
			
		}
		return All[n-1];
	}
	public static int max(int m,int n){
		return m>n ? m : n;
	}
	
	/**
	 * 优化的动态规划法
	 */
	public static int maxSubArray4(int arr[]){
		int n = arr.length;
		int nAll = arr[0];//有n个数字数组的最大子数组之和
		int nEnd = arr[0];//有n个数字数组包含最后一个元素的最大子数组之和
		for(int i=1;i<n;i++){
			nEnd = max(nEnd+arr[i],arr[i]);
			nAll = max(nEnd,nAll);
		}
		return nAll;
	}
	
	/**
	 * 
	 */
	private static int begin = 0;//记录最大字数组的起始位置
	private static int end = 0;//记录最大字数组的结束位置
	
	public static int maxSubArray5(int arr[]){
		int maxSum = Integer.MIN_VALUE;//字数组额最大值
		int nSum = 0;//包含字数组最后一位的最大值
		int nStart = 0;
		for(int i=0;i<arr.length;i++){
			if(nSum<0){
				nSum = arr[i];
				nStart = i;
			}
			else{
				nSum += arr[i];
			}
		    if(nSum>maxSum){
			    maxSum = nSum;
			    begin = nStart;
			    end = i;	
		    }
		}
		return maxSum;
	}
		

}
