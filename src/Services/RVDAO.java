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
import Models.RV;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 */
public class RVDAO implements DAO<RV> {

	private Connection conn;
	private List<RV> Rvs;

	public RVDAO() {
		try {
			conn = ConnectionFactory.getInstance();
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<RV> getAll() {
		Rvs = new ArrayList<RV>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from rv");

			while (rs.next()) {
				Rvs.add(new RV(rs.getInt(1), rs.getDate(2), new ClientDAO().getByID(rs.getInt(3)),
						new CreneauxDAO().getByID(rs.getInt(4))));
			}

			return Rvs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public RV getByID(int id) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from rv where ID = " + id);
			if (rs.next())
				return new RV(rs.getInt(1), rs.getDate(2), new ClientDAO().getByID(rs.getInt(3)),
						new CreneauxDAO().getByID(rs.getInt(4)));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean AddOne(RV o) {
		boolean flag = false ;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into rv values (?,?,?,?)");

			ps.setInt(1, o.getId());
			ps.setDate(2, o.getJour());
			ps.setInt(3, o.getClient().getID());
			ps.setInt(4, o.getCreneaux().getId());

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
	public boolean Update(RV o) {
		boolean flag = false ;
		try {
			PreparedStatement ps = conn.prepareStatement("Update rv set Jour = ? , id_client = ?, id_creneau = ? where id = ?");

			ps.setDate(1, o.getJour());
			ps.setInt(2, o.getClient().getID());
			ps.setInt(3, o.getCreneaux().getId());
			ps.setInt(4, o.getId());

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
			PreparedStatement ps = conn.prepareStatement("delete from rv where id = ?");

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
