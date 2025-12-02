/*
Define DP array:

Let dp[i] = number of ways to decode the first i characters.
Base case: dp[0] = 1 (empty string can be “decoded” in one way).

Recurrence relation:
If the last digit is valid → dp[i] += dp[i-1]
If the last two digits are valid → dp[i] += dp[i-2]

Iterate from left to right:
Fill the DP array using the above logic for each position.
The final answer is dp[n], where n is the length of the string.

Edge cases:
'0' cannot be decoded alone → must be part of '10' or '20'.
Strings like "06" are invalid → these contribute 0 ways.*/


class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // empty string has 1 way

        // Base case for first character
        dp[1] = s.charAt(0) != '0' ? 1 : 0;

        for (int i = 2; i <= n; i++) {
            // Check last single digit
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];  // add dp[i-1] if valid
            }

            // Check last two digits
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];  // add dp[i-2] if valid
            }
        }

        return dp[n]; // total ways to decode
    }
}
