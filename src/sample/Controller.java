package sample;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TextField uneseniBrojN;
    public GridPane brojeviLista;

    public void UnosBroja(ActionEvent actionEvent) {
        var uneseniBroj = uneseniBrojN.getText();
        var broj = Integer.parseInt(uneseniBroj);
        var brojeviDjeljivi = BrojeviDjeljiviSaSumomSvojihCifara(broj);
        ShowListuBrojevaNaPanel(brojeviDjeljivi);
    }

    private void ShowListuBrojevaNaPanel(List<Integer> brojevi) {
        int row = 0;
        for (var broj : brojevi) {
            var label = new Label(broj.toString());
            brojeviLista.add(label, 0, row);
            row++;
        }
    }

    private List<Integer> BrojeviDjeljiviSaSumomSvojihCifara(int n) {
        List<Integer> brojeviDjeljiviSaSumomCifara = new ArrayList<>();
        for(int i = 1;i < n;i++) {
            int sumaCifara = SumaCifara(i);
            if(i % sumaCifara == 0) {
                brojeviDjeljiviSaSumomCifara.add(i);
            }
        }

        return brojeviDjeljiviSaSumomCifara;
    }

    private int SumaCifara(int n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n = n / 10;
        }
        return suma;
    }
}
