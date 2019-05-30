package controleur;



public class Admin {
	private int iduser;
	private String droits;
	private String poste;
	private String nom;
	private String email;
	private String mdp;
	
	public Admin()
	{
		this.droits=this.poste=this.nom=this.email=this.mdp="";
		this.iduser=0;
	}
	
	public Admin(int iduser,String droits,String poste,String nom,String email,String mdp)
	{
		this.iduser=iduser;
		this.droits=droits;
		this.poste=poste;
		this.nom=nom;
		this.email=email;
		this.mdp=mdp;
	}
	public Admin(String droits,String poste,String nom,String email,String mdp)
	{
		this.iduser=0;
		this.droits=droits;
		this.poste=poste;
		this.nom=nom;
		this.email=email;
		this.mdp=mdp;
	}

	public int getIduser() {
		return iduser;
	}

	public void setIduser(int iduser) {
		this.iduser = iduser;
	}

	public String getDroits() {
		return droits;
	}

	public void setDroits(String droits) {
		this.droits = droits;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
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
