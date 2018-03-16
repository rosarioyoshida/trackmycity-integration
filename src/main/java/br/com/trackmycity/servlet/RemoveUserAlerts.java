package br.com.trackmycity.servlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.trackmycity.dao.UserAlertDAO;
import br.com.trackmycity.models.UserAlert;


public class RemoveUserAlerts extends HttpServlet {

	private static final long serialVersionUID = 715629616332631953L;
	
	@Inject private UserAlertDAO userAlertDAO;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] ids = req.getParameterValues("selectedAlerts");
		userAlertDAO.getEm().getTransaction().begin();
		for (String id : ids) {
			UserAlert alert = userAlertDAO.find(Long.valueOf(id));
			userAlertDAO.getEm().remove(alert);
		}
		userAlertDAO.getEm().getTransaction().commit();
		resp.sendRedirect("listUserAlerts");
	}
	
}

