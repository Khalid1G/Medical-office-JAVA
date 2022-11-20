package Models;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class Creneaux {

	private int id;
	private int vesrion;
	private int hdebut;
	private int mdebut;
	private int hfin;
	private int mfin;
	private Medecin medecin;

	public Creneaux(int id, int vesrion, int hdebut, int mdebut, int hfin, int mfin, Medecin medecin) {
	
		this.id = id;
		this.vesrion = vesrion;
		this.hdebut = hdebut;
		this.mdebut = mdebut;
		this.hfin = hfin;
		this.mfin = mfin;
		this.medecin = medecin;

	}

	@Override
	public String toString() {
		return "Creneaux [id=" + id + ", vesrion=" + vesrion + ", hdebut=" + hdebut + ", mdebut=" + mdebut + ", hfin="
				+ hfin + ", mfin=" + mfin + ", medecin=" + medecin + "]";
	}

	public int getId() {
		return id;
	}

	public int getVesrion() {
		return vesrion;
	}

	public void setVesrion(int vesrion) {
		this.vesrion = vesrion;
	}

	public int getHbebut() {
		return hdebut;
	}

	public void setHbebut(int hbebut) {
		this.hdebut = hbebut;
	}

	public int getMdebut() {
		return mdebut;
	}

	public void setMdebut(int mdebut) {
		this.mdebut = mdebut;
	}

	public int getHfin() {
		return hfin;
	}

	public void setHfin(int hfin) {
		this.hfin = hfin;
	}

	public int getMfin() {
		return mfin;
	}

	public void setMfin(int mfin) {
		this.mfin = mfin;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
}
