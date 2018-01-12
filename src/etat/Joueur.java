package etat;

import java.util.ArrayList;

import cartes.FactoryCarte;
import cartes.commune.ChefDeRaid;
import cartes.commune.ChevaucheurDeLoup;
import cartes.commune.SanglierBrocheroc;
import cartes.commune.SoldatDuComteDeLor;
import cartes.commune.YetiNoroit;
import cartes.effet.EffetBenedictionDePuissance;
import cartes.effet.EffetCharge;
import cartes.effet.EffetConsecration;
import cartes.effet.EffetExplosionDesArcanes;
import cartes.effet.EffetImageMiroir;
import cartes.effet.EffetMaitriseDuBlocage;
import cartes.effet.EffetMetamorphose;
import cartes.effet.EffetPlus1Attaque;
import cartes.effet.EffetProvocation;
import cartes.effet.EffetTourbillon;
import cartes.effet.EffetVolDeVie;
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
import power.*;



public class Joueur {
	private Joueur jAdversaire;
	private String nomJoueur;
	private boolean enVie;
	private int mana;
	private Heros heros;
	private Etat etat;
	private ArrayList<FactoryCarte> listeCarteDuJoueurMain;
	private ArrayList<FactoryCarte> listeCarteEnJeux;

	public Joueur(String nom, String nomHeros, Joueur jAdversaire) {
		this.jAdversaire = jAdversaire;
		this.nomJoueur = nom;
		this.enVie = true;
		this.mana = 1;
		listeCarteDuJoueurMain = new ArrayList<>();
		listeCarteEnJeux = new ArrayList<>();
		this.selectionHeros(nomHeros);
	}
	
	public Joueur(String name) {
		this.nomJoueur = name;
		this.enVie = true;
		this.mana = 1;
		listeCarteDuJoueurMain = new ArrayList<>();
		listeCarteEnJeux = new ArrayList<>();
	}
	
	public ArrayList<FactoryCarte> getListeCarteDuJoueurMain() {
		return listeCarteDuJoueurMain;
	}

	public void setListeCarteMain(ArrayList<FactoryCarte> listeCarteDuJoueurMain) {
		this.listeCarteDuJoueurMain = listeCarteDuJoueurMain;
	}

	public ArrayList<FactoryCarte> getListeCarteEnJeux() {
		return listeCarteEnJeux;
	}

	public void setListeCarteJeux(ArrayList<FactoryCarte> listeCarteEnJeux) {
		this.listeCarteEnJeux = listeCarteEnJeux;
	}
	
	public Joueur getJoueurAdv() {
		return jAdversaire;
	}

	public void setJoueurAdv(Joueur jAdversaire) {
		this.jAdversaire = jAdversaire;
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

	public void setHeros(Heros heros) {
		this.heros = heros;
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
	public void afficherCarteMain(){
		for(FactoryCarte c : listeCarteDuJoueurMain){
			System.out.println("|" +listeCarteDuJoueurMain.indexOf(c) + "|" + c.toString() /*Faire les toString des cartes (en gros ajouter leur nom)*/);
		}
	}
	public void selectionHeros(String h) {
		if(h.equalsIgnoreCase("Mage")){
			
			this.heros = new HerosMage(jAdversaire, this);
			this.heros = new PowerMage(this.heros);
			
		} else if(h.equalsIgnoreCase("Guerrier")){
			
			this.heros = new HerosGuerrier(jAdversaire, this);
			this.heros = new PowerGuerrier(this.heros);
			
		} else if(h.equalsIgnoreCase("Paladin")){
			
			this.heros = new HerosPaladin(jAdversaire, this);
			this.heros = new PowerPaladin(this.heros);
		}
	}
	
	public FactoryCarte tirageCarte(){
		int min = 1;
		int max = 9;
		int random = (int)(Math.random()*(max-min)) + min;
		
		FactoryCarte factoryCarte = null;
		
		if(this.getHeros().typeHero() == "Mage"){
			switch (random) {
				case 1: factoryCarte = new ChefDeRaid(this, jAdversaire);
						factoryCarte = new EffetPlus1Attaque(factoryCarte);
				return factoryCarte;
				
				case 2: factoryCarte = new ChevaucheurDeLoup(this, jAdversaire);
						factoryCarte = new EffetCharge(factoryCarte);
				return factoryCarte;
				
				case 3: factoryCarte = new SanglierBrocheroc(this, jAdversaire);
				return factoryCarte;
				
				case 4: factoryCarte = new SoldatDuComteDeLor(this, jAdversaire);
				        factoryCarte = new EffetProvocation(factoryCarte);
				return factoryCarte;
				
				case 5: factoryCarte = new YetiNoroit(this, jAdversaire);
				return factoryCarte;
				
				case 6: factoryCarte = new ExplosionDesArcanes(this, jAdversaire);
						factoryCarte = new EffetExplosionDesArcanes(factoryCarte);
				return factoryCarte;
				
				case 7: factoryCarte = new ImageMiroir(this, jAdversaire);
						factoryCarte = new EffetImageMiroir(factoryCarte);
				return factoryCarte;
				
				case 8: factoryCarte = new Metamorphose(this, jAdversaire);
						factoryCarte = new EffetMetamorphose(factoryCarte);
				return factoryCarte;
			}
		} else if(this.getHeros().typeHero() == "Guerrier"){
			switch (random) {
				case 1: factoryCarte = new ChefDeRaid(this, jAdversaire);
						factoryCarte = new EffetPlus1Attaque(factoryCarte);
				return factoryCarte;
				
				case 2: factoryCarte = new ChevaucheurDeLoup(this, jAdversaire);
						factoryCarte = new EffetCharge(factoryCarte);
				return factoryCarte;
				
				case 3: factoryCarte = new SanglierBrocheroc(this, jAdversaire);
				return factoryCarte;
				
				case 4: factoryCarte = new SoldatDuComteDeLor(this, jAdversaire);
				        factoryCarte = new EffetProvocation(factoryCarte);
				return factoryCarte;
				
				case 5: factoryCarte = new YetiNoroit(this, jAdversaire);
				return factoryCarte;
				
				case 6: factoryCarte = new AvocatCommisDoffice(this, jAdversaire);
						factoryCarte = new EffetProvocation(factoryCarte);
				return factoryCarte;
				
				case 7: factoryCarte = new MaitriseDuBlocage(this, jAdversaire);
						factoryCarte = new EffetMaitriseDuBlocage(factoryCarte);
				return factoryCarte;
				
				case 8: factoryCarte = new Tourbillon(this, jAdversaire);
						factoryCarte = new EffetTourbillon(factoryCarte);
				return factoryCarte;
			}
		} else if(this.getHeros().typeHero() == "Paladin"){
			switch (random) {
			
				case 1: factoryCarte = new ChefDeRaid(this, jAdversaire);
						factoryCarte = new EffetPlus1Attaque(factoryCarte);
				return factoryCarte;
				
				case 2: factoryCarte = new ChevaucheurDeLoup(this, jAdversaire);
						factoryCarte = new EffetCharge(factoryCarte);
				return factoryCarte;
				
				case 3: factoryCarte = new SanglierBrocheroc(this, jAdversaire);
				return factoryCarte;
				
				case 4: factoryCarte = new SoldatDuComteDeLor(this, jAdversaire);
				        factoryCarte = new EffetProvocation(factoryCarte);
				return factoryCarte;
				
				case 5: factoryCarte = new YetiNoroit(this, jAdversaire);
				return factoryCarte;
				
				case 6: factoryCarte = new BenedictionDePuissance(this, jAdversaire);
						factoryCarte = new EffetBenedictionDePuissance(factoryCarte);
				return factoryCarte;
				
				case 7: factoryCarte = new ChampionFrisselame(this, jAdversaire);
						factoryCarte = new EffetCharge(factoryCarte);
						factoryCarte = new EffetVolDeVie(factoryCarte);
				return factoryCarte;
				
				case 8: factoryCarte = new Consecration(this, jAdversaire);
						factoryCarte = new EffetConsecration(factoryCarte);
				return factoryCarte;
			}
		}
		return factoryCarte;
	}
	
	
	public void cartesEnMain(int rand){
		int pointDeMana = getMana();
		if(rand == 1){
			
			ajoutCartesMain();
			ajoutCartesMain();
			ajoutCartesMain();
			setMana(pointDeMana+1);
			
		}
		else if(rand == 2){
			
			ajoutCartesMain();
			ajoutCartesMain();
			ajoutCartesMain();
		}
	}
	
	
	public void ajoutCartesMain(){
		FactoryCarte carteAjout = tirageCarte();
		listeCarteDuJoueurMain.add(carteAjout);
	}
	
	public void ajoutCarteJeu(){
		int NumeroDeLaCarteDansLaMain = 1;
		FactoryCarte carteAJouer = listeCarteDuJoueurMain.get(NumeroDeLaCarteDansLaMain);
		listeCarteEnJeux.add(carteAJouer);
	}

	public void affichageCartesMain(){
		for(FactoryCarte c : listeCarteDuJoueurMain){
			System.out.println("--" +listeCarteDuJoueurMain.indexOf(c) + "--" + c.toString());
		}
	}
	
	public void affichageCartesJeu(){
		for(FactoryCarte c : listeCarteEnJeux){
			System.out.println("--" +listeCarteEnJeux.indexOf(c) + "--" + c.toString());
		}
	}
	
	public void affichageInfoJoueur(){
		System.out.println("Vie  : " + heros.getVie());
		System.out.println("Mana : " + getMana());
		System.out.println("A votre tour "+getName());
	}
}