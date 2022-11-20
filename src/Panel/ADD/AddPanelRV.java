package Panel.ADD;

import java.awt.Color;
import java.awt.Font;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.DAO;
import Models.Client;
import Models.Creneaux;
import Models.RV;
import Services.ClientDAO;
import Services.CreneauxDAO;
import Services.RVDAO;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class AddPanelRV extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel ID_CRENEAU;
	private JLabel lblIJour;
	private JLabel lblCrID;
	private JTextField txtID;
	private JTextField txtJOUR;
	private JButton btnANNULER;
	private JButton btnAdd;
	private DAO<Client> DClient = new ClientDAO();
	private DAO<Creneaux> DCreneaux = new CreneauxDAO();
	private DAO<RV> DRV = new RVDAO();
	private JComboBox<String> comboClient;
	private JComboBox<String> comboCreneaux;

	public AddPanelRV() {
		super(null);
		this.setBounds(244, 91, 1084, 596);

		JLabel ID_CLIENT = new JLabel("ID CLIENT");
		ID_CLIENT.setForeground(new Color(0, 60, 0));
		ID_CLIENT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ID_CLIENT.setBounds(271, 309, 168, 34);
		this.add(ID_CLIENT);

		ID_CRENEAU = new JLabel("ID CRENEAU");
		ID_CRENEAU.setForeground(new Color(0, 60, 0));
		ID_CRENEAU.setFont(new Font("Times New Roman", Font.BOLD, 20));
		ID_CRENEAU.setBounds(271, 359, 168, 34);
		this.add(ID_CRENEAU);

		lblIJour = new JLabel("JOUR");
		lblIJour.setForeground(new Color(0, 60, 0));
		lblIJour.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblIJour.setBounds(271, 259, 168, 34);
		this.add(lblIJour);

		lblCrID = new JLabel("ID");
		lblCrID.setForeground(new Color(0, 60, 0));
		lblCrID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCrID.setBounds(271, 209, 100, 34);
		this.add(lblCrID);

		txtID = new JTextField();
		txtID.setBounds(486, 204, 389, 34);
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtID);

		txtJOUR = new JTextField();
		txtJOUR.setColumns(10);
		txtJOUR.setBounds(486, 261, 389, 34);
		txtJOUR.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtJOUR);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(640, 502, 115, 34);
		this.add(btnANNULER);
		btnAdd = new JButton("AJOUTER");

		btnANNULER.addActionListener(e -> {
			txtID.setText("");
			txtJOUR.setText("");
			comboClient.setSelectedIndex(0);
			comboCreneaux.setSelectedIndex(0);
		});

		btnAdd.addActionListener(v -> extracted());

		btnAdd.setBounds(462, 502, 128, 34);
		this.add(btnAdd);

		comboClient = new JComboBox<String>();
		comboClient.setBounds(486, 311, 389, 34);
		this.add(comboClient);

		comboCreneaux = new JComboBox<String>();
		comboCreneaux.setBounds(486, 361, 389, 34);
		this.add(comboCreneaux);

		comboClient.addItem("-- Sélectionnez un Client! --");
		for (Client c : DClient.getAll())
			comboClient.addItem("" + c.getID());

		comboCreneaux.addItem("-- Sélectionnez un Creneaux! --");
		for (Creneaux c : DCreneaux.getAll())
			comboCreneaux.addItem("" + c.getId());
	}

	private void extracted() {
		int id, creneaux_id, client_id;
		try {
			id = Integer.parseInt(txtID.getText());
			try {
				long jour = Date.parse(txtJOUR.getText());
				if (comboClient.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Sélectionnez un Client svp.");
				else if (comboCreneaux.getSelectedIndex() == 0)
					JOptionPane.showMessageDialog(null, "Sélectionnez un Creneaux svp.");
				else {
					creneaux_id = Integer.parseInt(comboCreneaux.getSelectedItem().toString());
					client_id = Integer.parseInt(comboClient.getSelectedItem().toString());

					if (DRV.AddOne(new RV(id, new Date(jour), DClient.getByID(client_id),
							DCreneaux.getByID(creneaux_id)))) {
						JOptionPane.showMessageDialog(null, "RV bien ajoute");
						btnANNULER.doClick();
					} else
						JOptionPane.showMessageDialog(null, "RV déja exists");
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "jour invalide : Le jour doit être une date valide (mm/dd/yyyy).");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "ID invalide : L'ID doit être un entier.");
		}
	}
}
