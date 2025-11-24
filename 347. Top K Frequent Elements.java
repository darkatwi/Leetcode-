/*
Key idea of this solution
1.Count how often each number appears.
2.Sort numbers by frequency.
3.Pick the k most frequent numbers.


Step 1: Count frequencies
Go through the array and count how many times each number appears.
Store this in a map where:
Key = the number
Value = how many times it occurs (its frequency)
Example: [1,1,1,2,2,3] → map becomes {1=3, 2=2, 3=1}



Step 2: Sort numbers by frequency
Take all the numbers and their frequencies from the map.
Sort them from highest frequency to lowest frequency.
After sorting, the numbers that appear most often are at the front.
Example sorted: [1, 2, 3] (because 1 appears 3 times, 2 appears 2 times, 3 appears 1 time)


Step 3: Pick the top k
Take the first k numbers from the sorted list — these are the numbers with the highest frequencies.
Example: If k = 2, pick [1, 2]


Step 4: Return the result
Return the top k numbers as the answer.

*/


class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
        entryList.sort((a, b) -> b.getValue() - a.getValue());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) ans[i] = entryList.get(i).getKey();

        return ans;
    }
}

