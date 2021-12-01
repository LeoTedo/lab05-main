package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Mazziere implements GiocatoreBJ {
  private List<Card> mano = new ArrayList<>();
  private DeckInterface mazzo = new MultiMazzo(6);
  //private BlackJack b = new BlackJack();

  public Card draw() {
    return mazzo.draw();
  }

  @Override
  public List<Card> carteIniziali() {
    mano.add(mazzo.draw());
    return mano;
  }

  @Override
  public void gioca() {

    if (getPunti()<17 && tuttiSballati()){
      mano.add(mazzo.draw());
    }

  }

  public boolean tuttiSballati() {
    for (int i = 0; i < BlackJack.getSfidanti().size(); i++) {
      if(BlackJack.getSfidanti().get(i).isSballato()){
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<Card> getCards() {
    return mano.listIterator();
  }

  @Override
  public String getName() {
    return "Mazziere1";
  }

  //TODO i vari metodi richiesti per aderire all'interfaccia

}
