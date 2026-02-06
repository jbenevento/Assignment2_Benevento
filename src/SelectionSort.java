public class SelectionSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {

        int[] arr = input.clone();

        for (int i = 0; i <arr.length; i++){

            int minIndex = i;

            for (int j = i + 1 ; j < arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }

        return arr;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr [j];
        arr[j] = temp;
    }
}

