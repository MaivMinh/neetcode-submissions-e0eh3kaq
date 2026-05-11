/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)  return list2;
        if (list2 == null)  return list1;
        ListNode res = null;
        if (list1.val < list2.val) {
            res = list1;
            list1 = list1.next;
            res.next = null;
        }   else {
            res = list2;
            list2 = list2.next;
            res.next = null;
        }
        ListNode cur = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                ListNode temp = list1;
                list1 = list1.next;
                cur.next = temp;
                cur = temp;
                cur.next = null;
            }   else {
                ListNode temp = list2;
                list2 = list2.next;
                cur.next = temp;
                cur = temp;
                cur.next = null;
            }
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }

        return res;
    }
}