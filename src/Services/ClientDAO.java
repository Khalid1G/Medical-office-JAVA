package Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DAO.DAO;
import DataBase.ConnectionFactory;
import Models.Client;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class ClientDAO implements DAO<Client> {

	private Connection conn;
	private List<Client> clients;

	public ClientDAO() {
		conn = ConnectionFactory.getInstance();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Client> getAll() {
		clients = new ArrayList<Client>();
		try {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from clients");

			while (rs.next()) {
				clients.add(new Client(rs.getInt(1), rs.getInt(2),
						rs.getNString(3), rs.getString(4), rs.getString(5)));
			}

			return clients;
		} catch (Exception e) {
			return null;			
		}
	}

	@Override
	public Client getByID(int id) {
		try {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from clients where ID = " + id);
			if (rs.next())
				return new Client(rs.getInt(1), rs.getInt(2), rs.getNString(3),
						rs.getString(4), rs.getString(5));

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public boolean AddOne(Client o) {
		boolean flag = false ;
		try {

			PreparedStatement ps = conn.prepareStatement("insert into clients values (?, ?,?,?,?)");

			ps.setInt(1, o.getID());
			ps.setInt(2, o.getVersion());
			ps.setString(3, o.getTitre());
			ps.setString(4, o.getNom());
			ps.setString(5, o.getPrenom());

			if(ps.executeUpdate() != 0)
				flag = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public boolean Update(Client o) {
		boolean flag = false ;
		try {
			PreparedStatement ps = conn
					.prepareStatement("Update clients set version = ? , titre = ?, nom = ?, prenom = ? where id = ?");
			ps.setInt(1, o.getVersion());
			ps.setString(2, o.getTitre());
			ps.setString(3, o.getNom());
			ps.setString(4, o.getPrenom());
			ps.setInt(5, o.getID());		
			if(ps.executeUpdate() != 0)
				flag = true;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		return flag;
	}

	@Override
	public boolean Delete(int id) {
		boolean flag = false ;
		try {
			PreparedStatement ps = conn.prepareStatement("delete from clients where id = ?");
			ps.setInt(1, id);
			if(ps.executeUpdate() != 0)
				flag = true;

			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} 
		return flag;
	}
}

