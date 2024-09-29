
import java.util.*;

public class Mergesort {
    public static void conquer(int arr[], int startindex, int mid, int endindex){
   int merger[]=new int[endindex-startindex+1];
   int index1= startindex;
   int index2= mid+1;
   int x= 0;
   //sort
   while(index1 <= mid&&index2 <= endindex){
    if(arr[index1]<=arr[index2]){
        merger[x++]=arr[index1++];
    }else{
        merger[x++]=arr[index2++];
    }
}
while(index1<=mid){
    merger[x++]=arr[index1++];
}
while(index2<=endindex){
    merger[x++]=arr[index2++];
    }
    for(int i=0, j=startindex; i<merger.length;i++,j++){
        arr[j]=merger[i];
    }
}

    public static void divide(int arr[], int startindex, int endindex) {
        if (startindex >= endindex) {
            return;
        }
        int mid = startindex + (endindex - startindex) / 2;
        divide(arr, startindex, mid);//Recursive call for left half
        divide(arr, mid + 1, endindex);//Recursive call for right half
        conquer(arr, startindex, mid, endindex);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array length");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
            divide(arr, 0, n-1);
            //print
            System.out.println("Print sorted array:");
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        sc.close();
    }
}
/* time complexity 
 Splitting the Array:

Each time the array is split into two halves. This occurs log₂(n) times because the array is halved at each step until each subarray has one element.
This step contributes O(log n) to the overall time complexity.
Merging the Array:

After splitting, merging the subarrays takes linear time, O(n), at each level of recursion.
Since there are log n levels (from the splitting), the merging step across all levels contributes O(n log n) time.
Thus, the overall time complexity of Merge Sort is O(n log n).
Space Complexity of Merge Sort:
Additional Space for Merging:
Merge Sort requires additional space to store the subarrays during the merging process.
At each recursive step, temporary arrays are created to merge the sorted subarrays. For an array of size n, this requires O(n) extra space.
Thus, the space complexity is O(n) due to the additional storage needed for merging.
 */
