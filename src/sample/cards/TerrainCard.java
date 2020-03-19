package sample.cards;


import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.Node;

import java.util.Map;

public class TerrainCard  extends Card {

    enum Intersection {
        BRIDGE, TUNNEL, MOUNTAIN, RED, BLUE, DIAMOND
    };

    enum Direction {
        N, E, S, W
    };

    public final Intersection intersection;
    public Map<Node.Direction, Boolean> entrance;
    public Boolean middle;
    public Boolean inPlay;
    public Node location;
    public final CardTypes type = CardTypes.TERRAIN;

    public TerrainCard(Intersection intersection, Map<Node.Direction, Boolean> entrance, Boolean middle, Boolean flip) {
        this.intersection = intersection;
        this.entrance = entrance;
        this.middle = middle;
        inPlay = false;
        location = null;

        Rectangle cardObject = new Rectangle(80, 80);
        cardObject.setArcHeight(5);
        cardObject.setArcWidth(5);
        cardObject.setFill(Color.AQUA);
        // cardObjecti setFill peaks olema pilt kaardist. Tuleb ilmselt teha paintis vms valmis.

        getChildren().add(new StackPane(cardObject));
    }

    public void flip() {
        entrance = Map.of(Node.Direction.N, entrance.get(Node.Direction.S), Node.Direction.E, entrance.get(Node.Direction.W), Node.Direction.S,
                entrance.get(Node.Direction.N), Node.Direction.W, entrance.get(Node.Direction.E));
    }

    // public void play(Node node) {
    //    inPlay = true;
    //    location = node
    // }
}
