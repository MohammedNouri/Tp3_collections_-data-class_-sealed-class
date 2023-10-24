package com.example.tp3_kotlin



import java.util.Date

//1.Créer la data classe Etape
data class Etape (
    var name:String,
    val DateDebut: Date ,
    val DateFin: Date ,
    var distance : Int,
    var difficulté:Difficulte) {}
enum class Difficulte{
    Facile,Difficile
}
//3.Créer la classe Cycliste avec les caractéristiques déjà abordés, dans la classe cycliste, ajouter une propriété de type hashMapOf <Etape,Resultat>(dictionnaire) ,
class Cycliste(
    var name: String,
    var prenom:String,
    var nationalite:String,
    var age:Int,
    var HistoriqueDesEtapes:HashMap<Etape,Resulat> = HashMap()
){
    // fun nouvelleEtape(etape :Etape, resultat :Resultat)
    fun nouvelleEtape(etape: Etape,resulat: Resulat):Boolean{
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
            history= "  nom de l'etape : ${K.name} , la duree : ${V.duree} et le classement : ${V.classement}"
        }
        return " nom et prenom de cycliste : $name $prenom , Nationality : $nationalite , Age : $age ans\n Historique a cette compitition : $history"
    }

}
//.Créer la data classe Résultat avec comme caractéristiques le temps effectué et le classement
data class Resulat(var duree :Double,var classement:Int){}

fun main() {
    var etape = Etape("Aller", Date(), Date(2023-1900,10,23),1000,Difficulte.Facile)
    var etape2 = Etape("Retour",Date(), Date(2023-1900,10,23),15000,Difficulte.Difficile)

    var resulat = Resulat(1.45,1)
    var resulat2 = Resulat(2.0,2)

    var cycliste = Cycliste("Nouri","Mohammed","Marocain",22)
    var cycliste2 = Cycliste("Douirek","Abdelghani","Mouritanain",21)

    cycliste.nouvelleEtape(etape,resulat)
    cycliste.nouvelleEtape(etape,resulat)
    cycliste.nouvelleEtape(etape2,resulat2)
    cycliste2.nouvelleEtape(etape2,resulat2)
   println( cycliste.toString())


}