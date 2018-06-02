/* Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Try solving it using constant additional space.

Example :

Input : 

                  ______
                 |     |
                 \/    |
        1 -> 2 -> 3 -> 4

Return the node corresponding to node 3. 

*/


 public ListNode detectCycle(ListNode a) {
                if(a==null)
                    return a;
                ListNode slow =a, fast=a.next ;
                while(slow!=fast){
                    if(slow == null)
                        return null;
                    slow = slow.next;
                    if( fast == null || fast.next==null)
                        return null;
                    else  fast= fast.next.next;
                }
           ListNode start=slow.next;
                int count=1;
                while(start!=slow){
                    start=start.next;
                    count++;
                }
                 start=a;
                while(count>0)
                {
                    start= start.next;
                    count--;
                }
                ListNode b =a;

                while(b!=start)
                {
                    b=b.next;
                    start=start.next;
                }
                return start;
        }


