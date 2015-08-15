package com.zy.test;


/**
 * Ïû³ý×Ö·û´®ÖÐÇ¶Ì×µÄÀ¨ºÅ
 * @author ZhaoYing
 *
 */
public class String_ChangeString {

	public static void main(String[] args) {
		String s = "(1,(2,3),(4,(5,6),7))";
		String result = changeString(s);
		if(result!=null)
			System.out.println(result);
		s = "((1,(2,3),(4,(5,6),7))";
		result = changeString(s);
		if(result!=null)
			System.out.println(result);
		
	}
	
	
	public static String changeString(String s){
		String result = "(";
		char[] ch =s.toCharArray();
		int bracket_num = 0;
		int i =0;
		while(i<ch.length){
			if(ch[i]=='('){
				bracket_num++;
			}
			else if(ch[i]==')')
				if(bracket_num>0)
					bracket_num--;
				else{
					System.out.println("Expression wrong!\n");
					return null;
				}
			else if(ch[i]==','){
				result += ch[i++];
				continue;
			}
			else if(ch[i]>='0' && ch[i]<='9'){
				result += ch[i];
			}
			else{
				System.out.println("Expression wrong!\n");
				return null;
			}
			i++;
		}
		if(bracket_num>0){
			System.out.println("Expression wrong!\n");
			return null;
		}
		result +=')';
		return result;
	}

}
