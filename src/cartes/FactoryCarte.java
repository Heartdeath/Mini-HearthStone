package cartes;

import etat.Joueur;
/**
 * Classe abstraite utilisant qui utilise le design pattern factory pour cr�er les cartes
 * @author Pierre
 *
 */
public abstract class FactoryCarte{
	
	protected Joueur joueur;
	protected Joueur jAdversaire;
	protected int vie;
	protected int mana;
	protected int attaque;
	protected boolean peutAttaquer;
	protected boolean peutEtreAttaquer;
	
	
	/**
	 * @return le joueur � qui appartient la carte
	 */
	public abstract Joueur getJoueur();
	
	/**
	 * Met a jour le joueur � qui appartient la carte
	 * @param joueur le nouveau joueur � qui appartient la carte
	 */
	public abstract void setJoueur(Joueur joueur);
	
	/**
	 * @return le joueur adverse � qui appartient la carte
	 */
	public abstract Joueur getAdversaire();
	
	/**
	 * Met a jour le joueur adverse d'une carte
	 * @param jAdversaire le nouveau joueur adverse � qui appartient la carte
	 */
	public abstract void setAdversaire(Joueur jAdversaire);
	
	/**
	 * @return la vie que poss�de une carte
	 */
	public abstract int getVie();
	
	/**
	 * Met a jour la vie que poss�de une carte
	 * @param vie la nouvelle valeur attribu� � une carte
	 */
	public abstract void setVie(int vie);
	
	/**
	 * @return le mana que poss�de une carte
	 */
	public abstract int getMana();
	
	/**
	 * Met a jour le mana que poss�de une carte
	 * @param mana la nouvelle valeur attribu� au mana
	 */
	public abstract void setNbMana(int mana);
	
	/**
	 * @return l'attaque que poss�de une carte
	 */
	public abstract int getAttaque();
	
	/**
	 * Met a jour l'attaque que poss�de une carte
	 * @param attaque la nouvelle valeur attribu� � l'attaque
	 */
	public abstract void setAttaque(int attaque);
	
	/**
	 * Met a jour si une carte peut attaqu� ou non
	 * @param bool la nouvelle valeur attribu� a la carte si elle peut attaquer ou non
	 */
	public abstract void setPeutAttaquer(boolean bool);
	
	/**
	 * @return si une carte peut attaquer ou non
	 */
	public abstract boolean getPeutAttaquer();
	
	/**
	 * Met a jour si une carte peut �tre attaqu� ou non
	 * @param boolla nouvelle valeur attribu� a la carte si elle peut �tre attaquer ou non
	 */
	public abstract void setPeutEtreAttaquer(boolean bool);
	
	/**
	 * @return si une carte peut �tre attaquer ou non
	 */
	public abstract boolean getPeutEtreAttaquer();
	
	/**
	 * @return l'effet que poss�de une carte
	 */
	public abstract String getEffet();
	
}
