package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.StoreMgmtService;
import com.nt.service.StoreMgmtServiceImpl;

public class MainControllerServlet extends HttpServlet {
     private  StoreMgmtService service;
     
     @Override
    public void init() throws ServletException {
         service=new StoreMgmtServiceImpl();
    }
     
     @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         int pid=0;
         Object obj[]=null;
         RequestDispatcher rd=null;
    	 //read form data
         pid=Integer.parseInt(req.getParameter("pid"));
         try {
         //use service
         obj=service.showCompleProductDetails(pid);
         //keep data in request scope
           req.setAttribute("results",obj);
           //forward to show_product.jsp
           rd=req.getRequestDispatcher("/show_product.jsp");
           rd.forward(req,res);
           
         }//try
         catch(Exception e) {
        	 rd=req.getRequestDispatcher("/error.jsp");
        	 rd.forward(req,res);
         }
    }
     
     @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
          doGet(req,res);
    }
     
     @Override
    public void destroy() {
      service=null;
    
    }
	  
}
