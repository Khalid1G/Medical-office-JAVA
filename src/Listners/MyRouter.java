package Listners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Panel.ADD.AddPanelCM;
import Panel.ADD.AddPanelCreneaux;
import Panel.ADD.AddPanelRV;
import Panel.DELETE.DeleteCMPanel;
import Panel.DELETE.DeleteCreneauxPanel;
import Panel.DELETE.DeleteRVPanele;
import Panel.SHOW.ShowAll;
import Panel.SHOW.ShowCM;
import Panel.SHOW.ShowCreneaux;
import Panel.SHOW.ShowRV;
import Panel.UPDATE.UpdateCreneaux;
import Panel.UPDATE.UpdatePanelCM;
import Panel.UPDATE.UpdateRVPanel;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class MyRouter implements ActionListener {
	private JPanel panel;

	public MyRouter(JPanel panel) {
		this.panel = panel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			panel.remove(2);
		} catch (Exception e2) {
			// do nothing
		} finally {
			switch (e.getActionCommand()) {
			// Client
			case "Afficher tout les clients":
				panel.add(new ShowAll("Client"));
				break;
			case "Rechercher un Client":
				panel.add(new ShowCM("Client"));
				break;
			case "Ajouter un Client":
				panel.add(new AddPanelCM("Client"));
				break;
			case "Modifier un Client":
				panel.add(new UpdatePanelCM("Client"));
				break;
			case "Supprimer un client":
				panel.add(new DeleteCMPanel("Client"));
				break;

			// Medecin
			case "Afficher tout les medecins":
				panel.add(new ShowAll("Medecin"));
				break;
			case "Rechercher un Medecin":
				panel.add(new ShowCM("Medecin"));
				break;
			case "Ajouter un Medecin":
				panel.add(new AddPanelCM("Medecin"));
				break;
			case "Modifier un Medecin":
				panel.add(new UpdatePanelCM("Medecin"));
				break;
			case "Supprimer un Medecin":
				panel.add(new DeleteCMPanel("Medecin"));
				break;

			// RV
			case "Afficher tout les rv":
				panel.add(new ShowAll("RV"));
				break;
			case "Rechercher un RV":
				panel.add(new ShowRV());
				break;
			case "Ajouter un RV":
				panel.add(new AddPanelRV());
				break;
			case "Modifier un RV":
				panel.add(new UpdateRVPanel());
				break;
			case "Supprimer un RV":
				panel.add(new DeleteRVPanele());
				break;

			// Creneaux
			case "Afficher tout les Creneaux":
				panel.add(new ShowAll("Creneaux"));
				break;
			case "Rechercher un Creneaux":
				panel.add(new ShowCreneaux());
				break;
			case "Ajouter un Creneaux":
				panel.add(new AddPanelCreneaux());
				break;
			case "Modifier un Creneaux":
				panel.add(new UpdateCreneaux());
				break;
			case "Supprimer un Creneaux":
				panel.add(new DeleteCreneauxPanel());
				break;

			}
			panel.repaint();
			panel.revalidate();
		}

	}

}
