package com.zy.test;

public class BucketSort {
	
	class Node{
		int key;
		Node next;
	}
	
	void bucketSort(int [] keys,int bucketsize){
		int size = keys.length;
		Node []bucketTable = new Node[bucketsize];
		for(int i=0;i<bucketsize;i++){
			bucketTable[i] = new Node();
			bucketTable[i].key = 0; //记录当前桶中的数据量
			bucketTable[i].next = null;
		}
		for(int j=0;j<size;j++){
			Node node = new Node();
			node.key = keys[j];
			node.next = null;
			int index = keys[j]/10;
			Node p = bucketTable[index];
			if(p.key==0){
				bucketTable[index].next = node;
				(bucketTable[index].key)++;
			}else{
				//链表结构的插入排序
				while(p.next!=null && p.next.key<=node.key)
					p= p.next;
				node.next = p.next;
				p.next = node;
				(bucketTable[index].key)++;
			}
		}
		//打印结果
		for(int i=0;i<bucketsize;i++)
			for(Node n=bucketTable[i].next;n!=null;n=n.next)
				System.out.print(n.key + " ");
	}

	public static void main(String[] args) {

		int arr[] = {49,38,65,76,13,27,49,10,9};
		new BucketSort().bucketSort(arr, 10);
	}

}
