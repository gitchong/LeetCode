package 链表操作.q24两两交换链表中的节点;

public class Solution {

    public static ListNode swagPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        // 虚拟节点记录最终结果
        ListNode dummyList = new ListNode(0);
        dummyList.next = head;
        // 临时节点, 交换的起点
        ListNode tempNode = dummyList;
        while (tempNode.next != null && null != tempNode.next.next) {
            ListNode node1 = tempNode.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            tempNode.next = node2;
            tempNode = node1;
        }

        return dummyList.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode1();
        ListNode listNode1 = swagPairs(listNode);
        listNode1.bianLi();
    }
}
