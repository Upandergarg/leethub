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
    ListNode merge(ListNode t1, ListNode t2){
        ListNode ans= new ListNode(-1);
        ListNode h1=t1;
        ListNode h2=t2;
        ListNode d=ans;
        while(h1!=null || h2!=null){
          if(h1!=null && h2!=null){
              if(h1.val<h2.val){
                d.next=h1;
                d=h1;
                h1=h1.next;
            }
            else{
                d.next=h2;
                d=h2;
                h2=h2.next;
            }
          }
          else{
            if(h1!=null){
                d.next=h1;
                h1=null;
            }
            else{
                d.next=h2;
                h2=null;
            }
          }
        }
        return ans.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length<1) return null;
        ListNode t1=lists[0];
       
        for(int i=1; i<lists.length; i++){
            t1= merge(t1,lists[i]);
        }
        return t1;
    }
}