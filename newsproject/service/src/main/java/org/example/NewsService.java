package org.example;

import java.util.List;

public interface NewsService {
    public void addNews(String filepath,String title);
    public List<News> getNewsList();
}
