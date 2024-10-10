package com.myproject.beitragsrechner.model;

public class BeitragAnfrage {
    private String versicherung;
    private int alter;
    private String plz;
    private String deckung;

    public BeitragAnfrage () { }

    public BeitragAnfrage(String versicherung, int alter, String plz, String deckung) {
        this.versicherung = versicherung;
        this.alter = alter;
        this.plz = plz;
        this.deckung = deckung;
    }

    public String getVersicherung() {
        return versicherung;
    }

    public int getAlter() {
        return alter;
    }

    public String getPlz() {
        return plz;
    }

    public String getDeckung() {
        return deckung;
    }
}
