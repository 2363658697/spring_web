package cn.et.web.service;

import java.util.List;

import cn.et.web.conf.News;

public interface NewsService {
    /**
     * 根据新闻内容获取新闻
     * 
     * @param content
     *            新闻内容
     * @return List<News>
     */
    public List<News> queryNewsByContent(String content);
    
    public void insertNews(String title,String content,String time);
}
