
import java.util.*;

public class QuickSort {

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pivotindex = partition(arr, low, high);
            quickSort(arr, low, pivotindex - 1);
            quickSort(arr, pivotindex + 1, high);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length");
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        quickSort(arr, 0, n - 1);
        //print
        System.out.println("Sorted array:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
/*
 TIME COMPLEXITY
 Worst case - O(n^2)
 Worst case O(n^2) occurs when the pivot is the smallest or the largest index in the array.
 Average case - O(nlogn)
 Space complexity
 Worst case- O(n) — due to the recursive stack depth, which will be as deep as the size of the array in the worst case.
 Average-case space complexity (O(log n)): On average, Quick Sort performs well when the pivot divides the array into roughly equal parts.
 In this case, the depth of recursion is O(log n), leading to a more optimal space complexity of O(log n) for the recursive stack.
 */
