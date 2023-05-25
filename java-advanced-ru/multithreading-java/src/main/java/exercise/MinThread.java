package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {
    private final int[] arr;
    private int minNum;

    public int getMinNum() {
        return this.minNum;
    }

    public MinThread(int[] inputArray) {
        arr = Arrays.copyOf(inputArray, inputArray.length);
    }

    @Override
    public void run() {
        minNum = arr[0];
        for (int j : arr) {
            if (minNum > j) {
                this.minNum = j;
            }
        }
    }
}
// END
