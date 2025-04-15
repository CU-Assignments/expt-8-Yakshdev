<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<html>
<head><title>Student Attendance</title></head>
<body>
  <h2>Enter Attendance</h2>
  <form action="AttendanceServlet" method="post">
    Student Name: <input type="text" name="student_name"><br>
    Date: <input type="date" name="date"><br>
    Status: 
    <select name="status">
      <option value="Present">Present</option>
      <option value="Absent">Absent</option>
    </select><br>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
