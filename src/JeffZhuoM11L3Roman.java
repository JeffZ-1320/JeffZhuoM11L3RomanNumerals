import java.util.Arrays;
import java.util.Formatter;

public class JeffZhuoM11L3Roman {
    private String[] romeTime;
    private String[] digitTime;

    // constructor, getter, setter, toString
    public JeffZhuoM11L3Roman(String[] timeArray) {
        this.romeTime = timeArray;
        this.digitTime = romeToDigit(timeArray);
        sortTime();
    }

    public String[] getRomeTime() {
        return this.romeTime;
    }

    public void setRomeTime(String[] romeTime) {
        this.romeTime = romeTime;
    }

    public String[] getDigitTime() {
        return this.digitTime;
    }

    public void setDigitTime(String[] digitTime) {
        this.digitTime = digitTime;
    }

    public String toString() {
        String time = "Time:\n";
        for (String string : romeTime) {
            time += string + " ";
        }
        time += "\n";
        
        for (String string : digitTime) {
            Formatter timex = new Formatter();
            String[] hM = string.split(":");
            timex.format("%02d:%02d ", Integer.parseInt(hM[0]), Integer.parseInt(hM[1]));
            time += timex.toString();
            timex.close();
        }
        return time;
    }

    /**
     * sorts the time; roman numeral and digital 
     */
    public void sortTime(){
        int[] timeByMinute = new int[digitTime.length];

        for (int i = 0; i < timeByMinute.length; i++) {
            timeByMinute[i] = timeToMin(digitTime[i]);
        }
        Arrays.sort(timeByMinute);
        for (int i = 0; i < digitTime.length; i++) {
            digitTime[i] = minToTime(timeByMinute[i]);
        }
        // now the digital time is sorted 
        // need to sort the roman time
        for (int i = 0; i < romeTime.length; i++) {
            romeTime[i] = digitToRome(digitTime[i]);
        }
    }
    
    /**
     * digital time to roman numeral time
     * @param digital digital time
     * @return roman numeral time
     */
    public String digitToRome(String digital){
        String[] hourMin = digital.split(":");
        for (int i = 0; i < hourMin.length; i++) {
            hourMin[i] = intToRome(Integer.parseInt(hourMin[i]));
        }
        return hourMin[0] + ":" + hourMin[1];
    }
  
    /**
     * Convert roman numeral time to digital time [array]
     * @param romeArray array of roman numeral time
     * @return array of digital time
     */
    public String[] romeToDigit(String[] romeArray){
        String[] time = new String [romeArray.length];
        for (int i = 0; i < time.length; i++) {
            time[i] = romeArray[i];
        }

        for (int i = 0; i < time.length; i++) {
            String[] hourMin = time[i].split(":", 2);
            String str = "";
            str += romeToInt(hourMin[0]) + ":";
            str += romeToInt(hourMin[1]);
            time[i] = str;
        }
        return time;
    }

    /**
     * Convert roman numeral time to digital time
     * @param rome roman numeral time
     * @return digital time
     */
    public String romeToDigit(String rome){
        String[] hourMin = rome.split(":");
        for (int i = 0; i < hourMin.length; i++) {
            hourMin[i] = romeToInt(hourMin[i]) + "";
        }
        return hourMin[0] + ":" + hourMin[1];
    }

    /**
     * Convert digital time to minutes 
     * @param time digital time
     * @return minutes
     */
    public int timeToMin(String time){
        String[] hourMinute = time.split(":");
        return Integer.parseInt(hourMinute[0]) * 60 + Integer.parseInt(hourMinute[1]);
    }

    /**
     * Convert minutes to digital time
     * @param time time in minutes 
     * @return digital time
     */
    public String minToTime(int time){
        if (time >= 1440) {
            time -= 1440;
        }
        int minute = time % 60;
        int hour = (time - minute) / 60;
        return hour + ":" + minute;
    }
    
    /**
     * Convert integer to roman numeral
     * @param num the number to convert to roman numeral
     * @return roman numeral
     */
    public String intToRome(int num){
        if (num < 1 || num > 3999){
            return "Invalid Roman Number Value";
        }
        String s = "";
        while (num >= 1000) {
            s += "M";
            num -= 1000;        }
        while (num >= 900) {
            s += "CM";
            num -= 900;
        }
        while (num >= 500) {
            s += "D";
            num -= 500;
        }
        while (num >= 400) {
            s += "CD";
            num -= 400;
        }
        while (num >= 100) {
            s += "C";
            num -= 100;
        }
        while (num >= 90) {
            s += "XC";
            num -= 90;
        }
        while (num >= 50) {
            s += "L";
            num -= 50;
        }
        while (num >= 40) {
            s += "XL";
            num -= 40;
        }
        while (num >= 10) {
            s += "X";
            num -= 10;
        }
        while (num >= 9) {
            s += "IX";
            num -= 9;
        }
        while (num >= 5) {
            s += "V";
            num -= 5;
        }
        while (num >= 4) {
            s += "IV";
            num -= 4;
        }
        while (num >= 1) {
            s += "I";
            num -= 1;
        }    
        return s;
        }
    
    /**
     * Convert roman numeral to integer
     * @param rome roman numeral
     * @return a integer
     */
    public int romeToInt(String rome){
        char[] romeArray = rome.toCharArray();
        int[] numArray = new int[romeArray.length];
        for (int i = 0; i < romeArray.length; i++) {
            if(romeArray[i] == 'I'){
                numArray[i] = 1;
            }else if(romeArray[i] == 'V'){
                numArray[i] = 5;
            }else if(romeArray[i] == 'X'){
                numArray[i] = 10;
            }else if(romeArray[i] == 'L'){
                numArray[i] = 50;
            }else if(romeArray[i] == 'C'){
                numArray[i] = 100;
            }else if(romeArray[i] == 'D'){
                numArray[i] = 500;
            }else if(romeArray[i] == 'M'){
                numArray[i] = 1000;
            }
        }
        int sum = 0;
        for (int i = 0; i < numArray.length - 1; i++) {
            if(numArray[i] < numArray[i + 1]){
                sum -= numArray[i];
            }else{
                sum += numArray[i];
            }
        }
        sum += numArray[numArray.length - 1];
        return sum;
    }
}