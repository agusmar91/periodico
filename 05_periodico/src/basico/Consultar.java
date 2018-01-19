package basico;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp.DriverManagerConnectionFactory;

/**
 * Servlet implementation class Consultar
 */
@WebServlet("/Consultar")
public class Consultar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consultar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "jdbc:mysql://localhost:3306/periodico";
		String user = "root";
		String pass = "";
		
		//request.getRequestDispatcher("/leer.jsp").forward(request, response);
		
		try {
			
			PrintWriter writerA = response.getWriter();
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,user,pass); 
			
			Statement st = conn.createStatement();
			ResultSet rs =  st.executeQuery("select * from noticias");
			
			String resultado ="";
			
			while(rs.next()) {
				String id = rs.getString(1);
				String titulo = rs.getString(2);
				String contenido = rs.getString(3);
				String fecha = rs.getString(4);
				resultado +="<tr><td>"+id+"</td><td>"+ titulo+ "</td><td> "+contenido+"</td><td>"+fecha+"</td><tr>";
				
			}			
			request.getSession().setAttribute("mensaje", resultado);
			response.sendRedirect("leer.jsp");
			
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
