package sample;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import sample.cards.Card;

public class Hand {

    private ObservableList<Node> cards;

    public Hand(ObservableList<Node> cards) {
        this.cards = cards;
    }

    public void takeCard(Card card) {
        cards.add(card);
    }

    public void buryCard(Card card) {
        cards.remove(card);
    }
}