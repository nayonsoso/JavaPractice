package javaPractice.minCandy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3}));
        System.out.println(solution(new int[]{3, 2, 1}));
        System.out.println(solution(new int[]{1, 0, 2}));
        System.out.println(solution(new int[]{1, 3, 5, 3, 1, 3, 5, 7, 5, 3, 1, 0}));
    }

    public static int solution(int[] r) {

        int[] a = new int[r.length];

        for (int i = 0; i < r.length; i++) {
            if (i == 0) { // 처음엔 1개
                a[0] = 1;
                continue;
            }
            if (r[i - 1] < r[i]) { // 순방향 : 이전것보다 +1개 더 줌
                a[i] = a[i - 1] + 1;
            } else { // 역방향 : 1을 준 다음 문제 해결 함수 호출
                a[i] = 1;
                a = reculsion(a, i);
            }
        }

        int sum = 0;
        for (int i : a) {
            sum += i;
        }
        return sum;
    }

    public static int[] reculsion(int[] a, int i) {
        if (i == 1 && a[0] == a[1]) { // a[0]의 경우 특별 처리
            a[0] += 1;
            return a;
        } else if (a[i - 1] == a[i]) { // 이전 것과 값이 동일하면, 이전것에 +1 추가
            a[i - 1] += 1;
            return reculsion(a, i - 1); // i-1에 문제 발생하는지 확인
        } else { // 이전것과 다르면 그대로 진행
            return a;
        }
    }
}