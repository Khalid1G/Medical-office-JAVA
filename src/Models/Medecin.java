package Models;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class Medecin {
	private int id;
	private int version;
	private String titre;
	private String nom;
	private String prenom;
	
	public int getId() {
		return id;
	}

	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public String toString() {
		return "Medecin [id=" + id + ", version=" + version + ", titre=" + titre + ", nom=" + nom + ", prenom="
				+ prenom + "]";
	}
	public Medecin(int id, int version, String titre, String nom, String prenom) {
		super();
		this.id = id;
		this.version = version;
		this.titre = titre;
		this.nom = nom;
		this.prenom = prenom;
	}
	
}
