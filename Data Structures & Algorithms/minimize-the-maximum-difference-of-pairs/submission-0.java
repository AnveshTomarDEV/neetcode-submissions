class Solution {

    public int minimizeMax(int[] nums, int p) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        int ans = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int pairs = 0;

            for (int i = 1; i < nums.length; i++) {

                if (nums[i] - nums[i - 1] <= mid) {
                    pairs++;
                    i++; // Skip both elements
                }
            }

            if (pairs >= p) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}