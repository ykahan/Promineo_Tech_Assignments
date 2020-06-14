package Java.Week_6;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many games?");
        int numGames = scanner.nextInt();
        for (int game = 0; game < numGames; game++) {
            Deck deck = new Deck(); // shuffle() included in constructor
            Player john = new Player("John");
            Player tom = new Player("Tom");
            for (int i = 0; i < 52; i++) {
                if (i % 2 == 0) john.draw(deck);
                else tom.draw(deck);
            }
            for (int i = 0; i < 26; i++) {
                Card johns = john.flip();
                Card toms = tom.flip();
                if (johns.getValue() > toms.getValue()) john.incrementScore();
                else if (toms.getValue() > johns.getValue()) tom.incrementScore();
            }

            if (tom.getScore() > john.getScore()) System.out.println("Tom Wins!");
            else if (john.getScore() > tom.getScore()) System.out.println("John Wins!");
            else System.out.println("Draw");
            System.out.println("Final Score:");
            System.out.println("John:\t" + john.getScore());
            System.out.println("Tom:\t" + tom.getScore() + "\n");
        }
    }
}
