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
        List<Integer>ls=new ArrayList<>();
        int idx=2;
        int ans[]={-1,-1};
        if(head.next==null||head.next.next==null)
            return ans;
        ListNode prev=head;
        ListNode cur=head.next;
        ListNode next=head.next.next;
        while(next!=null)
        {
            int p=prev.val;
            int c=cur.val;
            int n=next.val;

            if(c>p&&c>n)
               ls.add(idx);
            if(c<p&&c<n)
               ls.add(idx);
            idx++;   
            prev=cur;
            cur=next;
            next=next.next;   

        }
        if(ls.size()<2)
           return ans;
        int n=ls.size();   
        ans[1]=ls.get(n-1)-ls.get(0);
        int min=1000000000;

        for(int i=1;i<n;i++)
        {
            min=Math.min(min,ls.get(i)-ls.get(i-1));
            // System.out.println(ls.get(i));
        }
        ans[0]=min;
        return ans;
    }
}