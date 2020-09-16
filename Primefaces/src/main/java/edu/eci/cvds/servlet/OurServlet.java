package edu.eci.cvds.servlet;

import java.io.IOException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.eci.cvds.servlet.model.Todo;

@WebServlet(
    urlPatterns = "/servlet"
)

public class OurServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private List<Todo> todoList;
	
	public OurServlet() {
		super();
		todoList = new ArrayList<Todo>();
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String iden = req.getParameter("id");
			if (iden == null) throw new IllegalArgumentException();
			try {
				Todo t = Service.getTodo(Integer.parseInt(iden));	
			
				if (t == null) throw new Exception();
				
				resp.setStatus(HttpServletResponse.SC_OK);
				writeOk(resp.getWriter(), t);
			}catch (IOException ioe) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				writeNotFound(resp.getWriter());
			}catch (NumberFormatException nfe) {
				throw new MalformedURLException();
			}
			
		}catch (MalformedURLException errorURL) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writeInternalServerError(resp.getWriter());
		}catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			writeBadRequest(resp.getWriter());
		}
		
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String iden = req.getParameter("id");
			if (iden == null) throw new IllegalArgumentException();
			try {
				Todo t = Service.getTodo(Integer.parseInt(iden));	
			
				if (t == null) throw new Exception();
				
				resp.setStatus(HttpServletResponse.SC_OK);
				writeOk(resp.getWriter(), t);
			}catch (IOException ioe) {
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
				writeNotFound(resp.getWriter());
			}catch (NumberFormatException nfe) {
				throw new MalformedURLException();
			}
			
		}catch (MalformedURLException errorURL) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			writeInternalServerError(resp.getWriter());
		}catch (Exception e) {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			writeBadRequest(resp.getWriter());
		}
		
	}
	
	private void writeInternalServerError(Writer w) {
		try {
			w.write(new StringBuilder("<h1>")
					.append("500: Internal Server Error")
					.append("</h1>")
					.toString()
					);
		}catch (IOException ioe) {}
	}
	
	private void writeBadRequest(Writer w) {
		try {
			w.write(new StringBuilder("<h1>")
					.append("400: Bad Request!")
					.append("</h1>")
					.toString()
					);
		}catch (IOException ioe) {}
	}
	
	private void writeNotFound(Writer w) {
		try {
			w.write(new StringBuilder("<h1>")
					.append("404: Not Found")
					.append("</h1>")
					.toString()
					);
		}catch (IOException ioe) {}
	}
	
	private void writeOk(Writer w, Todo t) {
		todoList.add(t);
		try {
			w.write(Service.todosToHTMLTable(todoList));
		} catch (IOException e) {}
	}

}
