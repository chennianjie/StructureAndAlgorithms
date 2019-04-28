package digui;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
 */
public class PrintList {
     class ListNode {
       int val;
       ListNode next = null;

        ListNode(int val) {
          this.val = val;
       }
    }
    ArrayList<Integer> arrayList = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        if (listNode!=null) {
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}
