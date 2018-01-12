package cartes;

import etat.Joueur;
/**
 * Classe abstraite utilisant qui utilise le design pattern factory pour créer les cartes
 * @author Pierre
 *
 */
public abstract class FactoryCarte{
	
	/**
	 * @return le joueur à qui appartient la carte
	 */
	public abstract Joueur getJoueur();
	
	/**
	 * Met a jour le joueur à qui appartient la carte
	 * @param joueur le nouveau joueur à qui appartient la carte
	 */
	public abstract void setJoueur(Joueur joueur);
	
	/**
	 * @return le joueur adverse à qui appartient la carte
	 */
	public abstract Joueur getAdversaire();
	
	/**
	 * Met a jour le joueur adverse d'une carte
	 * @param jAdversaire le nouveau joueur adverse à qui appartient la carte
	 */
	public abstract void setAdversaire(Joueur jAdversaire);
	
	/**
	 * @return la vie que possède une carte
	 */
	public abstract int getVie();
	
	/**
	 * Met a jour la vie que possède une carte
	 * @param vie la nouvelle valeur attribué à une carte
	 */
	public abstract void setVie(int vie);
	
	/**
	 * @return le mana que possède une carte
	 */
	public abstract int getMana();
	
	/**
	 * Met a jour le mana que possède une carte
	 * @param mana la nouvelle valeur attribué au mana
	 */
	public abstract void setNbMana(int mana);
	
	/**
	 * @return l'attaque que possède une carte
	 */
	public abstract int getAttaque();
	
	/**
	 * Met a jour l'attaque que possède une carte
	 * @param attaque la nouvelle valeur attribué à l'attaque
	 */
	public abstract void setAttaque(int attaque);
	
	/**
	 * Met a jour si une carte peut attaqué ou non
	 * @param bool la nouvelle valeur attribué a la carte si elle peut attaquer ou non
	 */
	public abstract void setPeutAttaquer(boolean bool);
	
	/**
	 * @return si une carte peut attaquer ou non
	 */
	public abstract boolean getPeutAttaquer();
	
	/**
	 * Met a jour si une carte peut être attaqué ou non
	 * @param boolla nouvelle valeur attribué a la carte si elle peut être attaquer ou non
	 */
	public abstract void setPeutEtreAttaquer(boolean bool);
	
	/**
	 * @return si une carte peut être attaquer ou non
	 */
	public abstract boolean getPeutEtreAttaquer();
	
	/**
	 * @return l'effet que possède une carte
	 */
	public abstract String getEffet();
	
}
