package com.leetcode.LengthOfLongestSubstring3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ksy on 2016/1/20.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null)
            return 0;
        boolean[] flag = new boolean[256];
        int[] prefix = new int[256];
        int maxlength = 0,start = 0;

        char[] letters = s.toCharArray();

        for (int n = 0; n < letters.length; n++) {
            char current = letters[n];
            if(flag[current]){
                int length = n - start;
                maxlength = Math.max(length,maxlength);
                for(int m = start; m <= n; m++){
                    flag[letters[m]] = false;
                }
                start = prefix[current] + 1;
                prefix[current] = n;
                n = start - 1;
            }else{
                prefix[current] = n;
                flag[current] = true;
            }
        }

        maxlength = Math.max(letters.length - start, maxlength);

        return maxlength;
    }

    public static void main(String[] str){
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("dvdef"));
    }
}
