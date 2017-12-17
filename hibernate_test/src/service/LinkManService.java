package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.LinkMan;

public interface LinkManService {

	void save(LinkMan linkMan);

	List<LinkMan> getAll();

	//根据条件查询所有LinkMan
	List<LinkMan> getAll(DetachedCriteria dc);

}
