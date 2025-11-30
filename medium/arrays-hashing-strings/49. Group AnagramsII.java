/*Group Anagrams Solution Using Sorting (Java) nb 2

This code solves the “Group Anagrams” problem from LeetCode using the sorting method. 
The goal is to group strings that are anagrams of each other.

How it Works
Sort Each String
For each string, convert it to a character array and sort the characters.
Example: "eat" → ['a','e','t'] → "aet"
Use Sorted String as Key
The sorted string becomes the key in a HashMap.
Strings that are anagrams will have identical sorted keys.
Example: "eat", "tea", "ate" all sort to "aet"
Group Strings Using HashMap
HashMap key → sorted string
HashMap value → list of strings with that key
computeIfAbsent creates a new list if the key doesn’t exist, then adds the string.
Return the Result
Return all values from the HashMap as a list of lists. Each inner list contains grouped anagrams.*/


import java.util.*;

public class GroupAnagramsSorting {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);              
            String key = new String(chars);  

            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
