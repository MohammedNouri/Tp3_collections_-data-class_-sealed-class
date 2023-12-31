package com.example.tp3_kotlin

import java.util.Date
//1.Créer la data classe Etape
data class Etapes (
    var name:String,
    val DateDebut: Date,
    val DateFin: Date,
    var distance : Int,
    var difficulté:Difficultes) {}
enum class Difficultes{
    Facile,Difficile
}
//3.Créer la classe Cycliste avec les caractéristiques déjà abordés, dans la classe cycliste, ajouter une propriété de type hashMapOf <Etape,Resultat>(dictionnaire) ,
class Cyclistes(
    var name: String,
    var prenom:String,
    var nationalite:String,
    var age:Int,
    var HistoriqueDesEtapes:HashMap<Etapes,Resultats> = HashMap()
){
    // fun nouvelleEtape(etape: Etapes,resulat: Resultats):Boolean
    fun nouvelleEtape(etape: Etapes,resulat: Resultats):Boolean{
        for (K in HistoriqueDesEtapes){
            if (K.key.name == etape.name){
                return false
            }
        }
        HistoriqueDesEtapes.put(etape,resulat)
        return true
    }
      // fun toString()
    override fun toString(): String {
        var history :String=""
        for ((K,V) in HistoriqueDesEtapes){
            // Cast V , car V retourne objet de Resultats qui contient Termine et Abandone
            history = when(V){
                is Resultats.Termine -> "  nom de l'etape : ${K.name} ,le  temps effectue : ${V.tempsEffectue} et le classement : ${V.classement}"
                is Resultats.Abandonne->"  nom de l'etape : ${K.name} , la distance parcourue : ${V.distanceParcourue} m et la raison d'abandonné : ${V.raison}"
            }
        }
        return " nom et prenom de cycliste : $name $prenom , Nationality : $nationalite , Age : $age ans\n Historique a cette compitition : $history"
    }

}
// Creer class Resultat Sealed
sealed class Resultats{
    // data class Termine
    data class Termine(var tempsEffectue:Double, var classement : Int) : Resultats()
    // data class Abandonne
    data class Abandonne(var distanceParcourue:Double,var raison:String) :Resultats()
}

fun main() {
    var etapes = Etapes("Aller", Date(), Date(2023-1900,10,23),1000,Difficultes.Facile)
    var etapes2 = Etapes("Retour",Date(), Date(2023-1900,10,23),15000,Difficultes.Difficile)

    var resulats:Resultats = Resultats.Termine(1.45 ,1)
    var resulats2:Resultats = Resultats.Abandonne(900.6,"Malade")

    var cyclistes = Cyclistes("Nouri","Mohammed","Marocain",22)
    var cyclistes2 = Cyclistes("Douirek","Abdelghani","Mouritanain",21)

    cyclistes.nouvelleEtape(etapes,resulats2)
    println( cyclistes.toString())
}