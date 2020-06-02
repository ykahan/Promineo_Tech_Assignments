package Java;

import java.math.BigDecimal;

public class App_Week_2 {
    public static void main(String[] args) {
        boolean isHotOutside = true;
        boolean isWeekday = true;
        boolean hasMoneyInPocket = true;
        BigDecimal costOfMilk = new BigDecimal("4.52");
        BigDecimal moneyInWallet = new BigDecimal("45.31");
        int thirstLevel = 5;

        boolean shouldBuyIceCream = shouldBuyIceCream(isHotOutside, moneyInWallet);

        boolean willGoSwimming = shouldGoSwimming(isHotOutside, isWeekday);

        boolean isGoodDay = isGoodDay(isHotOutside, hasMoneyInPocket, isWeekday);

        boolean willBuyMilk = willBuyMilk(isHotOutside, moneyInWallet, costOfMilk, thirstLevel);
        System.out.println("Should Buy Ice Cream? " + shouldBuyIceCream);
        System.out.println("Will go swimming? " + willGoSwimming);
        System.out.println("Is good day? " + isGoodDay);
        System.out.println("Will buy milk? " + willBuyMilk);

    }

    private static boolean willBuyMilk(boolean hot, BigDecimal money, BigDecimal milk, int thirst){
        if(hot && thirst >= 3){
            BigDecimal doubleMilk = milk.multiply(new BigDecimal("2"));
            if(money.compareTo(doubleMilk) >= 0) return true;
        }
        return false;
    }

    private static boolean isGoodDay(boolean hot, boolean money, boolean weekday){
        if(hot && money && !weekday) return true;
        return false;
    }

    private static boolean shouldBuyIceCream(boolean isHotOutside, BigDecimal moneyInWallet) {
        boolean shouldBuyIceCream;
        if(isHotOutside && moneyInWallet.compareTo(BigDecimal.ZERO) > 0) return true;
        return false;
    }

    private static boolean shouldGoSwimming(boolean hot, boolean weekday){
        if(hot && !weekday) return true;
        return false;
    }
}
