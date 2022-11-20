package Panel.SHOW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.DAO;
import Models.Creneaux;
import Services.CreneauxDAO;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class ShowCreneaux extends JPanel {

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
	private JButton btnANNULER;
	private JComboBox<String> comboBox_ID;
	private DAO<Creneaux> DCreneaux = new CreneauxDAO();
	private JButton btnRechercher;
	private JTextField txtMedecin;

	public ShowCreneaux() {
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
		txtVERSION.setBackground(new Color(255, 255, 255));
		txtVERSION.setEnabled(false);
		txtVERSION.setColumns(10);
		txtVERSION.setBounds(366, 173, 389, 34);
		txtVERSION.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtVERSION);

		txtHDEBUT = new JTextField();
		txtHDEBUT.setBackground(new Color(255, 255, 255));
		txtHDEBUT.setEnabled(false);
		txtHDEBUT.setColumns(10);
		txtHDEBUT.setBounds(366, 223, 389, 34);
		txtHDEBUT.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtHDEBUT);

		txtMDEBUT = new JTextField();
		txtMDEBUT.setBackground(new Color(255, 255, 255));
		txtMDEBUT.setEnabled(false);
		txtMDEBUT.setColumns(10);
		txtMDEBUT.setBounds(366, 273, 389, 34);
		txtMDEBUT.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtMDEBUT);

		txtHFIN = new JTextField();
		txtHFIN.setBackground(new Color(255, 255, 255));
		txtHFIN.setEnabled(false);
		txtHFIN.setColumns(10);
		txtHFIN.setBounds(366, 323, 389, 34);
		txtHFIN.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtHFIN);

		txtMFIN = new JTextField();
		txtMFIN.setBackground(new Color(255, 255, 255));
		txtMFIN.setEnabled(false);
		txtMFIN.setColumns(10);
		txtMFIN.setBounds(366, 373, 389, 34);
		txtMFIN.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		this.add(txtMFIN);

		comboBox_ID = new JComboBox<String>();
		comboBox_ID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		comboBox_ID.setBounds(366, 121, 389, 34);
		comboBox_ID.addItem("-- Sélectionnez un Creneaux! --");
		for (Creneaux c : DCreneaux.getAll())
			comboBox_ID.addItem("" + c.getId());
		this.add(comboBox_ID);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(780, 173, 115, 34);
		this.add(btnANNULER);
		new JButton("MODIFIER");

		btnANNULER.addActionListener(e -> {
			comboBox_ID.setSelectedIndex(0);
			txtHDEBUT.setText("");
			txtHFIN.setText("");
			txtVERSION.setText("");
			txtMFIN.setText("");
			txtMDEBUT.setText("");
			txtMedecin.setText("");

		});

		btnRechercher = new JButton("Rechercher");
		btnRechercher.setBounds(780, 121, 115, 34);
		this.add(btnRechercher);
		btnRechercher.addActionListener(v -> {
			if (comboBox_ID.getSelectedIndex() != 0) {
				String version;
				String HDEBUT;
				String MDEBUT;
				String HFIN;
				String MFIN;
				String ID_MEDECIN;

				int ID = Integer.parseInt(comboBox_ID.getSelectedItem() + "");

				Creneaux C = DCreneaux.getByID(ID);
				HDEBUT = C.getHbebut() + "";
				version = C.getVesrion() + "";
				MDEBUT = C.getMdebut() + "";
				HFIN = C.getHfin() + "";
				MFIN = C.getMfin() + "";
				ID_MEDECIN = C.getMedecin().getId() + "";

				txtHDEBUT.setText(HDEBUT);
				txtVERSION.setText(version);
				txtMDEBUT.setText(MDEBUT);
				txtHFIN.setText(HFIN);
				txtMFIN.setText(MFIN);
				txtMedecin.setText(ID_MEDECIN);
			}
		});

		txtMedecin = new JTextField();
		txtMedecin.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtMedecin.setEnabled(false);
		txtMedecin.setColumns(10);
		txtMedecin.setBackground(Color.WHITE);
		txtMedecin.setBounds(366, 420, 389, 34);
		this.add(txtMedecin);

	}
}
