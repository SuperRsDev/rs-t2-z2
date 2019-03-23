package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.*;
import java.util.stream.Collectors;

public class Controller {

    public TextField uneseniBrojElemenata;
    public TextField uneseniElementi;
    public Label prikaziGreske;
    public ListView listaElemenata;

    public void UnosBrojaElemenata() {
         var brojElemenata = getNumberOfElements();
        int maxNumberOfElements = 100;
        if (brojElemenata > maxNumberOfElements) {
             prikaziGreske.setText(String.format("Broj elemenata prevelik, max je %s", maxNumberOfElements));
         }
    }

    public void UnosElemenata() {
         var text = uneseniElementi.getText();
        List<String> brojevi = Arrays.asList(text.split("\\s+"));
        if(brojevi.size() != getNumberOfElements()) {
            prikaziGreske.setText("Pogresan broj unesenih elemenata");
            listaElemenata.setVisible(false);
            return;
        }

        List<Integer> uneseniBrojevi = brojevi.stream().map(Integer::parseInt).collect(Collectors.toList());
        int[] veciBrojevi = VratiBrojClanovaKojiSuVeciOdMaxBroja(uneseniBrojevi);
        prikaziElementeUListView(veciBrojevi);
    }

    private int getNumberOfElements() {
        return Integer.parseInt(uneseniBrojElemenata.getText());
    }

    private static int[] VratiBrojClanovaKojiSuVeciOdMaxBroja(List<Integer> niz) {
        int najveci = Collections.max(niz);
        int[] brojevi = niz.stream().mapToInt(i->i).toArray();
        brojevi = BrojClanovaVeciOdElementa(brojevi, najveci);
        return brojevi;
    }

    private static int[] BrojClanovaVeciOdElementa(int[] niz, int element) {
        return Arrays.stream(niz).filter(x -> x > Math.sqrt(element)).toArray();
    }

    private void prikaziElementeUListView(int[] brojevi) {
        listaElemenata.getItems().clear();
        listaElemenata.setVisible(true);
        List<Integer> elementiUListi = listaElemenata.getItems();
        Arrays.stream(brojevi).forEach(elementiUListi::add);
    }
}

