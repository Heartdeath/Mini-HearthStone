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
	private int valChoisie; 

	public Joueur(String nom, String nomHeros, Joueur jAdv) {
		this.jAdversaire = jAdv;
		this.nomJoueur = nom;
		this.enVie = true;
		this.mana = 1;
		listeCarteDuJoueurMain = new ArrayList<>();
		listeCarteEnJeux = new ArrayList<>();
		this.valChoisie = 0;
		this.selectionHeros(nomHeros);
	}
	
	public Joueur(String name) {
		this.jAdversaire = null;
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
		return jAdversaire;
	}

	public void setJoueurAdv(Joueur joueurAdv) {
		this.jAdversaire = joueurAdv;
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

	public int getValChoisi() {
		return 0;
	}
	
	public void setValChoisi(int valChoisi){
		this.valChoisie = valChoisi;
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
		int min = 1 , max = 9;
		int random = (int)(Math.random()*(max-min)) + min;
		
		FactoryCarte fc = null;
		
		if(this.getHeros().typeHero() == "Mage"){
			switch (random) {
				case 1: fc = new ChefDeRaid(this, jAdversaire);
						fc = new EffetPlus1Attaque(fc);
				return fc;
				case 2: fc = new ChevaucheurDeLoup(this, jAdversaire);
						fc = new EffetCharge(fc);
				return fc;
				case 3: fc = new SanglierBrocheroc(this, jAdversaire);
				return fc;
				case 4: fc = new SoldatDuComteDeLor(this, jAdversaire);
				        fc = new EffetProvocation(fc);
				return fc;
				case 5: fc = new YetiNoroit(this, jAdversaire);
				return fc;
				case 6: fc = new ExplosionDesArcanes(this, jAdversaire);
						fc = new EffetExplosionDesArcanes(fc);
				return fc;
				case 7: fc = new ImageMiroir(this, jAdversaire);
						fc = new EffetImageMiroir(fc);
				return fc;
				case 8: fc = new Metamorphose(this, jAdversaire);
						fc = new EffetMetamorphose(fc);
				return fc;
			}
		} else if(this.getHeros().typeHero() == "Guerrier"){
			switch (random) {
				case 1: fc = new ChefDeRaid(this, jAdversaire);
						fc = new EffetPlus1Attaque(fc);
				return fc;
				case 2: fc = new ChevaucheurDeLoup(this, jAdversaire);
						fc = new EffetCharge(fc);
				return fc;
				case 3: fc = new SanglierBrocheroc(this, jAdversaire);
				return fc;
				case 4: fc = new SoldatDuComteDeLor(this, jAdversaire);
				        fc = new EffetProvocation(fc);
				return fc;
				case 5: fc = new YetiNoroit(this, jAdversaire);
				return fc;
				case 6: fc = new AvocatCommisDoffice(this, jAdversaire);
						fc = new EffetProvocation(fc);
				return fc;
				case 7: fc = new MaitriseDuBlocage(this, jAdversaire);
						fc = new EffetMaitriseDuBlocage(fc);
				return fc;
				case 8: fc = new Tourbillon(this, jAdversaire);
						fc = new EffetTourbillon(fc);
				return fc;
			}
		} else if(this.getHeros().typeHero() == "Paladin"){
			switch (random) {
				case 1: fc = new ChefDeRaid(this, jAdversaire);
						fc = new EffetPlus1Attaque(fc);
				return fc;
				case 2: fc = new ChevaucheurDeLoup(this, jAdversaire);
						fc = new EffetCharge(fc);
				return fc;
				case 3: fc = new SanglierBrocheroc(this, jAdversaire);
				return fc;
				case 4: fc = new SoldatDuComteDeLor(this, jAdversaire);
				        fc = new EffetProvocation(fc);
				return fc;
				case 5: fc = new YetiNoroit(this, jAdversaire);
				return fc;
				case 6: fc = new BenedictionDePuissance(this, jAdversaire);
						fc = new EffetBenedictionDePuissance(fc);
				return fc;
				case 7: fc = new ChampionFrisselame(this, jAdversaire);
						fc = new EffetCharge(fc);
						fc = new EffetVolDeVie(fc);
				return fc;
				case 8: fc = new Consecration(this, jAdversaire);
						fc = new EffetConsecration(fc);
				return fc;
			}
		}
		return fc;
	}
	
	
	public void initialisationDesCartesEnMain(int rand){
		int pdM = getMana();
		if(rand == 1){
			ajoutCarteDansLaMain();
			ajoutCarteDansLaMain();
			ajoutCarteDansLaMain();
			setMana(pdM+1);
		}
		else if(rand == 2){
			ajoutCarteDansLaMain();
			ajoutCarteDansLaMain();
			ajoutCarteDansLaMain();
		}
	}
	
	
	public void ajoutCarteDansLaMain(){
		FactoryCarte carteAjout = tirageCarte();
		System.out.println(carteAjout.toString() + " a ete ajoute a votre main !");
		listeCarteDuJoueurMain.add(carteAjout);
	}
	
	public void ajoutDeCarteEnJeu(){
		int NumeroDeLaCarteDansLaMain = 1;
		FactoryCarte carteAJouer = listeCarteDuJoueurMain.get(NumeroDeLaCarteDansLaMain);
		listeCarteEnJeux.add(carteAJouer);
	}

	public void affichageDesCartesEnMain(){
		for(FactoryCarte c : listeCarteDuJoueurMain){
			System.out.println("|" +listeCarteDuJoueurMain.indexOf(c) + "|" + c.toString());
		}
	}
	
	public void affichageDesCartesEnJeu(){
		for(FactoryCarte c : listeCarteEnJeux){
			System.out.println("|" +listeCarteEnJeux.indexOf(c) + "|" + c.toString());
		}
	}
	
	public void affichageDesInfoJoueur(){
		System.out.println("Vie restante : " + heros.getVie());
		System.out.println("Mana         : " + getMana());
		System.out.println("A vous "+getName()+" !");
	}
}