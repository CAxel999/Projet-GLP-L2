Projet Auto-Ecole
=================
Notre projet a été réalisé dans le cadre de l'UE génie logiciel projet de deuxième année de licence informatique à l'université Cergy Paris Université. Il a été réalisé sur une période s'étalant du 20 Janvier au 27 Avril durant notre deuxième année d'étude en licence informatique à Cergy Paris Université.

Lancer notre projet sur Eclipse
-------------------------------

Afin de lancer notre projet avec l'IDE Eclipse :

1. Téléchargez le zip contenant l'ensemble du projet et décompressez le. Dans ce zip vous devriez trouver un dossier src et un dossier libs :
   * Le dossier src contient le code que nous avons réalisé
   * Le dossier libs nous a été fourni par notre professeur et doit contenir les .jar suivant : hamcrest-core-1.3.jar, jcommon-1.0.23.jar, jfreechart-1.0.19.jar, jfreechart-1.0.19-experimental.jar, jfreechart-1.0.19-swt.jar, jfreesvg-2.0.jar, junit-4.11.jar, log4j-1.2.17.jar, orsoncharts-1.4-eval-nofx.jar, orsonpdf-1.6-eval.jar, servlet.jar et swtgraphics2d.jar
2. Démarrer l'IDE Eclipse
3. Dans "File" en haut à gauche de la fenêtre  sélectionner "New" puis cliquer sur "Project..." 
4. Dans la fenêtre venant de s'ouvrir, sélectionner "Java Project" 
5. Nommez le projet comme vous le souhaitez, choisissez le JRE, de préférence la version 21 et cliquez sur "Finish"
6. Copiez le contenu du dossier src que vous avez télécharger et collez le dans le dossier src se trouvant dans la fenêtre "Project Explorer" de l'IDE Eclipse
7. Copiez le dossier libs dans le dossier de votre nom de projet.
8. En cliquant droit sur le dossier portant le nom de votre projet, sélectionnez "Build Path" puis "Configure Build Path"
9. Dans cette nouvelle fenêtre, au milieu, cliquez sur "Classpath" puis à droite sur "Add JARs"
10. Déroulez le menu jusqu'à ouvrir le dossier libs, sélectionnez "log4j-1.2.17.jar" cliquez sur "OK"
11. Répétez les étapes 9. et 10. pour "junit-4.11.jar" puis fermez la fenêtre
12. De retour sur le "Project Explorer", cliquez sur src pour le dérouler puis sur le package test, double-cliquez sur le fichier TestGame.java et enfin cliquez sur la flêche vert représentant le bouton run en haut de la fenêtre.
13. Vous pouvez aussi le faire avec le fichier TestDebug.java pour lancer le programme en mode debug
   
