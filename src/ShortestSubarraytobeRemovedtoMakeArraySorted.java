public class ShortestSubarraytobeRemovedtoMakeArraySorted {
    public int findLengthOfShortestSubarray(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < arr.length - 1) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
            i++;
        }
        if (i == j) {
            return 0;
        }
        while (j > 0) {
            if (arr[j] < arr[j - 1]) {
                break;
            }
            j--;
        }
        int k = 0, res = Math.min(arr.length - 1 - i, j);
        while (k <= i && j < arr.length) {
            if (arr[k] <= arr[j]) {
                res = Math.min(res, j - k - 1);
                k++;
            } else {
                j++;
            }
        }
        return res;
    }
}
