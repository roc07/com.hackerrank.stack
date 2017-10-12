package simple.text.editor;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
	
	static StringBuilder text = new StringBuilder();
	static Stack<String> crntState = new Stack<String>();
	static int count = 0;
	
	static void prfrmOperOne(String add) {
		count++;
		text.append(add);
		crntState.push(text.toString());
	}
	
	static void prfrmOperTwo(int num) {
		count++;
		text.delete(text.length() - num, text.length());
		crntState.push(text.toString());
	}	
	
	static void prfrmOperThree(int chr) {
		chr--;
		System.out.println(text.substring(chr, chr + 1));
	}	
	
	static void prfrmOperFour() {
		
		crntState.pop();
		text.delete(0, text.length());
		text.append(crntState.peek());
	}
	
	public static void main(String[] args) {

		crntState.push(text.toString());
		count++;
		
		Scanner in = new Scanner(System.in);
		int n = Integer.parseInt(in.nextLine());
		
		String[] currInstr = new String[2];

		for (int i = 0; i < n; i++) {
			String chk = in.nextLine();
			if (chk.length() > 1) {
				currInstr = chk.split(" ");
				if (currInstr[0].equals("1")) {
					prfrmOperOne(currInstr[1]);
				} else if (currInstr[0].equals("2")) {
					prfrmOperTwo(Integer.parseInt(currInstr[1]));				
				} else if (currInstr[0].equals("3")) {
					prfrmOperThree(Integer.parseInt(currInstr[1]));
				}
			} else {
				prfrmOperFour();
			}
		}	
		
		in.close();

	}
}
