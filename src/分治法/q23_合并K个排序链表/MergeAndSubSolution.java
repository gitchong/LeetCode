package 分治法.q23_合并K个排序链表;

/**
 * 分而治之思想运用
 */
public class MergeAndSubSolution {

    public static ListNode mergeLists(ListNode[] lists) {
        final int length = lists.length;
        if (length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        // 递归获取两个节点
        int mid = length / 2;
        ListNode one = mergeLists(subArray(lists, 0 , mid));
        ListNode two = mergeLists(subArray(lists, mid, length));
        // 合并最后两个节点
        return mergeTwoLists(one, two);
    }

    private static ListNode[] subArray(ListNode[] listNodes, int start, int end) {
        int size = end - start;
        ListNode[] result = new ListNode[size];
        int index = 0;
        for (int i = start; i < end; i++) {
            result[index++] = listNodes[i];
        }

        return result;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        // 临时变量
        ListNode newNode = new ListNode(0);
        // 新增的头指针
        ListNode head = newNode;
        // 循环处理
        while (l1 != null && l2 != null) {
            int valOne = l1.val;
            int valTwo = l2.val;
            // 插入小的元素节点
            if(valOne <= valTwo) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            // 变换 newNode
            newNode = newNode.next;
        }
        // 如果长度不一样
        if(l1 != null) {
            newNode.next = l1;
        }
        if(l2 != null) {
            newNode.next = l2;
        }
        return head.next;
    }


    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode1();
        ListNode listNode2 = ListNode.listNode2();
        ListNode listNode3 = ListNode.listNode1();
        ListNode listNode4 = ListNode.listNode2();
        ListNode listNode1 = mergeLists(new ListNode[]{listNode, listNode2, listNode3, listNode4});
        listNode1.bianLi();
    }
}
