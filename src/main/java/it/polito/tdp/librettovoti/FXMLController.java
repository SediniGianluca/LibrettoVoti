package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Libretto model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;
    
    @FXML
    private DatePicker pickerData;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    void HandleInserisci(ActionEvent event) {
    	//1 leggi e controlla i dati 
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length()==0) {
    		txtResult.setText("ERRORE:nome esame vuoto!");
    		return;
    	}
    	String votoEsame = txtVoto.getText();
    	int votoInt= 0;
    	try {
    		votoInt= Integer.parseInt(votoEsame);
    	}
    	catch(NumberFormatException ex) {
    		txtResult.setText("ERRORE:Il voto deve essere un numero intero!");
    		return;
    	}
    	if(votoInt<18||votoInt>30) {
    		txtResult.setText("ERRORE:Il voto deve essere compreso tra 18 e 30!");
    		return;
    	}

    	LocalDate data=pickerData.getValue();
    	if(data==(null)) {
    		txtResult.setText("ERRORE:Devi inserire una data!");
    		return;
    	}
    	// controlli vari da fare qua ad eccezione di quelli di logica!!!
    	//2 Esegui l' azione
    	Voto voto= new Voto(nomeEsame,votoInt,data);
    	model.add(voto);
    	//3 Aggiorna i risultati(view)
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();
    	pickerData.setValue(null);
    }
    
    public void setModel(Libretto model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert pickerData != null : "fx:id=\"pickerData\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
