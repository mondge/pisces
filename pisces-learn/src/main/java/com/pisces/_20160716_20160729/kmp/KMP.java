package com.pisces._20160716_20160729.kmp;

/**
 * Created by jun.xu on 16/7/24.
 */
public class KMP {
    private void getNext(char[] t, int[] next) {
        int i=0;
        int j=0;
        next[0]=0;

        while (i < t.length-1) {
            if (j == 0 || t[i] == t[j-1]) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j-1];
            }
        }
    }

    public int contains(char[] str,char[] t){
        int[] next=new int[t.length];
        this.getNext(t,next);
        int i=0;
        int j=0;
        while (i<str.length&&j<t.length){
            if(j==0||str[i]==t[j-1]){
                i++;
                j++;
            }else{
                j=next[j-1];
            }
        }
        return i-j+1+1;
    }
}
