package cn.et.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.et.web.conf.News;
import cn.et.web.dao.NewsDao;
import cn.et.web.service.NewsService;

@Repository
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> queryNewsByContent(String content) {
        if(content==null){
            content="";
        }
        return newsDao.queryNewsByContent(content);
    }

    @Override
    public void insertNews(String title, String content, String time) {
        newsDao.insertNews(title, content, time); 
    }

}
