package javaboatparts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JavaBoatParts {
    
    // https://open.kattis.com/problems/boatparts
    // simple calculation program
    // I get wrong answer

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String days = DaysOfRepairingBoat(in);

        System.out.println(days);

    }// end main

    private static String DaysOfRepairingBoat(Scanner input) {
        try {
            int[] twoNums = String2IntArray(GetLine(input));
            int numOfParts = twoNums[0];
            int numOfDays = twoNums[1];

            if (numOfDays < 1 || numOfDays > 1000) {
                throw new InputMismatchException();
            }
            if (numOfParts < 1 || numOfParts > numOfDays) {
                throw new InputMismatchException();
            }

            String[] broughtParts = GetBroughtParts(input, numOfDays, numOfParts);

            int distinct = NumberOfDistinctParts(broughtParts);

            String res = PartsArrayCheck(broughtParts, distinct, numOfParts);

            return res;
        }// end try
        catch (Exception e) {
            return DaysOfRepairingBoat(input);
        }
    }

    private static String PartsArrayCheck(String[] parts, int numOfDistinctParts, int numberOfParts) {
        if (numOfDistinctParts < numberOfParts) {
            return "paradox avoided";
        } else {
            return String.valueOf(parts.length-1); // return String.valueOf(IndexOfLastDistinctItem(parts, numberOfParts)+1);
        }
    }

    private static int NumberOfDistinctParts(String[] parts) {
        int same = 0;
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < parts.length; j++) {
                if (i == j) {
                    continue;
                }
                if (parts[i].equals(parts[j])) {
                    same = same + 1;
                }
            }
        }
        return (int) parts.length - (same / 2);
    }

    private static String[] GetBroughtParts(Scanner input, int days, int numOfAllParts) {
        try {
            String[] parts = new String[days];
            for (int i = 0; i < parts.length; i++) {
                parts[i] = GetLegalString(input);
            }
            int distinct = NumberOfDistinctParts(parts);
            if (distinct > numOfAllParts) {
                throw new InputMismatchException();
            }
            return parts;
        }// end try 
        catch (Exception e) {
            return GetBroughtParts(input, days, numOfAllParts);
        }
    }

    private static String GetLine(Scanner input) {
        return input.nextLine();
    }

    private static String GetLegalString(Scanner input) {
        try {
            String res = input.nextLine();
            if (!CheckString(res)) {
                throw new InputMismatchException();
            }
            return res;

        } catch (Exception e) {
            return GetLegalString(input);
        }
    }

    private static int[] String2IntArray(String str) {
        String[] array = str.split(" ", 2);
        int[] numbers = new int[array.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }
        return numbers;
    }

    private static boolean CheckString(String str) {
        char underScore = '_';
        char[] checkChars = str.toCharArray();

        if (checkChars.length < 1 || checkChars.length > 20) {
            return false;
        }

        for (int i = 0; i < checkChars.length; i++) {
            if (!Character.isLowerCase(checkChars[i]) && checkChars[i] != underScore) {
                return false;
            }
        }
        return true;
    }
    /*
    private static int IndexOfLastDistinctItem(String[] array, int numberOfParts)
    {
        int count=1;
        
        for (int i = 1; i < array.length; i++) {
            
            if(CompareItem(array, array[i], i))
            {
                count++;
            }
            
            if(count == numberOfParts)
                return i;
        }
        return -1;
    }
    
    private static boolean CompareItem(String[] array, String item, int indexOfItem)
    {
        for (int i = 0; i < indexOfItem-1; i++) {
            if(item.equals(array[i]))
                return false;
        }
        return true;
    }
    */
}
