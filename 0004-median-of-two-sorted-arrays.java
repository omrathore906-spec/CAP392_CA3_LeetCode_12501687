class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        int leftSize = (m + n + 1) / 2;

        while (low <= high) {
            int partition1 = low + (high - low) / 2; //number of elements taken from nums1 into the left half
            int partition2 = leftSize - partition1; //number of elements taken from nums2 into the left half

            int Left1, Left2, Right1, Right2;

            if (partition1 == 0) {
                Left1 = Integer.MIN_VALUE;
            } else {
                Left1 = nums1[partition1 - 1];
            }

            if (partition1 == m) {
                Right1 = Integer.MAX_VALUE;
            } else {
                Right1 = nums1[partition1];
            }

            if (partition2 == 0) {
                Left2 = Integer.MIN_VALUE;
            } else {
                Left2 = nums2[partition2 - 1];
            }

            if (partition2 == n) {
                Right2 = Integer.MAX_VALUE;
            } else {
                Right2 = nums2[partition2];
            }

            if (Left1 <= Right2 && Left2 <= Right1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(Left1, Left2);
                } else {
                    return (Math.max(Left1, Left2) + Math.min(Right1, Right2)) / 2.0;
                }
            }
            if (Left1 > Right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }

        }
        return 0.0;
    }
}