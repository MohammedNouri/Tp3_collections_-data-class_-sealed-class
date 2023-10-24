package com.example.tp3_kotlin

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.LocalDate
import java.time.Month
import java.time.Year
import java.util.Date

data class Joueur(var nom:String,var numero:Int,var points:Int){

}
enum class Sigle(){
    OCS,OCK,RCA,WAC
}
enum class Pays(){
    Maroc,TUNISIE,EGYPTE,ALGERIE,MOURITANTE
}
class Equipe(var pays: Pays,var sigle: Sigle, var ListJoueur:ArrayList<Joueur> = ArrayList()){

    fun ajout(joueur: Joueur):Boolean{

        for (i in ListJoueur){
            if(i.numero == joueur.numero){
                return false
            }
        }
        ListJoueur.add(joueur)
        return true
    }
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
    fun setPoints(joueur: Joueur,points: Int){
        println(" Points Avant Update :${joueur.points} \n -------------------------------------------")
        joueur.points = points
        println("Points Apres Updte :"+joueur.points)
    }
}
@RequiresApi(Build.VERSION_CODES.O)
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
    val dateDebut: Date = Date(2023-1900,9,23)
    println(dateDebut)
}
