package Data;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class admin extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException{ 
// String username=request.getParameter("Username"); 
// String password=request.getParameter("Password"); 

response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<html>");
out.println("<head><title>Servlet JDBC</title></head>");
out.println("<body>");
out.println("<h1>Servlet JDBC</h1>");
out.println("</body></html>");
// connecting to database Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try {
    Class.forName("com.mysql.jdbc.Driver");
}       catch (ClassNotFoundException ex) {
            Logger.getLogger(admin.class.getName()).log(Level.SEVERE, null, ex);
}
    }
}