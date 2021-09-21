package tw.yayichen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
@Transactional
public class UsersDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean checkLogin(Users users) {
		Session session = sessionFactory.getCurrentSession();
		
		String hql = "from Users where username=:user";
		Query<Users> query = session.createQuery(hql, Users.class);
		query.setParameter("user", users.getUsername());
		Users result = query.uniqueResult(); //帳號不會重複,故一定唯一uniqueResult()
		
		if(result!=null) {
			return true;
		}		
		return false;
	}
}
