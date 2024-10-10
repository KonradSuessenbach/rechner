package com.myproject.beitragsrechner.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeitragsBerechnung {
    private static int nextId = 1;
    private static List<BeitragsBerechnung> db = new ArrayList<BeitragsBerechnung>();
    private int id;
    private String versicherung;
    private double beitrag;
    private Map<String,Integer> details;


    public BeitragsBerechnung () { }

    public BeitragsBerechnung (BeitragAnfrage anfrage) {
        this.id = nextId++;
        this.versicherung = anfrage.getVersicherung();
        details = extrahiereDetails(anfrage);
        this.beitrag = berechneBeitrag();
        db.add(this);
    }

    private HashMap extrahiereDetails(BeitragAnfrage anfrage) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        int value = 0;
        switch(anfrage.getVersicherung().toLowerCase()) {
            case "auto" -> value = 50;
            case "haus" -> value = 40;
            case "gesundheit" -> value = 60;
        }
        map.put("basisbeitrag",value);

        if(anfrage.getAlter() < 25) {
            value = 20;
        } else if (anfrage.getAlter() < 50) {
            value = 10;
        } else {
            value = 5;
        }
        map.put("alterszuschlag",value);

        if (anfrage.getPlz().startsWith("1") || anfrage.getPlz().startsWith("2")) {
            value = 10;
        } else if (anfrage.getPlz().startsWith("3") || anfrage.getPlz().startsWith("4") || anfrage.getPlz().startsWith("5")) {
            value = 5;
        } else {
            value = 0;
        }
        map.put("plz-zuschlag", value);

        switch (anfrage.getDeckung().toLowerCase()) {
            case "basis" -> value = 0;
            case "premium" -> value = 15;
            case "vip" -> value = 30;
        }
        map.put("deckungszuschlag", value);

        return map;
    }

    private double berechneBeitrag () {
        double b = details.get("basisbeitrag");
        double prozent = (details.get("alterszuschlag") + details.get("plz-zuschlag") + details.get("deckungszuschlag")) / 100.0;
        b += b * prozent;

        return b;
    }

    public static BeitragsBerechnung getBeitragBerechnungById (int id) {
        for (BeitragsBerechnung berechnung: db) {
            if(berechnung.getId() == id) {
                return berechnung;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public String getVersicherung() {
        return versicherung;
    }

    public double getBeitrag() {
        return beitrag;
    }

    public Map<String, Integer> getDetails() {
        return details;
    }
}
