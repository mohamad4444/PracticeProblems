
 // Definition for singly-linked list.
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Problem21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode current1,current2;
            ListNode newListHead,current3;
            current1=list1;
            current2=list2;
            if(current1==null &&current2==null){
                return null;
            }else if(current1==null){
                return current2;
            }else if(current2==null){
                return current1;
            }
            if(current1.val>current2.val){
                newListHead=new ListNode(current2.val);
                current2=current2.next;
            }else{
                newListHead= new ListNode(current1.val);
                current1=current1.next;
            }
            current3=newListHead;
            while(current1!=null &&current2!=null){
                if(current1.val>current2.val){
                    current3.next=new ListNode(current2.val);
                    current3=current3.next;
                    current2=current2.next;
                }else{
                    current3.next=new ListNode(current1.val);
                    current3=current3.next;
                    current1=current1.next;
                }
            }
            while(current1!=null){
                current3.next=new ListNode(current1.val);
                current3=current3.next;
                current1=current1.next;
            }
            while(current2!=null){
                current3.next=new ListNode(current2.val);
                current3=current3.next;
                current2=current2.next;
            }
            return newListHead;

    

        }
    }