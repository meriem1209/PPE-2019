package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controleur.Prestataire;

public class Modele
{
	private static BDD uneBdd = new BDD ("localhost:8889","ppe_event","root","root"); 
	
	public static ArrayList<Prestataire> selectAll()
	{
		ArrayList<Prestataire> lesPrestataires = new ArrayList<>(); 
		
		String requete = "select * from Prestataire ; ";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats = unStat.executeQuery(requete);
			while (desResultats.next())
			{
				Prestataire unPrestataire = new Prestataire(
						desResultats.getInt("iduser"),
						desResultats.getString("nom"),
						desResultats.getString("service"),
						desResultats.getString("email"),
						desResultats.getString("adresse"),
						desResultats.getString("telephone"),
						desResultats.getString("mdp")	
						);
				lesPrestataires.add(unPrestataire);
			}
		}
		catch (SQLException exp)
		{
			System.out.println("Erreur requete : " + requete);
		}
		Modele.uneBdd.seDeConnecter();
		return lesPrestataires;
	}
	
	public static void insertPrestataire (Prestataire unPrestataire)
	{
		String requete = "insert into Prestataire values (null, '"+ unPrestataire.getNom()+"','"
				+ unPrestataire.getService()+"','"+ unPrestataire.getEmail()+"','" +
				unPrestataire.getAdresse()+"','"+unPrestataire.getTelephone()+"',"
						+ "'"+unPrestataire.getMdp()+ "');";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		Modele.uneBdd.seDeConnecter();
	}
	
	public static void deletePrestataire (int iduser)
	{
		String requete = "delete from Prestataire where iduser = "+iduser+";";
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		Modele.uneBdd.seDeConnecter();
	}
	
	public static void updatePrestataire (Prestataire unPrestataire)
	{
		String requete="Update Prestataire set nom = '"+ unPrestataire.getNom()
		+ "' , service = '" + unPrestataire.getService()+"', email = '" + unPrestataire.getEmail()
		+ "', adresse = '" + unPrestataire.getAdresse() + "',telephone = '"+ unPrestataire.getTelephone() 
		+"',mdp='"+ unPrestataire.getMdp() 
		+"' where iduser  ="  + unPrestataire.getIduser()+ ";";
		
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		Modele.uneBdd.seDeConnecter();
	}

	public static Prestataire selectWherePrestataire(Prestataire unPrestataire) {
		Prestataire unP = null; 
		String requete = "select iduser from Prestataire where nom ='"
				+ unPrestataire.getNom() + "' and service = '"
				+ unPrestataire.getService()+ "' and email ='"
				+ unPrestataire.getEmail()+ "' and adresse = '"
				+ unPrestataire.getAdresse()+ "' and telephone ='"
				+ unPrestataire.getTelephone()+"'and mdp ='"
				+ unPrestataire.getMdp()+  "';";
		System.out.println(requete);
		Modele.uneBdd.seConnecter();
		try
		{
			Statement unStat = Modele.uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				int id = unRes.getInt("iduser");
				
				unP = new Prestataire(id, unPrestataire.getNom(),
						unPrestataire.getService(), unPrestataire.getEmail(),
						unPrestataire.getAdresse(), unPrestataire.getTelephone(), 
						unPrestataire.getMdp());
				System.out.println(id + "  "+unPrestataire.getNom() );
			}
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		Modele.uneBdd.seDeConnecter();
		return unP; 
	}
	

public static ArrayList<Prestataire> selectWhere(String mot)
{
	ArrayList<Prestataire> lesPrestataires = new ArrayList<>(); 
	
	String requete = "select * from Prestataire where iduser like '%"+mot+"%' "+" or iduser like '%"
					+ mot+ "%' or adresse like '%"+ mot + "%' or telephone like'%"+mot+"%' or mdp like '%"+mot+"%' ;";
	Modele.uneBdd.seConnecter();
	try
	{
		Statement unStat = Modele.uneBdd.getMaConnexion().createStatement();
		ResultSet desResultats = unStat.executeQuery(requete);
		while (desResultats.next())
		{
			Prestataire unPrestataire = new Prestataire(
					desResultats.getInt("iduser"),
					desResultats.getString("nom"),
					desResultats.getString("service"),
					desResultats.getString("email"),
					desResultats.getString("adresse"),
					desResultats.getString("telephone"),
					desResultats.getString("mdp")
						
					
					);
			
			lesPrestataires.add(unPrestataire);
		}
	}
	catch (SQLException exp)
	{
		System.out.println("Erreur requete : " + requete);
	}
	Modele.uneBdd.seDeConnecter();
	return lesPrestataires;
}

}








