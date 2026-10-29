/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int len(ListNode h){
        int c=0;
while(h!=null){
    c++;
    h=h.next;
}
return c;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null && headB==null) return null;
    int l=len(headA);
    int l1=len(headB);
    int s;
    if(l>l1){
s=l-l1;
while(s>0){
    headA=headA.next;
    s--;
}
    }
    else{
       s=l1-l;
while(s>0){
    headB=headB.next;
    s--;
} 
    }
    ListNode t1=headA;
    ListNode t2=headB;
    while(t1!=null && t2!=null){
        if(t1==t2) return t1;
    t1=t1.next;
        t2=t2.next;
    }
return null;
    }
}