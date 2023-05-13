import java.util.*;
public class quickSort {
    
    // utility swap function 
    static void swap (int[] a ,int i1, int i2) {
        int temp = a[i1];
        a[i1] = a[i2] ; 
        a[i2] = temp ;
    }
    static void ranPivot(int[] a,int low,int high){
        Random rand = new Random();
        int rind = rand.nextInt(high-low) + low;
        swap(a,rind,high);
    }
    static int partition(int[] a,int low,int high,boolean randomized){
        // we select last(rightmost) element as our pivot
        int pivot;
        if(randomized){
            ranPivot(a,low,high);
        }
        pivot = a[high];

        int i = (low - 1) ; // this is pointer pointing to leftmost
        // larger element and then get swapped every time an element
        // smaller than pivot is found
        for(int j = low ; j<high ; j++){

            if(a[j]<=pivot){
                i++;
                swap(a,i,j);
            }
        }
        // after j reaches to high -1 we terminate for loop
        //and declare i+1th index is correct place for pivot
        // since function of for-loop is swapping all <= pivot before ith index
        swap(a,i+1,high);
        return (i+1);// return pivots current position for further partition .
    }
    static void QuickSort(int[] a,int low,int high,boolean randomized){
        if(low<high){
            int pivot = partition(a,low,high,randomized);
            // this pivot variable store the location or index of pivot element
            // and is used for further partition

            QuickSort(a, low, pivot-1,randomized);
            QuickSort(a, pivot+1, high,randomized);
        }
    }
    static void printArrays(int[] a){
        System.out.print("Array looks like : ");
        for (int i : a) {
            System.out.print(i+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in array : ");
        int n,choice;
        n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter value of "+ (i+1) +" element : " );
            a[i] = sc.nextInt();
        }

        System.out.println("Enter choice for randomized or not randomized quicksort");
        System.out.println("Enter 1 to select randomized quicksort");
        System.out.println("Enter 2 to select not-randomized quicksort");
        System.out.println("Enter 3 to exit");
        choice = sc.nextInt();
        switch (choice) {
            case 1 -> {
                printArrays(a);
                QuickSort(a, 0, a.length - 1, true);
                printArrays(a);
            }
            case 2 -> {
                printArrays(a);
                QuickSort(a, 0, a.length - 1, false);
                printArrays(a);
            }
            default -> System.out.println("Invalid input");
        }


        sc.close();
    }
}
