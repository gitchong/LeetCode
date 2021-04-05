package 数字操作.q9_回文数;

/**
 * 不转换成String 反转一半的数字o(log(n))
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        if (x % 10 == 0) {
            return false;
        }
        int rs = 0;
        while (rs < x / 10) {
            int y = x % 10;
            x = x / 10;
            rs = rs * 10 + y;
            if (rs == x) {// 处理偶数回文
                return true;
            } else if (x / 10 == rs) {// 处理奇数回文
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(12343215));
    }
}
