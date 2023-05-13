public class SubsetSumB {
    public static void main(String[] args) {
        int[] arr = {15, 22, 14, 26, 32, 9, 16, 8};
        int targetSum = 53;
        System.out.println("Subset sums that add up to " + targetSum + ":");
        subsetSum(arr, targetSum, new boolean[arr.length], 0, 0);
    }

    public static void subsetSum(int[] arr, int targetSum, boolean[] used, int sumSoFar, int index) {
        if (sumSoFar == targetSum) { // subset found
            for (int i = 0; i < arr.length; i++) {
                if (used[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        if (index == arr.length || sumSoFar > targetSum) { // end of array or target sum exceeded
            return;
        }
        // include current element
        used[index] = true;
        subsetSum(arr, targetSum, used, sumSoFar + arr[index], index + 1);
        // exclude current element
        used[index] = false;
        subsetSum(arr, targetSum, used, sumSoFar, index + 1);
    }
}

