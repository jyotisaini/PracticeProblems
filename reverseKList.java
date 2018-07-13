/*Given a singly linked list and an integer K, reverses the nodes of the

list K at a time and returns modified linked list.

 NOTE : The length of the list is divisible by K 
Example :

Given linked list 1 -> 2 -> 3 -> 4 -> 5 -> 6 and K=2,

You should return 2 -> 1 -> 4 -> 3 -> 6 -> 5

Try to solve the problem using constant extra space.

*/

 public ListNode reverseList(ListNode a, int b) {
        if(a==null || a.next==null || b==1||b==0)
            return a;

        ListNode prev=null, curr =null, start=a;

        int count =0;
        ListNode  next=null;
        while(count<b && start!=null)
        {
            next = start.next;
            start.next = prev;
            prev = start;
            start=next;
            count++;
        }
        if(start!=null)
            a.next= reverseList(start,b);

        return prev;

    }
