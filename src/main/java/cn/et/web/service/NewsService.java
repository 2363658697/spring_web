package cn.et.web.service;

import java.util.List;

import cn.et.web.conf.News;

public interface NewsService {
    /**
     * �����������ݻ�ȡ����
     * 
     * @param content
     *            ��������
     * @return List<News>
     */
    public List<News> queryNewsByContent(String content);
    
    public void insertNews(String title,String content,String time);
}
