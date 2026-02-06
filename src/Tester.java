import java.util.Random;

public class Tester {

    private final SortingAlgorithm sorting;

    public Tester(SortingAlgorithm sa){
        this.sorting = sa;
    }

    public double singleTest(int size){
        int[] arr = new int[size];
        Random r = new Random();

        for (int i = 0; i < arr.length; i++){
            arr[i] = r.nextInt();
        }

        long startTime = System.nanoTime();
        sorting.sorty(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000.0;
    }

    public double singleTestK(int[] arr){
        long startTime = System.nanoTime();
        sorting.sorty(arr);
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000.0;
    }

    public void test(int iterations, int size){

        double totalTime = 0;

        for(int i = 0; i < iterations; i++){
            totalTime += singleTest(size);
        }

        double avgTime = totalTime / iterations;

        System.out.println(" average time: "
                + avgTime + " ");

    }
}

/*
Sources:
https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/
https://stackoverflow.com/questions/180158/how-do-i-time-a-methods-execution-in-java
ChatGPT for test(int iterations, int size)
 */


