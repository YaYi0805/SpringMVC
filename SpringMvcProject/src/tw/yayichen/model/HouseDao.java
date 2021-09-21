package tw.yayichen.model;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("houseDao")
public class HouseDao {

	@Autowired 
	private SessionFactory sessionFactory;

	public House select(int houseid) throws SQLException {
		Session session = sessionFactory.getCurrentSession();
		House hBean = session.get(House.class, houseid);
		return hBean;
	}

}
