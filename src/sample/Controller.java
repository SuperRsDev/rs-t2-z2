package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Arrays;
import java.util.Comparator;

public class Controller {
    public TextField uneseniTekst;
    public Label izmjenjeniTekst;

    public void UnosTeksta(ActionEvent actionEvent) {
        var tekst = uneseniTekst.getText();
        var noviTekstSaNajduzomRijeci = NajduzaRijecUVelikaSlova(tekst);
        izmjenjeniTekst.setText(noviTekstSaNajduzomRijeci);
    }

     private String NajduzaRijecUVelikaSlova(String tekst) {
        String[] rijeci = tekst.trim().split("\\s+");
        Arrays.sort(rijeci, Comparator.comparingInt(String::length).reversed()); // Sortiranje u desc orderuv
        var najduzaRijec = rijeci[0];
        var najduzaRijecVelikaSlova = najduzaRijec.toUpperCase();
        return tekst.replaceAll("\\b"+ najduzaRijec +"\\b", najduzaRijecVelikaSlova);
     }

}

