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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode second = slow;
        ListNode prev=null;
        
        while(second !=null){
            ListNode next = second.next;
            second.next=prev;
            prev=second;
            second=next;
        }
        second = prev;
        
        ListNode temp1 = head;
        ListNode temp2 = second;

        int max=0;
        while(temp2 != null){
            max = Math.max(max,temp1.val+temp2.val);
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return max;
    }
}