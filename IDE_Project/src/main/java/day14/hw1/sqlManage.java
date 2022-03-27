package day14.hw1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class sqlManage {

    private Connection con = null;

    public sqlManage() throws SQLException, ClassNotFoundException {

        //load database driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Database Driver connect successfully! ");

        //connect my database
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-practice", "root", "J8e5n171455048");
        System.out.println("Database connect successfully! ");
    }

//    public void insertEmployee(Employee employee) throws SQLException {
//        String sql = "insert into employee(id, first_name, last_name) value(?,?,?)";
//        //preparedStatement can pre-compile sql statements, which prevents SQL injection and improves security
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, employee);
//    }
}
