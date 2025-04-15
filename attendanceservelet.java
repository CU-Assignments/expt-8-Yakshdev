import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AttendanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String name = request.getParameter("student_name");
        String date = request.getParameter("date");
        String status = request.getParameter("status");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/yourDB", "root", "password");

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO attendance(student_name, date, status) VALUES (?, ?, ?)");
            ps.setString(1, name);
            ps.setString(2, date);
            ps.setString(3, status);

            int i = ps.executeUpdate();
            if (i > 0) {
                out.println("<h3>Attendance recorded successfully!</h3>");
            } else {
                out.println("<h3>Error saving attendance.</h3>");
            }
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        }
    }
}
