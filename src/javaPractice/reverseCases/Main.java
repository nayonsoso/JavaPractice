package javaPractice.reverseCases;

import java.util.*;
public class Main {
    public static void solution(String str) {
        int step = 'a' - 'A';
        char[] array = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char c : array) {
            if(c > 'Z'){
                sb.append((char)(c-step));
            } else {
                sb.append((char)(c+step));
            }
        }

        System.out.println(sb.toString());
    }

    public static void reference(){
        System.out.println("a : " + (int)'a');
        System.out.println("z : " + (int)'z');
        System.out.println("0 : " + (int)'0');
        System.out.println("A : " + (int)'A');
        System.out.println("Z : " + (int)'Z');
    }
    public static void main(String[] args) {
        solution("aBcDeFg");
    }
}
