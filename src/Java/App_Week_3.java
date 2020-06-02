package Java;

import java.util.ArrayList;
import java.util.List;

public class App_Week_3 {
    public static void main(String[] args) {

        int[] ages = new int[8];
        ages[0] = 3;
        ages[1] = 9;
        ages[2] = 23;
        ages[3] = 64;
        ages[4] = 2;
        ages[5] = 8;
        ages[6] = 28;
        ages[7] = 93;
        int result = getDiff(ages);
        System.out.println("Difference between last and first values of ages: " + result);

        List<Integer> agesList = getList(ages);

        agesList.add(1);

        int[] newAges = getArray(agesList);

        result = getDiff(newAges);
        System.out.println("Difference between last and first values of newAges: " + result);

        double average = getAverage(ages);

        System.out.println("Average age of ages: " + average);

        average = getAverage(newAges);
        System.out.println("Average age of newAges: " + average);


        String[] names = new String[6];
        names[0] = "Sam";
        names[1] = "Tommy";
        names[2] = "Tim";
        names[3] = "Sally";
        names[4] = "Buck";
        names[5] = "Bob";

        double averageStringLength = getAvgLetters(names);

        System.out.println("The strings in names have an average length of: " + averageStringLength);

        String combinedNames = combineStrings(names);

        System.out.println("Contatenation of names is: " + combinedNames);

        int[] namesLength = getLengthStrings(names);

        int totalLength = sumIntegers(namesLength);

        System.out.println("Total length of all strings in names: " + totalLength);
    }

    private static boolean willGoToBed(boolean isBedtime, boolean amTired, boolean earlyMorning){
        // checks if it's bedtime yet, if user is tired, or if user must get up early
        // if all are false, returns false
        // otherwise, returns true
        if(!isBedtime && !amTired && !earlyMorning) return false;
        return true;
    }

    private static boolean willBuyDrink(boolean isHot, double money){
        if(isHot){
            if(money > 10.5) return true;
        }
        return false;
    }

    private static boolean compareAverages(double[] first, double[] second){
        double avgFirst = getAverage(first);
        double avgSecond = getAverage(second);
        if(avgFirst > avgSecond) return true;
        return false;
    }

    private static double getAverage(double[] doubles){
        double total = 0.0;
        for(int i = 0; i < doubles.length; i++){
            total += doubles[i];
        }
        return total / (double) doubles.length;
    }

    private static boolean isSumGreaterThan(int[] integers, int target){
        int total = 0;
        for(int i = 0; i < integers.length; i++){
            total += integers[i];
        }
        if (total > target) return true;
        return false;
    }

    private static String getFullName(String first, String last){
        return first + " " + last;
    }

    private static String selfConcat(String word, int n){
        String output = "";
        for(int i = 0; i < n; i++){
            output += word;
        }
        return output;
    }
    private static int sumIntegers(int[] integers){
        int total = 0;
        for(int i = 0; i < integers.length; i++){
            total += integers[i];
        }
        return total;
    }

    private static int[] getLengthStrings(String[] strings){
        int[] lengths = new int[strings.length];
        for(int i = 0; i < strings.length; i++){
            lengths[i] = strings[i].length();
        }
        return lengths;
    }

    private static String combineStrings(String[] strings){
        String result = "";
        for(int i = 0; i < strings.length; i++){
            result += strings[i];
        }
        return result;
    }


    private static double getAvgLetters(String[] strings){
        int totalChars = 0;
        for(int i = 0; i < strings.length; i++){
            String curr = strings[i];
            int numChars = curr.length();
            totalChars += numChars;
        }
        return (double)totalChars / (double) strings.length;
    }

    private static int[] getArray(List<Integer> integersList) {
        int[] integers = new int[integersList.size()];
        for(int i = 0; i < integers.length; i++){
            integers[i] = integersList.get(i);
        }
        return integers;
    }

    private static List<Integer> getList(int[] integers) {
        List<Integer> integersList = new ArrayList<>();
        for(int i = 0; i < integers.length; i++){
            integersList.add(integers[i]);
        }
        return integersList;
    }

    private static int getDiff(int[] integers) {
        int first;
        int last;
        int result;
        first = integers[0];
        last = integers[integers.length - 1];
        result = last - first;
        return result;
    }

    private static double getAverage(int[] integers) {
        int total = 0;
        for(int i = 0; i < integers.length; i++){
            total += integers[i];
        }
        return (double)total / (double)integers.length;
    }
}
