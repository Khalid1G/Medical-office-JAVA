package Panel.UPDATE;

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
public class UpdatePanelCM extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnANNULER;
	private JTextPane txtVERSION;
	private JTextPane txtNOM;
	private JTextPane txtPRENOM;
	private JButton btnUPDATE;
	private JComboBox<String> comboBoxTITRE;
	private JComboBox<String> comboBox_ID;
	
	private DAO<Client> DClient = new ClientDAO();
	private DAO<Medecin> DMedecin = new MedecinDAO();

	public UpdatePanelCM(String role) {
		super(null);
		this.setBounds(244, 91, 1084, 596);

		JLabel lblID = new JLabel("ID");
		lblID.setForeground(new Color(0, 60, 0));
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblID.setBounds(146, 95, 100, 34);
		this.add(lblID);

		JLabel lblVERSION = new JLabel("VERSION");
		lblVERSION.setForeground(new Color(0, 60, 0));
		lblVERSION.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblVERSION.setBounds(146, 155, 100, 34);
		this.add(lblVERSION);

		JLabel lblTITLE = new JLabel("TITRE");
		lblTITLE.setForeground(new Color(0, 60, 0));
		lblTITLE.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTITLE.setBounds(146, 215, 100, 34);
		this.add(lblTITLE);

		JLabel lblNOM = new JLabel("NOM");
		lblNOM.setForeground(new Color(0, 60, 0));
		lblNOM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNOM.setBounds(146, 275, 100, 34);
		this.add(lblNOM);

		JLabel lblPRENOM = new JLabel("PRENOM");
		lblPRENOM.setForeground(new Color(0, 60, 0));
		lblPRENOM.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblPRENOM.setBounds(146, 335, 100, 34);
		this.add(lblPRENOM);

		txtVERSION = new JTextPane();
		txtVERSION.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtVERSION.setBounds(315, 155, 402, 28);
		this.add(txtVERSION);

		txtNOM = new JTextPane();
		txtNOM.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtNOM.setBounds(315, 275, 402, 28);
		this.add(txtNOM);

		txtPRENOM = new JTextPane();
		txtPRENOM.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtPRENOM.setBounds(315, 335, 402, 34);
		this.add(txtPRENOM);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(602, 432, 115, 34);
		this.add(btnANNULER);

		btnUPDATE = new JButton("Modifier");
		btnUPDATE.setBounds(294, 432, 128, 34);
		this.add(btnUPDATE);

		comboBoxTITRE = new JComboBox<String>();
		comboBoxTITRE.addItem("M.");
		comboBoxTITRE.addItem("Mlle.");
		comboBoxTITRE.addItem("Mme.");

		comboBoxTITRE.setBounds(315, 215, 402, 28);
		this.add(comboBoxTITRE);

		comboBox_ID = new JComboBox<String>();
		comboBox_ID.setBounds(319, 95, 398, 30);
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
				String version;
				String titre;
				String nom;
				String prenom;
				int ID = Integer.parseInt(comboBox_ID.getSelectedItem() + "");

				if (role == "Client") {
					Client c = DClient.getByID(ID);
					nom = c.getNom();
					version = c.getVersion()+"";
					titre = c.getTitre();
					prenom = c.getPrenom();
				} else {
					Medecin c = DMedecin.getByID(ID);
					nom = c.getNom();
					version = c.getVersion()+"";
					titre = c.getTitre();
					prenom = c.getPrenom();
				}

				txtNOM.setText(nom);
				txtPRENOM.setText(prenom);
				txtVERSION.setText(version);
				comboBoxTITRE.setSelectedItem(titre);
			}

		});
		
		btnUPDATE.addActionListener(v -> {
			if(comboBox_ID.getSelectedIndex() == 0) JOptionPane.showMessageDialog(null, "Sélectionnez un ID svp !");
			{
				int id,version;
				try {
		    		id = Integer.parseInt(comboBox_ID.getSelectedItem()+"");
		    		try {
			    		version = Integer.parseInt(txtVERSION.getText());	
			    		String titre = comboBoxTITRE.getSelectedItem().toString();
				    	String nom = txtNOM.getText();
				    	String prenom = txtPRENOM.getText();
				    	if(nom.equals("") || prenom.equals(""))  JOptionPane.showMessageDialog(null, "Tout les champs sont obligatoires.");
				    	else if(role == "Client")
				    	{
				    		Client c = new Client(id, version, titre, nom, prenom);
				    		if(DClient.Update(c)) 
				    		{
				    			JOptionPane.showMessageDialog(null, "Client bien Modifier.");
				    			btnANNULER.doClick();
				    		}
				    	}
				    	else
				    	{
				    		Medecin c = new Medecin(id, version, titre, nom, prenom);
				    		if(DMedecin.Update(c)) 
				    		{
				    			JOptionPane.showMessageDialog(null, "Medecin bien Modifier.");
				    			btnANNULER.doClick();
				    		}
				    	}
			    	}catch(NumberFormatException e)
			    	{
			    		JOptionPane.showMessageDialog(null, "Version invalide : La Version doit être un entier.");
			    	}
		    	}catch(NumberFormatException e)
		    	{
		    		JOptionPane.showMessageDialog(null, "ID invalide : L'ID doit être un entier.");
		    	}
			}
	    	
	    });
		   
		
		btnANNULER.addActionListener(v -> {
			comboBox_ID.setSelectedIndex(0);
			txtVERSION.setText("");
			txtPRENOM.setText("");
			txtNOM.setText("");
			comboBoxTITRE.setSelectedIndex(0);
		});

	}
}
