package javaPractice.star;

public class Main {
    public static void solution(int n){
        for (int i = 0; i < n; i++) { // n개의 층
            for (int j = n-(i+1); j >0  ; j--) { //
                System.out.print(" ");
            }

            for (int j = 0; j < i*2+1 ; j++) {
                System.out.print("*");
            }

            // 별찍기에서 오른쪽 공백은 없어도 됨
            /*
            for (int j = n-(i+1); j >0  ; j--) {
                System.out.print(" ");
            }
            */

            System.out.println();
        }
        System.out.println();
        System.out.println();

        for (int i = 0; i <= n/2; i++) {
            for (int j = n-(i+1); j >0  ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n/2-1; i >=0; i--) {
            for (int j = n-(i+1); j >0  ; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < i*2+1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solution(7);
    }
}
