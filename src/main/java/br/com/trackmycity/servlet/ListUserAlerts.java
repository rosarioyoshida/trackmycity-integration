package br.com.trackmycity.servlet;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.trackmycity.dao.UserAlertDAO;
import br.com.trackmycity.models.UserAlert;

public class ListUserAlerts extends HttpServlet {

	private static final long serialVersionUID = 3904584220411266584L;

	@Inject
	private UserAlertDAO userAlertDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserAlert> alerts = userAlertDAO.list(userAlertDAO.getCriteriaBuilder().asc(userAlertDAO.getRoot().get("id")) );
		req.setAttribute("alerts", alerts);
		req.getRequestDispatcher("listUserAlerts.jsp").forward(req, resp);
	}
	
}

