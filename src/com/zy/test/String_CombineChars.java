package com.zy.test;

public class String_CombineChars {

	public static void main(String[] args) {
		String s = "abc";
//		char[] c = s.toCharArray();
//		StringBuffer sb = new StringBuffer("");
//		int len = c.length;
//		for(int i=1;i<=len;i++){
//			combineChars(c, 0, i, sb);
//		}
		char[] c = s.toCharArray();
		combineChars2(c);
		
		

	}
	
	
	public static void combineChars(char[] c,int begin,int len,StringBuffer sb){
		if(len==0){
			System.out.print(sb + " ");
			return;
		}
		if(begin==c.length){
			return;
		}
		sb.append(c[begin]);
		combineChars(c, begin+1, len-1, sb);
		sb.deleteCharAt(sb.length()-1);
		combineChars(c, begin+1, len, sb);
	}
	
	public static void combineChars2(char[] c){
		if(c==null)
			return;
		int len = c.length;
		boolean used[] = new boolean[len];
		char cache[] = new char[len];
		int result = len;
		while(true){
			int index = 0;
			while(used[index]){
				used[index]=false;
				result++;
				if(++index==len)
					return;
			}
			used[index]=true;
			cache[--result] = c[index];
			System.out.print(new String(cache).substring(result) + " ");
		}
	}

}
