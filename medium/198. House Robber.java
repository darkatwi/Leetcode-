/*


dp[i] represents the maximum money we can rob from house 0 up to house i.

Base cases:
House 0 → rob it → dp[0] = nums[0]
House 1 → choose richer of house 0 or 1 → dp[1] = max(nums[0], nums[1])

Choices at each house i (i ≥ 2):
Skip current house i: take the best money from the previous house → dp[i-1]
Rob current house i: add current house money nums[i] + best money from safe previous houses → dp[i-2] + nums[i]

Recurrence relation:
dp[i] = max(dp[i-1], dp[i-2] + nums[i])

This picks the better choice at each house: skip or rob.

Final answer:
After iterating all houses, dp[n-1] gives the maximum money we can rob without alerting the police.

*/


class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;               // no houses
        if (n == 1) return nums[0];         // only one house
        if (n == 2) return Math.max(nums[0], nums[1]); // two houses

        int[] dp = new int[n];
        dp[0] = nums[0];                     // base case
        dp[1] = Math.max(nums[0], nums[1]);  // base case

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]); // skip or rob
        }

        return dp[n-1]; // max money we can rob
    }
}
