/*

Step 1: Handle negative numbers
If x < 0, it cannot be a palindrome because of the negative sign
So immediately return false for negative numbers.

Step 2: Convert the number to a string
Turn the integer into a string so we can check each digit easily.
Example: x = 121 → s = "121"

Step 3: Use two pointers
Place one pointer at the start of the string (left)
Place another pointer at the end of the string (right)

Step 4: Compare digits
While left < right, check if the characters at left and right are the same:
If not equal, return false 
If equal, move left forward and right backward, then compare the next pair.

Step 5: All checks passed
If you reach the middle of the string and all characters matched, return true.
That means the number reads the same forward and backward.

 */



class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;

        String s = Integer.toString(x);
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }

        return true;
    }
}
