package javaPractice.reverseInteger;

// 입력된 숫자를 뒤집어 출력하는 문제
// 나머지 연산과 나누기 연산의 조합이 숫자를 한 자리수씩 분리하는데에 사용될 수 있음

public class Main {
    public static void solution(int num){
        int numReverse = 0;
        boolean isMinus = false;

        // 숫자가 음수인지 저장하는 부분
        if(num < 0 ){
            isMinus = true;
            num *= -1;
        }

        // 10으로 나머지 == 마지막 자리의 수
        // 10으로 나눈 몫 == 마지막 자리의 수가 제외된 숫자
        // (10으로 나눈 나머지 + numReverse*10) 는 numReverse가 됨
        while(num>0) {
            int r = num%10;
            num /= 10;
            numReverse = numReverse*10 + r;
        }

        System.out.println(isMinus ? numReverse*-1 : numReverse);
    }

    public static void main(String[] args) {
        solution(12345);
        solution(-12345);
        solution(100);
        solution(00);
    }
}