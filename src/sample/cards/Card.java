package sample.cards;

import javafx.scene.Parent;

public class Card extends Parent {

    enum CardTypes {TERRAIN, DESTRUCTION, DISABLE}

    public CardTypes type;
}
