package com.whh.leetcode;

public class _151反转字符串中的单词 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        _151反转字符串中的单词 ss = new _151反转字符串中的单词();
        //去掉首尾的空格
        StringBuilder stringBuilder = ss.removeSpace(s);
        System.out.println(stringBuilder);
        //反转整个字符串
        ss.reverseString(stringBuilder,0,s.length() - 1);
        System.out.println(stringBuilder);
        //反转每个单词
        ss.reverseEachWord(stringBuilder);
        System.out.println(stringBuilder);
    }
    /**
     *去除首尾的空格
     */
    private StringBuilder removeSpace(String s){
        int start = 0;
        int end = s.length() - 1;
        while(s.charAt(start) == ' ') start ++;
        while(s.charAt(end) == ' ') end --;
        StringBuilder sb = new StringBuilder();
        while(start <= end){
            char c = s.charAt(start);
            if(c != ' ' || sb.charAt(sb.length() - 1) != ' '){
                sb.append(c);
            }
            start ++;
        }
        return sb;
    }
    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    /**
     * 反转每个单词
     */
    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }
}
