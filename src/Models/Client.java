package Models;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class Client {
	private int ID;
	private int VERSION;
	private String TITRE;
	private String NOM;
	private String PRENOM;
		
	public Client(int iD, int vERSION, String tITRE, String nOM, String pRENOM) {
		ID = iD;
		VERSION = vERSION;
		TITRE = tITRE;
		NOM = nOM;
		PRENOM = pRENOM;
	}
	
	@Override
	public String toString() {
		return "Client [ID=" + ID + ", VERSION=" + VERSION + 
			   ", TITRE=" + TITRE + ", NOM=" + NOM + ", PRENOM=" + PRENOM + "]";
	}
	public int getID() {
		return ID;
	}

	public int getVersion() {
		return VERSION;
	}
	public void setVersion(int vERSION) {
		VERSION = vERSION;
	}
	public String getTitre() {
		return TITRE;
	}
	public void setTitre(String tITRE) {
		TITRE = tITRE;
	}
	public String getNom() {
		return NOM;
	}
	public void setNom(String nOM) {
		NOM = nOM;
	}
	public String getPrenom() {
		return PRENOM;
	}
	public void setPrenom(String pRENOM) {
		PRENOM = pRENOM;
	}
}
