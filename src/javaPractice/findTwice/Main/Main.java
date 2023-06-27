package javaPractice.findTwice.Main;

public class Main {
    public static void main(String[] args) {
        solution(new int[] {4,3,2,7,8,2,3,1});
        System.out.println();
        solution(new int[] {1,1,2});
        System.out.println();
        solution(new int[] {1,3,1,3,5,5});
    }

    public static void solution(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int v = (arr[i] > 0) ? arr[i] : arr[i]*(-1);
            if(arr[v-1] > 0 ){
                arr[v-1] *= -1;
            } else {
                System.out.print(Math.abs(arr[i]) + " ");
                System.out.print(Math.abs(arr[i]) + " ");

            }
        }
    }
}
