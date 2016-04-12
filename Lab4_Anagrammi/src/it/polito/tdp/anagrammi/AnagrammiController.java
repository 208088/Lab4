package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.model.AnagrammaModel;
import it.polito.tdp.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {
	private AnagrammaModel model= new AnagrammaModel();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField lblWord;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextFlow txtparole;

    @FXML
    private Button btnReset;

    @FXML
    void CalcolaAnagramma(ActionEvent event) {
    	txtparole.getChildren().clear();
    	String parola=lblWord.getText();
    	if(parola.compareTo("")==0) txtparole.getChildren().add(new Text("Inserire una parola"));
    	List<RichWord> parole= model.getAnagrammi(parola);
    	Text t;
    	for (RichWord r : parole) {
    		t= new Text(r.getParola()+"\n");
    		if(!r.isEsiste())
    		{
    			t.setFill(Color.RED);
    		}
    		txtparole.getChildren().add(t);
    		
			
		}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtparole.getChildren().clear();
    	lblWord.clear();
    }

    @FXML
    void initialize() {
        assert lblWord != null : "fx:id=\"lblWord\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtparole != null : "fx:id=\"txtparole\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
}

