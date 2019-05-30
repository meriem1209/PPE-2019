package controleur;

public class Prestataire {

	private int iduser ; 
	private String nom; 
	private String service ; 
	private String email ; 
	private String adresse ;
	private String telephone ;
	private String mdp ;

	
	public Prestataire ()
	{
		this.iduser = 0; 
		this.nom ="";
		this.service ="";
		this.email =""; 
		this.adresse ="";
		this.telephone="";
		this.mdp="";
		
		
		
	}
	public Prestataire(int iduser, String nom, String service, String email, String adresse, String telephone, String mdp)
	{
		this.iduser = iduser; 
		this.nom = nom; 
		this.service = service; 
		this.email = email;
		this.adresse = adresse;
		this.telephone= telephone;
		this.mdp = mdp;
		
	}
	public Prestataire(String nom, String service, String email, String adresse, String telephone, String mdp)
	{
		this.iduser = 0; 
		this.nom = nom; 
		this.service = service; 
		this.email = email;
		this.adresse = adresse;
		this.adresse = adresse;
		this.telephone= telephone;
		this.mdp = mdp;
		
	}
	
	public int getIduser() {
		return iduser;
	}
	public void setIduser(int iduser) {
		this.iduser = iduser;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

}
