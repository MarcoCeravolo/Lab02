/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	Dizionario dizionario = new Dizionario();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="bottonClear"
    private Button bottonClear; // Value injected by FXMLLoader

    @FXML // fx:id="txtInserimento"
    private TextField txtInserimento; // Value injected by FXMLLoader

    @FXML // fx:id="bottonTraslate"
    private Button bottonTraslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doClear(ActionEvent event) {
    	txtResult.clear();
    }

    @FXML
    void doInsertorTraslate(ActionEvent event) {
    	String inputText = txtInserimento.getText();
    	inputText.toLowerCase();
    	String array[]=inputText.split(" ");
    	if(array.length==1){
    		int cont=0;
    		for(int i=0; i<inputText.length(); i++){
    			char daTestare = inputText.charAt(i);
    			if(!Character.isLetter(daTestare)){
    				if(daTestare!='?'){
    					txtResult.setText("Errore: inserire solo caratteri alfabetici!");
    					return;
    				}
    			}
    			if(daTestare=='?')
    				cont++;
    		}
    		if(cont>1){
    			txtResult.setText("La parola da ricercare può contenere al massimo un solo ? per regola wildcard");
    			return;
    		}
    		else{
    			for(CoppiaAlienaTraduzione cat : dizionario.getDizionario()){
    				if(inputText.contains("?")){	
    					int posizione = 0;
    					for(int i=0; i<inputText.length(); i++)
    						if(inputText.charAt(i)=='?'){
    							posizione = i;
    							break;
    						}
    					boolean trovataDifferenza = false;
    					if(inputText.length()==cat.getAliena().length()){
    						for(int j=0; j<posizione; j++)
    							if(inputText.charAt(j)!=cat.getAliena().charAt(j))
    								trovataDifferenza = true;
    						for(int k=posizione+1; k<inputText.length(); k++)
    							if(inputText.charAt(k)!=cat.getAliena().charAt(k))
    								trovataDifferenza = true;
    					}
    					if (trovataDifferenza == false)
    						inputText=cat.getAliena();
    				}
    				if(cat.getAliena().compareTo(inputText)==0){
    					String risultato="";
    					for(String traduzione : cat.elencoTraduzioni){
    					risultato+=traduzione+"\n";
    					}
    					txtResult.setText(risultato);
    				}
    			}
    		}
    	}
    	else if (array.length==2){
    		String parolaAliena = array[0];
    		for(int i=0; i<parolaAliena.length(); i++){
    			char daTestare = parolaAliena.charAt(i);
    			if(!Character.isLetter(daTestare)){
    				txtResult.setText("Errore: inserire solo caratteri alfabetici!");
    				return;
    			}
    		}
    		String traduzione = array[1];
    		for(int i=0; i<traduzione.length(); i++){
    			char daTestare = traduzione.charAt(i);
    			if(!Character.isLetter(daTestare)){
    				txtResult.setText("Errore: inserire solo caratteri alfabetici!");
    				return;
    			}
    		}
    		dizionario.addTraduzione(parolaAliena, traduzione);
    		txtResult.setText("Aggiunta traduzione: "+parolaAliena+" = "+traduzione);
    	}
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert bottonClear != null : "fx:id=\"bottonClear\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtInserimento != null : "fx:id=\"txtInserimento\" was not injected: check your FXML file 'Alien.fxml'.";
        assert bottonTraslate != null : "fx:id=\"bottonTraslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}
