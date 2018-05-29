package com.cyt.jsp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cyt.jsp.dao.IUserDao;
import com.cyt.jsp.dao.impl.UserDaoImpl;
import com.cyt.jsp.entity.User;

@WebServlet(name="login",urlPatterns="/user/login")
public class LoginServlet extends HttpServlet {
	IUserDao ud = new UserDaoImpl();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//设置请求编码
		//req.setCharacterEncoding("utf-8");
		//接收登录的用户名和密码
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		//根据用户名验证用户是否存在
		User user = ud.selectUserByName(name);
		//接收是否记住密码
		String flag = req.getParameter("flag");
		
		if (user != null) {
			//用户存在，判断密码
			if (user.getPassword().equals(pass)) {
				//密码正确
				if ("1".equals(flag)) {
					//创建Cookie
					Cookie c = new Cookie("myUserInfo", user.getUsername()+":"+user.getPassword());
					
					c.setMaxAge(60*60*24*14);
					c.setPath("/");
					
					resp.addCookie(c);
				}
				//获得当前session
				HttpSession hs = req.getSession();
				hs.setAttribute("userInfo", user);
				
				//resp.sendRedirect("/ServeltDemo_02/success?username="+name);
				//resp.sendRedirect("/ServeltDemo_02/success");
				resp.sendRedirect(resp.encodeRedirectUrl(req.getContextPath()+"/book/success"));
			}else {
				//密码不正确
				resp.sendRedirect(req.getContextPath()+"/jsp/day02/login.jsp?info=1");
			}
		}else {
			//用户不存在
			resp.sendRedirect(req.getContextPath()+"/jsp/day02/login.jsp?info=2");
		}
	}
	
}
