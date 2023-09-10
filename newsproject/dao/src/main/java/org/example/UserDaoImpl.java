package org.example;

import org.example.exception.DuplicateValueException;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(User user) throws DuplicateValueException, NullPointerException {
        Connection connection = JDBCUtils.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name,pass,role_id) values (?,?,?)");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPass());
            preparedStatement.setInt(3, user.getRole_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new DuplicateValueException("name", e);
        }
        return true;
    }

    @Override
    public User getUser(int id) {

        return null;
    }

    @Override
    public User getUser(String name) {
        User u = new User();
        Connection conn = JDBCUtils.getConnection();
        PreparedStatement st = null;
        try {
            st =conn.prepareStatement("select * from users where name=?",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            st.setString(1,"admin");
            st.executeQuery();
            st.setString(1,name);
            ResultSet resultSet = st.getResultSet();
            if(resultSet==null){
                return null;
            }
            resultSet.first();
            String username = resultSet.getString("name");
            String pass = resultSet.getString("pass");
            int id = resultSet.getInt("id");
            int role_id = resultSet.getInt("role_id");
            u.setId(id);
            u.setRole_id(role_id);
            u.setPass(pass);
            u.setName(username);
            st.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public Role getUserRole(String name) {
        return getUserRole(getUser(name));
    }

    @Override
    public Role getUserRole(User user) {
        if (user.getRole_id() == Role.ADMIN_ID) {
            return new Role(Role.ADMIN_ID, "role_admin");
        }
        return new Role(Role.USER_ID, "role_user");

    }

    @Override
    public Role getUserRole(int id) {

        return null;
    }
}
