# Mini_HearthStone projet sur le traitement des Design Patterns - LP MiAR

# Travail à rendre

Un compte-rendu est attendu pour ce TP. Il est à fournir sous forme électronique sur Madoc.
Le travail a rendre est sous forme d’archive zip, qui comprendra :

— le code source commenté en Java de vos programmes qui tourneront sous GNU/Linux ;

— un script ant ou bash commenté permettant de construire et lancer vos programmes ;

— un rapport au format pdf.

L’archive est à déposer sur madoc avant le vendredi 22 décembre 2017 à 23h55. Le serveur de dépôt
sera bloqué après cette date.

Le non-respect de la consigne du script ant/bash, du langage ou de GNU/Linux ou
un travail non déposé sur madoc avant le 22/12 à 23h55 implique une non-correction
du devoir, impliquant lui-même la note 0.

### Mini HearthStone

Le but de ce projet est de recoder en mode texte une petite partie à deux joueurs du jeu
HearthStone en incluant dans le projet les 4 design patterns suivant : State, Observer, Decorator
et Factory Method.
Il est conseillé de jouer un peu à HearthStone pour vous familiariser avec les mécaniques de
jeu que vous devez reproduire. Le jeu est gratuit et disponible sur Windows, OSX et les systèmes
android et IOS.
Il ne vous ai pas demandé de faire une interface graphique, ni de gérer des parties en réseau, ni
de coder une IA. Ceci peut être des extensions intéressantes mais aucun point supplémentaire ne
seront apportés à celles-ci. De même, vous pouvez inclure des patterns supplémentaires au quatre
demandés mais ceci n’apportera pas de points supplémentaires.

Le minimum vital pour que votre projet soit noté est qu’il doit compiler et tourner (sans planter
au bout de quelques tours). La notation portera principalement sur la bonne mise en œuvre et la
bonne utilisation des design patterns. Le reste de la notation portera sur le rapport, l’implémentation
de toutes les mécaniques de jeu demandées, ainsi que la qualité du code et de ses commentaires.
Dans le rapport, il sera inutile de rappeler des informations présentes sur ce document pdf. Par
contre, il vous est demandé de décrire vos principales classes développées, comment elles interagissent
entre elles (un diagramme de classe serait le bienvenu), de décrire comment joueur à votre jeu (chaque
projet aura sans doute une interface différente), de décrire quels sont les classes implémentant et
utilisant tel pattern pour chaque pattern, et de conclure en précisant les difficultés rencontrées et
les parties qui n’ont pas été implémentées, s’il y en a.

## 1 - Les mécaniques à reproduire

HearthStone est un jeu de cartes de combat, à la manière des cartes Magic. Votre héros et votre
adversaire ont chacun 30 points de vie. Le vainqueur sera celui qui amène à 0 ou moins le nombre
de points de vie de son opposant. Ceci se fait via un combat de carte au tour par tour.
Un des deux joueurs est choisi au hasard pour jouer en premier. Il commencera alors avec
3 cartes tirées aléatoirement et son adversaire avec 4. Pour jouer une carte, il faut dépenser un
certain nombre de point (dit de mana) associé à la carte. Au premier tour, chaque joueur ne dispose
que d’un point de mana et ce stock de point est incrémenté de un à chaque tour, avec un plafond
de 10 points de mana. À chaque tour, les joueurs commencent avec le nombre maximal de point de
mana que leur stock leur permette. On peut jouer plusieurs cartes pendant son tour, du moment
que la somme des points de mana associée aux cartes n’excède pas le stock de mana du joueur.
À chaque début de tour, une carte parmi les cartes jouables du héros (la pioche) est tirée au
hasard et mise dans sa main. Il n’y a pas de limite au nombre total de cartes que l’on peut avoir en
main, ni de limite au nombre de copies d’une même carte que l’on peut avoir en main (par exemple,
on peut avoir en main n fois la même carte Sanglier brocheroc).

# La mécanique des cartes

Il y a deux types de cartes : les serviteurs et les sorts.
Les serviteurs sont des combattants qui, une fois invoqués par leur carte, restent sur le plateau
de jeu tant qu’ils sont en vie. Leur caractéristique notée d/v signifie qu’ils peuvent infliger d point
de dégâts lorsqu’ils attaquent et disposent de v points de vie. Lorsqu’un serviteur à 0 point de vie
ou moins, il est retiré du plateau. Lorsque le joueur invoque un serviteur en jouant sa carte associée,
le serviteur est déposé sur le plateau et pourra être joué au tour suivant. Dès qu’il est jouable, il
peut être utilisé une fois par tour pour attaquer une cible (un serviteur ou un héros). Il n’y a pas
de limite au nombre de serviteurs que l’on peut jouer lors d’un même tour.
Les sorts sont des cartes jouables qu’une seule fois par carte (donc si un joueur possède n cartes
du même sort, il pourra lancer ce sort n fois). Les effets d’un sort sont immédiat, dès que la carte
est jouée.

# Les héros

Dans ce mini HearthStone, 3 héros seront jouables : le mage, le paladin et le guerrier. Chaque
joueur doit sélectionner son héros en début de partie. Les deux joueurs peuvent jouer le même héros.
Chaque héros a une action spéciale qu’il peut exécuter une fois par tour en payant 2 points de
mana. Ces actions sont :

— Mage : Boule de feu, infligeant un point de dégâts à un adversaire (serviteur ou héros).

— Paladin : Renfort, invoquant un serviteur “recrue de la Main d’argent” 1/1.

— Guerrier : Armure, lui conférant 2 points d’armure.

Les points d’armure sont des points qui seront d’abord décrémentés lorsque le héros subit une
attaque. Les points de vie d’un héros ne sont ainsi entamés que lorsque ses points d’armure sont à
zéro. Par exemple, si un héros à 2 points d’armure et qu’il subbit une attaque de 3 points de dégâts,
dans ce cas ses 2 points d’armure sont réduites à 0 et ses points de vie sont décrémentés de 1.

## 2 - Les cartes

Dans ce mini HearthStone, on considèrera 5 cartes communes et 3 cartes spécifiques à chaque
héros. Un héros pourra donc manipuler types de 8 cartes différentes.
Les cartes serviteur sont caractérisées par m/d/v où m est le nombre de point de mana à
dépenser pour invoquer le serviteur aux caractéristiques d/v, ainsi que par leur effet spécifique (voir
liste ci-dessous). Les cartes sort sont caractérisées par m ainsi que par leur effet spécifique.

# Effets des cartes serviteur :

— provocation : votre adversaire est obligé d’attaquer ce serviteur avant d’attaquer votre héros
ou un autre serviteur sans provocation.

— charge : le serviteur peut attaquer dès qu’il est posé sur le plateau, sans attendre le tour
suivant.

— vol de vie : Lorsque le serviteur inflige des dégâts, votre héros récupère des points de vie à
hauteur des dégâts infligés.

# Les cartes communes :

— Sanglier brocheroc, 1/1/1.

— Soldat du comté-de-l’or, 1/1/2, provocation.

— Chevaucheur de loup, 3/3/1, charge.

— Chef de raid, 3/2/2, +1 d’attaque pour tous les serviteurs alliés du plateau (tant que ce
serviteur est vivant).

— Yéti noroit, 4/4/5.

# Les cartes spécifiques au mage :

— Image miroir, sort de 1 point de mana, invoque deux serviteurs 0/2 avec provocation.

— Explosion des arcanes, sort de 2 points de mana, inflige 1 point de dégâts à tous les serviteurs
adverses.

— Métamorphose, sort de 4 points de mana, transforme un serviteur en serviteur 1/1 sans effet
spécial.

# Les cartes spécifiques au paladin :

— Champion frisselame, 4/3/2, charge, vol de vie.

— Bénédiction de puissance, sort de 1 point de mana, confère +3 d’attaque à un serviteur.

— Consécration, sort de 4 points de mana, inflige 2 points de dégâts à tous les adversaires.

# Les cartes spécifiques au guerrier :

— Tourbillon. sort de 1 point de mana, inflige 1 points de dégâts à TOUS les serviteurs (y
compris les vôtres).

— Avocat commis d’office, 2/0/7, provocation.

— Mai^trise du blocage, sort de 3 points de mana, +5 d’armure ET place une carte aléatoire de
la pioche dans votre main.
