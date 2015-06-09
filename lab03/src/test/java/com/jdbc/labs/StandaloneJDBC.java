package com.jdbc.labs;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;

public class StandaloneJDBC {

    private static final String UNAME = "root";
    private static final String PASS = "password";
    private static final String SERVER = "localhost";
    private static final String PORT = "3306";
    private static final String DB = "springcourse";
    private Connection conn = null;
    private Statement stmt = null;
    
    @Before
    public void setUp() throws Exception {
        conn = getConnection();
    }

    @Test
    public void testConnection() {
        try {
            assertNotNull(conn);
        } catch (Exception e) {
            fail("cannot connect!");
        }
    }

    
    @Test
    public void insertEmployee(){
        try {
            assertNotNull(insertEmployee(1L,"Arthur Dent",3000D) != 0);
        } catch (Exception e) {
            fail("cannot insert!");
            e.printStackTrace();
        }
    }
    
    @Test
    public void showAllEmployee(){
        try {
            List<Employee> le = executeQuery("select id, name, salary from Employee",new RowMapperEmployee());
            for(Employee emp : le){
                System.out.println(emp.toString());
            }
            assertEquals(le.size(),1);
        } catch (Exception e) {
            //fail("cannot insert!");
            e.printStackTrace();
        }
    }
    
    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    private Connection getConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        Properties connectionProps = new Properties();
        connectionProps.put("user", UNAME);
        connectionProps.put("password", PASS);

        System.out.println("jdbc:mysql://" + SERVER + ":" + PORT + "/" + DB);
        conn = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT + "/" + DB, connectionProps);
        System.out.println("Connected to database");
        return conn;
    }
    
    private int insertEmployee(Long id, String name, Double salary) throws SQLException{
        stmt = conn.createStatement();
        String sql = String.format("insert into Employee values (%d,'%s',%f)",id, name, salary);
        System.out.println(sql);
        int count = stmt.executeUpdate(sql);
        stmt.close();
        return count;
    }
    
    private List<Employee> executeQuery(String sql, RowMapper rowMapper) throws SQLException{
        stmt = conn.createStatement();
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        List<Employee> lemployee = new ArrayList<Employee>();
        while(rs.next()){
            lemployee.add((Employee) rowMapper.mapRow(rs));
        }
        stmt.close();
        rs.close();
        return lemployee;
    }

   
}
