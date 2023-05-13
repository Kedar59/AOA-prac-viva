import java.util.*;

public class insertionSort {
    static void sort(int[] a){
        int key,j ;
        for(int i=1;i<a.length;i++){
            // select leftmost unsorted element as key
            key = a[i];
            // select element left to key as j
            j=i-1;
            while(j>=0 && key<a[j]){
                // as long as j>=0 and left element to key >= key make left+1 element = left
                a[j+1]=a[j];
                //decrement j
                j--;
            }
            // once out of the loop make left+1 element = key
            a[j+1]=key;
        }
    }
    static void recSort(int[] a,int i){
        if(i>=a.length)return;
        // select leftmost unsorted element as key
        // select element left to key as j
        int key = a[i],j=i-1;
        while(j>=0 && a[j]>key){
            // as long as j>=0 and left element to key >= key make left+1 element = left
            a[j+1]=a[j];
            //decrement j
            j--;
        }
        // once out of the loop make left+1 element = key
        a[j+1]=key;
        recSort(a,i+1);
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
//        sort(a);
        recSort(a,1);

        printArrays(a);
        sc.close();
    }
}
