# Mini-HearthStone
Travail a rendre
Un compte-rendu est attendu pour ce TP. Il est a fournir sous forme electronique sur Madoc.
Le travail a rendre est sous forme d'archive zip, qui comprendra :
| le code source commente en Java de vos programmes qui tourneront sous GNU/Linux ;
| un script ant ou bash commente permettant de construire et lancer vos programmes ;
| un rapport au format pdf.
L'archive est a deposer sur madoc avant le vendredi 22 decembre 2017 a 23h55. Le serveur de dep^ot
sera bloque apres cette date.
Le non-respect de la consigne du script ant/bash, du langage ou de GNU/Linux ou
un travail non depose sur madoc avant le 22/12 a 23h55 implique une non-correction
du devoir, impliquant lui-m^eme la note 0.
Mini HearthStone
Le but de ce projet est de recoder en mode texte une petite partie a deux joueurs du jeu
HearthStone en incluant dans le projet les 4 design patterns suivant : State, Observer, Decorator
et Factory Method.
Il est conseille de jouer un peu a HearthStone pour vous familiariser avec les mecaniques de
jeu que vous devez reproduire. Le jeu est gratuit et disponible sur Windows, OSX et les systemes
android et IOS.
Il ne vous ai pas demande de faire une interface graphique, ni de gerer des parties en reseau, ni
de coder une IA. Ceci peut ^etre des extensions interessantes mais aucun point supplementaire ne
seront apportes a celles-ci. De m^eme, vous pouvez inclure des patterns supplementaires au quatre
demandes mais ceci n'apportera pas de points supplementaires.
Le minimum vital pour que votre projet soit note est qu'il doit compiler et tourner (sans planter
au bout de quelques tours). La notation portera principalement sur la bonne mise en uvre et la
bonne utilisation des design patterns. Le reste de la notation portera sur le rapport, l'implementation
de toutes les mecaniques de jeu demandees, ainsi que la qualite du code et de ses commentaires.
Dans le rapport, il sera inutile de rappeler des informations presentes sur ce document pdf. Par
contre, il vous est demande de decrire vos principales classes developpees, comment elles interagissent
entre elles (un diagramme de classe serait le bienvenu), de decrire comment joueur a votre jeu (chaque
projet aura sans doute une interface dierente), de decrire quels sont les classes implementant et
utilisant tel pattern pour chaque pattern, et de conclure en precisant les dicultes rencontrees et
les parties qui n'ont pas ete implementees, s'il y en a.
1
Les mecaniques a reproduire
HearthStone est un jeu de cartes de combat, a la maniere des cartes Magic. Votre heros et votre
adversaire ont chacun 30 points de vie. Le vainqueur sera celui qui amene a 0 ou moins le nombre
de points de vie de son opposant. Ceci se fait via un combat de carte au tour par tour.
Un des deux joueurs est choisi au hasard pour jouer en premier. Il commencera alors avec
3 cartes tirees aleatoirement et son adversaire avec 4. Pour jouer une carte, il faut depenser un
certain nombre de point (dit de mana) associe a la carte. Au premier tour, chaque joueur ne dispose
que d'un point de mana et ce stock de point est incremente de un a chaque tour, avec un plafond
de 10 points de mana. A
chaque tour, les joueurs commencent avec le nombre maximal de point de
mana que leur stock leur permette. On peut jouer plusieurs cartes pendant son tour, du moment
que la somme des points de mana associee aux cartes n'excede pas le stock de mana du joueur.
A
chaque debut de tour, une carte parmi les cartes jouables du heros (la pioche) est tiree au
hasard et mise dans sa main. Il n'y a pas de limite au nombre total de cartes que l'on peut avoir en
main, ni de limite au nombre de copies d'une m^eme carte que l'on peut avoir en main (par exemple,
on peut avoir en main n fois la m^eme carte Sanglier brocheroc).
La mecanique des cartes
Il y a deux types de cartes : les serviteurs et les sorts.
Les serviteurs sont des combattants qui, une fois invoques par leur carte, restent sur le plateau
de jeu tant qu'ils sont en vie. Leur caracteristique notee d/v signie qu'ils peuvent in
iger d point
de deg^ats lorsqu'ils attaquent et disposent de v points de vie. Lorsqu'un serviteur a 0 point de vie
ou moins, il est retire du plateau. Lorsque le joueur invoque un serviteur en jouant sa carte associee,
le serviteur est depose sur le plateau et pourra ^etre joue au tour suivant. Des qu'il est jouable, il
peut ^etre utilise une fois par tour pour attaquer une cible (un serviteur ou un heros). Il n'y a pas
de limite au nombre de serviteurs que l'on peut jouer lors d'un m^eme tour.
Les sorts sont des cartes jouables qu'une seule fois par carte (donc si un joueur possede n cartes
du m^eme sort, il pourra lancer ce sort n fois). Les eets d'un sort sont immediat, des que la carte
est jouee.
Les heros
Dans ce mini HearthStone, 3 heros seront jouables : le mage, le paladin et le guerrier. Chaque
joueur doit selectionner son heros en debut de partie. Les deux joueurs peuvent jouer le m^eme heros.
Chaque heros a une action speciale qu'il peut executer une fois par tour en payant 2 points de
mana. Ces actions sont :
| Mage : Boule de feu, in
igeant un point de deg^ats a un adversaire (serviteur ou heros).
| Paladin : Renfort, invoquant un serviteur \recrue de la Main d'argent" 1/1.
| Guerrier : Armure, lui conferant 2 points d'armure.
Les points d'armure sont des points qui seront d'abord decrementes lorsque le heros subit une
attaque. Les points de vie d'un heros ne sont ainsi entames que lorsque ses points d'armure sont a
zero. Par exemple, si un heros a 2 points d'armure et qu'il subbit une attaque de 3 points de deg^ats,
dans ce cas ses 2 points d'armure sont reduites a 0 et ses points de vie sont decrementes de 1.
2
Les cartes
Dans ce mini HearthStone, on considerera 5 cartes communes et 3 cartes speciques a chaque
heros. Un heros pourra donc manipuler types de 8 cartes dierentes.
Les cartes serviteur sont caracterisees par m/d/v ou m est le nombre de point de mana a
depenser pour invoquer le serviteur aux caracteristiques d/v, ainsi que par leur eet specique (voir
liste ci-dessous). Les cartes sort sont caracterisees par m ainsi que par leur eet specique.
Eets des cartes serviteur :
| provocation : votre adversaire est oblige d'attaquer ce serviteur avant d'attaquer votre heros
ou un autre serviteur sans provocation.
| charge : le serviteur peut attaquer des qu'il est pose sur le plateau, sans attendre le tour
suivant.
| vol de vie : Lorsque le serviteur in
ige des deg^ats, votre heros recupere des points de vie a
hauteur des deg^ats in
iges.
Les cartes communes :
| Sanglier brocheroc, 1/1/1.
| Soldat du comte-de-l'or, 1/1/2, provocation.
| Chevaucheur de loup, 3/3/1, charge.
| Chef de raid, 3/2/2, +1 d'attaque pour tous les serviteurs allies du plateau (tant que ce
serviteur est vivant).
| Yeti noroit, 4/4/5.
Les cartes speciques au mage :
| Image miroir, sort de 1 point de mana, invoque deux serviteurs 0/2 avec provocation.
| Explosion des arcanes, sort de 2 points de mana, in
ige 1 point de deg^ats a tous les serviteurs
adverses.
| Metamorphose, sort de 4 points de mana, transforme un serviteur en serviteur 1/1 sans eet
special.
Les cartes speciques au paladin :
| Champion frisselame, 4/3/2, charge, vol de vie.
| Benediction de puissance, sort de 1 point de mana, confere +3 d'attaque a un serviteur.
| Consecration, sort de 4 points de mana, in
ige 2 points de deg^ats a tous les adversaires.
Les cartes speciques au guerrier :
| Tourbillon. sort de 1 point de mana, in
ige 1 points de deg^ats a TOUS les serviteurs (y
compris les v^otres).
| Avocat commis d'oce, 2/0/7, provocation.
| Ma^trise du blocage, sort de 3 points de mana, +5 d'armure ET place une carte aleatoire de
la pioche dans votre main.
3