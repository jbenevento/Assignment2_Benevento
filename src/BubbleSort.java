import static java.util.Collections.swap;

public class BubbleSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {

        int[] arr = input.clone();

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
            }
        }

        return arr;
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr [j];
        arr[j] = temp;
        }
    }



/*
Sources:
ChatGPT to explain interface formating (implements) and how to integrate the sorty method
https://www.w3schools.com/java/ref_keyword_implements.asp
https://www.geeksforgeeks.org/java/clone-method-in-java-2/
https://docs.oracle.com/javase/8/docs/api/java/lang/Cloneable.html
https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#clone--
 */