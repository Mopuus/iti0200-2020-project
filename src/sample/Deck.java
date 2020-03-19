package sample;

import sample.cards.Card;

import java.util.List;

public class Deck {
    private List<Card> cards;

    public Deck() {
        // TODO
    }

    public Card drawCard() {
        Card card = cards.get((int)(Math.random() * cards.size()));
        cards.add(card);

        return card;
    }

}

