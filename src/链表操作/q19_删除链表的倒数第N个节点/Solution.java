package 链表操作.q19_删除链表的倒数第N个节点;

/**
 * 利用两个指针 o(n)
 */
public class Solution {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建一个临时的dummy的listNode,带有头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // first 节点代表率先遍历的节点
        ListNode first = dummy;
        // second 节点代表后面遍历的节点
        ListNode second = dummy;
        /**
         * <P>
         *    second                 First
         *     1 ----> 2 ----> 3 ----> 4 ----> 5 ----> 6 ----> null
         *     中间间隔两个  先将first移动到3的位置，间隔n个
         *     然后判别first是否为null, 为null的时候second也移动到了合适的位置
         *     然受second.next = second.next.next
         *
         * </P>
         */

        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);

        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);

        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        ListNode listNode = removeNthFromEnd(listNode1, 2);
        listNode.bianLi();
    }
}
