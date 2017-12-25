package top.kylewang.service;

import org.springframework.transaction.annotation.Transactional;
import top.kylewang.dao.IAccountDAO;

@Transactional
public class AccountServiceImpl implements IAccountService {

	private IAccountDAO accountDao;

	public IAccountDAO getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(IAccountDAO accountDao) {
		this.accountDao = accountDao;
	}

	// 转账操作的方法
	
	@Override
	public void account(String outname, String inname, double money) {

		// 从outname转出money
		accountDao.accountOut(outname, money);

//		int a = 10 / 0; // 一定会抛出异常

		// 向inname转入money
		accountDao.accountIn(inname, money);
	}

}
