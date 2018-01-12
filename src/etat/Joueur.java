package etat;

import java.util.ArrayList;

import cartes.FactoryCarte;
import cartes.commune.ChefDeRaid;
import cartes.commune.ChevaucheurDeLoup;
import cartes.commune.SanglierBrocheroc;
import cartes.commune.SoldatDuComteDeLor;
import cartes.commune.YetiNoroit;
import cartes.effect.Effect1DegatTOUSServiteur;
import cartes.effect.EffectCharge;
import cartes.effect.EffectConfere3AttaqueUnServiteur;
import cartes.effect.EffectInflige2DegatTousAdv;
import cartes.effect.EffectInfligeDegatAdversaire;
import cartes.effect.EffectInvoqueDeuxServiteurs;
import cartes.effect.EffectMaitriseDuBlocage;
import cartes.effect.EffectMetamorphose;
import cartes.effect.EffectPlus1AttaqueToutServiteurAllie;
import cartes.effect.EffectProvocation;
import cartes.effect.EffectVolDeVie;
import cartes.guerrier.AvocatCommisDoffice;
import cartes.guerrier.MaitriseDuBlocage;
import cartes.guerrier.Tourbillon;
import cartes.mage.ExplosionDesArcanes;
import cartes.mage.ImageMiroir;
import cartes.mage.Metamorphose;
import cartes.paladin.BenedictionDePuissance;
import cartes.paladin.ChampionFrisselame;
import cartes.paladin.Consecration;
import hero.*;
import power.PowerGuerrier;
import power.PowerMage;
import power.PowerPaladin;

public class Joueur {
	private Joueur joueurAdv;
	private String nomJoueur;
	private boolean enVie;
	private int mana;
	private Heros heros;
	private Etat etat;
	private ArrayList<FactoryCarte> listeCarteDuJoueurMain;
	private ArrayList<FactoryCarte> listeCarteEnJeux;
	private int valChoisie; //index de la carte cibl� pour un pouvoir/effet

	public Joueur(String name, String heros, Joueur joueurAdv) {
		this.joueurAdv = joueurAdv;
		this.nomJoueur = name;
		this.enVie = true;
		this.mana = 1;
		setHeros(heros);
		listeCarteDuJoueurMain = new ArrayList<>();
		listeCarteEnJeux = new ArrayList<>();
		this.valChoisie = 0;
	}
	
	public Joueur(String name) {
		this.joueurAdv = null;
		this.nomJoueur = name;
		this.enVie = true;
		this.mana = 1;
		listeCarteDuJoueurMain = new ArrayList<>();
		listeCarteEnJeux = new ArrayList<>();
	}
	
	public ArrayList<FactoryCarte> getListeCarteDuJoueurMain() {
		return listeCarteDuJoueurMain;
	}

	public void setListeCarteDuJoueurMain(ArrayList<FactoryCarte> listeCarteDuJoueurMain) {
		this.listeCarteDuJoueurMain = listeCarteDuJoueurMain;
	}

	public ArrayList<FactoryCarte> getListeCarteEnJeux() {
		return listeCarteEnJeux;
	}

	public void setListeCarteEnJeux(ArrayList<FactoryCarte> listeCarteEnJeux) {
		this.listeCarteEnJeux = listeCarteEnJeux;
	}
	
	public Joueur getJoueurAdv() {
		return joueurAdv;
	}

	public void setJoueurAdv(Joueur joueurAdv) {
		this.joueurAdv = joueurAdv;
	}
	
	public boolean isEnVie() {
		return enVie;
	}

	public void setEnVie(boolean enVie) {
		this.enVie = enVie;
	}

	public Heros getHeros() {
		return heros;
	}

	public void setHeros(String heros) {
		if(heros.equalsIgnoreCase("Mage")){
			this.heros = new HerosMage(joueurAdv, this);
			this.heros = new PowerMage(this.heros);
		} else if(heros.equalsIgnoreCase("Guerrier")){
			this.heros = new HerosGuerrier(joueurAdv, this);
			this.heros = new PowerGuerrier(this.heros);
		} else if(heros.equalsIgnoreCase("Paladin")){
			this.heros = new HerosPaladin(joueurAdv, this);
			this.heros = new PowerPaladin(this.heros);
		}
		System.out.println("Heros choisi +>" + getHeros());
		System.out.println("Pouvoir du hero +>" +getHeros().getPower());
	}

	public String getName() {
		return nomJoueur;
	}

	public void setName(String name) {
		this.nomJoueur = name;
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getValChoisi() {
		return 0;
	}
	
	public void setValChoisi(int valChoisi){
		this.valChoisie = valChoisi;
	}
	
	public FactoryCarte tirageCarte(){
		int min = 1 , max = 9;
		int random = (int)(Math.random()*(max-min)) + min;
		
		FactoryCarte fc = null;
		
		if(this.getHeros().typeHero() == "Mage"){
			switch (random) {
				case 1: fc = new ChefDeRaid(this, joueurAdv);
						fc = new EffectPlus1AttaqueToutServiteurAllie(fc);
				return fc;
				case 2: fc = new ChevaucheurDeLoup(this, joueurAdv);
						fc = new EffectCharge(fc);
				return fc;
				case 3: fc = new SanglierBrocheroc(this, joueurAdv);
				return fc;
				case 4: fc = new SoldatDuComteDeLor(this, joueurAdv);
				        fc = new EffectProvocation(fc);
				return fc;
				case 5: fc = new YetiNoroit(this, joueurAdv);
				return fc;
				case 6: fc = new ExplosionDesArcanes(this, joueurAdv);
						fc = new EffectInfligeDegatAdversaire(fc);
				return fc;
				case 7: fc = new ImageMiroir(this, joueurAdv);
						fc = new EffectInvoqueDeuxServiteurs(fc);
				return fc;
				case 8: fc = new Metamorphose(this, joueurAdv);
						fc = new EffectMetamorphose(fc);
				return fc;
			}
		} else if(this.getHeros().typeHero() == "Guerrier"){
			switch (random) {
				case 1: fc = new ChefDeRaid(this, joueurAdv);
						fc = new EffectPlus1AttaqueToutServiteurAllie(fc);
				return fc;
				case 2: fc = new ChevaucheurDeLoup(this, joueurAdv);
						fc = new EffectCharge(fc);
				return fc;
				case 3: fc = new SanglierBrocheroc(this, joueurAdv);
				return fc;
				case 4: fc = new SoldatDuComteDeLor(this, joueurAdv);
				        fc = new EffectProvocation(fc);
				return fc;
				case 5: fc = new YetiNoroit(this, joueurAdv);
				return fc;
				case 6: fc = new AvocatCommisDoffice(this, joueurAdv);
						fc = new EffectProvocation(fc);
				return fc;
				case 7: fc = new MaitriseDuBlocage(this, joueurAdv);
						fc = new EffectMaitriseDuBlocage(fc);
				return fc;
				case 8: fc = new Tourbillon(this, joueurAdv);
						fc = new Effect1DegatTOUSServiteur(fc);
				return fc;
			}
		} else if(this.getHeros().typeHero() == "Paladin"){
			switch (random) {
				case 1: fc = new ChefDeRaid(this, joueurAdv);
						fc = new EffectPlus1AttaqueToutServiteurAllie(fc);
				return fc;
				case 2: fc = new ChevaucheurDeLoup(this, joueurAdv);
						fc = new EffectCharge(fc);
				return fc;
				case 3: fc = new SanglierBrocheroc(this, joueurAdv);
				return fc;
				case 4: fc = new SoldatDuComteDeLor(this, joueurAdv);
				        fc = new EffectProvocation(fc);
				return fc;
				case 5: fc = new YetiNoroit(this, joueurAdv);
				return fc;
				case 6: fc = new BenedictionDePuissance(this, joueurAdv);
						fc = new EffectConfere3AttaqueUnServiteur(fc);
				return fc;
				case 7: fc = new ChampionFrisselame(this, joueurAdv);
						fc = new EffectCharge(fc);
						fc = new EffectVolDeVie(fc);
				return fc;
				case 8: fc = new Consecration(this, joueurAdv);
						fc = new EffectInflige2DegatTousAdv(fc);
				return fc;
			}
		}
		return fc;
	}
	
	
	public void initialiseMain(int rand){
		int pdM = getMana();
		if(rand == 1){
			addCardMain();
			addCardMain();
			addCardMain();
			setMana(pdM+1);
		}
		else if(rand == 2){
			addCardMain();
			addCardMain();
			addCardMain();
		}
	}
	
	
	
	public void addCardMain(){
		FactoryCarte carteAjout = tirageCarte();
		System.out.println(carteAjout.toString() + " a ete ajoute a votre main !");
		listeCarteDuJoueurMain.add(carteAjout);
	}
	
	public void addCardJeu(){
		int NumeroDeLaCarteDansLaMain = 1;
		FactoryCarte carteAJouer = listeCarteDuJoueurMain.get(NumeroDeLaCarteDansLaMain);
		listeCarteEnJeux.add(carteAJouer);
	}

	public void afficherCarteMain(){
		for(FactoryCarte c : listeCarteDuJoueurMain){
			System.out.println("|" +listeCarteDuJoueurMain.indexOf(c) + "|" + c.toString() /*Faire les toString des cartes (en gros ajouter leur nom)*/);
		}
	}
	
	public void afficherCardJeu(){
		for(FactoryCarte c : listeCarteEnJeux){
			System.out.println("|" +listeCarteEnJeux.indexOf(c) + "|" + c.toString() /*Faire les toString des cartes (en gros ajouter leur nom)*/);
		}
	}
	
	public void afficherInfoJoueur(){
		System.out.println("Vie restante : " + heros.getVie());
		System.out.println("Mana         : " + getMana());
		System.out.println("A vous "+getName()+" !");
	}
}
