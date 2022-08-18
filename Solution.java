import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*

k = 3
1 2 3 4 5
3 4 5 1 2

k = 2
1 2 3 4 5
4 5 1 2 3

k = 3
1 2 3
2 3 1

first (n - k) elements

 */

public class Solution {
	
	public static void main(String[] args) {	
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		//T = fs.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int n = fs.nextInt();
			int k = fs.nextInt();
			int q = fs.nextInt();
			int[] a = fs.readArray(n);
			if (k != n) {
				k %= n;
				rotateRight(a, n, k);
			}
			for (int i = 0; i < q; i++) {
				int id = fs.nextInt();
				out.println(a[id]);
			}
			//System.out.println(Arrays.toString(a));
		}
		out.close();
	}
	
	static void rotateRight(int[] a, int n, int k) {
		int[] hold = new int[n-n+k];
		for (int i = n - k; i < n; i++) {
			hold[i-n+k] = a[i];
		}
		int[] newHold = new int[n-k];
		for (int i = 0; i < n - k; i++) {
			newHold[i] = a[i];
		}
		for (int i = k; i < n; i++) {
			a[i] = newHold[i-k];
		}
		for (int i = 0; i < n - n + k; i++) {
			a[i] = hold[i];
		}
	}
	
	static void sort(int[] a) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int x : a) {
			arr.add(x);
		}
		Collections.sort(arr);
		for (int i = 0; i < a.length; i++) {
			a[i] = arr.get(i);
		}
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
