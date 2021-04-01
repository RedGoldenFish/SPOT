package main;

import it.unisa.dia.gas.jpbc.Element;
import it.unisa.dia.gas.jpbc.Pairing;
import it.unisa.dia.gas.plaf.jpbc.pairing.PairingFactory;

public class Sys_init {
	public Pairing params;
	
	Sys_init(){
		set_params("params.properties"); //Choix du groupe bilinéaire asymétrique - Comment choisir les paramètres ?
		//Qu'est-ce que le security parameter lambda ?
		//est-ce que tous les acteurs du systèmes ont accès à la même asymmetric bilineare setting ?
	}
	
	public void set_params(String properties_file) {
		params=PairingFactory.getPairing(properties_file);
	}
	
	public void ha_keygen() {
		
		Element secret_key_ha = params.getZr().newRandomElement(); //skha = x random dans Zn*
		Element g2_ha = params.getG2().newRandomElement(); //Est-ce vraiment g2 ?
		Element public_key_ha = g2_ha.duplicate().powZn(secret_key_ha);

	}
	
	public void s_keygen() { //même principe que ha_keygen mais pour le serveur
		
		Element secret_key_server = params.getZr().newRandomElement(); 
		Element g2_server = params.getG2().newRandomElement(); 
		Element public_key_server = g2_server.duplicate().powZn(secret_key_server);
		
	}
	
	public void setup_proxyGrPA() { //que siginifie CRS ? g,h ?
		
		//STEP 4
		
		Element gr1 = params.getG1().newRandomElement();
		Element hu1 = params.getG1().newRandomElement();
		
		Element gr2 = params.getG2().newRandomElement();
		Element hu2 = params.getG2().newRandomElement();
		
		Element y11 = params.getZr().newRandomElement();
		Element y12 = params.getZr().newRandomElement();
		Element d11 =  params.getZr().newRandomElement();
		Element d12 =  params.getZr().newRandomElement();
		
		Element[] y2 = new Element[8]; //tableau de taille 8 afin de commencer les indices à 1 pour éviter confusion
		y2[0]=params.getZr().newZeroElement();
		Element[] d2 = new Element[8]; 
		d2[0]=params.getZr().newZeroElement();
		
		for (int j=1; j<=7; j++) {
			y2[j]=params.getZr().newRandomElement();
			d2[j]=params.getZr().newRandomElement();
		}
		
		//STEP 5 - faute à "g2i = gr2^y2j" ?
		
		Element g11 = gr1.duplicate().powZn(y11);
		Element g12 = gr1.duplicate().powZn(y12);
		Element h11 = hu1.duplicate().powZn(d11);
		Element h12 = hu1.duplicate().powZn(d12);
		
		Element[] g2 = new Element[8];
		g2[0]=params.getZr().newZeroElement();		
		Element[] h2 = new Element[8];
		h2[0]=params.getZr().newZeroElement();
		
		for (int j=1; j<=7; j++) {
			g2[j] = gr2.duplicate().powZn(y2[j]);
			h2[j] = hu2.duplicate().powZn(d2[j]);
		}
		
		//STEP 6
		
		Element y1z = params.getZr().newRandomElement();
		Element d1z = params.getZr().newRandomElement();
		Element y2z = params.getZr().newRandomElement();
		Element d2z = params.getZr().newRandomElement();
		
		//STEP 7
		
		Element g1z = gr1.duplicate().powZn(y1z);
		Element h1z = hu1.duplicate().powZn(d1z);
		Element g2z = gr2.duplicate().powZn(y2z);
		Element h2z = hu2.duplicate().powZn(d2z);
		
		//STEP 8
		
		Element a1 = params.getZr().newRandomElement();
		Element a2 = params.getZr().newRandomElement();
		Element b1 = params.getZr().newRandomElement();
		Element b2 = params.getZr().newRandomElement();
		
		//STEP 9-10-11-12  sous quelle forme doit etre le couple ? est-ce juste plusieurs éléments à la suite ?
		// meme question pour les clés
		
		//STEP 14 Comment obtenir le générateur ?
		
		//STEP 15-16-17
			
	}
	
	void join_ProxyGrppa() {
		Element lambda = params.getZr().newRandomElement(); // INPUTS A CHANGER
		Element skg = params.getZr().newRandomElement();
		
		//STEP 4
		
		Element gr = params.getG1().newRandomElement();
		Element hu = params.getG1().newRandomElement();
		
		Element y = params.getZr().newRandomElement();
		Element d = params.getZr().newRandomElement();
		
		//STEP 5
		
		Element gy = gr.duplicate().powZn(y);
		Element hd = hu.duplicate().powZn(d);
		
		//STEP 6
		
		Element yz = params.getZr().newRandomElement();
		Element dz = params.getZr().newRandomElement();
		
		//STEP 7
		
		Element gz = gr.duplicate().powZn(yz);
		Element hz = hu.duplicate().powZn(dz);
		
		//STEP 8
		
		Element a = params.getZr().newRandomElement();
		Element b = params.getZr().newRandomElement();
		
		//STEP 9-10 question couples
		
		//STEP 11 ??????????
	}
	
	
	
}
