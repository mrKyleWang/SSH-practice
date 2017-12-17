package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import domain.LinkMan;
import service.LinkManService;
import service.impl.LinkManServiceImpl;

/**
 * Servlet implementation class ListLinkManServlet
 */
public class ListLinkManServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LinkManService ls = new LinkManServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取查询条件
		String lkm_name = request.getParameter("lkm_name");
		DetachedCriteria dc = DetachedCriteria.forClass(LinkMan.class);
		//判断是否为空
		if(lkm_name!=null && !"".equals(lkm_name)) {
			dc.add(Restrictions.like("lkm_name","%"+lkm_name+"%"));
		}
	
		List<LinkMan> list = ls.getAll(dc);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/linkman/list.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
