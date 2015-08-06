package com.zy.test;

import java.util.ArrayList;

public class Array_MixedSub {

	public static void main(String[] args) {
		int a1[] = {0,1,2,3,4};
		int a2[] = {1,3,5,7,9};
		ArrayList<Integer> mix = mixed(a1,a2);
		for(int i=0;i<mix.size();i++)
			System.out.print(mix.get(i) + " ");

	}
	/**
	 * 二路归并法
	 */
	public static ArrayList<Integer> mixed(int a1[],int a2[]){
		ArrayList<Integer> mix = new ArrayList<Integer>();
		int i=0,j=0;
		int n1 = a1.length;
		int n2 = a2.length;
		while(i<n1 && j<n2){
			if(a1[i]==a2[j]){
				mix.add(a1[i]);
				i++;
				j++;
			}
			else if(a1[i]>a2[j]){
				j++;
			}
			else{
				i++;
			}
		}
		return mix;
	}

}
