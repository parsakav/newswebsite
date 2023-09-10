package org.example;


import org.example.News;

import java.sql.SQLException;
import java.util.List;
public interface NewDao {

    public boolean addNews(News n) throws SQLException;

    public List<News> getNewsList();

}

