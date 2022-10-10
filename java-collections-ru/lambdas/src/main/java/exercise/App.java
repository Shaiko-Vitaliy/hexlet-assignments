package exercise;

import java.util.Arrays;

// BEGIN
class App {
    public static String[][] enlargeArrayImage(String[][] arr) {
        var numberOfRows = arr.length * 2;
        var numberOfColumns = arr[0].length * 2;
        var resultArray = new String[numberOfRows][numberOfColumns];
        var countOfRows = 0;
        var countOfColumns = 0;
        for (var i = 0; i < numberOfRows / 2; i++) {
            countOfColumns = 0;
            for (var j = 0; j < numberOfColumns / 2; j++) {
                resultArray[i + countOfRows][j + countOfColumns] = arr[i][j];
                resultArray[i + countOfRows][j + countOfColumns + 1] = arr[i][j];
                resultArray[i + countOfRows + 1][j + countOfColumns] = arr[i][j];
                resultArray[i + countOfRows + 1][j + countOfColumns + 1] = arr[i][j];
                countOfColumns++;
            }
            countOfRows++;
        }
        //resultArray = Arrays.stream(arr)
         //       .flatMap((p) -> Arrays.asList())
 //               flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray(String[]::new)
        return  resultArray;
    }
}
// END
