package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import dao.LinkManDao;
import domain.LinkMan;
import utils.HibernateUtils;
@SuppressWarnings("unchecked")
public class LinkManDaoImpl implements LinkManDao {

	@Override
	public void save(LinkMan linkMan) {
		Session session = HibernateUtils.getCurrentSession();
		session.save(linkMan);

	}

	@Override
	public List<LinkMan> getAll() {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = session.createCriteria(LinkMan.class);
		List<LinkMan> list = criteria.list();
		return list;
	}

	@Override
	public List<LinkMan> getAll(DetachedCriteria dc) {
		Session session = HibernateUtils.getCurrentSession();
		Criteria criteria = dc.getExecutableCriteria(session);
		return criteria.list();
	}

}
