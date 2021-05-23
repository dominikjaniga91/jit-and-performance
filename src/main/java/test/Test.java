package test;

public class Test {

	public static void main(String[] args) {
		
		for(int i = 0; i < 25_000; ++i) {
			new Test().method();	
		}
	
	}

	int[] method() {
		int[] arr = new int[1_000_000];
		for(int i = 0; i < arr.length; ++i) {
			arr[i] = i;
		}
		return arr;
	}
}
