package Models;


import java.sql.Date;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class RV {
	private int id;
	private Date Jour;
	private Client client;
	private Creneaux creneaux;
	public Date getJour() {
		return Jour;
	}
	public void setJour(Date jour) {
		Jour = jour;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Creneaux getCreneaux() {
		return creneaux;
	}
	public void setCreneaux(Creneaux creneaux) {
		this.creneaux = creneaux;
	}
	public int getId() {
		return id;
	}
	public RV(int id, Date jour, Client client, Creneaux creneaux) {
		super();
		this.id = id;
		Jour = jour;
		this.client = client;
		this.creneaux = creneaux;
	}
	@Override
	public String toString() {
		return "RV [id=" + id + ", Jour=" + Jour + ", client=" + client + ", creneaux=" + creneaux + "]";
	}

}
