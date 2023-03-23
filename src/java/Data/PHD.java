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

public class PHD extends HttpServlet {

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
            String Pos = request.getParameter("pos");
            String Rol = request.getParameter("rol");
            String All = request.getParameter("all");
            String Spec = request.getParameter("spec");
            String fac = request.getParameter("Fac");
            String uni = request.getParameter("Uni");
            String Post = request.getParameter("post");
            String Roll = request.getParameter("roll");
            String Each = request.getParameter("each");
            String Speci = request.getParameter("speci");
            String facu = request.getParameter("Facu");
            String univ = request.getParameter("Univ");
            String Depart = request.getParameter("depart");
            //out.println("your name is"+firstName);
            storeStudent(depart, Name, father, birth, vilage, center, govern, Nat, relg, ID, Place, Date, Rec, Job, add, Phone, Bak, Role, over, Spcial, faculty, universty, Pos, Rol, All, Spec, fac, uni, Post, Roll, Each, Speci, facu, univ, Depart);
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
            
            pstmt = con.prepareStatement("INSERT INTO bhd " + "(dep , name , Father , Birth , Viage , center , Governorate, Nationality, rel, id, place, date, recruiting, job, address, phone, bak, role, overall, spcial, Faculty, Universty, pos, rol, full, s, F, U, p, r, e, c, college, v, d) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
        } catch (Exception ex) {
            System.out.println("Error..." + ex.getMessage());
        }
    }

    private void storeStudent(String depart, String Name, String father, String birth, String vilage, String center, String govern, String Nat, String relg, String ID, String Place, String Date, String Rec, String Job, String add, String Phone, String Bak, String Role, String over, String Spcial, String faculty, String universty, String Pos, String Rol, String All, String Spec, String fac, String uni, String Post, String Roll, String Each, String Speci, String facu, String Univ, String Depart) throws SQLException {
        pstmt.setString(1, depart);
        pstmt.setString(2, Name);
        pstmt.setString(3, father);
        pstmt.setString(4, birth);
        pstmt.setString(5, vilage);
        pstmt.setString(6, center);
        pstmt.setString(7, govern);
        pstmt.setString(8, Nat);
        pstmt.setString(9, relg);
        pstmt.setString(10, ID);
        pstmt.setString(11, Place);
        pstmt.setString(12, Date);
        pstmt.setString(13, Rec);
        pstmt.setString(14, Job);
        pstmt.setString(15, add);
        pstmt.setString(16, Phone);
        pstmt.setString(17, Bak);
        pstmt.setString(18, Role);
        pstmt.setString(19, over);
        pstmt.setString(20, Spcial);
        pstmt.setString(21, faculty);
        pstmt.setString(22, universty);
        pstmt.setString(23, Pos);
        pstmt.setString(24, Rol);
        pstmt.setString(25, All);
        pstmt.setString(26, Spec);
        pstmt.setString(27, fac);
        pstmt.setString(28, uni);
        pstmt.setString(29, Post);
        pstmt.setString(30, Roll);
        pstmt.setString(31, Each);
        pstmt.setString(32, Speci);
        pstmt.setString(33, facu);
        pstmt.setString(34, Univ);
        pstmt.setString(35, Depart);
        pstmt.executeUpdate();
    }

}
