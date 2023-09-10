package org.example.exception;

import java.sql.SQLException;

public class DuplicateValueException extends Exception{
    public DuplicateValueException(String field, SQLException e){
        super("The Database does not ignore a duplicate value for this field: "+field +"/or error is :"+e.getMessage());
    }
}
