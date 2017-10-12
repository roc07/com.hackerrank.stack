package three.equal.stacks;

import java.util.*;

public class EqualStacks {
	
    static Stack<Integer> t1 = new Stack<Integer>();
    static Stack<Integer> t2 = new Stack<Integer>();
    static Stack<Integer> t3 = new Stack<Integer>();
    static int t1Val;       
    static int t2Val;        
    static int t3Val;
    
	static int fillTower(Stack<Integer> t, int n, Scanner in) {
		int sum = 0;
		int x;
		int[] temp = new int[n];
		
		//System.out.println("Start n:");
		
		for (int i = 0; i < n; i++) {
			x = in.nextInt();
			temp[i] = x;
			sum += x;
		}
				
		for (int i = n - 1; i >= 0; i--) {
			t.push(temp[i]);
		}
		
		temp = null;
		//System.out.println("sum: " + sum);
		return sum;
	}
	
	static int updateSum(int initValue, int removeFromSum) {
		return initValue - removeFromSum;
	}
	
	static int largestTower(int t1s, int t2s, int t3s) {
		if (t1s == t2s && t2s == t3s) {
			return 5;
		} else
		if (t1s > t2s && t1s > t3s) {
			return 1;
		} else
		if (t2s > t1s && t2s > t3s) {
			return 2;
		} else
		if (t3s > t2s && t3s > t1s) {
			return 3;
		} else {
			if (t1s == t2s && t3s > t1s) {
				return 301;
			} else
			if (t1s == t2s && t3s < t1s) {
				return 300;
			} else
			if (t3s == t2s && t3s > t1s) {
				return 100;
			} else
			if (t3s == t2s && t3s < t1s) {
				return 101;
			} else
			if (t3s == t1s && t2s > t1s) {
					return 201;
			} else
			if (t3s == t1s && t2s < t1s) {
					return 200;
			}
			
			System.out.println("WRONG CODE!");
			return 0;
		}	
	}
	
	static void checkTower() {		
		int res = largestTower(t1Val, t2Val, t3Val);
		
		//System.out.println("T1S: " + t1Val + " T2S: " + t2Val + " T3S: " + t3Val);
		
		if (res == 0) {
			return;
		}
		
		if (res == 5) {
			System.out.println(t1Val);
			return;
		} else {
			res = largestTower(t1Val, t2Val, t3Val);
			//System.out.println("Result: " + res);
//			try {
//				Thread.sleep(1500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			if (res == 1) {
				t1Val = updateSum(t1Val, t1.peek());
				t1.pop();				
			} else if (res == 2) {
				t2Val = updateSum(t2Val, t2.peek());
				t2.pop();
			} else if (res == 3) {
				t3Val = updateSum(t3Val, t3.peek());
				t3.pop();
			} else if (res == 300) {
				t2Val = updateSum(t2Val, t2.peek());
				t1Val = updateSum(t1Val, t1.peek());
				t2.pop();
				t1.pop();
			} else if (res == 301) {
				t3Val = updateSum(t3Val, t3.peek());
				t3.pop();
			} else if (res == 200) {
				t1Val = updateSum(t1Val, t1.peek());
				t3Val = updateSum(t3Val, t3.peek());
				t1.pop();
				t3.pop();
			} else if (res == 201) {
				t2Val = updateSum(t2Val, t2.peek());
				t2.pop();
			} else if (res == 100) {
				t2Val = updateSum(t2Val, t2.peek());
				t3Val = updateSum(t3Val, t3.peek());
				t2.pop();
				t3.pop();
			} else if (res == 101) {
				t1Val = updateSum(t1Val, t1.peek());
				t1.pop();
			}
			checkTower();
		}
	}
	

	
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        int[] ns = new int[3];
        
        for (int i = 0; i < 3; i++) {
        	ns[i] = in.nextInt();
        }    

        t1Val = fillTower(t1, ns[0], in);       
        t2Val = fillTower(t2, ns[1], in);        
        t3Val = fillTower(t3, ns[2], in);

        checkTower();
        
        in.close();

        
    }

}

