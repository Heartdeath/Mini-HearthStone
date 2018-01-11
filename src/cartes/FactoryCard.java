package cartes;

import etat.Joueur;
/**
 * Classe abstraite utilisant le design pattern factory pour la creation
 * de carte
 * @author Pierre
 *
 */
public abstract class FactoryCard{
	
	/**
	 * @return le joueur de la carte
	 */
	public abstract Joueur getJoueur();
	
	/**
	 * Met a jour le joueur d'une carte
	 * @param j étant le nouveau joueur attribue a la carte
	 */
	public abstract void setJoueur(Joueur j);
	
	/**
	 * @return le joueur adversaire a la carte
	 */
	public abstract Joueur getAdversaire();
	
	/**
	 * Met a jour le joueur adverse d'une carte
	 * @param jAdv étant le nouveau joueur adverse attribue a la carte
	 */
	public abstract void setAdversaire(Joueur jAdv);
	
	/**
	 * @return la vie d'une carte
	 */
	public abstract int getVie();
	
	/**
	 * Met a jour la vie d'une carte
	 * @param vie étant la nouvelle valeur attribué à la vie
	 */
	public abstract void setVie(int vie);
	
	/**
	 * @return le mana d'une carte
	 */
	public abstract int getNbMana();
	
	/**
	 * Met a jour le mana d'une carte
	 * @param mana étant la nouvelle valeur attribué au mana
	 */
	public abstract void setNbMana(int mana);
	
	/**
	 * @return l'attaque d'une carte
	 */
	public abstract int getAttaque();
	
	/**
	 * Met a jour l'attaque d'une carte
	 * @param attaque étant la nouvelle valeur attribué à l'attaque
	 */
	public abstract void setAttaque(int attaque);
	
	/**
	 * Met a jour si une carte peut attaquer ou non
	 * @param bool étant la nouvelle valeur attribué a la carte si elle peut attaquer ou non
	 */
	public abstract void setPeutAttaquer(boolean bool);
	
	/**
	 * @return si une carte peut attaquer ou non
	 */
	public abstract boolean getPeutAttaquer();
	
	/**
	 * Met a jour si une carte peut être attaquer ou non
	 * @param bool étant la nouvelle valeur attribué a la carte si elle peut être attaquer ou non
	 */
	public abstract void setPeutEtreAttaquer(boolean bool);
	
	/**
	 * @return si une carte peut être attaquer ou non
	 */
	public abstract boolean getPeutEtreAttaquer();
	
	/**
	 * @return l'effet d'une carte
	 */
	public abstract String getEffect();
	
}
