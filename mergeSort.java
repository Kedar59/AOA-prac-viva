import java.util.*;
public class mergeSort {
    static void merge(int[] a,int low,int mid,int high){
        // determine length of 2 split sorter halves
        int l_half,r_half;
        l_half = mid-low+1;
        r_half = high-mid;
        // create temp arrays to store left and right sorted arrays
        int[] left = new int[l_half];
        int[] right = new int[r_half];

        for(int i=0;i<l_half;i++){
            left[i]=a[low+i];
        }
        for(int i=0;i<r_half;i++){
            right[i]=a[mid+1+i];
        }
        // now since copy of both halves is created we will start merging in main array
        // while filling original array we will follow these steps
        // step 1 fill till all elements in 1st or 2nd array are used
        int i=0,j=0,k=low;
        while(i<l_half && j<r_half){
            if(left[i]<right[j]){
                a[k]=left[i];
                i++;
            } else {
                a[k]=right[j];
                j++;
            }
            k++;
        }

        // now depending on which part of the array is still unused copy rest of the elements are inserted
        while(i<l_half){
            a[k]=left[i];
            i++;
            k++;
        }
        while(j<r_half){
            a[k]=right[j];
            j++;
            k++;
        }

    }
    static void sort(int[] a,int low,int high){
        if(low<high){
            int mid = low + ( high - low ) /2;
            // split in 2 halves
            sort(a,low,mid);
            sort(a,mid+1,high);

            // after sorting 2 split halves merge them
            merge(a,low,mid,high);

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
        System.out.print("Enter size of array : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("Enter "+(i+1)+" element : ");
            a[i]=sc.nextInt();
        }
        printArrays(a);
        sort(a,0,a.length-1);
        printArrays(a);
        sc.close();
    }
}
