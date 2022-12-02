package meeting;

import java.util.HashMap;
import java.util.Map;

public class Coding002 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(""));
    }

    private static int lengthOfLongestSubstring(String s) {

        if (s == null || s.isEmpty()) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        Map<String, Integer> indexMap = new HashMap<>();
        while (right < s.length()) {
            // 右边移动至没有重复的范围
            String chStr = String.valueOf(chars[right]);
            if (indexMap.containsKey(chStr)) {
                left = Math.max(left, indexMap.get(chStr) + 1);
            }
            max = Math.max(max, (right - left) + 1);
            indexMap.put(chStr, right);
            right++;
        }
        return max;
    }


    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        // 递推开始
        // 先枚举子串长度
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }

                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
