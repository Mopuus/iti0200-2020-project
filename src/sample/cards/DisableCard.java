package sample.cards;

import sample.Player;

public class DisableCard extends Card {

    enum Condition {
        DISEASE, INJURY, FATIGUE
        // Disease - ei saa midagi käia, kuni 3 käiku.
        // Injury - ei saa käia TerrainCard tüüpi kaarte, kuni 3 käiku. Võib ennast vabastada, andes ära ühe kaardi oma
        //          pakist, ning mängides edasi vähemate kaartidega.
        // Fatigue - jääb 1 käigu vahele.
    };

    public final Condition condition;
    public Integer duration;
    public CardTypes type = CardTypes.DISABLE;
    public Player target;
    public Boolean inPlay;

    public DisableCard(Condition condition, Integer duration) {
        this.condition = condition;
        this.duration = duration;
        this.target = null;
    }

    public void turnEnd() {
        this.duration--;
        if (duration == 0) this.target = null;
    }

    public void setTarget(Player target) {
        if (this.target == null) this.target = target;
    }

    public void play() {
        inPlay = true;
    }

}
