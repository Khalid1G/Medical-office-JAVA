package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Listners.MyRouter;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class MainForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenu ClientMenu, MedecinMenu, RVMenu, CreneauxMenu;
	private JMenuItem addClient, getALLClients, updateClient, getClient, deleteClient;
	private JMenuItem addMedecin, getALLMedecin, updateMedecin, getMedecin, deleteMedecin;
	private JMenuItem addCreneaux, getALLCreneaux, updateCreneaux, getCreneaux, deleteCreneaux;
	private JMenuItem addRV, getALLRV, updateRV, getRV, deleteRV;

	private JMenuBar menuBar = new JMenuBar();
	private JPanel panel;

	public MainForm() {
		setResizable(false);
		setSize(new Dimension(1354, 748));
		setLocationRelativeTo(null);
		setTitle("Application de gestion");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Menus
		ClientMenu = new JMenu("Client");
		MedecinMenu = new JMenu("Medecin");
		RVMenu = new JMenu("RV");
		CreneauxMenu = new JMenu("Creneaux");

		// MenuItems

		// Client
		getALLClients = new JMenuItem("Afficher tout les clients");
		getClient = new JMenuItem("Rechercher un Client");
		addClient = new JMenuItem("Ajouter un Client");
		updateClient = new JMenuItem("Modifier un Client");
		deleteClient = new JMenuItem("Supprimer un client");

		ClientMenu.add(getALLClients);
		ClientMenu.add(getClient);
		ClientMenu.add(addClient);
		ClientMenu.add(updateClient);
		ClientMenu.add(deleteClient);

		// Medecin
		getALLMedecin = new JMenuItem("Afficher tout les medecins");
		getMedecin = new JMenuItem("Rechercher un Medecin");
		addMedecin = new JMenuItem("Ajouter un Medecin");
		updateMedecin = new JMenuItem("Modifier un Medecin");
		deleteMedecin = new JMenuItem("Supprimer un Medecin");

		MedecinMenu.add(getALLMedecin);
		MedecinMenu.add(getMedecin);
		MedecinMenu.add(addMedecin);
		MedecinMenu.add(updateMedecin);
		MedecinMenu.add(deleteMedecin);

		// RV
		getALLRV = new JMenuItem("Afficher tout les rv");
		getRV = new JMenuItem("Rechercher un RV");
		addRV = new JMenuItem("Ajouter un RV");
		updateRV = new JMenuItem("Modifier un RV");
		deleteRV = new JMenuItem("Supprimer un RV");

		RVMenu.add(getALLRV);
		RVMenu.add(getRV);
		RVMenu.add(addRV);
		RVMenu.add(updateRV);
		RVMenu.add(deleteRV);

		// Creneaux
		getALLCreneaux = new JMenuItem("Afficher tout les Creneaux");
		getCreneaux = new JMenuItem("Rechercher un Creneaux");
		addCreneaux = new JMenuItem("Ajouter un Creneaux");
		updateCreneaux = new JMenuItem("Modifier un Creneaux");
		deleteCreneaux = new JMenuItem("Supprimer un Creneaux");

		CreneauxMenu.add(getALLCreneaux);
		CreneauxMenu.add(getCreneaux);
		CreneauxMenu.add(addCreneaux);
		CreneauxMenu.add(updateCreneaux);
		CreneauxMenu.add(deleteCreneaux);

		menuBar.add(ClientMenu);
		menuBar.add(MedecinMenu);
		menuBar.add(CreneauxMenu);
		menuBar.add(RVMenu);
		setJMenuBar(menuBar);
		getContentPane().setLayout(new BorderLayout(0, 0));

		panel = new JPanel(null);

		getContentPane().add(panel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 128, 0));
		panel_1.setBounds(0, 0, 247, 687);
		panel.add(panel_1);

		try {
			BufferedImage img = ImageIO.read(new File("logo.png"));
			JLabel pic = new JLabel(new ImageIcon(img));
			panel_1.add(pic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setBounds(244, 0, 1094, 100);
		
		
		try {
			BufferedImage img = ImageIO.read(new File("header.png"));
			JLabel pic = new JLabel(new ImageIcon(img));
			panel_2.add(pic);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		panel.add(panel_2);
		
		try {
			JPanel hero = new JPanel();
			hero.setBounds(244, 91, 1084, 596);
			BufferedImage img = ImageIO.read(new File("wel.jpg"));
			JLabel pic = new JLabel(new ImageIcon(img));
			hero.add(pic);
			panel.add(hero);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		MyRouter listner = new MyRouter(panel);

		getALLClients.addActionListener(listner);
		getClient.addActionListener(listner);
		addClient.addActionListener(listner);
		updateClient.addActionListener(listner);
		deleteClient.addActionListener(listner);

		getALLMedecin.addActionListener(listner);
		getMedecin.addActionListener(listner);
		addMedecin.addActionListener(listner);
		updateMedecin.addActionListener(listner);
		deleteMedecin.addActionListener(listner);

		getALLRV.addActionListener(listner);
		getRV.addActionListener(listner);
		addRV.addActionListener(listner);
		updateRV.addActionListener(listner);
		deleteRV.addActionListener(listner);

		getALLCreneaux.addActionListener(listner);
		getCreneaux.addActionListener(listner);
		addCreneaux.addActionListener(listner);
		updateCreneaux.addActionListener(listner);
		deleteCreneaux.addActionListener(listner);

	}
}
