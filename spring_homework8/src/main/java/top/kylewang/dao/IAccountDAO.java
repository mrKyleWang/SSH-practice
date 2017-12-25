package top.kylewang.dao;

public interface IAccountDAO {

	// 转出操作
	public void accountOut(String outname, double money);

	// 转入操作
	public void accountIn(String inname, double money);
}
