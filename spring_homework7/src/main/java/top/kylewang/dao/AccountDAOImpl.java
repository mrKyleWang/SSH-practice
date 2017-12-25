package top.kylewang.dao;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Administrator
 *
 */
public class AccountDAOImpl implements IAccountDAO {

	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// 转出
	@Override
	public void accountOut(String outname, double money) {
		jdbcTemplate.update("update account set money=money-? where name=?", money, outname);
	}

	// 转入
	@Override
	public void accountIn(String inname, double money) {
		jdbcTemplate.update("update account set money=money+? where name=?", money, inname);
	}

}
