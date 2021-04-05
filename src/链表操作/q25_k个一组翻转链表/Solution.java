package 链表操作.q25_k个一组翻转链表;

/**
 * 难点在于返回每个部分被修改的头节点，新建一个头节点的前置节点 o(n)
 */
public class Solution {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        hair.next = head;
        // 四个变量  pre
        /**
         * pre start end next
         *
         * 0---->1---->2---->3---->4
         * pre 代表的是队首 即0
         * start 代表的是转换的开始， 即1 start = pre.next;  交换之后，start.next = nulll, 正好吧next接上
         * ened 代表的是转换的结束，如果不够转换的个数，直接break
         * next 代表的是转换的下一个K组的head
         */
        ListNode pre = hair;
        ListNode end = hair;

        while (end.next != null) {
            // 遍历到第k个位置  交换的最后一个位置，即第k个位置
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            // 如果不够k个位置，退出循环，前面已经将不够的连接到hair中了，所以这里直接break就好
            if (end == null){
                break;
            }
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;

            end = pre;
        }
        return hair.next;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.listNode1();
        ListNode listNode1 = reverseKGroup(listNode, 3);
        listNode1.bianLi();
    }
}
