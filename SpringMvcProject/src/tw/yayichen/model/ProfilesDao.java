package tw.yayichen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("profilesDao")
@Transactional
public class ProfilesDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Profiles insert(Profiles pBean) {
		Session session = sessionFactory.getCurrentSession();
		if(pBean != null) {
			session.save(pBean);
		}
		return pBean;
	}
	
	public Profiles update(Profiles pBean) {
		Session session = sessionFactory.getCurrentSession();
		if(pBean != null) {
			session.update(pBean);
			session.flush();
		}
		return pBean;
	}
	
	public Profiles findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Profiles resultBean = session.get(Profiles.class, id);
		//session.get()找不到會回傳null
		//session.load()找不到會拋exception,較不易處理
		return resultBean;
	}
	
	public boolean delete(Profiles pBean) {
		Session session = sessionFactory.getCurrentSession();
		if(pBean != null) {
			session.delete(pBean);
			session.flush();
			return true;
		}
		return false;
	}

}
