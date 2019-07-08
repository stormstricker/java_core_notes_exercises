/*
Write a program that prompts the user to enter a string and 
counts the number of occurrences of each letter in the string regardless of case

Solution:
1. Convert all letters in string to lowercase
2. create an array of 26 int values; each value corresponds with a letter on the alphabet
3. For each character in the string, increment the corresponding letter value in array
*/

import java.util.Scanner;

public class CountEachLetter{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        // invoke the countLetters method to count each letter
        int[] counts = countLetters(s.toLowerCase());

        // Display results
        for(int i = 0; i < counts.length; i++){
            if(counts[i] != 0){
                System.out.println((char)('a' + i) + "appears " + counts[i] + ((counts[i] == 1) ? " time" : " times"));
            }
        }
    }

    public static int[] countLetters(String s){
        int[] alphabet = new int[26];

        for(int i=0; i<s.length(); i++){
            if(Character.isLetter(s.charAt(i))){
                counts[s.charAt(i) - 'a']++;
            }
        }
        return alphabet;
    }
}

/*
OUTPUT: 

Enter a string: abababx 
a appears 3 times 
b appears  3 times 
x appears  1 time 

*/
