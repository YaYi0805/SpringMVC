package tw.yayichen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("accountDao")
@Transactional
public class AccountDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean checkLogin(Account users) {
		//Session session = sessionFactory.getCurrentSession();
		Session session = sessionFactory.openSession();
		
		String hql = "From Account where username=:user and userpwd=:pwd";
		Query<Account> query = session.createQuery(hql, Account.class);
		query.setParameter("user", users.getUsername());
		query.setParameter("pwd", users.getUserpwd());
		Account result = query.uniqueResult();
		
		if(result!=null) {
			return true;
		}
		return false;
	}

}
