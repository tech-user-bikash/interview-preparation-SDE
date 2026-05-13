package com.dsa.two_pointer;

public class PalindromeCheck {
    public static void main(String[] args) {
        String S = "RAMESH";
        var ans = isPalindrome(S);
        var ans1 = reverse(S);
        System.out.println(ans);
        System.out.println(ans1);
    }

    private static String reverse(String s) {
        int n = s.length(), l = 0, r = n-1;
        char[] chArr = s.toCharArray();
        while(l < n/2){
            char temp = chArr[l];
            chArr[l] = chArr[r];
            chArr[r] = temp;
            l++;
            r--;
        }
        return String.valueOf(chArr);
    }

    private static boolean isPalindrome(String S) {
        int l = 0, r = S.length()-1;
        while(l <= r){
            if(S.charAt(l) == S.charAt(r)){
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }


}
