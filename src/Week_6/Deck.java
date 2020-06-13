package Week_6;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        String[] suits = new String[]{"Hearts", "Clubs", "Diamonds", "Spades"};
        for(int suit = 0; suit < suits.length; suit++){
            for(int valueInt = 1; valueInt <= 14; valueInt++){
                String valueString = "";
                if(valueInt == 11) valueString = "Jack";
                else if(valueInt == 12) valueString = "Queen";
                else if(valueInt == 13) valueString = "King";
                else if(valueInt == 14) valueString = "Ace";
                else valueString = String.valueOf(valueInt);
                valueString += " of ";
                String name = valueString + suits[suit];
                Card card = new Card(valueInt, name);
                cards.add(card);
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Card card: cards){
            sb.append(card.toString());
        }
        return sb.toString();
    }

    public void display(){
        System.out.println(toString());
    }
}
