package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.List;

public class Risk implements Strategia {
    Strategia next;
    public Risk(Strategia next) {
        this.next = next;
    }

    public boolean chiediCarta(Sfidante s) {
if (s.getPunti()<10){
    return true;
} else {
    return next.chiediCarta();
}
    }
}
