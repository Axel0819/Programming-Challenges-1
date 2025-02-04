public class MergeTwoSortedList {

    public ListNode solution(ListNode l1, ListNode l2) {
        ListNode baseNode = new ListNode(0);
        ListNode prev = baseNode;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 != null ? l1 : l2;
        return baseNode.next;
    }
}
