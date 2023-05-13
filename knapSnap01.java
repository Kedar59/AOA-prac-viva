import java.util.*;

public class knapSnap01 {
    static void printArray(int[][] mat){
        for(int[] row : mat){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    static void knapSnap01dp(int[][] data,int[][] K,int n,int W){
        for(int i=0;i<=n;i++){
            for(int w=0;w<=W;w++){
                if(i==0 || w==0){
                    K[i][w]=0;
                } else if(data[i-1][1]<=w){
                    K[i][w] = Math.max(data[i-1][0]+K[i-1][w-data[i-1][1]],K[i-1][w]);
                } else {
                    K[i][w] = K[i-1][w];
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements : ");
        int n = sc.nextInt();
        System.out.print("Enter maximum weight : ");
        int W = sc.nextInt();
        int[][] data = new int[n][2];//0 for price 1 for weight
        for(int i=0;i<n;i++){
            System.out.print("Enter price and weight "+(i+1)+" item : ");
            data[i][0]=sc.nextInt();
            data[i][1]=sc.nextInt();
        }
        System.out.println("data looks like");
        printArray(data);
        int[][] K = new int[n+1][W+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(K[i],0);
        }
        System.out.println("knapsnap matrix looks like before function");
        printArray(K);
        knapSnap01dp(data, K, n, W);
        printArray(K);
        System.out.println("Maximum profit is : "+K[n][W]);
        sc.close();
    }
}
