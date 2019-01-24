package com.douzon.guestbook.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzon.guestbook.dao.GuestbookDao;
import com.douzon.guestbook.vo.GuestbookVo;
import com.douzon.web.WebUtils;

@WebServlet("/gb")
public class GuestbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		//요청 분리(요청식별)
		String action = request.getParameter("a");
		
		if("deleteform".equals(action)) {
			WebUtils.forward(request, response, "/WEB-INF/views/deleteform.jsp");
		} else if("delete".equals(action)) {
			
			String no_string = request.getParameter("no");
			Long no = Long.parseLong(no_string);
			String password = request.getParameter("password");
			
			GuestbookVo vo = new GuestbookVo();
			
			vo.setNo(no);
			vo.setPassword(password);
			
			new GuestbookDao().delete(vo);
			
			WebUtils.redirect(request, response, request.getContextPath()+"/gb");
			
		} else if("add".equals(action)) {

			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestbookVo vo = new GuestbookVo();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestbookDao().insert(vo);
			
			WebUtils.redirect(request, response, request.getContextPath()+"/gb");
			
		} else {
			/* default action : 디폴트 요청 처리 */
			/* list를 보여주면 좋다 = index.jsp */
			GuestbookDao dao = new GuestbookDao();
			List<GuestbookVo> list = dao.getList();
			
			// 데이터를 request 범위에 저장
			request.setAttribute("list", list);
			
			//forwarding
			WebUtils.forward(request, response, "/WEB-INF/views/index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
