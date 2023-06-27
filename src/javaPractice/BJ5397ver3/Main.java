package javaPractice.BJ5397ver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());

        for (int i = 0; i < count; i++) {
            char[] input = bf.readLine().toCharArray();

            LinkedList<String> leftDQ = new LinkedList<>();
            LinkedList<String> rightDQ = new LinkedList<>();

            for (int j = 0; j < input.length; j++) {
                if(input[j]=='<'){
                    // 커서를 왼쪽으로 이동
                    if(leftDQ.size() != 0){
                        rightDQ.addFirst(leftDQ.pollLast());
                    }
                } else if (input[j]=='>') {
                    // 커서를 오른쪽으로 이동
                    if(rightDQ.size() != 0){
                        leftDQ.addLast(rightDQ.pollFirst());
                    }
                } else if (input[j]=='-') {
                    // 커서 왼쪽에 있는 값을 삭제
                    if(leftDQ.size() != 0){
                        leftDQ.pollLast();
                    }
                } else {
                    // 커서를 오른쪽으로 이동, input[j]를 sb에 insert
                    leftDQ.addLast(String.valueOf(input[j]));
                }
                // System.out.println("leftDQ" + leftDQ + "\trightDQ : " + rightDQ);
            }
            StringBuilder sb = new StringBuilder();
            for(String s : leftDQ){ sb.append(s); }
            for(String s : rightDQ){ sb.append(s); }
            System.out.println(sb);
        }
    }
}
