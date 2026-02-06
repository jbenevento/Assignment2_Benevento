public class ShellSort implements SortingAlgorithm {
    @Override
    public int[] sorty(int[] input) {

        int[] arr = input.clone();
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; ++i) {
                int tmp = arr[i];
                int j;

                for (j = i; j >= gap && tmp < arr[j - gap]; j -= gap) {
                    arr[j] = arr[j - gap];
                }

                arr[j] = tmp;

            }
        }

        return arr;
    }
}
