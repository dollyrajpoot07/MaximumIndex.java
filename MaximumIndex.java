// Given an array arr[], find the maximum j – i such that arr[j] > arr[i].
// Examples : 
//   Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
//   Output: 6  (j = 7, i = 1)

//   Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
//   Output: 8 ( j = 8, i = 0)

//   Input:  {1, 2, 3, 4, 5, 6}
//   Output: 5  (j = 5, i = 0)

//   Input:  {6, 5, 4, 3, 2, 1}
//   Output: -1 


class MaximumIndex {

    static int maxIndexDiff(int arr[], int n) {

        int[] leftMin = new int[n];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++)
            leftMin[i] = Math.min(leftMin[i - 1], arr[i]);

        int maxDist = Integer.MIN_VALUE;
        int i = n - 1, j = n - 1;
        while (i >= 0 && j >= 0) {
            if (arr[j] >= leftMin[i]) {
                maxDist = Math.max(maxDist, j - i);
                i--;
            } else
                j--;
        }

        return maxDist;
    }

    public static void main(String[] args) {
        int arr[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
        int n = arr.length;
        int maxDiff = maxIndexDiff(arr, n);
        System.out.print(maxDiff);
    }
}