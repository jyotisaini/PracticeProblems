/*

Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.

 Note:
If n is greater than the size of the list, remove the first node of the list.

*/
public ListNode removeNthFromEnd(ListNode a, int b) {
        if (a == null) return null;
        int count = 0;
        ListNode c = a, prevc =null;
        while (c!= null) {
            count++;
            prevc = c;
            c= c.next;
        }

        if(count <= b) {
           // System.out.println("here");
            return a.next;
        }

        count = 1;

        ListNode prevh = null, current = a;
        while (count < b) {
            current = current.next;
            count++;
        }
        ListNode head = a;
        while (current.next != null) {
            prevh = head;
            head = head.next;
            current = current.next;
        }
        prevh.next = head.next;
        return a;

   } 
