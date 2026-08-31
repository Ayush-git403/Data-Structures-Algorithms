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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int first = -1;
        int prevCritical = -1;
        int min = Integer.MAX_VALUE;
        int index = 1;
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null && curr.next != null) {

            int p = prev.val;
            int c = curr.val;
            int next = curr.next.val;

            // Critical point
            if ((c > p && c > next) ||
                (c < p && c < next)) {

                if (first == -1) {
                    // First critical point
                    first = index;
                } else {
                    // Distance from previous critical point
                    min = Math.min(
                        min,
                        index - prevCritical
                    );
                }

                prevCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        int max = prevCritical - first;

        return new int[]{min, max};
    }
}