package cn.et.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.et.web.conf.News;
import cn.et.web.service.NewsService;


public class AddNewsController extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter pWriter=response.getWriter();
        
        //获取容器对象
        ApplicationContext aContext=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        
        NewsService service=(NewsService) aContext.getBean("newsServiceImpl");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String time=dateFormat.format(date);
        
        service.insertNews(title, content, time);
        
        response.getWriter().write("添加新闻成功");
        
        pWriter.write("<script>alert('添加新闻成功')</script>");  
        
        response.setHeader("refresh", "1;url="+request.getContextPath()+"/addNews.html");
     
	}

}
