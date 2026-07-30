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

    public ListNode convArr(ArrayList<Integer> ar){
        if(ar==null || ar.size()==0){
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for(int num: ar){
            temp.next = new ListNode(num);
            temp = temp.next;
        }
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp1 = list1, temp2 = list2;
        while(temp1!=null){
            arr.add(temp1.val);
            temp1 = temp1.next;
        }
        while(temp2!=null){
            arr.add(temp2.val);
            temp2 = temp2.next;
        }
        Collections.sort(arr);
        ListNode list = convArr(arr);
        return list;
    }
}