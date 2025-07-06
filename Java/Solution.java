import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> countMap;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.countMap = new HashMap<>();
        
        // Initialize countMap with the frequency of each number in nums2
        for (int num : nums2) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int oldValue = nums2[index];
        countMap.put(oldValue, countMap.get(oldValue) - 1);
        nums2[index] += val;
        countMap.put(nums2[index], countMap.getOrDefault(nums2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int count = 0;
        for (int num : nums1) {
            int complement = tot - num;
            count += countMap.getOrDefault(complement, 0);
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */