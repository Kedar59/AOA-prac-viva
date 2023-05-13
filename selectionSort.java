import java.util.*;
public class selectionSort {
    static void swap(int[] a,int i1,int i2){
        int temp = a[i1];
        a[i1]=a[i2];
        a[i2]=temp;
    }
    static void sort(int[] a){
        int min_ind;

        for(int i=0;i<a.length-1;i++){
            // initialize min_index as leftmost element
            min_ind=i;

            for(int j=i+1;j<a.length;j++){
                // compare it with every element after i
                if(a[min_ind]>a[j]){
                    // if element after a[i] > a[j]
                    // make min_ind as j
                    min_ind=j;
                }
            }
            // if min_ind not equal to ith term swap ith and current min_ind
            if(min_ind!=i){
                swap(a,min_ind,i);
            }
        }
    }
    static void recSort(int[] a,int i){
        if(i==a.length-2)return;
        // initialize min_index as leftmost element
        int min_ind=i;
        for(int j = i+1;j<a.length;j++){
            // compare it with every element after i
            if(a[min_ind]>a[j]){
                // if element after a[i] > a[j]
                // make min_ind as j
                min_ind=j;
            }
        }
        // if min_ind not equal to ith term swap ith and current min_ind
        if(min_ind!=i)swap(a,min_ind,i);

        // recursive call for next i
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
            System.out.print("Enter "+(i+1)+" value : ");
            a[i]=sc.nextInt();
        }
        printArrays(a);
        recSort(a,0);
//        sort(a);
        printArrays(a);
        sc.close();

    }
}
