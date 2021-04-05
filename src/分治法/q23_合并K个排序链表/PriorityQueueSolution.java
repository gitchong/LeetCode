package 分治法.q23_合并K个排序链表;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * {https://juejin.cn/post/6844904198555992077}
 */
public class PriorityQueueSolution {

    public static ListNode mergeLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode listNode : lists) {
            queue.offer(listNode);
        }

        return buildHead(queue);
    }

    public static ListNode buildHead(Queue<ListNode> queue) {
        ListNode dummy = new ListNode(0);
        // 最后一个元素添加最小的元素
        ListNode tail = dummy;
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode1();
        ListNode listNode2 = ListNode.listNode2();
        ListNode listNode1 = mergeLists(new ListNode[]{listNode, listNode2});
        listNode1.bianLi();
    }
}
