public class ClimbStairs {
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;

        int[] dp = new int[n + 1]; // dp[i] = #ways to reach step i
        dp[0] = 1; // base case
        dp[1] = 1; // base case

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2]; // recurrence
        }

        return dp[n];
    }
}
