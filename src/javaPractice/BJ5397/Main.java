package javaPractice.BJ5397;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 백스페이스 : -, 화살표 입력 : <, >
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bf.readLine());
        for (int i = 0; i < count; i++) {
            // StringBuilder로 구현
            StringBuilder sb = new StringBuilder(bf.readLine());
            int cursor = 0;
            for (int j = 0; j < sb.length(); j++) {
                System.out.println("j : " + j);
                if(sb.charAt(j)=='<'){
                    cursor = Math.max(0, cursor-1);
                    sb.delete(j, j+1);
                    j--;
                } else if(sb.charAt(j)=='>'){
                    cursor = Math.min(j, cursor+1);
                    sb.delete(j, j+1);
                    j--;
                } else if(sb.charAt(j)=='-'){
                    sb.delete(j, j+1);
                    j--;
                    if(cursor == 0){
                        continue;
                    }
                    sb.delete(cursor-1, cursor);
                    cursor--;
                } else {
                    char c = sb.charAt(j);
                    sb.delete(j, j+1);
                    sb.insert(cursor, c);
                    cursor++;
                }
                // System.out.println(sb + "\t" + "cursor : " + cursor);
            }
            System.out.println(sb);
        }
    }
}