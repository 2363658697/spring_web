package cn.et.web.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import cn.et.web.conf.News;
import cn.et.web.dao.NewsDao;
@Service
public class NewsDaoImpl implements NewsDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<News> queryNewsByContent(String content) {
        
        String sql = "select id,title,content from news where  content like '%" + content + "%'";

        List<News> list = jdbcTemplate.query(sql, new RowMapper<News>() {
            @Override
            public News mapRow(ResultSet rs, int rowNum) throws SQLException {
                News news = new News();
                news.setId(rs.getString("id"));
                news.setTitle(rs.getString("title"));
                news.setContent(rs.getString("content"));
                return news;
            }
        });
        return list;
    }

    @Override
    public void insertNews(String title, String content, String time) {
            String sql="insert into news(title , content , time) values('"+title+"' , '"+content+"' , '"+time+"')";
            jdbcTemplate.execute(sql);
    }

}
