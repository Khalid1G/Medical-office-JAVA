package Panel.SHOW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;

import DAO.DAO;
import Models.*;
import Services.*;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class ShowCM extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnANNULER;
	private String role;
	private JTextPane txtVERSION;
	private JTextPane txtNOM;
	private JTextPane txtPRENOM;
	private JButton btnSearch;
	private JTextPane txtID;
	DAO<Client> DClient = new ClientDAO();
	DAO<Medecin> DMedecin = new MedecinDAO();

	public ShowCM(String r) {
		super(null);
		this.role = r;
		this.setBounds(244, 91, 1084, 596);

		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(0, 60, 0));
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblID.setBounds(170, 167, 100, 34);
		this.add(lblID);

		JLabel lblVERSION = new JLabel("VERSION");
		lblVERSION.setForeground(new Color(0, 60, 0));
		lblVERSION.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblVERSION.setBounds(170, 227, 100, 34);
		this.add(lblVERSION);

		JLabel lblTITLE = new JLabel("TITRE");
		lblTITLE.setForeground(new Color(0, 60, 0));
		lblTITLE.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTITLE.setBounds(170, 287, 100, 34);
		this.add(lblTITLE);

		JLabel lblNOM = new JLabel("NOM");
		lblNOM.setForeground(new Color(0, 60, 0));
		lblNOM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNOM.setBounds(170, 347, 100, 34);
		this.add(lblNOM);

		JLabel lblPRENOM = new JLabel("PRENOM");
		lblPRENOM.setForeground(new Color(0, 60, 0));
		lblPRENOM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPRENOM.setBounds(170, 407, 100, 34);
		this.add(lblPRENOM);

		txtID = new JTextPane();
		txtID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtID.setBounds(339, 167, 402, 28);
		this.add(txtID);

		txtVERSION = new JTextPane();
		txtVERSION.setBackground(Color.WHITE);
		txtVERSION.setEnabled(false);
		txtVERSION.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtVERSION.setBounds(339, 227, 402, 28);
		this.add(txtVERSION);

		txtNOM = new JTextPane();
		txtNOM.setEnabled(false);
		txtNOM.setBackground(Color.WHITE);
		txtNOM.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtNOM.setBounds(339, 347, 402, 28);
		this.add(txtNOM);

		txtPRENOM = new JTextPane();
		txtPRENOM.setEnabled(false);
		txtPRENOM.setBackground(Color.WHITE);
		txtPRENOM.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtPRENOM.setBounds(339, 407, 402, 28);
		this.add(txtPRENOM);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(798, 229, 128, 34);
		this.add(btnANNULER);

		btnSearch = new JButton("RECHERCHER");
		btnSearch.setBounds(798, 169, 128, 34);
		this.add(btnSearch);

		JTextPane txtTitre = new JTextPane();
		txtTitre.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtTitre.setEnabled(false);
		txtTitre.setBackground(Color.WHITE);
		txtTitre.setBounds(339, 293, 402, 28);
		this.add(txtTitre);

		btnSearch.addActionListener(v -> {
			int ID;
			try {

				if (role == "Client") {
					ID = Integer.parseInt(txtID.getText());
					Client m = DClient.getByID(ID);
					if (m == null) {
						JOptionPane.showMessageDialog(null, "Client introuvable");
						btnANNULER.doClick();
					} else {
						txtVERSION.setText(m.getVersion() + "");
						txtTitre.setText(m.getTitre());
						txtNOM.setText(m.getNom());
						txtPRENOM.setText(m.getPrenom());
					}
				} else {
					Medecin m = DMedecin.getByID(Integer.parseInt(txtID.getText()));
					if (m == null) {
						JOptionPane.showMessageDialog(null, "Medecin introuvable");
						btnANNULER.doClick();
					} else {
						txtVERSION.setText(m.getVersion() + "");
						txtTitre.setText(m.getTitre());
						txtNOM.setText(m.getNom());
						txtPRENOM.setText(m.getPrenom());
					}
				}

			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "ID invalide : L'ID doit être un entier");
			}
		});

		btnANNULER.addActionListener(e -> {
			txtID.setText("");
			txtVERSION.setText("");
			txtTitre.setText("");
			txtNOM.setText("");
			txtPRENOM.setText("");
		});

	}
}
