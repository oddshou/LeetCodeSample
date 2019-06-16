package com.odds.algorithm;

import java.util.HashMap;
import java.util.Map;

class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        //先排序再取值,排序同时记录
        int [] temps = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j >= 0 && j + 1 < nums.length && nums[j + 1] < nums[j]) {
                int tem = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tem;
                j--;
            }
        }
        //
        int last = 0;
        int i = nums.length - 1;
        for (; i > 0;i--) {
                int j = last;
                if (nums[j] + nums[i] > target) {
                    while (j > 0 && nums[j] + nums[i] > target) {
                        j--;
                        if (nums[j] + nums[i] == target) {
                            last = j;
                            break;
                        }else if(nums[j] + nums[i] < target) {
                            last = j;
                        }
                    }
                } else if (nums[j] + nums[i] < target) {
                    while (j < i && nums[j] + nums[i] < target) {
                        j++;
                        if (nums[j] + nums[i] == target) {
                            last = j;
                            break;
                        }else if(nums[j] + nums[i] > target) {
                            last = j;
                        }
                    }
                }
            if (nums[j] + nums[i] == target){
                break;
            }


        }
        System.out.println(nums[last] + " : " + nums[i]);
        //取两个数
        int [] result = new int[]{-1, -1};
        for (int index = 0; index < temps.length; index++) {
            if (nums[last] == temps[index] || nums[i] == temps[index]) {
                if (result[0] < 0) {
                    result[0] = index;
                } else  {
                    result[1] = index;
                    break;
                }
            }
        }
        return result;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] data = new int[]{5,75,25};
        twoSum(data, 100);
    }
}
