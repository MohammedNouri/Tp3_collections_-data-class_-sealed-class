package com.example.tp3_kotlin


//1.Créer une classe Joueur avec les propriétés mentionnées.
//Peut-on la déclarer data class ou classe normale ? pourquoi ?
// on peut la declarer comme une data class parceque est un class contient seulement les caractéristiques
data class Joueur(var nom:String,var numero:Int,var points:Int){

}
//2. Créer  "enum" Sigle
enum class Sigle(){
    OCS,OCK,RCA,WAC
}
//3.Créer l’énumération Pays avec les différents pays participant
//à la compétition
enum class Pays(){
    Maroc,TUNISIE,EGYPTE,ALGERIE,MOURITANTE
}
//4. Créer la classe Equipe
class Equipe(var pays: Pays,var sigle: Sigle, var ListJoueur:ArrayList<Joueur> = ArrayList()){
    //5.Methode ajout qui ajoute sur ListJoueur
    fun ajout(joueur: Joueur):Boolean{

        for (i in ListJoueur){
            if(i.numero == joueur.numero){
                return false
            }
        }
        ListJoueur.add(joueur)
        return true
    }
    //6.Methode rechercher qui recherche sur ListJoueur

    fun rechercher(joueur: Joueur):Int{
      /*  for (i in 0..ListJoueur.size-1){
            if (ListJoueur.get(i).nom == joueur.nom){
                return i
            }
        }*/
        if (!ajout(joueur)){
            return ListJoueur.indexOf(joueur)
        }
        return -1
    }
    //7.Methode suppression qui supprime un joueur sur ListJoueur

    fun suppression(joueur: Joueur):Boolean{
      /*  for (i in ListJoueur){
            if (i.numero == joueur.numero){
                ListJoueur.remove(i)
                return true
            }
        }*/
     /*   var v :Int = rechercher(joueur)
        if (v!=-1){
            ListJoueur.remove(joueur)
            return true
        }*/
        if (!ajout(joueur)){
            ListJoueur.remove(joueur)
            return true
        }
        return false
        }
    //8.Methode setPoints qui modifier les points gagne par un joueur
    fun setPoints(joueur: Joueur,points: Int){
        println(" Points Avant Update :${joueur.points} \n -------------------------------------------")
        joueur.points = points
        println("Points Apres Updte :"+joueur.points)
    }
}
fun main() {

    var joueur1 = Joueur("Mohammed",14,15)
    var joueur2 = Joueur("Yassine",10,25)
    var joueur3 = Joueur("Tariq",8,17)
    var joueur4  = Joueur("Hamza",7,21)

    var OCS = Equipe(Pays.Maroc,Sigle.OCS)
    var RCA = Equipe(Pays.TUNISIE,Sigle.RCA)
    var WAC = Equipe(Pays.MOURITANTE,Sigle.WAC)
    var OCK = Equipe(Pays.ALGERIE,Sigle.OCK)

    OCS.ajout(joueur1)
    OCS.ajout(joueur2)
    OCS.ajout(joueur3)
    RCA.ajout(joueur1)
    RCA.ajout(joueur4)
    OCK.ajout(joueur2)
    OCK.ajout(joueur4)
    WAC.ajout(joueur3)
    WAC.ajout(joueur2)

    OCS.suppression(joueur2)
    for (i in OCS.ListJoueur){
        println(i.nom)
    }
    OCS.setPoints(joueur1,25)

    println(OCS.rechercher(joueur3))

}
