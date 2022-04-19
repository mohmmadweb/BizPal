import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter your Amount/ Percentage/ number of month you deposit");
        System.out.println("Max amount: "+printNumber((String.valueOf(Integer.MAX_VALUE))));
        String amount = scanner.next();
        int percentage = scanner.nextInt();
        System.out.println(getDailyProfit(amount,percentage));
    }
    public static String calculateProfit(String amount, int percentage, int currentMonth){
        String answer="";
        if ((percentage>100|| percentage<0 )|| (Integer.getInteger(getDailyProfit(amount,percentage))<100) ){
            answer="Cannot calculate profit.";
            return answer;
        }
        return answer;
    }
    public static int getNumberOfDay(int Months, int currentMonth){
        int numberofDay= 0;
        for (int i=0;i<Months;i++){
            numberofDay+= getMonthdays(currentMonth);
            currentMonth = (currentMonth+1)%12;
        }
        return numberofDay;
    }
    public static int getMonthdays(int currentMonth){
        int answer=0;
        if (currentMonth==1 || currentMonth==2 || currentMonth==3 || currentMonth==4 || currentMonth==5 || currentMonth==6 ){
            answer= 31;
        }
        else if (currentMonth == 7 || currentMonth==8 || currentMonth==9 || currentMonth==10 || currentMonth==11){
            answer=30;
        }
        else if (currentMonth==12){
            answer=29;
        }
        return answer;
    }
    public static String getDailyProfit(String amount, int percentage){
        double p = (double) percentage/100;
        double c = p /365;
        double answer= (double) Integer.parseInt(amount)*c;
        return printNumber(String.valueOf(answer));
    }
    public static String printNumber(String number){
        String answer = "";
        if (number.contains(".")){
            answer = printDoubleNumber(number);
        }
        else {
            answer= printIntNumber(number);
        }
        return answer;
    }
    public static String printDoubleNumber(String number){
        String stringNumber= String.valueOf(number);
        int index= stringNumber.indexOf(".");
        String temp="";
        for (int i=0;i<index;i++){
            temp+= stringNumber.charAt(i);
        }
        String temp2="";
        for (int j=index;j<stringNumber.length();j++){
            temp2+= stringNumber.charAt(j);
        }
        return printIntNumber(temp)+temp2;
    }
    public static String printIntNumber(String number){
        int length = number.length();
        int n = length/3;
        int r = length%3;
        String []array = new String[n+1];
        Arrays.fill(array, "");
        String temp="";
        for (int i=0;i<number.length();i++){
            temp+= number.charAt(i)+" ";
        }
        temp="";
        for (int i=0;i<number.length();i++){
            temp+= String.valueOf(i)+" ";
        }
        for (int j=0;j<r;j++){
            array[0]+=number.charAt(j);
        }
        int counter=0;
        int arrayIndex=1;
        for (int i=r;i<number.length();i++){
            if (counter!=3){
                array[arrayIndex]+=number.charAt(i);
                counter++;
            }
            else {
                counter=0;
                arrayIndex++;
                array[arrayIndex]+=number.charAt(i);
                counter++;
            }
        }
        //merging array
        String answer="";
        for (int i=0;i<array.length;i++){
            answer+= array[i]+",";
        }
        answer = answer.substring(0,answer.length()-1);
        if (r==0){
            answer= answer.substring(1);
        }
        return answer;
    }
}
