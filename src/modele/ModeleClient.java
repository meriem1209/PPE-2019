package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import controleur.Client;

public class ModeleClient
{
    private static BDD uneBdd = new BDD ("localhost:8889","ppe_event","root","root");

    public static ArrayList<Client> selectAll()
    {
        ArrayList<Client> lesClients = new ArrayList<>();

        String requete = "select * from Client ; ";
        ModeleClient.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);
            while (desResultats.next())
            {
                Client unClient = new Client(
                        desResultats.getInt("iduser"),
                        desResultats.getString("prenom"),
                        desResultats.getString("adressepersonnelle"),
                        desResultats.getString("datenaissance"),
                        desResultats.getString("adressefacturation"),
                        desResultats.getString("nom"),
                        desResultats.getString("email"),
                        desResultats.getString("mdp")

                );
                lesClients.add(unClient);
            }
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur requete : " + requete);
        }
        ModeleClient.uneBdd.seDeConnecter();
        return lesClients
                ;
    }

    public static void insertClient (Client unClient)
    {
        String requete = "insert into Client values (null, '"+ unClient.getPrenom()+"','"
                + unClient.getAdressepersonnelle()+"','"+ unClient.getDatenaissance()+"','" +
                unClient.getAdressefacturation()+"','"+unClient.getNom()+"','"+unClient.getEmail()+"'," +
                "'"+unClient.getMdp()+ "');";
        ModeleClient.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        ModeleClient.uneBdd.seDeConnecter();
    }

    public static void deleteClient (int iduser)
    {
        String requete = "delete from Client where iduser = "+iduser+";";
        ModeleClient.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        ModeleClient.uneBdd.seDeConnecter();
    }

    public static void updateClient (Client unClient)
    {
        String requete="Update Client set prenom = '"+ unClient.getPrenom()
                + "' , adressepersonelle = '" + unClient.getAdressepersonnelle()+"', datenaissence = '" + unClient.getDatenaissance()
                + "', adressefacturation = '" + unClient.getAdressefacturation() + "',nom = '"+ unClient.getNom()
                +"',email='"+ unClient.getEmail()+"',mdp='"+ unClient.getMdp()
                +"' where iduser  ="  + unClient.getIduser()+ ";";

        ModeleClient.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
            unStat.execute(requete);
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        ModeleClient.uneBdd.seDeConnecter();
    }

    public static Client selectWhereClient(Client unClient) {
        Client unC = null;
        String requete = "select iduser from Client where prenom ='"
                + unClient.getPrenom() + "' and adressepersonnelle = '"
                + unClient.getAdressepersonnelle()+ "' and datenaissance ='"
                + unClient.getDatenaissance()+ "' and adressefacturation = '"
                + unClient.getAdressefacturation()+ "' and nom ='"
                + unClient.getNom()+ "' and mdp = '"
                + unClient.getMdp()+"'and email ='"
                + unClient.getEmail()+  "';";
        System.out.println(requete);
        ModeleClient.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
            ResultSet unRes = unStat.executeQuery(requete);
            if (unRes.next())
            {
                int id = unRes.getInt("iduser");

                unC = new Client(id, unClient.getPrenom(),
                        unClient.getAdressepersonnelle(), unClient.getDatenaissance(),
                        unClient.getAdressefacturation(), unClient.getNom(),
                        unClient.getMdp(), unClient.getEmail());

                System.out.println(id + "  "+unClient.getPrenom() );
            }
        }
        catch(SQLException exp)
        {
            System.out.println("Erreur de la requete : "+ requete);
        }
        ModeleClient.uneBdd.seDeConnecter();
        return unC;
    }


    public static ArrayList<Client> selectWhere(String mot)
    {
        ArrayList<Client> lesClients = new ArrayList<>();

        String requete = "select * from Client where iduser like '%"+mot+"%' "+" or iduser like '%"
                + mot+ "%' or nom like '%"+ mot + "%' or mdp like'%"+mot+"%' or email like '%"+mot+"%' ;";
        ModeleClient.uneBdd.seConnecter();
        try
        {
            Statement unStat = ModeleClient.uneBdd.getMaConnexion().createStatement();
            ResultSet desResultats = unStat.executeQuery(requete);
            while (desResultats.next())
            {
                Client unClient = new Client(
                        desResultats.getInt("iduser"),
                        desResultats.getString("prenom"),
                        desResultats.getString("adressepersonnelle"),
                        desResultats.getString("datenaissance"),
                        desResultats.getString("adressefacturation "),
                        desResultats.getString("nom"),
                        desResultats.getString("email"),
                        desResultats.getString("mdp")



                );
                lesClients.add(unClient);
            }
        }
        catch (SQLException exp)
        {
            System.out.println("Erreur requete : " + requete);
        }
        ModeleClient.uneBdd.seDeConnecter();
        return lesClients;
    }

}








