package com.leetcode.AddTwoNumbers2;

/**
 * Created by ksy on 2016/1/20.
 */

public class Solution {

      public class ListNode {
         int val;
         ListNode next;
          ListNode(int x) { val = x; }
     }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int mod = 0,first = 0;
        ListNode tempNode = null,start = null;
        while(l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }

            int a = v1 + v2 + mod;
            int[] result = {a % 10,a/10};
            ListNode newNode = new ListNode(result[0]);
            mod = result[1];
            if(tempNode != null){
                tempNode.next = newNode;
            }
            tempNode = newNode;
            if(first == 0){
                first = 1;
                start = tempNode;
            }
        }

        if(mod > 0){
            ListNode newNode = new ListNode(mod);
            tempNode.next = newNode;
        }

        return start;
    }

}
