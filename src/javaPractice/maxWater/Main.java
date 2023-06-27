package javaPractice.maxWater;

public class Main {
    public static void solution(int[] arr){
        // 방법 1 ) 앞에서부터 하나씩 left를 고정하고 right만 움직이는 방법
        // => 시작할 때 left, right의 간격이 아주 좁으므로 비효율적
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                max = Math.max((j-i)*Math.min(arr[i],arr[j]), max);
            }
        }
        System.out.println(max);

        // 방법 2 ) 간격이 가장 먼 기둥들에서 시작하여, 더 높이가 높은 기둥을 남겨둔채로 기둥을 움직이는 방법
        // 전체 연산 수가 줄어들게 됨
        int maxArea = 0;
        int left = 0; // 가장 왼쪽
        int right = arr.length - 1; // 가장 오른쪽
        while(left < right){
            maxArea = Math.max(maxArea, (right-left)*Math.min(arr[left], arr[right]));
            if(arr[left]>=arr[right]){
                right--;
            } else {
                left++;
            }
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        solution(new int[] {1,8,6,2,5,4,8,3,7});
    }
}