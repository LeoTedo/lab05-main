package it.unimi.di.prog2.blackjack;

import ca.mcgill.cs.stg.solitaire.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
  public static int cardValue(Card c) {
    return Math.min(c.getRank().ordinal() + 1, 10);
  }

    public static List<Sfidante> getSfidanti() {
        return sfidanti;
    }

    public static List<Sfidante> sfidanti = new ArrayList<>();
  public static void main(String[] args) {
    Mazziere banco = new Mazziere();

    Sfidante carlo = new Sfidante("Carlo", banco);
    Sfidante mattia = new Sfidante("Mattia", banco);
    Sfidante violetta = new Sfidante("Violetta", banco);

      sfidanti.add(carlo);
      carlo.setStrategia(new Risk(new RandomStrategy(new Sto())));
      sfidanti.add(mattia);
      mattia.setStrategia(new Risk(new RandomStrategy(new Sto())));
      sfidanti.add(violetta);
      violetta.setStrategia(new Risk(new RandomStrategy(new Sto())));

    for (Sfidante sfidante : sfidanti) {
      sfidante.carteIniziali();
    }
    banco.carteIniziali();

    int sballati = 0;
    for (Sfidante sfidante : sfidanti) {
      sfidante.gioca();
      if (sfidante.isSballato()) sballati++;
      }

      if (sballati < sfidanti.size()){
      banco.gioca();
      }

   System.out.println(banco.getPunti());
    for (Sfidante sfidante : sfidanti) {
      System.out.println(sfidante.getName());
      System.out.println(sfidante.getPunti());
      if (sfidante.isSballato() || (sfidante.getPunti() < banco.getPunti() && !banco.isSballato()))
        System.out.println("Vince il banco.");
      else if (banco.isSballato() || sfidante.getPunti() > banco.getPunti())
        System.out.println("Il banco perde!!!");
      else
        System.out.println("Pareggio.");
    }
  }

}
