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
import Models.Creneaux;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class CreneauxDAO implements DAO<Creneaux> {

	private Connection conn;
	private List<Creneaux> creneaux;
	
	public CreneauxDAO() {
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Creneaux> getAll() {
		creneaux = new ArrayList<Creneaux>();
		try {

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from creneaux");

			while (rs.next()) {
				
				creneaux.add(
						new Creneaux(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getInt(6),new MedecinDAO().getByID(rs.getInt(7))));
			}

			return creneaux;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Creneaux getByID(int id) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from creneaux where ID = " + id);
			if (rs.next())
				return new Creneaux(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5),rs.getInt(6),new MedecinDAO().getByID(rs.getInt(7)));

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public boolean AddOne(Creneaux o) {
		boolean flag = false ;
		try {

			PreparedStatement ps = conn.prepareStatement("insert into creneaux values (?, ?,?,?,?,?,?)");
			ps.setInt(1, o.getId());
			ps.setInt(2, o.getVesrion());
			ps.setInt(3, o.getHbebut());
			ps.setInt(4, o.getMdebut());
			ps.setInt(5, o.getHfin());
			ps.setInt(6, o.getMfin());
			ps.setInt(7, o.getMedecin().getId());

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
	public boolean Update(Creneaux o) {
		boolean flag = false ;
		try {
			PreparedStatement ps = conn
					.prepareStatement("Update creneaux set version = ? , hdebut = ?, mdebut = ?, hfin = ? ,mfin = ?,ID_MEDECIN = ? where id = ?");

			ps.setInt(7, o.getId());
			ps.setInt(1, o.getVesrion());
			ps.setInt(2, o.getHbebut());
			ps.setInt(3, o.getMdebut());
			ps.setInt(4, o.getHfin());
			ps.setInt(5, o.getMfin());
			ps.setInt(6, o.getMedecin().getId());
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
			PreparedStatement ps = conn.prepareStatement("delete from creneaux where id = ?");

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
