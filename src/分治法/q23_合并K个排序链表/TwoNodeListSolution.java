package 分治法.q23_合并K个排序链表;

public class TwoNodeListSolution {
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        // 临时变量
        ListNode tempNode = new ListNode(0);
        ListNode head = tempNode;

        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 <= val2) {
                tempNode.next = l1;
                l1 = l1.next;
            } else {
                tempNode.next = l2;
                l2 = l2.next;
            }
            // tempNode更新
            tempNode = tempNode.next;
        }

        if (l1 != null) {
            tempNode.next = l1;
        }

        if (l2 != null) {
            tempNode.next = l2;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode1();
        ListNode listNode2 = ListNode.listNode2();
        ListNode listNode1 = mergeTwoList(listNode, listNode2);
        listNode1.bianLi();
    }
}
