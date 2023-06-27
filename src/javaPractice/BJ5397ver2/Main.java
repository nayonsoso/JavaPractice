package javaPractice.BJ5397ver2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        // 인라인으로 처리하는 것보다 두개의 StringBuilder를 만드는게 더 좋겠음

        for (int i = 0; i < count; i++) {
            char[] input = bf.readLine().toCharArray(); // j
            StringBuilder output = new StringBuilder(); // cursor
            int cursor = 0;
            for (int j = 0; j < input.length; j++) {
                if(input[j]=='<'){
                    // 커서를 왼쪽으로 이동
                    cursor = Math.max(0, cursor-1);
                } else if (input[j]=='>') {
                    // 커서를 오른쪽으로 이동
                    cursor = Math.min(output.length(), cursor+1);
                } else if (input[j]=='-') {
                    // 커서 왼쪽에 있는 값을 삭제
                    if(cursor == 0){
                        continue;
                    }
                    output.delete(cursor-1, cursor);
                    cursor--;
                } else {
                    // 커서를 오른쪽으로 이동, input[j]를 sb에 insert
                    output.insert(cursor, input[j]);
                    cursor++;
                }
                // System.out.println(output + "\t" + "cursor : " + cursor);
            }
            System.out.println(output);
        }
    }
}
