package com.jdbc.labs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RowMapperEmployee implements RowMapper<Employee> {

    @Override
    public Employee mapRow(ResultSet rs) {
        Employee employee = new Employee();
        try {
            employee.setId(rs.getLong(1));
            employee.setName(rs.getString(2));
            employee.setSalary(rs.getDouble(3));
            return employee;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            return null;
            //e.printStackTrace();
        }
    }
}
