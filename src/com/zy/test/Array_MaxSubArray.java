package com.zy.test;

public class Array_MaxSubArray {

	public static void main(String[] args) {
		int[] arr ={1,-2,4,8,-4,7,-1,-5,8};
		System.out.println("��     ��     ��: " + maxSubArray(arr));
		System.out.println("�Ż���������: " + maxSubArray2(arr));
		System.out.println("�� ̬ �� ����: " + maxSubArray3(arr));
		System.out.println("�Ż��Ķ�̬��: " + maxSubArray4(arr));
		System.out.println("�Ż��Ķ�̬��: " + maxSubArray5(arr));
		System.out.println("begin=" +  begin + ",end=" + end);

	}
	
	/**
	 * �������������ҳ����������飬��ͣ������ֵ
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
	 * �ظ������Ѿ�����������
	 * @param arr:����
	 * @return:���������֮��
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
	 * ��̬�滮��
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
	 * �Ż��Ķ�̬�滮��
	 */
	public static int maxSubArray4(int arr[]){
		int n = arr.length;
		int nAll = arr[0];//��n��������������������֮��
		int nEnd = arr[0];//��n����������������һ��Ԫ�ص����������֮��
		for(int i=1;i<n;i++){
			nEnd = max(nEnd+arr[i],arr[i]);
			nAll = max(nEnd,nAll);
		}
		return nAll;
	}
	
	/**
	 * 
	 */
	private static int begin = 0;//��¼������������ʼλ��
	private static int end = 0;//��¼���������Ľ���λ��
	
	public static int maxSubArray5(int arr[]){
		int maxSum = Integer.MIN_VALUE;//����������ֵ
		int nSum = 0;//�������������һλ�����ֵ
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
