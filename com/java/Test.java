package com.java;

public class Test {
    public static void main(String[] args) {
       StringBuffer sb = new StringBuffer();
       String str = "ABC";

       for(int i = 0; i<str.length(); i++){
           if(str.charAt(i) == 'B'){
               sb.append("#,");
           } else {
               sb.append(str.charAt(i)).append(",");
           }
       }
       sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }

}
