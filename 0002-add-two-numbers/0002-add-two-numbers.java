class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1;
        ListNode second = l2;
        ListNode dummy = new ListNode(0);
        ListNode sum = dummy;
        int carry = 0;

        while (first != null || second != null) {
            int x = (first != null) ? first.val : 0;
            int y = (second != null) ? second.val : 0;
            int total = x + y + carry;

            if (total < 10) {
                sum.next = new ListNode(total);
                sum = sum.next;
                carry = 0;
            } else {
                int digit = total % 10;
                sum.next = new ListNode(digit);
                sum = sum.next;
                carry = total / 10;
            }

            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        if (carry > 0) {
            sum.next = new ListNode(carry);
        }

        return dummy.next;
    }
}