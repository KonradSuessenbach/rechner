package com.myproject.beitragsrechner.controller;

import com.myproject.beitragsrechner.exception.BeitragMissingParameterException;
import com.myproject.beitragsrechner.model.BeitragAnfrage;
import com.myproject.beitragsrechner.model.BeitragsBerechnung;
import com.myproject.beitragsrechner.exception.BeitragRechnerNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class BeitragsrechnerController {

    @PostMapping("/beitrag-berechnen")
    public BeitragsBerechnung berechneBeitrag (@RequestBody BeitragAnfrage anfrage) {
        if(anfrage.getVersicherung() == null) {
            throw new BeitragMissingParameterException("versicherung");
        }
        if(anfrage.getAlter() <= 0) {
            throw new BeitragMissingParameterException("alter");
        }
        if(anfrage.getPlz() == null) {
            throw new BeitragMissingParameterException("postleitzahl");
        }
        if(anfrage.getDeckung() == null) {
            throw new BeitragMissingParameterException("deckungsumfang");
        }
        return new BeitragsBerechnung(anfrage);
    }


    @GetMapping("beitrag/:{id}")
    public BeitragsBerechnung getBeitragBerechnung (@PathVariable int id) {
        BeitragsBerechnung gesuchterBeitrag = BeitragsBerechnung.getBeitragBerechnungById(id);
        if (gesuchterBeitrag == null) {
            throw new BeitragRechnerNotFoundException("Es wurde keine Beitragsberechnung mit der id " + id + " gefunden");
        }
        return gesuchterBeitrag;
    }
}
