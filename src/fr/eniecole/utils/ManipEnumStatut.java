package fr.eniecole.utils;

import fr.eniecole.bean.Statut;

public class ManipEnumStatut {

	public static Statut StringToEnum(String chaine){
		Statut statut = null;
		switch (chaine) {
		case "A TRAITER":
			statut = Statut.A_TRAITER;
			break;
		case "EN COURS DE TRAITEMENT":
			statut = Statut.EN_COURS_DE_TRAITEMENT;
			break;
		case "TRAITEE":
			statut = Statut.TRAITEE;
		default:
			statut = null;
			break;
		}
		return statut;
	}
	
	public static String EnumToString(Statut statut){
		String resultat = null;
		if(statut.equals(Statut.A_TRAITER)){
			resultat = "A TRAITER";
		}else if (statut.equals(Statut.EN_COURS_DE_TRAITEMENT)){
			resultat = "EN COURS DE TRAITEMENT";
		}else if(statut.equals(Statut.TRAITEE)){
			resultat = "TRAITEE";
		}
		return resultat;
	}
}
