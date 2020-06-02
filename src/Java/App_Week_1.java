package Java;

import java.math.BigDecimal;

public class App_Week_1 {
    public static void main(String[] args) {
        BigDecimal bananaPrice = new BigDecimal("3.25");
        BigDecimal applePrice = new BigDecimal("2.73");
        BigDecimal moneyMyWallet = new BigDecimal("20.32");
        BigDecimal moneyYourWallet = new BigDecimal("31.49");
        int johnsFriends = 4;
        int tomsFriends = 5;
        int johnsAge = 27;
        int tomsAge = 32;
        String myFirstName = "Yehoshua";
        String yourFirstName = "John";
        String myLastName = "Kahan";
        String yourLastName = "Reddick";
        char myMidInit = 'T';
        char yourMidInit = 'R';
        BigDecimal changeFromBanana = moneyMyWallet.subtract(bananaPrice);
        BigDecimal changeFromApple = moneyYourWallet.subtract(applePrice);
        double johnsFriendsPerYear = (double)johnsFriends / (double)johnsAge;
        String myFullName = myFirstName + " " + Character.toString(myMidInit) + " " + myLastName;
        StringBuilder sb = new StringBuilder();
        sb.append("\nA banana costs $" + bananaPrice);
        sb.append("\nAn apple costs $" + applePrice);
        sb.append("\nI have $" + moneyMyWallet + " in my wallet");
        sb.append("\nYou have $" + moneyYourWallet + " in your wallet");
        sb.append("\nJohn has " + johnsFriends + " friends.");
        sb.append("\nTom has " + tomsFriends + " friends.");
        sb.append("'nJohn is " + johnsAge + " years old.");
        sb.append("\nTom is " + tomsAge + " years old");
        sb.append("\nMy first name is " + myFirstName);
        sb.append("\nYour first name is " + yourFirstName);
        sb.append("\nMy last name is " + myLastName);
        sb.append("\nYour last name is " + yourLastName);
        sb.append("\nMy middle initial is " + myMidInit);
        sb.append("\nYour middle initial is " + yourMidInit);
        sb.append("\nAfter buying a banana, I will have $" + changeFromBanana + " left.");
        sb.append("\nAfter buying an apple, you will have $" + changeFromApple + " left");
        sb.append("\nJohn has made an average of " + johnsFriendsPerYear + " friends per year of his life.");
        sb.append("\nMy full name is " + myFullName);
        System.out.println(sb.toString());
    }
}