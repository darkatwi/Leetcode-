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
