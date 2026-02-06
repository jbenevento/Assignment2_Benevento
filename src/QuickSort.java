public class QuickSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {

        int[] arr = input.clone();
        quickSort(arr, 0, arr.length - 1);
        return arr;

    }

    private static void quickSort(int[] arr, int left, int right){

        //base case checking for 0 or 1 elements in the array
        if(left >= right) return;

        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex-1);
        quickSort(arr, pivotIndex + 1, right);

    }

    private static int medianOfThree(int[] arr, int left, int right){
        int center = (left + right) / 2;

        if(arr[left] > arr[center]){
            swap(arr, left, center);
        }
        if(arr[left] > arr[right]){
            swap(arr, left, right);
        }
        if(arr[center] > arr[right]){
            swap(arr, center, right);
        }

        //median at the middle index
        return center;

    }

    private static int partition(int[] arr, int left, int right ){

        //find pivot
        int pivotIndex = medianOfThree(arr, left, right);
        //swap with last element in the array
        swap(arr, pivotIndex, right);
        int pivot = arr[right];

        int i = left;
        int j = right - 1;

        while (true) {
            while (i <= j && arr[i] < pivot) i++;
            while (j >= i && arr[j] > pivot) j--;

            if (i >= j) break;

            swap(arr, i, j);
            i++;
            j--;
        }

        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

}

/*
Sources:
https://www.w3schools.com/dsa/dsa_algo_quicksort.php
https://www.geeksforgeeks.org/dsa/quick-sort-algorithm/
https://stackoverflow.com/questions/7559608/median-of-three-values-strategy
ChatGPT for formating and brainstorming the helper methods
ChatGPT for debugging. Tried a do while loop in partition and it did not work
https://stackoverflow.com/questions/50065716/increment-and-decrement-in-while-loops
 */


