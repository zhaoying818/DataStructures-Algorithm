package com.zy.test;

/**
 * 删除字符串中重复的字符
 * @author ZhaoYing
 *
 */
public class String_RemoveDuplicate {

	public static void main(String[] args) {
		String str = "abcaabcd";
		String str1 = removeDuplicate(str);
		System.out.println(str1);
		String str2 = removeDuplicate2(str);
		System.out.println(str2);
//		String str3 = removeDuplicate3(str);
//		System.out.println(str3);

	}
	
	
	/**
	 * 蛮力法
	 */
	public static String removeDuplicate(String str){
		char[] c = str.toCharArray();
		int len = c.length;
		for(int i=0;i<len;i++){
			if(c[i]=='\0')
				continue;
			for(int j=i+1;j<len;j++){
				if(c[j]=='\0')
					continue;
				//把重复的字符置为'\0'
				if(c[i]==c[j])
					c[j]='\0';
			}
		}
		//去掉'\0'
		int l=0;
		for(int i=0;i<len;i++){
			if(c[i]!='\0')
				c[l++] = c[i];
		}
		return new String(c,0,l);	
	}
	
	/**
	 * 空间换时间
	 */
	public static String removeDuplicate2(String str){
		char[] c = str.toCharArray();
		int len = c.length;
		int[] flag = new int[8];//只需要8个32bit的int，8*32bit= 256bit
		int i;
		for(i=0;i<8;i++)
			flag[i] = 0;
		for(i=0;i<len;i++){
			int index = (int)c[i]/32;
			int shift = (int)c[i]%32;
			if((flag[index]&(1<<shift))!=0)
				c[i] = '\0';
			flag[index] |= (1<<shift);
		}
		//去掉'\0'
		int l=0;
		for(i=0;i<len;i++){
			if(c[i]!='\0')
				c[l++] = c[i];
		}
		return new String(c,0,l);	
	}
	
	
	/**
	 * 正则表达式
	 */
//	public static String reverse(String str){
//		StringBuffer sb = new StringBuffer(str);
//		sb = sb.reverse();
//		return sb.toString();
//	}
//	public static String removeDuplicate3(String str){
//		str = reverse(str);
//		str = str.replaceAll("(? s)(. )(? =. *\\1)","");
//		str = reverse(str);
//		return str;
//	}

}
