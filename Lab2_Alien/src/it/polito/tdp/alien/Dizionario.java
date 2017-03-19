package it.polito.tdp.alien;

import java.util.*;

public class Dizionario {
	
	LinkedList <CoppiaAlienaTraduzione> dizionario;

	public Dizionario() {
		super();
		dizionario = new LinkedList <CoppiaAlienaTraduzione>();
	}
	
	public void addTraduzione(String parolaAliena, String traduzione){
		/*CoppiaAlienaTraduzione nuovaTraduzione = new CoppiaAlienaTraduzione(parolaAliena, traduzione);
		dizionario.add(nuovaTraduzione);*/
		for(CoppiaAlienaTraduzione cat : dizionario){
			if(cat.getAliena().compareTo(parolaAliena)==0){
				cat.addNuovaTraduzione(traduzione);
				return;
			}
		}
		CoppiaAlienaTraduzione nuovaTraduzione = new CoppiaAlienaTraduzione(parolaAliena);
		nuovaTraduzione.addNuovaTraduzione(traduzione);
		dizionario.add(nuovaTraduzione);
	}
	
	public LinkedList <CoppiaAlienaTraduzione> getDizionario() {
		return dizionario;
	}
	
}
