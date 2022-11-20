package Panel.DELETE;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import DAO.DAO;
import Models.Client;
import Models.Medecin;
import Services.ClientDAO;
import Services.MedecinDAO;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class DeleteCMPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextPane txtNOMCOMPLATE;
	private JButton btnANNULER;
	private JButton btnDelete;
	private DAO<Client> DClient = new ClientDAO();
	private DAO<Medecin> DMedecin = new MedecinDAO();
	
	public DeleteCMPanel(String role) {
		super(null);

		this.setBounds(244, 91, 1084, 596);

		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(0, 60, 0));
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblID.setBounds(146, 199, 100, 34);
		this.add(lblID);

		JLabel lblNOM = new JLabel("NOM COMPLATE");
		lblNOM.setForeground(new Color(0, 60, 0));
		lblNOM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNOM.setBounds(146, 275, 201, 34);
		this.add(lblNOM);

		txtNOMCOMPLATE = new JTextPane();
		txtNOMCOMPLATE.setBackground(Color.WHITE);
		txtNOMCOMPLATE.setEnabled(false);
		txtNOMCOMPLATE.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtNOMCOMPLATE.setBounds(357, 281, 402, 28);
		this.add(txtNOMCOMPLATE);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(579, 432, 115, 34);
		this.add(btnANNULER);

		btnDelete = new JButton("SUPPRIMER");
		btnDelete.setBounds(288, 432, 128, 34);
		this.add(btnDelete);

		JComboBox<String> comboBox_ID = new JComboBox<String>();
		comboBox_ID.setBounds(357, 213, 402, 28);

		if (role == "Client") {
			comboBox_ID.addItem("-- Sélectionnez un client ! --");
			for (Client c : DClient.getAll()) {
				comboBox_ID.addItem("" + c.getID());
			}
		} else {
			comboBox_ID.addItem("-- Sélectionnez un médecin! --");
			for (Medecin c : DMedecin.getAll())
				comboBox_ID.addItem("" + c.getId());
		}

		this.add(comboBox_ID);

		comboBox_ID.addActionListener(e -> {
			if (comboBox_ID.getSelectedIndex() != 0) {
				String nom;
				int ID = Integer.parseInt(comboBox_ID.getSelectedItem() + "");

				if (role == "Client") {
					Client c = DClient.getByID(ID);
					nom = c.getNom() + " " + c.getPrenom();
				} else {
					Medecin c = DMedecin.getByID(ID);
					nom = c.getNom() + " " + c.getPrenom();
				}

				txtNOMCOMPLATE.setText(nom);
			}

		});

		btnDelete.addActionListener(v -> {
			if (JOptionPane.showConfirmDialog(null,
					"Voulez-vous vraiment supprimer ce " + role + " ?") == JOptionPane.OK_OPTION) {
				int index = comboBox_ID.getSelectedIndex();
				if (role == "Client") {
					if (DClient.Delete(Integer.parseInt(comboBox_ID.getSelectedItem().toString())))
						JOptionPane.showMessageDialog(null, "Client bien supprimer");
				} else {
					if (DMedecin.Delete(Integer.parseInt(comboBox_ID.getSelectedItem().toString())))
						JOptionPane.showMessageDialog(null, "Medecin bien supprimer");
				}
				btnANNULER.doClick();
				comboBox_ID.removeItemAt(index);
			}
		});

		btnANNULER.addActionListener(v -> {
			txtNOMCOMPLATE.setText("");
			comboBox_ID.setSelectedIndex(0);
		});
	}
}
