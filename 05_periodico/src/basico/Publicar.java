package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Publicar
 */
@WebServlet("/Publicar")
public class Publicar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Publicar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String titulo = request.getParameter("titulo");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		String contenido = request.getParameter("contenido");
		
		PrintWriter writerA = response.getWriter();
		String url = "jdbc:mysql://localhost:3306/periodico";
		String user = "root";
		String pass = "";

		PrintWriter out = response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pass);

			String query = "insert into noticias (mail,titulo,id_categoria,contenido) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,email);
			ps.setString(2,titulo);
			ps.setInt(3,categoria);
			ps.setString(4,contenido);
			
			out.println("<a href='leer.jsp'>Volver a noticias</a>");
			System.out.println("Registros---> " + ps.executeUpdate());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
