package javaPractice.romeToInteger;


public class Main {
    public static void solution(String str){
        char[] arr = str.toCharArray();
        int check = -1;
        int asw = 0;
        for(char c : arr){
            switch(c){
                case 'I' : check = 0; asw += 1; break;
                case 'V' : if(check==0) {asw += 3;} else{asw += 5;} check = -1; break;
                case 'X' : if(check==0) {asw += 8; check = -1;} else{asw += 10; check = 1;} break;
                case 'L' : if(check==1){asw += 30;} else{asw += 50;} check = -1; break;
                case 'C' : if(check==1){asw += 80; check = -1;} else{asw += 100; check = 2;}  break;
                case 'D' : if(check==2){asw += 300;} else{asw += 500;} check = -1; break;
                case 'M' : if(check==2){asw += 800;} else{asw += 1000;} check = -1; break;
            }
        }
        System.out.println(asw);
    }
    public static void main(String[] args) {
        solution("III");
        solution("IV");
        solution("VI");
        solution("XIII");
        solution("XXVI");
        solution("MCMXCIV");
    }
}
