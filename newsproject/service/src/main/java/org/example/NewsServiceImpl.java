package org.example;

import java.sql.SQLException;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    private static final NewDao newDao;
    static{
        newDao = new NewDaoImpl();

    }

    public NewsServiceImpl() {
    }

    @Override
    public void addNews(String filepath,String title) {
        if (filepath.equals(null) || filepath.isEmpty() || title.equals(null) || title.isEmpty()) {
            throw new NullPointerException("filepath is empty or null");
        }
        News news = new News();
        news.setFilepath(filepath);
        news.setTitle(title);
        try {
            newDao.addNews(news);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<News> getNewsList() {
        return newDao.getNewsList();
    }
}
