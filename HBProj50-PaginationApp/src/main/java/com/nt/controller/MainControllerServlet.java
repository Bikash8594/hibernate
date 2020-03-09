package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmployeeMgmtServiceImpl;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	
	EmployeeMgmtService  service=null;
	@Override
	public void init() throws ServletException {
	    //create Service class object
		service=new EmployeeMgmtServiceImpl();
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   int pageSize=0;
	   int pageNo=0;
	   int pagesCount=0;
	   List<EmployeeDTO> listDTO=null;
	   RequestDispatcher rd=null;
	   HttpSession ses=null;
	   
		//read form data
	   if(req.getParameter("s1")!=null) {
	      pageSize=Integer.parseInt(req.getParameter("pageSize"));
	      ses=req.getSession(true);
	      ses.setAttribute("pageSize",pageSize);
	   }
	   else {
		   ses=req.getSession(false);
		   pageSize=(Integer)ses.getAttribute("pageSize");
	   }
	   
	   if(req.getParameter("pageNo")==null || req.getParameter("pageNo").equalsIgnoreCase(""))
		   pageNo=1;
	   else
		   pageNo=Integer.parseInt(req.getParameter("pageNo"));
	   //use service
	   pagesCount=service.fetchPagesCount(pageSize);
	   listDTO=service.fetchReportData(pageNo, pageSize);
	   //keep results in request scope
	   req.setAttribute("pagesCount",pagesCount);
	   req.setAttribute("listDTO",listDTO);
	   //forward to report.jsp
	   rd=req.getRequestDispatcher("/report.jsp");
	   rd.forward(req,res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
	
	@Override
	public void destroy() {
	     service=null;
	}

}
