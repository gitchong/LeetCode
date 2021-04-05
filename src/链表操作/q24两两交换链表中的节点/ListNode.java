package 链表操作.q24两两交换链表中的节点;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }



    public static ListNode listNode1(){
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        return listNode1;
    }

    public static ListNode listNode2(){
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        //listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        return listNode4;
    }

    public void bianLi() {
        ListNode temp = this;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

