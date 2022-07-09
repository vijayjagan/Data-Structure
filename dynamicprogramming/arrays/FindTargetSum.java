package dynamicprogramming.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindTargetSum {
    public int findTargetSumWays(int[] nums, Map<Integer, Integer> dp, int index, int target) {
        if (index == 0) {
            if (target - nums[index] == 0 && nums[index] + target == 0) {
                return 2;
            }
            return target - nums[index] == 0 || target + nums[index] == 0 ? 1 : 0;
        }
        if (dp.containsKey((index + "$" + target).hashCode())) {
            return dp.get((index + "$" + target).hashCode());
        }
        int add = findTargetSumWays(nums, dp, index - 1, target + nums[index]);
        int sub = findTargetSumWays(nums, dp, index - 1, target - nums[index]);
        dp.put((index + "$" + target).hashCode(), add + sub);
        return add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Integer> dp = new HashMap<>();
        return findTargetSumWays(nums, dp, nums.length - 1, target);
    }

}
