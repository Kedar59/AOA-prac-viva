import java.util.*;
public class BinarySearch {

    static int binaryRecursive(int[] a,int low,int high,int s){
        if(high>=low){
            int mid = low + ( high - low ) / 2;
            if(a[mid] == s) {
                return mid;
            } else if (a[mid] < s){
                return binaryRecursive(a,mid+1,high,s);
            } else {
                return binaryRecursive(a,low,mid-1,s);
            }
        } else {
            return -1;
        }
    }
    static void binaryIterative(int[] a,int low,int high,int s){
        int mid,ind = -1;
        boolean found = false ;
        while(low<=high){
            mid = low + (high - low) / 2 ;
            if(a[mid] == s){
                ind = mid;
                found = true;
                break;
            } else if ( a[mid] < s){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if(found){
            System.out.println("Value of " + s + " was found at "+ ind +" in array a");
        } else {
            System.out.println("Value of "+s+" was not found in array a");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements in the list : ");
        int n =sc.nextInt();
        int choice;
        boolean play = true;
        int[] a = new int[n];
        for (int i=0;i<n;i++){
            System.out.print("Enter value of "+(i+1)+" element : ");
            a[i] = sc.nextInt();
        }
        while(play){
            System.out.print("Enter number to be searched in the list : ");
            int s =sc.nextInt();
            System.out.println("Enter 1 for iterative binary search");
            System.out.println("Enter 2 for recursive binary search");
            System.out.println("Enter 3 for Exit");
            System.out.print("Enter choice for type of binary search : ");
            choice =sc.nextInt();
            switch (choice){
                case 1:{
                    binaryIterative(a,0,a.length-1,s);
                    break;
                }
                case 2:{
                    int place = binaryRecursive(a,0,a.length-1,s);
                    if(place!=(-1)) System.out.println("Value of " + s + " was found at "+ place+" in array a");
                    else System.out.println("Value of "+s+" was not found in array a");
                    break;
                }
                case 3:{
                    play=false;
                    break;
                }

                default:{
                    System.out.println("Invalid input plz try again");
                    break;
                }

            }
        }


        sc.close();
    }
}
