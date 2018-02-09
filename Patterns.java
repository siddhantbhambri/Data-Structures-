package Basics;

import java.util.Scanner;

public class Patterns {
	
	public static void pattern1(){
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Enter any number 'n'.");
		int row = s.nextInt();
		for(int r=1;r<=row;r++){
			for(int col =1;col<=row-r;col++){
				System.out.print(" ");
			}
			System.out.println("1");
			}
	}
	
	public static void pattern2(){
		
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		System.out.println("Enter any number 'n'.");;
		int num = s.nextInt();
		
	}
	
	
	public static void main(String[] args) {
		pattern2();
	}
}
