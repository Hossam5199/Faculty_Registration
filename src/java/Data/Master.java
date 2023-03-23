package Data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Master extends HttpServlet {

    private PreparedStatement pstmt;

    @Override
    public void init() throws ServletException {
        initializejdbc();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html ; charset=UTF-8");
        PrintWriter out = response.getWriter();
// Obtain parameters from the client

        try {
            String depart = request.getParameter("dep");
            String diploma = request.getParameter("diploma");
            String Name = request.getParameter("name");
            String father = request.getParameter("Father");
            String birth = request.getParameter("Birth");
            String vilage = request.getParameter("Viage");
            String center = request.getParameter("center");
            String govern = request.getParameter("Governorate");
            String Nat = request.getParameter("Nationality");
            String relg = request.getParameter("rel");
            String ID = request.getParameter("id");
            String Place = request.getParameter("place");
            String Date = request.getParameter("date");
            String Rec = request.getParameter("recruiting");
            String Job = request.getParameter("job");
            String add = request.getParameter("address");
            String Phone = request.getParameter("phone");
            String Bak = request.getParameter("bak");
            String Role = request.getParameter("role");
            String over = request.getParameter("overall");
            String Spcial = request.getParameter("spcial");
            String faculty = request.getParameter("Faculty");
            String universty = request.getParameter("Universty");
            String deploma = request.getParameter("deploma");
            String r = request.getParameter("r");
            String s = request.getParameter("s");
            String o = request.getParameter("o");
            String f = request.getParameter("f");
            String v = request.getParameter("v");
            String d = request.getParameter("d");

            //out.println("your name is"+firstName);
            storeStudent(depart, diploma, Name, father, birth, vilage, center, govern, Nat, relg, ID, Place, Date, Rec, Job, add, Phone, Bak, Role, over, Spcial, faculty, universty, deploma, r, s, o, f, v, d);
            //out.println(firstName + " " + lastName
                   // + " is now registered in the database");

        } catch (Exception ex) {
            out.println("Error: " + ex.getMessage());
        } finally {
            out.close(); // Close stream
        }
    }

    private void initializejdbc() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/postgraduate", "root", "");
            System.out.println("Database connected");
            
            pstmt = con.prepareStatement("INSERT INTO master " + "(depart , diploma , name , father , birth , vilage , center , govern , nat , rel, id, place, date, recruiting, job, address, phone, bak, role, overall, spcial, faculty, university, deploma , r, s, o, f, v, d) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        } catch (Exception ex) {
            System.out.println("Error..." + ex.getMessage());
        }
    }

    private void storeStudent(String depart, String diploma, String name, String father, String birth, String vilage, String center, String govern, String Nat, String relg, String ID, String Place, String Date, String Rec, String Job, String add, String Phone, String Bak, String Role, String over, String Spcial, String faculty, String universty, String deploma, String r, String s, String o, String f, String v, String d) throws SQLException {
        pstmt.setString(1, depart);
        pstmt.setString(2, diploma);
        pstmt.setString(3, name);        
        pstmt.setString(4, father);
        pstmt.setString(5, birth);
        pstmt.setString(6, vilage);
        pstmt.setString(7, center);
        pstmt.setString(8, govern);
        pstmt.setString(9, Nat);
        pstmt.setString(10, relg);
        pstmt.setString(11, ID);
        pstmt.setString(12, Place);
        pstmt.setString(13, Date);
        pstmt.setString(14, Rec);
        pstmt.setString(15, Job);
        pstmt.setString(16, add);
        pstmt.setString(17, Phone);
        pstmt.setString(18, Bak);
        pstmt.setString(19, Role);
        pstmt.setString(20, over);
        pstmt.setString(21, Spcial);
        pstmt.setString(22, faculty);
        pstmt.setString(23, universty);
        pstmt.setString(24, deploma);
        pstmt.setString(25, r);
        pstmt.setString(26, s);
        pstmt.setString(27, o);
        pstmt.setString(28, f);
        pstmt.setString(29, v);
        pstmt.setString(30, d);
        pstmt.executeUpdate();
    }

}
