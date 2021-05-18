package inlining;

public class ConsecutiveNumbersSum {

    private long totalSum;
    private int totalNumbers;

    public ConsecutiveNumbersSum(int totalNumbers) {
        this.totalNumbers = totalNumbers;
    }

    public long getTotalSum() {
        totalSum = 0;
        for (int i = 0; i < totalNumbers; i++) {
            totalSum += i;
        }
        return totalSum;
    }
	
	private static long calculateSum(int n) {
		return new ConsecutiveNumbersSum(n).getTotalSum();
	}

    public static void main(String[] args) {
        long sum = 0;
        for (int i = 0; i < 15_000; i++) {
            sum += calculateSum(i);
        }
        System.out.println(sum);

    }
}