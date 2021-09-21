package tw.yayichen.model;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {
	
	@Autowired
	private HouseDao houseDao;
	
	public House select(int houseid) throws SQLException {
		return houseDao.select(houseid);
	}

}
