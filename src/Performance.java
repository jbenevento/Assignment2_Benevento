import java.io.*;
import java.util.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class Performance {

    public static void main(String[] args) {
        SortingAlgorithm[] algorithms = {
                new BubbleSort(),
                new InsertionSort(),
                new SelectionSort(),
                new ShellSort(),
                new QuickSort(),
                new MergeSort()
        };

        int iterations = 20;
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        Map<String, XYSeries> seriesMap = new LinkedHashMap<>(); //random
        Map<String, XYSeries> kSortedSeriesMap = new LinkedHashMap<>();//k sorted

        try (PrintWriter pw = new PrintWriter(new FileWriter("sorting_report.txt"))) {
            for (SortingAlgorithm sa : algorithms) {
                Tester tester = new Tester(sa);
                String name = sa.getClass().getSimpleName();

                pw.println("Sorting algorithm - " + name);

                XYSeries series = new XYSeries(name);
                XYSeries kSeries = new XYSeries(name + " (K-sorted)");

                for (int size : sizes) {
                    double totalTime = 0;
                    double totalTimeK = 0;

                    for (int i = 0; i < iterations; i++) {
                        totalTime += tester.singleTest(size);
                    }

                    double avgTime = totalTime / iterations;

                    pw.printf("Sorted %d elements in %.2f ms (avg)%n", size, avgTime);

                    series.add(size, avgTime);

                    //k-sorted data
                    for(int i = 0; i < iterations; i++){
                        int[]arr = new int[size];
                        generateKSorted(arr, 10);
                        totalTimeK += tester.singleTestK(arr);
                    }
                    
                    double avgTimeK = totalTimeK / iterations;
                    
                    pw.printf("K-sorted Data: Sorted %d elements in %.2f ms (avg)%n", size, avgTimeK);

                    kSeries.add(size,avgTimeK);

                }

                pw.println();
                seriesMap.put(name, series);
                kSortedSeriesMap.put(name, kSeries);

            }
            //Confirmation of file creation/completion
            System.out.println("Performance report generated: sorting_report.txt");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Create Chart
        XYSeriesCollection dataset = new XYSeriesCollection();
        for (XYSeries s : seriesMap.values()) {
            dataset.addSeries(s);
        }
        for (XYSeries s : kSortedSeriesMap.values()) {
            dataset.addSeries(s);
        }

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Sorting Algorithm Performance",
                "Array Size (N)",
                "Average Time (ms)",
                dataset
        );

        //Logarithmic axis to handle the large differences
        //chart.getXYPlot().setRangeAxis(new LogarithmicAxis("Average Time (ms)"));

        JFrame frame = new JFrame("Sorting Performance Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ChartPanel(chart));
        frame.pack();
        frame.setVisible(true);

    }

    public static void generateKSorted(int[] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        Random rand = new Random();

        for(int i = 0; i < arr.length; i++) {
            int j = i + rand.nextInt(Math.min(k + 1, arr.length - i));

            //swap
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }

}

/*
Sources:
https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html
https://docs.oracle.com/javase/8/docs/api/java/io/PrintWriter.html
https://www.w3schools.com/JAVA/ref_output_printf.asp
https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
jfreechart-1.5.6-intro.pdf
https://stackoverflow.com/questions/26014528/can-someone-please-provide-step-by-step-instructions-for-using-jfreechart-in-an
ChatGPT to assist in implementing jfreechart
 */
