/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode a = l1, b = l2, current = ans;
        int temp = 0;
        while (a != null || b != null){
            int x = (a != null) ? a.val : 0;
            int y = (b != null) ? b.val : 0;
            int sum = temp + x + y;
            temp = sum / 10;    //if the sum > 0
            current.next = new ListNode(sum % 10);
            //update the operating parameters
            current = current.next;
            if (a != null) a = a.next;
            if (b != null) b = b.next;
        }
        if (temp > 0) current.next = new ListNode(temp);
        return ans.next;
    }
}