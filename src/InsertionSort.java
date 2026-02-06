public class InsertionSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {

        int[] arr = input.clone();

        int n = arr.length;

        for(int p = 1; p < n; p++){
            int temp = arr[p];
            int i;

            for(i = p; i > 0 && temp < arr[i-1]; i--){
                arr[i] = arr[i-1];
            }

            arr[i] = temp;
        }

        return arr;
    }
}
