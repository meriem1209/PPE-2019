package controleur;

import javax.swing.JOptionPane;


import modele.Modele;
import modele.ModeleClient;
import modele.ModeleUser;
import view.VueConnexion;
import view.VuePrincipale;

public class Main {

	private static VueConnexion uneVueConnexion = null;
	private static VuePrincipale uneVuePrincipale = null ;
	
	public static void main(String[] args) {
			uneVueConnexion = new VueConnexion();	
	}

	public static void verifConnexion(String email, String mdp) {
		if (email.equals("") || mdp.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Veuillez remplir les identifiants", "Erreur", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			Admin unAdmin = ModeleUser.selectWhereUnAdmin(email, mdp); 
			if(unAdmin == null)
			{
				JOptionPane.showMessageDialog(null, "Veuillez verifier vos identifiants", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Bienvenue MMe./ M."+unAdmin.getNom()
						, "Connexion Reussie", JOptionPane.INFORMATION_MESSAGE);
				if (uneVuePrincipale == null)
				{
					uneVuePrincipale = new VuePrincipale(unAdmin);
				}
				uneVueConnexion.setVisible(false);
				uneVuePrincipale.setVisible(true);
			}
		}
		
	}
	public static VueConnexion getVueConnexion ()
	{
		return uneVueConnexion;
	}
	public static VuePrincipale getVuePrincipale ()
	{
		return uneVuePrincipale;
	}
	public static void insertPrestataire (Prestataire unPrestataire)
	{
		Modele.insertPrestataire(unPrestataire);
	}

	public static void deleteArticle(int id) {
		Modele.deletePrestataire(id);
	}

	public static Prestataire selectWherePrestataire(Prestataire unPrestataire) {
		return Modele.selectWherePrestataire(unPrestataire);
	}


public static void insertClient (Client unClient)
{
	ModeleClient.insertClient(unClient);
}

public static void deleteArticleC(int id) {
	
	ModeleClient.deleteClient(id);
}

public static Client selectWhereClient(Client unClient) {
	return ModeleClient.selectWhereClient(unClient);
}
}







