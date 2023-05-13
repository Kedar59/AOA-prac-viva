import java.util.Arrays;
import java.util.Scanner;

public class fracKnapSnapGreedy {
    static void swapRows(double[][] data,int i1,int i2){
        double[] temp = data[i1];
        data[i1] = data[i2];
        data[i2] = temp;
    }
    static void bSort(double[][] data){
        for(int i=0;i<data.length;i++){
            for(int j=0;j<data.length-i-1;j++){
                if(data[j][2]<data[j][2]){
                    swapRows(data,j,j+1);
                }
            }
        }
    }
    static void printArray(double[][] data){
        for(double[] row : data){
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
    static double knapSnapGreedy(double[][] data,double M){
        double mP = 0;
        int i=0;
        while(M>0){
            if(M>=data[i][1]){
                M-=data[i][1];
                mP+=data[i][0];
                data[i][3]=1;
                i++;
            } else {
                data[i][3]=M/data[i][1];
                mP+=data[i][3]*data[i][0];
                break;
            }
        }
        return mP;
    }
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.print("Enter number of items : ");
        int n = sc.nextInt();
        System.out.print("Enter maximum  mass of items : ");
        double M = sc.nextDouble();
        double[][] data = new double[n][4];
        for(int i=0;i<n;i++){
            Arrays.fill(data[i],0);
        }
        //data =   0price | 1weight | 2price/weight | 3fraction
        for(int i=0;i<n;i++){
            System.out.print("Enter price and weight of "+(i+1)+" item : ");
            data[i][0]=sc.nextDouble();
            data[i][1]=sc.nextDouble();
            data[i][2]=data[i][0]/data[i][1];
        }
        printArray(data);
        bSort(data);
        printArray(data);
        double maxProfit = knapSnapGreedy(data,M);
        printArray(data);
        System.out.println("Maximum profit is : "+maxProfit);
        sc.close();

    }
}
