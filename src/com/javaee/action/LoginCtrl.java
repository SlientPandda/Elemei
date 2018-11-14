package com.javaee.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaee.bean.Dish;
import com.javaee.bean.Users;
import com.javaee.biz.DishService;
import com.javaee.biz.UserService;
import com.javaee.biz.UserServiceImpl;
import com.javaee.dao.DishesDAO;
import com.javaee.utils.DAOFactory;
import com.javaee.utils.PageModel;

/**
 * Servlet implementation class LoginCtrl
 */
@WebServlet("/ctrl")
public class LoginCtrl extends baseControl {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCtrl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "loginctrl":
			loginCtrl(request, response);break;
		case "pagelist":
			pageList(request, response);break;
		case "chkbox":
			chkboxList(request, response);
		}
	}

	private void chkboxList(HttpServletRequest request, HttpServletResponse response){
		String[] chkbox = request.getParameterValues("chkbox");
		logger.debug(chkbox.toString());
	}
	private void pageList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = Integer.parseInt(request.getParameter("pageNo"));
		DishService dishserv = (DishService) DAOFactory.newInstance("DishServ");
		ArrayList<Dish> dishlist = dishserv.findDish4PageList(pageNo, 6);
		logger.debug(dishlist);
		int totalRecords = dishserv.getTotalRecords();
		PageModel<Dish> pageModel = new PageModel<Dish>(totalRecords,pageNo,6,dishlist);
		request.setAttribute("pageModel", pageModel);
		// 跳转到show.jsp页面
		RequestDispatcher rd = request.getRequestDispatcher("/show.jsp");
		rd.forward(request, response);
	}

	private void loginCtrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("loginName");
		String password = request.getParameter("loginPass");
		// 用户身份验证
		Users user = new Users();
		user.setUsername(username);
		user.setPassword(password);
		UserServiceImpl userserv = (UserServiceImpl) DAOFactory.newInstance("UserServ");
		RequestDispatcher rd = request.getRequestDispatcher("/show.jsp");
		if (userserv.validateUser(user)) {// 验证通过
			// 查询首页菜品信息
//			DishesDAO dishdao = (DishesDAO) DAOFactory.newInstance("DishDAO");
//			ArrayList dishlist = dishdao.findDishes();
			DishService dishserv = (DishService) DAOFactory.newInstance("DishServ");
			ArrayList<Dish> dishlist = dishserv.findDish4PageList(1, 6);
			logger.debug(dishlist);
			int totalRecords = dishserv.getTotalRecords();
			PageModel<Dish> pageModel = new PageModel<Dish>(totalRecords,1,6,dishlist);
			request.setAttribute("pageModel", pageModel);
			request.setAttribute("loginuser", user);
			// 跳转到show.jsp页面
			rd.forward(request, response);
		} else {// 验证失败
			response.sendRedirect("login.html");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
