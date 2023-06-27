package javaPractice.BJ2608;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static int romeToInt(String[] r1){
        HashMap<String, Integer> hm = new HashMap<>();
        {
            hm.put("I", 1);
            hm.put("V", 5);
            hm.put("X", 10);
            hm.put("L", 50);
            hm.put("C", 100);
            hm.put("D", 500);
            hm.put("M", 1000);
            hm.put("IV", 4);
            hm.put("IX", 9);
            hm.put("XL", 40);
            hm.put("XC", 90);
            hm.put("CD", 400);
            hm.put("CM", 900);
        }

        if(r1.length == 1){
            return hm.get(r1[0]);
        }

        int result = 0;

        // 로직은 좋으나 r1가 한자리수인 경우 실행되지 않으므로 따로 처리해줘야 함
        for (int i = 0; i < r1.length-1; i++) {
            if(hm.get(r1[i]) >= hm.get(r1[i+1])){ // 순방향이면 그대로 정수로 바꾸기
                result += hm.get(r1[i]);
            } else {
                result += hm.get((r1[i])+r1[i+1]); // 역방향이면 다음 수랑 결합한 것을 정수로 바꾸기
                i++;
            }
            if(i == r1.length-2){
                result += hm.get(r1[r1.length-1]); // 마지막 idx에 도달하면 그대로 정수로 바꾸기
            }
        }

        return result;
    }

    public static String intToRome(int num){
        StringBuilder result = new StringBuilder();
        
        // 해시맵을 이용하려 했으나, 해시맵은 정렬을 보장하지 않으므로 크기 순서대로 꺼낼 수 없다는 단점이 있음
        // => 두개의 배열을 이용하면 됨
        // 내가 정적 배열 두개를 만들 수 있고, 각 인덱스가 매핑되게 하면, '키를 기준으로 정렬된 해시맵'처럼 사용할 수 있는 것!
        String[] rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        int i = 0;
        while(num > 0){
            while(num >= values[i]){
                num-=values[i];
                result.append(rome[i]);
            }
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] r1 = bf.readLine().split("");
        String[] r2 = bf.readLine().split("");

        int sum = romeToInt(r1) + romeToInt(r2);
        String result = intToRome(sum);

        System.out.println(sum);
        System.out.println(result);
    }
}
