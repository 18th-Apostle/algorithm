package com.java.algorithm.n2_两数相加;

public class Solution {

    /**
     * 与官方解题思路相同，代码稍有不同。
     * 在第一个while里，我们可以将为null的节点的值设为0，直至两个节点都遍历完，而不需要在后面为没有结束的l1或l2单独遍历。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode head = null;
        int carry = 0;
        while (l1!=null && l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            int sum = val1 + val2 + carry;
            int merchant = sum / 10;
            int remainder = sum % 10;
            if(node==null){
                node = new ListNode(remainder);
                head = node;
            }else{
                node.next = new ListNode(remainder);
                node = node.next;
            }
            carry = merchant;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1!=null){
            int val = l1.val + carry;
            int merchant = val / 10;
            int remainder = val % 10;
            carry = merchant;
            l1 = l1.next;
            node.next = new ListNode(remainder);
            node = node.next;
        }
        while (l2!=null){
            int val = l2.val + carry;
            int merchant = val / 10;
            int remainder = val % 10;
            carry = merchant;
            l2 = l2.next;
            node.next = new ListNode(remainder);
            node = node.next;
        }
        if(carry!=0){
            node.next = new ListNode(carry);
        }
        return head;
    }


    /**
     * 官方描述
     * 就像你在纸上计算两个数字的和那样，我们首先从最低有效位也就是列表 l1l1 和 l2l2 的表头开始相加。由于每位数字都应当
     * 处于 0…9 的范围内，我们计算两个数字的和时可能会出现 “溢出”。例如，5 + 7 = 125+7=12。在这种情况下，我们会将当前
     * 位的数值设置为 22，并将进位 carry = 1 带入下一次迭代。进位 carry 必定是 0 或 1，这是因为两个数字相加（考虑到进位）
     * 可能出现的最大和为 9 + 9 + 1 = 19。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode p = l1, q = l2, head = node;
        int carry = 0;
        while (p!=null || q!=null){
            int x = (p!=null) ? p.val : 0;
            int y = (q!=null) ? q.val : 0;
            int sum = x+y+carry;
            carry = sum/10;
            head.next = new ListNode(sum%10);
            head = head.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry>0){
            head.next = new ListNode(carry);
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        addTwoNumbers(l1, l2);
    }


}
