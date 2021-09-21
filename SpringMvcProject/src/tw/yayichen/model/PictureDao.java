package tw.yayichen.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("pictureDao")
@Transactional //對應<tx:annotation-driven transaction-manager="transactionManager"/>
public class PictureDao {
	
	@Autowired @Qualifier("sessionFactory") //@Qualifier可不加
	private SessionFactory sessionFactory;
	
	public Picture insert(Picture pBean) {
		Session session = sessionFactory.openSession();
		
		if(pBean!=null) {
			session.save(pBean);
		}
		
		return pBean;
	}
}
