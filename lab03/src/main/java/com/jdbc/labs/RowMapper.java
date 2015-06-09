package com.jdbc.labs;

import java.sql.ResultSet;

public interface RowMapper<T> {
    public T mapRow(ResultSet rs);
}
