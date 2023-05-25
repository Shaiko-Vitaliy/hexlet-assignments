package exercise;

import java.util.Arrays;

// BEGIN
public class MaxThread extends Thread {
    private final int[] arr;
    private int maxNum;

    public int getMaxNum() {
        return maxNum;
    }

    public MaxThread(int[] inputArray) {
        arr = Arrays.copyOf(inputArray, inputArray.length);
    }

    @Override
    public void run() {
        maxNum = arr[0];
        for (int j : arr) {
            if (maxNum < j) {
                maxNum = j;
            }
        }
    }
}
// END
