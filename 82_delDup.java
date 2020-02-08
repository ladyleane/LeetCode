class Solution{
	public ListNode deleteDuplicates(ListNode head){
		if (head == null){
			return null;
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode latter = dummy;
		ListN0de pre = head;

		while (pre != null){
			if (pre.next != null && pre.val == pre.next.val){
				do{
					pre = pre.next;
				} while (pre.next != null && pre.val == pre.next.val);
				latter.next = pre.next;
				pre = pre.next;
			} else {
				pre = pre.next;
				latter = latter.next;
			}
		}

		return dummy.next;
	}
}
