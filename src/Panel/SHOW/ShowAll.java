package Panel.SHOW;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DAO.DAO;
import Models.Client;
import Models.Creneaux;
import Models.Medecin;
import Models.RV;
import Services.ClientDAO;
import Services.CreneauxDAO;
import Services.MedecinDAO;
import Services.RVDAO;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class ShowAll extends JPanel {

	private static final long serialVersionUID = 1L;
	private DAO<Client> DClient = new ClientDAO();
	private DAO<Medecin> DMedecin = new MedecinDAO();
	private DAO<Creneaux> DCreneaux = new CreneauxDAO();
	private DAO<RV> DRV = new RVDAO();

	public ShowAll(String role) {
		super(null);
		this.setBounds(244, 91, 1084, 596);

		JButton btnshowAll = new JButton("Afficher Tout les " + role);

		btnshowAll.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		btnshowAll.setForeground(new Color(0, 128, 64));
		btnshowAll.setBounds(370, 30, 340, 50);
		this.add(btnshowAll);
		btnshowAll.addActionListener(v -> extracted(role));

	}

	private void extracted(String role) {
		String[] columnHeaders = null;
		Object[][] data = null;
		if (role == "Client") {

			List<Client> clients = DClient.getAll();

			if (clients == null || clients.size() == 0)
				JOptionPane.showMessageDialog(null, "Aucun clients");
			else {
				columnHeaders = new String[] { "ID", "Version", "Titre", "Nom", "Prenom" };
				data = new Object[clients.size()][columnHeaders.length];

				for (int i = 0; i < clients.size(); i++) {
					data[i][0] = clients.get(i).getID();
					data[i][1] = clients.get(i).getVersion();
					data[i][2] = clients.get(i).getTitre();
					data[i][3] = clients.get(i).getNom();
					data[i][4] = clients.get(i).getPrenom();
				}
			}

		} else if (role == "Medecin") {
			List<Medecin> Medecins = DMedecin.getAll();
			if (Medecins == null || Medecins.size() == 0)
				JOptionPane.showMessageDialog(null, "Aucun Medecins");
			else {
				columnHeaders = new String[] { "ID", "Version", "Titre", "Nom", "Prenom" };
				data = new Object[Medecins.size()][columnHeaders.length];

				for (int i = 0; i < Medecins.size(); i++) {
					data[i][0] = Medecins.get(i).getId();
					data[i][1] = Medecins.get(i).getVersion();
					data[i][2] = Medecins.get(i).getTitre();
					data[i][3] = Medecins.get(i).getNom();
					data[i][4] = Medecins.get(i).getPrenom();
				}
			}

		} else if (role == "RV") {
			List<RV> rvs = DRV.getAll();
			if (rvs == null || rvs.size() == 0)
				JOptionPane.showMessageDialog(null, "Aucun RV");
			else {

				columnHeaders = new String[] { "ID", "Jour", "Client ID", "Cleint Nom Complate", "Creneaux id",
						"Medecin Nom Complate" };
				data = new Object[rvs.size()][columnHeaders.length];

				for (int i = 0; i < rvs.size(); i++) {
					data[i][0] = rvs.get(i).getId();
					data[i][1] = rvs.get(i).getJour();
					data[i][2] = rvs.get(i).getClient().getID();
					data[i][3] = rvs.get(i).getClient().getNom() + " " + rvs.get(i).getClient().getPrenom();
					data[i][4] = rvs.get(i).getCreneaux().getId();
					data[i][5] = rvs.get(i).getCreneaux().getMedecin().getNom() + " "
							+ rvs.get(i).getCreneaux().getMedecin().getPrenom();

				}
			}
		} else {
			List<Creneaux> Creneauxs = DCreneaux.getAll();
			if (Creneauxs == null || Creneauxs.size() == 0)
				JOptionPane.showMessageDialog(null, "Aucune Creneauxs");
			else {

				columnHeaders = new String[] { "ID", "VERSION", "HDEBUT", "MDEBUT", "HFIN", "MFIN", "MEDECIN ID",
						"MEDECIN NOM" };
				data = new Object[Creneauxs.size()][columnHeaders.length];

				for (int i = 0; i < Creneauxs.size(); i++) {
					data[i][0] = Creneauxs.get(i).getId();
					data[i][1] = Creneauxs.get(i).getVesrion();
					data[i][2] = Creneauxs.get(i).getHbebut();
					data[i][3] = Creneauxs.get(i).getMdebut();
					data[i][4] = Creneauxs.get(i).getHfin();
					data[i][5] = Creneauxs.get(i).getMfin();
					data[i][6] = Creneauxs.get(i).getMedecin().getId();
					data[i][7] = Creneauxs.get(i).getMedecin().getNom();

				}
			}
		}
		if (columnHeaders != null && data != null) {
			JTable table = new JTable(data, columnHeaders);
			table.setBounds(0, 80, 1000, 470);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			table.setRowHeight(28);

			if (role == "RV") {
				table.getColumnModel().getColumn(0).setPreferredWidth(1);
				table.getColumnModel().getColumn(2).setPreferredWidth(1);
				table.getColumnModel().getColumn(4).setPreferredWidth(1);
			}else if(role == "Creneaux")
			{
				table.getColumnModel().getColumn(7).setPreferredWidth(100);
			}
				

			JScrollPane pane = new JScrollPane(table);
			pane.setBounds(50, 90, 1000, 470);
			this.add(pane);
		}
	}
}
