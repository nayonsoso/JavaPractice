package javaPractice.implementReplace2;

public class Main {
    public static String solution(char[] str, char[] find, char[] to){
        // 바꾸는 부분
        int idx = 0;
        String replaceStr = "";
        char[] replaceBucket = str.clone();

        do{
            idx = findIndex(replaceBucket, find);

            if(idx != -1){
                for (int i = 0; i < idx; i++) {
                    replaceStr += replaceBucket[i];
                }

                for (int i = 0; i < to.length; i++) {
                    replaceStr += to[i];
                }

                for (int i = idx + find.length; i < replaceBucket.length; i++) {
                    replaceStr += replaceBucket[i];
                }

                replaceBucket = replaceStr.toCharArray();
                replaceStr = "";
            }
        } while(idx != -1);

        return new String(replaceBucket);
    }

    public static int findIndex(char[] str, char[] find){
        int idx = -1;
        boolean isMatch = false;

        for (int i = 0; i < str.length; i++) {
            if(str[i]==find[0] && str.length - i >= find.length){
                isMatch = true;
                for (int j = 1; j < find.length; j++) {
                    if(str[i+j] != find[j]){
                        isMatch = false;
                        break;
                    }
                }
            }
            if(isMatch){
                idx = i;
                break;
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        String str = "Boom, boom, boom 내 심장이 뛰네";
        String find = "boom";
        String to = "붐";

        System.out.println(solution(str.toCharArray(), find.toCharArray(), to.toCharArray()));
    }
}
