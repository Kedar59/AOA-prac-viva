import java.util.*;

class Pair{
    int min,max;
    Pair(){
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
    }

}
public class minMaxDAC {

    public static Pair solution(int[] a, int low, int high){
        // here we have 3 cases
        Pair sol = new Pair();
        int mid;
        if(low==high){                  // Only 1 element in this partition
            sol.max = sol.min = a[low]; // here we can also write high
            return sol;
        } else if (high - low == 1) {   // Partition has 2 elements
            if(a[low]<a[high]){
                sol.min = a[low];
                sol.max = a[high];
            } else {
                sol.min = a[high];
                sol.max = a[low];
            }
            return sol;
        } else {                                // More than 2 elements in the partition
            mid = low+high/2;
            Pair mml = solution(a,low,mid);          // Recursion splitting into right and left parts this is left part
            Pair mmr = solution(a,mid+1,high);   // Recursion splitting into right and left parts this is right part

            if(mml.min < mmr.min)  sol.min = mml.min;
            else sol.min = mmr.min;

            if(mml.max < mmr.max)  sol.max = mmr.max;
            else sol.max = mml.max;

            return sol;
        }
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            System.out.print("Enter value of "+(i+1)+" element : ");
            a[i] = sc.nextInt();
        }
        Pair mm = solution(a,0,a.length-1);
        System.out.println("Minimum number of array is : " + mm.min);
        System.out.println("Maximum number of array is : " + mm.max);
        sc.close();
    }
}
