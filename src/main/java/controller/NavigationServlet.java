package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WorkOfArt;

/**
 *Larry J Maxwell - ljmaxwell1@dmacc.edu
 *CIS175 - Spring 2022
 *Mar 2, 2022
 *
 */

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WorkOfArtHelper dao = new WorkOfArtHelper();
		String act = request.getParameter("doThisToItem");

		// after all changes, we should redirect to the viewAllItems servlet
		// The only time we don't is if they select to add a new item or edit
		String path = "/viewAllWorksOfArtServlet";

		if (act.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				WorkOfArt itemToDelete = dao.searchForItemById(tempId);
				dao.deleteName(itemToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}

		} else if (act.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				WorkOfArt itemToEdit = dao.searchForItemById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				request.setAttribute("month", itemToEdit.getDatePublished().getMonthValue());
				request.setAttribute("day", itemToEdit.getDatePublished().getDayOfMonth());
				request.setAttribute("year", itemToEdit.getDatePublished().getYear());
				path = "/edit-work-of-art.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}

		} else if (act.equals("add")) {
			path = "/index.html";

		}

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
//
