/*
1. Goal
We want to reverse the order of words in a string, ignoring extra spaces.
Example: " hello world " → "world hello".

2. Approach
Instead of splitting the string scan the string
Words are sequences of non-space characters
Spaces separate words
Extra spaces at the start/end or between words need to be ignored.

3. Direction of scanning
Reversing words is easier if we start from the end of the string.
This way, we can append words to the result directly in reverse order.

4. Skip unnecessary characters
When scanning backward, skip trailing spaces first.
This ensures we only deal with actual words.

5. Identify each word
Find the end of a word (first non-space character from the right).
Then find the start of the word (first space before this word or beginning of string).
This gives us a clean slice of the string representing the current word.

6. Build the result
Append the word to the result string.
Add a space only if the result already has content (to avoid trailing/leading spaces).

7. Repeat
Move left past the word and continue until the entire string is processed.*/



class Solution {
    public String reverseWords(String s) {
        StringBuilder results = new StringBuilder();
        int i = s.length() -1;

        while(i>=0){

            while(i>=0 && s.charAt(i) == ' ') i--;

            if(i<0) break;

            int end =i;

            while(i>=0 && s.charAt(i) != ' ') i--;

            if(results.length() >0) results.append(' ');
            results.append(s.substring(i+1,end+1));
        }

        return results.toString();
    }
}
