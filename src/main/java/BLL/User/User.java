package BLL.User;

import java.sql.ResultSet;

public abstract class User {
    private String firstname, lastname, middlename, address_line_1,
            address_line_2, date_of_birth,email_address,
            joining_date,city,province,postal_code,contact,email, ssn_no;

    public User (){

    }
    public void CreateInstance(ResultSet rs){

    }

    void login(){

    }

    void logout(){

    }
}
