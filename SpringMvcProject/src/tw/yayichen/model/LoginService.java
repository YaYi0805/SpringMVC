package tw.yayichen.model;

public class LoginService {

	private LoginDao loginDao;

	public LoginService() {

	}

	// Constructor Dependency Injection
	public LoginService(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	// 右鍵source產生Setter Dependency Injection
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public boolean checkLogin(String user, String pwd) {
		return loginDao.checkLogin(user, pwd);
	}

}
