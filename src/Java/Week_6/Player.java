package Java.Week_6;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private List<Card> hand;
    private int score;
    private String name;

    public Player(String name){
        hand = new ArrayList<>();
        score = 0;
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }

    public void describe(){
        System.out.println(toString());
        for(Card card: hand){
            card.describe();
            System.out.println();
        }
    }

    public Card flip(){
        if (hand.size() > 0) return hand.remove(0);
        return null;
    }

    public void draw(Deck deck){
        Card card = deck.draw();
        if(card == null) {
            Deck deck2 = new Deck();
            card = deck2.draw();
        }
        hand.add(card);
    }

    public void incrementScore(){
        score++;
    }
}
