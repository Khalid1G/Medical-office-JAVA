package DAO;

import java.util.List;
/**
 * 
 * @author Khalid Boussaroual ISIL
 *
 * @param <T>
 */
public interface DAO<T> {
	List<T> getAll();
	T getByID(int id);
	boolean AddOne(T o);
	boolean Update(T o);
	boolean Delete(int id);
}


