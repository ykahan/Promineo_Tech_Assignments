package Java.Week_6;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Messages.print(Messages.numGames());
        int numGames = scanner.nextInt();
        for (int game = 0; game < numGames; game++) {
            Deck deck = new Deck(); // shuffle() included in constructor
            Player player1 = new Player("John");
            Player player2 = new Player("Tom");
            for (int card = 0; card < 52; card++) {
                if (card % 2 == 0) player1.draw(deck);
                else player2.draw(deck);
            }
            for (int i = 0; i < 26; i++) {
                Card player1s = player1.flip();
                Card player2s = player2.flip();
                if (player1s.getValue() > player2s.getValue()) player1.incrementScore();
                else if (player2s.getValue() > player1s.getValue()) player2.incrementScore();
            }

            if (player2.getScore() > player1.getScore()) Messages.print(Messages.winner(player2));
            else if (player1.getScore() > player2.getScore()) Messages.print(Messages.winner(player1));
            else Messages.print(Messages.draw());
            Messages.print(Messages.finalScore(player1, player2));
        }
    }
}
