package Panel.DELETE;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import DAO.DAO;
import Models.RV;
import Services.RVDAO;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class DeleteRVPanele extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblCrID;
	private JButton btnANNULER;
	private DAO<RV> DRV = new RVDAO();
	private JComboBox<String> comboBox_ID;
	private JButton btnDelete;

	public DeleteRVPanele() {
		super(null);
		this.setBounds(244, 91, 1084, 596);

		lblCrID = new JLabel("ID");
		lblCrID.setForeground(new Color(0, 60, 0));
		lblCrID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblCrID.setBounds(167, 242, 100, 34);
		this.add(lblCrID);

		comboBox_ID = new JComboBox<String>();
		comboBox_ID.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		comboBox_ID.setBounds(366, 241, 389, 34);
		comboBox_ID.addItem("-- Sélectionnez un RV! --");
		for (RV c : DRV.getAll())
			comboBox_ID.addItem("" + c.getId());

		this.add(comboBox_ID);

		btnANNULER = new JButton("ANNULER");
		btnANNULER.setBounds(610, 376, 115, 34);
		this.add(btnANNULER);

		btnDelete = new JButton("SUPPRIMER");
		btnDelete.setBounds(389, 376, 128, 34);
		this.add(btnDelete);

		btnDelete.addActionListener(v -> {
			if (comboBox_ID.getSelectedIndex() != 0)
				if (JOptionPane.showConfirmDialog(null,
						"Voulez-vous vraiment supprimer ce  RV ?") == JOptionPane.OK_OPTION) {
					int index = comboBox_ID.getSelectedIndex();
					if (DRV.Delete(Integer.parseInt(comboBox_ID.getSelectedItem() + ""))) {
						JOptionPane.showMessageDialog(null, "RV bien supprimer");
						btnANNULER.doClick();
						comboBox_ID.removeItemAt(index);
					}
				}
		});

		btnANNULER.addActionListener(v -> {
			comboBox_ID.setSelectedIndex(0);
		});

	}
}
