package com.whh.leetcode;

public class _剑指Offer58_II左旋转字符串 {
    public static void main(String[] args) {
        String s = "abcdefj";
        _剑指Offer58_II左旋转字符串 offer58_ii左旋转字符串 = new _剑指Offer58_II左旋转字符串();
        String s1 = offer58_ii左旋转字符串.reverseLeftWords(s, 3);
        System.out.println(s1);
    }
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - 1 - n);
        reverse(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }
}
