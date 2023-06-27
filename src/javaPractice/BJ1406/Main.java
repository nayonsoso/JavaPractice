package javaPractice.BJ1406;

import java.util.*;
import java.io.*;

public class Main {
    public static int calCursor(String command, int cursor) {
        if("L".equals(command) || "B".equals(command)){
            cursor--;
        } else if("D".equals(command) || 'P' == command.charAt(0)){
            cursor++;
        }
        return cursor;
    }

    public static String calInput(String command, String input, int cursor){
        char[] inputArray = input.toCharArray();
        char[] bucket = new char[]{};
        if("L".equals(command) || "D".equals(command)){
            return input;
        } else if("B".equals(command)){
            if(cursor == 0 || input.length() == 0){ // 커서가 문장 맨 앞이면 무시
                return input;
            }
            bucket = new char[inputArray.length-1];
            for(int i=0; i<cursor-1; i++){
                bucket[i] = inputArray[i];
            }
            for(int i=cursor; i<inputArray.length; i++){
                bucket[i-1] = inputArray[i];
            }
        }
        else if ('P' == command.charAt(0)) {
            bucket = new char[inputArray.length+1];
            for(int i=0; i<cursor; i++){
                bucket[i] = inputArray[i];
            }
            bucket[cursor] = command.charAt(2);
            for(int i=cursor; i<inputArray.length; i++){
                bucket[i+1] = inputArray[i];
            }
        }
        return new String(bucket);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String command = "";
        int cursor = input.length();

        int num = Integer.parseInt(bf.readLine());
        for (int i = 0; i < num; i++) {
            command = bf.readLine();
            input = calInput(command, input, cursor);
            cursor = calCursor(command, cursor);
            if(cursor < 0 ){
                cursor = 0;
            } else if(cursor > input.length()){
                cursor = input.length();
            }
            // System.out.println("input : " + input + "   cursor : " + cursor);
        }
        System.out.println(input);
    }
}
