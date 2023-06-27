package javaPractice.implementReplace;

public class Main {
    public static String solution(char[] str, char[] find, char[] to){
        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone();
        
        do{
            idx = findIndex(replaceBucket, find);

            // do while을 쓸 때, do에 무턱대고 실행문을 쓰면 바디에 있는 것이 조건을 만족 안 할 수도 있으므로
            // if를 추가하면 do-while을 더욱 사용하기 쉬워진다.
            if(idx != -1){
                // 처음부터 idx 전까진 원래 값 넣기
                for (int i = 0; i < idx; i++) {
                    replaceStr += replaceBucket[i];
                }

                // idx에 해당하는 순서부터는 to를 넣기
                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }

                // idx 이후부터도 원래 값 넣기
                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }

                // replaceBucket 업데이트
                replaceBucket = replaceStr.toCharArray();
                // replaceStr 초기화
                replaceStr = "";
            }
        } while(idx != -1);

        replaceStr = new String(replaceBucket);
        return replaceStr;

    }
    
    public static int findIndex(char[] str, char[] find){
        int idx = -1;
        boolean isMatch = false;


        for (int i = 0; i < str.length; i++) {
            // isMatch를 판별하고, 적당한 i에서 break하는 부분
            if(str[i]==find[0] && str.length - i >= find.length){
                // 가능하지 않는 경우를 if로 걸고 break로 빠져나오게 함
                // 그렇기 때문에 for문에 들어가기 전에 이미 true라고 해둔 것
                // 나의 아마추어 방식보다 훨씬 좋은 것 같음
                isMatch = true;
                for(int j = 1; j < find.length; j++){
                    if(str[i + j] != find[j]){
                        isMatch = false;
                        break;
                    }
                }
            }

            // isMatch가 true이면 idx = i를 저장하는 부분
            if(isMatch){
                idx = i;
                break; // 첫번째 것을 찾아야 하므로 break로 for문 탈출
            }
        }
        return idx;
    }
    public static void main(String[] args) {

    }
}
