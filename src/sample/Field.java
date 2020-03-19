package sample;

import sample.cards.Card;
import sample.cards.TerrainCard;

import java.util.ArrayList;
import java.util.List;

public class Field {
    Node[] nodes;
    List<Card> cardsInPlay;

    public Field() {
        nodes = new Node[56];
        cardsInPlay = new ArrayList<>();
    }

    public boolean playCard(TerrainCard card, Node node)  {
        if (!node.isOccupied() || node.isPlayable(card)) {
            card.location = node;
            card.inPlay = true;
            node.setCard(card);
            node.setOccupied(true);
            return true;
        }
        return false;
    }

    public Node[] getNodes() {
        return nodes;
    }
}
