package controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.WorkOfArt;

/**
 * Servlet implementation class EditWorkOfArtServlet
 */
@WebServlet("/editWorkOfArtServlet")
public class EditWorkOfArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditWorkOfArtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WorkOfArtHelper helper = new WorkOfArtHelper();
		String title = request.getParameter("title");
		String medium = request.getParameter("medium");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException ex) {
			ld = LocalDate.now();
		}
		
		WorkOfArt toUpdate = helper.searchForItemById(tempId);
		toUpdate.setTitle(title);
		toUpdate.setMedium(medium);
		toUpdate.setDatePublished(ld);
		
		helper.updateWorkOfArt(toUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllWorksOfArtServlet").forward(request, response);
	}

}
