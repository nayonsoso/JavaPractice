package javaPractice.BJ1406ver3;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedList<String> leftDQ = new LinkedList<>(Arrays.asList(bf.readLine().split("")));
        LinkedList<String> rightDQ = new LinkedList<>();

        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count; i++) {
            String command = bf.readLine();
            if("L".equals(command)){
                if(leftDQ.size()==0){ continue; }
                rightDQ.addFirst(leftDQ.pollLast());
            } else if("D".equals(command)){
                if(rightDQ.size()==0){ continue; }
                leftDQ.addLast(rightDQ.pollFirst());
            } else if("B".equals(command)){
                if(leftDQ.size()==0){ continue; }
                leftDQ.pollLast();
            } else if('P' == command.charAt(0)){
                leftDQ.addLast(String.valueOf(command.charAt(2)));
            }
            // System.out.print("leftST = " + leftDQ);
            // System.out.println("    rightST = " + rightDQ);
        }

        StringBuilder sb = new StringBuilder();
        while (leftDQ.size()>0) {
            sb.append(leftDQ.pollFirst());
        }
        while (rightDQ.size()>0) {
            sb.append(rightDQ.pollFirst());
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
