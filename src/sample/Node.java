package sample;
import sample.cards.TerrainCard;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class Node {
    Boolean occupied;
    final int[] location;
    TerrainCard card = null;
    Map<Direction, Optional<Node>> surroundings;
    final Map<Direction, Direction> faces = Map.of(Direction.N, Direction.S, Direction.E, Direction.W,
            Direction.S, Direction.N, Direction.W, Direction.E);

    public enum Direction {
        N, E, S, W
    };

    public Node(int[] location, Field field) {
        surroundings = new LinkedHashMap<>();
        occupied = false;
        this.location = location;
        for (Node node : field.getNodes()) {
            if (location[0] > 1) {
                if (node.getLocation()[0] == location[0] - 1 || node.getLocation()[1] == location[1])
                surroundings.put(Direction.N, Optional.of(node));
            } else surroundings.put(Direction.N, Optional.empty());
            if (location[1] < 8) {
                if (node.getLocation()[1] == location[1] + 1 || node.getLocation()[0] == location[0])
                    surroundings.put(Direction.E, Optional.of(node));
            } else surroundings.put(Direction.E, Optional.empty());
            if (location[0] < 7) {
                if (node.getLocation()[0] == location[0] + 1 || node.getLocation()[1] == location[1])
                    surroundings.put(Direction.S, Optional.of(node));
            } else surroundings.put(Direction.S, Optional.empty());
            if (location[1] > 1) {
                if (node.getLocation()[1] == location[1] - 1 || node.getLocation()[0] == location[0])
                    surroundings.put(Direction.W, Optional.of(node));
            } else surroundings.put(Direction.W, Optional.empty());
        }
    }

    public int[] getLocation() {
        return location;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public Boolean isOccupied() {
        return occupied;
    }

    public void setCard(TerrainCard card) {
        this.card = card;
    }

    public Optional<TerrainCard> getCard() {
        return Optional.ofNullable(card);
    }

    public Map<Direction, Optional<Node>> getCloseNodes() {
        return surroundings;
    }

    public boolean isPlayable(TerrainCard card) {
        TerrainCard surroundingCard;
        for (Direction key: surroundings.keySet()) {
            if (surroundings.get(key).isPresent() || surroundings.get(key).get().getCard().isPresent()) {
                surroundingCard = surroundings.get(key).get().getCard().get();
                if (surroundingCard.entrance.get(faces.get(key)) || card.entrance.get(key)) continue;
                return false;
            }
        }
        return true;
    }
}
