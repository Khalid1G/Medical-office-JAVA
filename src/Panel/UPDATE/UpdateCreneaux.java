package Panel.UPDATE;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.DAO;
import Models.Creneaux;
import Models.Medecin;
import Services.CreneauxDAO;
import Services.MedecinDAO;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class UpdateCreneaux extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblICr_MDEBUT;
	private JLabel lblICr_HFIN;
	private JLabel lblICr_MFIN;
	private JLabel lblCr_ID_MEDECIN;
	private JLabel lblICr_VERSION;
	private JLabel lblCrID;
	private JTextField txtVERSION;
	private JTextField txtHDEBUT;
	private JTextField txtMDEBUT;
	private JTextField txtHFIN;
	private JTextField txtMFIN;
	private JComboBox<String> comboBox;
	private JButton btnANNULER;
	private JButton btnUPDATE;
	private JComboBox<String> comboBox_ID;
	private DAO<Medecin> DMedecin = new MedecinDAO();
	private DAO<Creneaux> DCreneaux = new CreneauxDAO();
	
	public UpdateCreneaux() {
		super(null);
		this.setBounds(244, 91, 1084, 596);
		JLabel lblCr_HDEBUT = new JLabel("Heur DEBUT");
		lblCr_HDEBUT.setForeground(new Color(0, 60, 0));
		lblCr_HDEBUT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCr_HDEBUT.setBounds(151, 221, 168, 34);
		this.add(lblCr_HDEBUT);

		lblICr_MDEBUT = new JLabel("Minute DEBUT");
		lblICr_MDEBUT.setForeground(new Color(0, 60, 0));
		lblICr_MDEBUT.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblICr_MDEBUT.setBounds(151, 271, 168, 34);
		this.add(lblICr_MDEBUT);

		lblICr_HFIN = new JLabel("Heur FIN");
		lblICr_HFIN.setForeground(new Color(0, 60, 0));
		lblICr_HFIN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblICr_HFIN.setBounds(151, 321, 168, 34);
		this.add(lblICr_HFIN);

		lblICr_MFIN = new JLabel("Minute FIN");
		lblICr_MFIN.setForeground(new Color(0, 60, 0));
		lblICr_MFIN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblICr_MFIN.setBounds(151, 371, 168, 34);
		this.add(lblICr_MFIN);

		lblCr_ID_MEDECIN = new JLabel("ID MEDECIN");
		lblCr_ID_MEDECIN.setForeground(new Color(0, 60, 0));
		lblCr_ID_MEDECIN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCr_ID_MEDECIN.setBounds(151, 421, 168, 34);
		this.add(lblCr_ID_MEDECIN);

		lblICr_VERSION = new JLabel("VERSION");
		lblICr_VERSION.setForeground(new Color(0, 60, 0));
		lblICr_VERSION.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblICr_VERSION.setBounds(151, 171, 168, 34);
		this.add(lblICr_VERSION);

		lblCrID = new JLabel("ID");
		lblCrID.setForeground(new Color(0, 60, 0));
		lblCrID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCrID.setBounds(151, 121, 100, 34);
		this.add(lblCrID);

		txtVERSION = new JTextField();
		txtVERSION.setColumns(10);
		txtVERSION.setBounds(366, 173, 389, 34);
		txtVERSION.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtVERSION);

		txtHDEBUT = new JTextField();
		txtHDEBUT.setColumns(10);
		txtHDEBUT.setBounds(366, 223, 389, 34);
		txtHDEBUT.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtHDEBUT);

		txtMDEBUT = new JTextField();
		txtMDEBUT.setColumns(10);
		txtMDEBUT.setBounds(366, 273, 389, 34);
		txtMDEBUT.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtMDEBUT);

		txtHFIN = new JTextField();
		txtHFIN.setColumns(10);
		txtHFIN.setBounds(366, 323, 389, 34);
		txtHFIN.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtHFIN);

		txtMFIN = new JTextField();
		txtMFIN.setColumns(10);
		txtMFIN.setBounds(366, 373, 389, 34);
		txtMFIN.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtMFIN);

		comboBox = new JComboBox<String>();
		comboBox.setBounds(366, 423, 389, 34);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		comboBox.addItem("-- Sélectionnez un médecin! --");
		for (Medecin c : DMedecin.getAll())
			comboBox.addItem("" + c.getId());
		this.add(comboBox);

		comboBox_ID = new JComboBox<String>();
		comboBox_ID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		comboBox_ID.setBounds(366, 121, 389, 34);
		comboBox_ID.addItem("-- Sélectionnez un Creneaux! --");
		for (Creneaux c : DCreneaux.getAll())
			comboBox_ID.addItem("" + c.getId());
		this.add(comboBox);
		this.add(comboBox_ID);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(640, 502, 115, 34);
		this.add(btnANNULER);
		btnUPDATE = new JButton("MODIFIER");

		btnANNULER.addActionListener(e -> {
			comboBox_ID.setSelectedIndex(0);
			txtHDEBUT.setText("");
			txtHFIN.setText("");
			txtVERSION.setText("");
			txtMFIN.setText("");
			txtMDEBUT.setText("");
			comboBox.setSelectedIndex(0);
		});

		btnUPDATE.addActionListener(v -> {
			int id, hdebut, hfin, mdebut, mfin, version, medecin_id;
			if (comboBox_ID.getSelectedIndex() == 0)
				JOptionPane.showMessageDialog(null, "Sélectionnez un Creneaux svp.");
			id = Integer.parseInt(comboBox_ID.getSelectedItem() + "");
			try {
				version = Integer.parseInt(txtVERSION.getText());
				try {
					hdebut = Integer.parseInt(txtHDEBUT.getText());
					try {
						mdebut = Integer.parseInt(txtMDEBUT.getText());
						try {
							hfin = Integer.parseInt(txtHFIN.getText());
							try {
								mfin = Integer.parseInt(txtMFIN.getText());
								if (comboBox.getSelectedIndex() == 0)
									JOptionPane.showMessageDialog(null, "Sélectionnez un médecin svp.");
								else {
									medecin_id = Integer.parseInt(comboBox.getSelectedItem().toString());
									if (DCreneaux.Update(new Creneaux(id, version, hdebut, mdebut, hfin, mfin,
											DMedecin.getByID(medecin_id)))) {
										JOptionPane.showMessageDialog(null, "Creneaux bien Modifier");
										btnANNULER.doClick();
									}
								}
							} catch (NumberFormatException e) {
								JOptionPane.showMessageDialog(null,
										"Menute fin invalide : Menute de fin doit être un entier.");
							}
						} catch (NumberFormatException e) {
							JOptionPane.showMessageDialog(null, "heur fin invalide : L'heur fin doit être un entier.");
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,
								"Menute debut invalide : Le menute de debut doit être un entier.");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "heur debut invalide : le'heur de debut doit être un entier.");
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "version invalide : La version doit être un entier.");
			}

		});

		comboBox_ID.addActionListener(e -> {
			if (comboBox_ID.getSelectedIndex() != 0) {
				String version;
				String HDEBUT;
				String MDEBUT;
				String HFIN;
				String MFIN;
				String ID_MEDECIN;

				int ID = Integer.parseInt(comboBox_ID.getSelectedItem() + "");

				Creneaux C = DCreneaux.getByID(ID);
				HDEBUT = C.getHbebut()+"";
				version = C.getVesrion() + "";
				MDEBUT = C.getMdebut()+"";
				HFIN = C.getHfin()+"";
				MFIN = C.getMfin()+"";
				ID_MEDECIN = C.getMedecin().getId()+"";

				txtHDEBUT.setText(HDEBUT);
				txtVERSION.setText(version);
				txtMDEBUT.setText(MDEBUT);
				txtHFIN.setText(HFIN);
				txtMFIN.setText(MFIN);
				comboBox.setSelectedItem(ID_MEDECIN);
			}

		});

		btnUPDATE.setBounds(462, 502, 128, 34);
		this.add(btnUPDATE);

	}

}
