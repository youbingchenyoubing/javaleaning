package leetcode;

/**
 * @author Mr_chen
 * @date 2021-04-09
 * @Project algorithm
 **/
public class LinkSortByNumber {
    public static void main(String[] args) {

    }

      public class ListNode {
        int val;
        ListNode next = null;
      }

    public ListNode partition (ListNode head, int x) {
      ListNode last = head;
      while(last.next!=null){
          last = last.next;
      }

      ListNode beforeFind = head;
      ListNode find = beforeFind.next;
      ListNode newLast = last;
      while(find!=last.next){
          if(find.val >=x){
              newLast.next = find;
              beforeFind.next= find.next;
              beforeFind = find.next;
              find = beforeFind.next;
          }
          else{
              beforeFind = beforeFind.next;
              find = beforeFind.next;
          }
      }
      return head;
    }
}
