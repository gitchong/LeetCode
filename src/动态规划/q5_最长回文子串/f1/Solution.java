package 动态规划.q5_最长回文子串.f1;

/**
 * o(n^2) 以每个字符为中心计算回文长度
 */
class Solution {

    /**
     *
     * @param s 回文字串
     * @param index 每个字符的位置
     * @return 返回第i个字母的最大的回文串
     */
    public static String getPalindrome(String s, int index) {
        String rs = "";
        int sLen = s.length();
        //起始边界  左边界
        int i = index;
        // 起始边界 右边界
        int j = index;
        // 从index开始遍历重复的，直到没有重复的break,记录下有边界供后面的遍历使用
        while (j < sLen) {
            if (s.charAt(j) == s.charAt(index)) {
                rs = rs + s.charAt(j);
                j++;
            } else {
                break;// 推出循环
            }
        }
        // index已经被遍历 减一到前面一个元素，
        i--;
        // 左右边界大比较  i往左，j往右 边界条件是i 到最左  j到最右
        while (i >= 0 && j < sLen) {
            if (s.charAt(i) == s.charAt(j)) {
                rs = s.charAt(i) + rs;
                rs = rs + s.charAt(i);
                i--;
                j++;
            } else {
                break;
            }
        }
        return rs;
    }

    public static String longestPalindrome(String s) {
        // 需要两个变量来记录长度和回文串
        int maxLen = -1;
        String rs = "";
        for (int i = 0; i < s.length(); i++) {
            String t = getPalindrome(s, i);
            if (t.length() > maxLen) {
                maxLen = t.length();
                rs = t;
            }
        }
        return rs;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("adddccdddhhfsddd"));
    }
}
