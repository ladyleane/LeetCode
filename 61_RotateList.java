class Solution{
	public ListNode rotateRight(ListNode head, int k){
		// Base cases
		if (head == null) return null;
		if (head.next == null)	return head;

		// CLose the linked list into the ring
		ListNode old_tail = head;
		int n;
		for (n = 1; old_tail.next != null; n++)
			old_tail = old_tail.next;
		old_tail.next = head;

		// Find new tail : (n - k % n - 1)th node and new head : (n - k % n)th node
		ListNode new_tail = head;
		for (int i = 0; i < n - k % n - 1; i++){
			new_tail = new_tail.next;
		}

		ListNode new_head = new_tail.next;

		// Break the ring.
		new_tail.next = null;

		return new_head;
	}
}
