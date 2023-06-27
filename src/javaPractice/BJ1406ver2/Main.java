package javaPractice.BJ1406ver2;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(bf.readLine());
        int count = Integer.parseInt(bf.readLine());

        int cursor = sb.length();

        for (int i = 0; i < count; i++) {
            String command = bf.readLine();
            if("L".equals(command)){
                cursor = Math.max(0, cursor-1);
            } else if("D".equals(command)){
                cursor = Math.min(sb.length(), cursor+1);
            } else if("B".equals(command)){
                if(cursor-1<0){
                    continue;
                }
                sb.delete(cursor-1, cursor);
                cursor--;
            } else if('P' == command.charAt(0)){
                sb.insert(cursor, command.charAt(2));
                cursor++;
            }
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
