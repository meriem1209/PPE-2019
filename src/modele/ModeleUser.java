package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Admin;
public class ModeleUser {
	private static BDD uneBdd = new BDD ("localhost:8889", "ppe_event","root","root"); 
	
	public static void insertUser (Admin unAdmin){
		//inscription d'un nouvel User dans la BDD
		
		String requete="insert into user values(null,'"+unAdmin.getDroits()+"','"+unAdmin.getPoste()+
				"','"+unAdmin.getNom()+"','"+unAdmin.getEmail()+"','"+unAdmin.getMdp()+"');";
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
	}
	public static ArrayList<Admin> selectAllAdmin (){
		// l'admin selecte tous les users 
		ArrayList<Admin> lesAdmin = new ArrayList<>();
		String requete ="select * from admin;";
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement(); 
			ResultSet desResultats = unStat.executeQuery(requete);
			while(desResultats.next())
			{
				Admin unAdmin = new Admin(
					desResultats.getInt("iduser"),
					desResultats.getString("droits"),
					desResultats.getString("poste"),
					desResultats.getString("nom"),
					desResultats.getString("email"),
					desResultats.getString("mdp")
					
				    );
				lesAdmin.add(unAdmin);			
			}	
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
		return lesAdmin;
	}
	public static Admin selectWhereUnAdmin (String email, String mdp) {
		//Verification de la connexion d'un user
		Admin unAdmin = null; 
		String requete = "select * from admin where email='"+ email +"' and mdp ='"
					+ mdp +"' ; "; 
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next())
			{
				 unAdmin = new Admin(
						 unRes.getInt("iduser"),
						 unRes.getString("droits"),
						 unRes.getString("poste"),
						 unRes.getString("nom"),
						 unRes.getString("email"),
						 unRes.getString("mdp")
					    );
			}
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
		return unAdmin; 
	}
	public static void deleteUser(int idAdmin) {
		String requete = "delete from user where iduser = "+idAdmin+";";
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
	}
	public static void updateUser(Admin unAdmin) {
		//un user change son profil 
		String requete="Update User set droits = '"+ unAdmin.getDroits()
		+ "' , poste = " + unAdmin.getPoste()+ ", nom = " + unAdmin.getNom()
		+ ",email = '" + unAdmin.getEmail() + ", mdp = '" + unAdmin.getMdp() +"' where iduser =" 
		+ unAdmin.getIduser() + ";";
		
		ModeleUser.uneBdd.seConnecter();
		try
		{
			Statement unStat = ModeleUser.uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
		}
		catch(SQLException exp)
		{
			System.out.println("Erreur de la requete : "+ requete);
		}
		ModeleUser.uneBdd.seDeConnecter();
	}
}








