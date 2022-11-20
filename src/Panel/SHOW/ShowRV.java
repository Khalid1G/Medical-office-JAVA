package Panel.SHOW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
public class ShowRV extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JLabel ID_CRENEAU;
	private JLabel lblIJour;
	private JLabel lblCrID;
	private JTextField txtJOUR;
	private JButton btnANNULER;
	private JButton btnSEARCH;
	private DAO<Client> DClient = new ClientDAO();
	private DAO<Creneaux> DCreneaux = new CreneauxDAO();
	private DAO<RV> DRV = new RVDAO();
	private JComboBox<String> comboClient;
	private JComboBox<String> comboCreneaux;
	private JComboBox<String> combo_ID;

	public ShowRV() {
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

		txtJOUR = new JTextField();
		txtJOUR.setColumns(10);
		txtJOUR.setBounds(486, 261, 389, 34);
		txtJOUR.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtJOUR);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(897, 261, 129, 34);
		this.add(btnANNULER);
		btnSEARCH = new JButton("RECHERCHER");

		btnSEARCH.addActionListener(v -> {
			if (combo_ID.getSelectedIndex() != 0) {
				RV rv = DRV.getByID(Integer.parseInt(combo_ID.getSelectedItem() + ""));

			
				String Client_id = rv.getClient().getID() + "";
				String Creneaux_id = rv.getCreneaux().getId() + "";

				txtJOUR.setText(rv.getJour()+"");
				comboClient.setSelectedItem(Client_id);
				comboCreneaux.setSelectedItem(Creneaux_id);
			}
		});

		btnANNULER.addActionListener(e -> {
			combo_ID.setSelectedIndex(0);
			txtJOUR.setText("");
			comboClient.setSelectedIndex(0);
			comboCreneaux.setSelectedIndex(0);
		});

		btnSEARCH.setBounds(898, 209, 128, 34);
		this.add(btnSEARCH);

		comboClient = new JComboBox<String>();
		comboClient.setBounds(486, 311, 389, 34);
		this.add(comboClient);

		comboCreneaux = new JComboBox<String>();
		comboCreneaux.setBounds(486, 361, 389, 34);
		this.add(comboCreneaux);

		combo_ID = new JComboBox<String>();
		combo_ID.setBounds(486, 209, 389, 34);
		this.add(combo_ID);

		combo_ID.addItem("-- Sélectionnez un RV ! --");
		for (RV c : DRV.getAll())
			combo_ID.addItem("" + c.getId());

		comboClient.addItem("-- Sélectionnez un Client! --");
		for (Client c : DClient.getAll())
			comboClient.addItem("" + c.getID());

		comboCreneaux.addItem("-- Sélectionnez un Creneaux! --");
		for (Creneaux c : DCreneaux.getAll())
			comboCreneaux.addItem("" + c.getId());
	}
}
