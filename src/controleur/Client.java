package controleur;

public class Client {

    private int iduser;
    private String prenom;
    private String adressepersonnelle;
    private String datenaissance;
    private String adressefacturation;
    private String nom;
    private String email;
    private String mdp;




public Client() {
        this.iduser = 0;
        this.prenom = "";
        this.adressepersonnelle = "";
        this.datenaissance = "";
        this.adressefacturation = "";
        this.nom = "";
        this.email = "";
        this.mdp = "";


    }
public Client(int iduser, String prenom, String adressepersonnelle, String datenaissance,
                  String adressefacturation, String nom, String email, String mdp) {
        this.iduser = iduser;
        this.prenom = nom;
        this.adressepersonnelle = adressepersonnelle;
        this.datenaissance = datenaissance;
        this.adressefacturation = adressefacturation;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;

 }

    public Client( String prenom, String adressepersonnelle, String datenaissance, String adressefacturation, String nom, String email, String mdp) {
        this.iduser = 0;
        this.prenom = nom;
        this.adressepersonnelle = adressepersonnelle;
        this.datenaissance = datenaissance;
        this.adressefacturation = adressefacturation;
        this.nom = nom;
        this.email = email;
        this.mdp = mdp;

    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdressepersonnelle() {
        return adressepersonnelle;
    }

    public void setAdressepersonnelle(String adressepersonnelle) {
        this.adressepersonnelle = adressepersonnelle;
    }

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getAdressefacturation() {
        return adressefacturation;
    }

    public void setAdressefacturation(String adressefacturation) {
        this.adressefacturation = adressefacturation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

}