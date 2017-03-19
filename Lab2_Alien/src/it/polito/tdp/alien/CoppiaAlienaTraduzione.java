package it.polito.tdp.alien;

import java.util.LinkedList;

public class CoppiaAlienaTraduzione {
	
	private String aliena;
	/*private String traduzione;*/
	LinkedList <String> elencoTraduzioni;
	
	public CoppiaAlienaTraduzione(String aliena) {
		super();
		this.aliena = aliena;
		/*this.traduzione = traduzione;*/
		elencoTraduzioni = new LinkedList <String>();
	}
	public String getAliena() {
		return aliena;
	}
	/*public String getTraduzione() {
		return traduzione;
	}
	public void setTraduzione(String traduzione) {
		this.traduzione = traduzione;
	}*/
	public void addNuovaTraduzione(String traduzione){
		elencoTraduzioni.add(traduzione);
	}
	

}
