package org.example;

import org.example.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewDaoImpl implements NewDao {
    @Override
    public boolean addNews(News n) throws SQLException {
     Connection conn=JDBCUtils.getConnection();
     PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO news(imageaddress,newstext) values(?,?)");


    preparedStatement.setString(1,n.getFilepath());
    preparedStatement.setString(2,n.getTitle());
    preparedStatement.executeUpdate();
    preparedStatement.close();
    conn.close();
    return  true;
    }

    @Override
    public List<News> getNewsList() {
       List<News> news=new  ArrayList<>();
       Connection conn=JDBCUtils.getConnection();
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM news order by id desc");
            if(resultSet==null){
                return null;
            }
            while(resultSet.next()){
                News n = new News();
                n.setId(resultSet.getInt("id"));
                n.setFilepath(resultSet.getString("imageaddress"));
                n.setTitle(resultSet.getString("newstext"));
                news.add(n);
            }
            st.close();
conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
return news;
    }
}
