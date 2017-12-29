package cn.et.web.dao;

import java.util.List;

import cn.et.web.conf.News;



public interface NewsDao {
       /**
        * �����������ݻ�ȡ����
        * @param content ��������
        * @return List<News>
        */
        public List<News> queryNewsByContent(String content);
        
        
        public void insertNews(String title,String content,String time);
}
