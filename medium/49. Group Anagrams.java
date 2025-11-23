/*Group Anagrams Solution (Java)

This code solves the “Group Anagrams” problem from LeetCode. The goal is to group strings that are anagrams of each other.

How it Works
Frequency Array as Key
For each string, we count the occurrences of each lowercase letter using an array of size 26.
Example: "eat" → e:1, a:1, t:1
Convert Frequency Array to String Key
The array is converted to a string like "1#0#1#...#1#" to use as a key in a HashMap.
Strings with the same character counts (anagrams) will produce the same key.
Group Strings Using HashMap
HashMap key → frequency string
HashMap value → list of strings matching that key
computeIfAbsent ensures a new list is created if the key doesn’t exist, then adds the string.
Return the Result
Finally, we return all values from the HashMap as a list of lists. Each inner list contains anagrams grouped together.*/



import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26]; 

            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int count : freq) {
                sb.append(count).append("#"); 
            }

            String key = sb.toString();

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);

        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
