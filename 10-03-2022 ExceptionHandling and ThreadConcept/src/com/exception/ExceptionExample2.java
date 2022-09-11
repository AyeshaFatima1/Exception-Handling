package com.exception;

public class ExceptionExample2 {

	public static void main(String[] args) {
		try {
			int a=5,b=6,c;
			c=a/b;
		    System.out.println("value of c:"+c);
		    /*String s="abc";
			System.out.println("value of s:"+s);*/
		    /*String s1="abc";
			String s2="13";
			int i=Integer.parseInt(s1);
			System.out.println("value of i:"+i);*/
			/*int m[]=new int[5];
			m[2]=5;
			System.out.println(m[2]);*/
			
		}
		catch (Exception e) {
			System.out.println("exception occured"+e);
		}
	}

}
