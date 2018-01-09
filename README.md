# Mini_HearthStone projet sur le traitement des Design Patterns - LP MiAR

# Travail � rendre

Un compte-rendu est attendu pour ce TP. Il est � fournir sous forme �lectronique sur Madoc.
Le travail a rendre est sous forme d�archive zip, qui comprendra :

� le code source comment� en Java de vos programmes qui tourneront sous GNU/Linux ;

� un script ant ou bash comment� permettant de construire et lancer vos programmes ;

� un rapport au format pdf.

L�archive est � d�poser sur madoc avant le vendredi 22 d�cembre 2017 � 23h55. Le serveur de d�p�t
sera bloqu� apr�s cette date.

Le non-respect de la consigne du script ant/bash, du langage ou de GNU/Linux ou
un travail non d�pos� sur madoc avant le 22/12 � 23h55 implique une non-correction
du devoir, impliquant lui-m�me la note 0.

### Mini HearthStone

Le but de ce projet est de recoder en mode texte une petite partie � deux joueurs du jeu
HearthStone en incluant dans le projet les 4 design patterns suivant : State, Observer, Decorator
et Factory Method.
Il est conseill� de jouer un peu � HearthStone pour vous familiariser avec les m�caniques de
jeu que vous devez reproduire. Le jeu est gratuit et disponible sur Windows, OSX et les syst�mes
android et IOS.
Il ne vous ai pas demand� de faire une interface graphique, ni de g�rer des parties en r�seau, ni
de coder une IA. Ceci peut �tre des extensions int�ressantes mais aucun point suppl�mentaire ne
seront apport�s � celles-ci. De m�me, vous pouvez inclure des patterns suppl�mentaires au quatre
demand�s mais ceci n�apportera pas de points suppl�mentaires.

Le minimum vital pour que votre projet soit not� est qu�il doit compiler et tourner (sans planter
au bout de quelques tours). La notation portera principalement sur la bonne mise en �uvre et la
bonne utilisation des design patterns. Le reste de la notation portera sur le rapport, l�impl�mentation
de toutes les m�caniques de jeu demand�es, ainsi que la qualit� du code et de ses commentaires.
Dans le rapport, il sera inutile de rappeler des informations pr�sentes sur ce document pdf. Par
contre, il vous est demand� de d�crire vos principales classes d�velopp�es, comment elles interagissent
entre elles (un diagramme de classe serait le bienvenu), de d�crire comment joueur � votre jeu (chaque
projet aura sans doute une interface diff�rente), de d�crire quels sont les classes impl�mentant et
utilisant tel pattern pour chaque pattern, et de conclure en pr�cisant les difficult�s rencontr�es et
les parties qui n�ont pas �t� impl�ment�es, s�il y en a.

## 1 - Les m�caniques � reproduire

HearthStone est un jeu de cartes de combat, � la mani�re des cartes Magic. Votre h�ros et votre
adversaire ont chacun 30 points de vie. Le vainqueur sera celui qui am�ne � 0 ou moins le nombre
de points de vie de son opposant. Ceci se fait via un combat de carte au tour par tour.
Un des deux joueurs est choisi au hasard pour jouer en premier. Il commencera alors avec
3 cartes tir�es al�atoirement et son adversaire avec 4. Pour jouer une carte, il faut d�penser un
certain nombre de point (dit de mana) associ� � la carte. Au premier tour, chaque joueur ne dispose
que d�un point de mana et ce stock de point est incr�ment� de un � chaque tour, avec un plafond
de 10 points de mana. � chaque tour, les joueurs commencent avec le nombre maximal de point de
mana que leur stock leur permette. On peut jouer plusieurs cartes pendant son tour, du moment
que la somme des points de mana associ�e aux cartes n�exc�de pas le stock de mana du joueur.
� chaque d�but de tour, une carte parmi les cartes jouables du h�ros (la pioche) est tir�e au
hasard et mise dans sa main. Il n�y a pas de limite au nombre total de cartes que l�on peut avoir en
main, ni de limite au nombre de copies d�une m�me carte que l�on peut avoir en main (par exemple,
on peut avoir en main n fois la m�me carte Sanglier brocheroc).

# La m�canique des cartes

Il y a deux types de cartes : les serviteurs et les sorts.
Les serviteurs sont des combattants qui, une fois invoqu�s par leur carte, restent sur le plateau
de jeu tant qu�ils sont en vie. Leur caract�ristique not�e d/v signifie qu�ils peuvent infliger d point
de d�g�ts lorsqu�ils attaquent et disposent de v points de vie. Lorsqu�un serviteur � 0 point de vie
ou moins, il est retir� du plateau. Lorsque le joueur invoque un serviteur en jouant sa carte associ�e,
le serviteur est d�pos� sur le plateau et pourra �tre jou� au tour suivant. D�s qu�il est jouable, il
peut �tre utilis� une fois par tour pour attaquer une cible (un serviteur ou un h�ros). Il n�y a pas
de limite au nombre de serviteurs que l�on peut jouer lors d�un m�me tour.
Les sorts sont des cartes jouables qu�une seule fois par carte (donc si un joueur poss�de n cartes
du m�me sort, il pourra lancer ce sort n fois). Les effets d�un sort sont imm�diat, d�s que la carte
est jou�e.

# Les h�ros

Dans ce mini HearthStone, 3 h�ros seront jouables : le mage, le paladin et le guerrier. Chaque
joueur doit s�lectionner son h�ros en d�but de partie. Les deux joueurs peuvent jouer le m�me h�ros.
Chaque h�ros a une action sp�ciale qu�il peut ex�cuter une fois par tour en payant 2 points de
mana. Ces actions sont :

� Mage : Boule de feu, infligeant un point de d�g�ts � un adversaire (serviteur ou h�ros).

� Paladin : Renfort, invoquant un serviteur �recrue de la Main d�argent� 1/1.

� Guerrier : Armure, lui conf�rant 2 points d�armure.

Les points d�armure sont des points qui seront d�abord d�cr�ment�s lorsque le h�ros subit une
attaque. Les points de vie d�un h�ros ne sont ainsi entam�s que lorsque ses points d�armure sont �
z�ro. Par exemple, si un h�ros � 2 points d�armure et qu�il subbit une attaque de 3 points de d�g�ts,
dans ce cas ses 2 points d�armure sont r�duites � 0 et ses points de vie sont d�cr�ment�s de 1.

## 2 - Les cartes

Dans ce mini HearthStone, on consid�rera 5 cartes communes et 3 cartes sp�cifiques � chaque
h�ros. Un h�ros pourra donc manipuler types de 8 cartes diff�rentes.
Les cartes serviteur sont caract�ris�es par m/d/v o� m est le nombre de point de mana �
d�penser pour invoquer le serviteur aux caract�ristiques d/v, ainsi que par leur effet sp�cifique (voir
liste ci-dessous). Les cartes sort sont caract�ris�es par m ainsi que par leur effet sp�cifique.

# Effets des cartes serviteur :

� provocation : votre adversaire est oblig� d�attaquer ce serviteur avant d�attaquer votre h�ros
ou un autre serviteur sans provocation.

� charge : le serviteur peut attaquer d�s qu�il est pos� sur le plateau, sans attendre le tour
suivant.

� vol de vie : Lorsque le serviteur inflige des d�g�ts, votre h�ros r�cup�re des points de vie �
hauteur des d�g�ts inflig�s.

# Les cartes communes :

� Sanglier brocheroc, 1/1/1.

� Soldat du comt�-de-l�or, 1/1/2, provocation.

� Chevaucheur de loup, 3/3/1, charge.

� Chef de raid, 3/2/2, +1 d�attaque pour tous les serviteurs alli�s du plateau (tant que ce
serviteur est vivant).

� Y�ti noroit, 4/4/5.

# Les cartes sp�cifiques au mage :

� Image miroir, sort de 1 point de mana, invoque deux serviteurs 0/2 avec provocation.

� Explosion des arcanes, sort de 2 points de mana, inflige 1 point de d�g�ts � tous les serviteurs
adverses.

� M�tamorphose, sort de 4 points de mana, transforme un serviteur en serviteur 1/1 sans effet
sp�cial.

# Les cartes sp�cifiques au paladin :

� Champion frisselame, 4/3/2, charge, vol de vie.

� B�n�diction de puissance, sort de 1 point de mana, conf�re +3 d�attaque � un serviteur.

� Cons�cration, sort de 4 points de mana, inflige 2 points de d�g�ts � tous les adversaires.

# Les cartes sp�cifiques au guerrier :

� Tourbillon. sort de 1 point de mana, inflige 1 points de d�g�ts � TOUS les serviteurs (y
compris les v�tres).

� Avocat commis d�office, 2/0/7, provocation.

� Mai^trise du blocage, sort de 3 points de mana, +5 d�armure ET place une carte al�atoire de
la pioche dans votre main.
