package 链表操作.q19_删除链表的倒数第N个节点;


public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void bianLi() {
        ListNode temp = this;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

