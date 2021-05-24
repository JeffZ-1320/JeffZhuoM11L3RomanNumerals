import java.util.Scanner;
/*
Program Name: JeffZhuoM11L3RomanNumerals
Author: Jeff Zhuo
Date: 2/21/2021
Program description:
    Write a class Roman that can takes a String containing Roman numerals and returns the corresponding time in a standard digital clock format.  It must also be capable of converting a numeric time  to a roman numeral. 
What I learned from this program:
    I learned to convert roman numerals to integers and back. 
What difficulties did I have and how I solved them:.
    I had to learn the rule of roman numeral before I can implement them in my code. 
*/

public class JeffZhuoM11L3RomanNumerals {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String timeInput = "";
        do{
            System.out.print("Enter time(hh:mm): ");
            timeInput += scan.nextLine().toUpperCase() + " ";
            System.out.print("Do yo want to add any more time? ");
        } while (!(scan.nextLine().toUpperCase().equals("NO")));
        scan.close();
        JeffZhuoM11L3Roman clock = new JeffZhuoM11L3Roman(timeInput.split(" "));
        System.out.println(clock.toString());
        
    }
}

/*
Sample Output:
Enter time(hh:mm): II:xi
Do yo want to add any more time? yes
Enter time(hh:mm): XI:XXX
Do yo want to add any more time? yes
Enter time(hh:mm): IV:VII
Do yo want to add any more time? no
Time:
II:XI IV:VII XI:XXX
02:11 04:07 11:30
*/