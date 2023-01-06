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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // print all
//         while(l1 !=null)
   //     {
             // System.out.print(l1.val);
     //        l1 = l1.next;
       // }
        
        
        ListNode result = new ListNode();
        ListNode first = result;
        int tmpNextSum = 0;

        while(result != null)
        { 
            int l1val = l1!=null?l1.val:0;
            int l2val = l2!=null?l2.val:0;       
            System.out.print(l1val);
            System.out.print(l2val);
            int sum =  l1val+l2val + tmpNextSum; 
            // System.out.print(sum);
            int current = 0;

        if(tmpNextSum > 0)
        {
            tmpNextSum  = 0;
        }
            
            if(sum >= 10)
            { 
                current = sum - 10;
                tmpNextSum = 1;
            }
            else
            {
                current = sum;
            }
            result.val = current;
        
            // result = new ListNode(current, new ListNode());
            System.out.print(result.val);

            l1 = l1!=null?  l1.next:null;
            l2 = l2!=null?  l2.next:null;
            
            // check need more round
            if(l1!=null || l2!=null)
            {
                result.next = new ListNode();
                result = result.next;
            }
            else if(tmpNextSum>0)
            {
                 result.next = new ListNode();
                result = result.next;
            }
            else
            {
                break;                
            }
        }
        return first;
    }
}