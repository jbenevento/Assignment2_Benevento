public class MergeSort implements SortingAlgorithm {


    @Override
    public int[] sorty(int[] input) {

         int[] arr = input.clone();

         mergeSort(arr);

         return arr;
    }

    private static void mergeSort(int[] arr){
        int length = arr.length;

        if (length <= 1) return;

        int middle = length / 2;

        //temp arrays
        int[] left = new int[middle];
        int[] right = new int[length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for(; i < length; i++){
            if (i < middle){ //if index i is less than middle
                left[i] = arr[i]; //add to the temp left array
            }
            else{ //if i is greater than or equal to middle
                right[j] = arr[i]; //add to the right array
                j++;
            }
        }

        //recursive calls
        mergeSort(left); //continue to split the left array until it is 1 element
        mergeSort(right); //continue to split the right array until it is 1 element
        merge(left, right, arr); //merge them back together



    }

    private static void merge(int[] left, int[] right, int[] arr){

        //left list length
        int leftSize = arr.length / 2;

        //right list length
        int rightSize = arr.length - leftSize;

        //indices
        //i to keep track of arr
        //l to keep track of left array
        //r to keep track of right array
        int i = 0, l = 0, r = 0;

        while(l < leftSize && r < rightSize){
            if (left[l] < right[r]){
                arr[i] = left[l];
                i++;
                l++;
            }
            else{
                arr[i] = right[r];
                i++;
                r++;
            }
        }

        //if there is one element left in the left array
        while (l < leftSize){
            arr[i] = left[l];
            i++;
            l++;
        }

        //if there is one element left in the right array
        while (r < rightSize) {
            arr[i] = right[r];
            i++;
            r++;
        }
    }
}

/*
Sources:
https://www.youtube.com/watch?v=3j0SWDX4AtU
https://www.geeksforgeeks.org/dsa/merge-sort/
https://www.w3schools.com/dsa/dsa_algo_mergesort.php
 */