package cn.et.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.et.web.conf.News;
import cn.et.web.service.NewsService;


public class MyController extends HttpServlet {
	
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
	    //获取容器对象
		ApplicationContext aContext=WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		NewsService service=(NewsService) aContext.getBean("newsServiceImpl");
		String content=request.getParameter("content");
		List<News> list=service.queryNewsByContent(content);
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
