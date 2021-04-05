package 回溯法.q22_括号生成.f1;

import java.util.*;

/**
 * 暴力法 o(2^2n*n)
 */
public class Solution {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char t = s.charAt(i);
            if (t == '(') {
                stack.push(t);
            } else {
                if (stack.empty() || stack.pop() != '(') {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public List<String> generateParenthesis(int n) {
        List<String> rs = new ArrayList<>();

        if (n < 1) {
            return rs;
        }
        // 首先规定好（ 1个，n= 3时，一个6个括号， 还需遍历 2*n - 1次，
        String root = "(";
        rs.add(root);
        // 因为从0开始，所以遍历2*n-1次
        for (int k = 0; k < 2 * n - 1; k++) {
            List<String> tempList = new ArrayList<>();
            // 每次在之前存储的基础上增加左括号或者右括号
            for (int i = 0; i < rs.size(); i++) {
                String temp = rs.get(i);
                tempList.add(temp + "(");
                tempList.add(temp + ")");
            }
            rs.clear();
            rs.addAll(tempList);
        }
        rs.removeIf(s -> !isValid(s));
        return rs;
    }

    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        strings.stream().forEach(System.out::println);
    }
}
