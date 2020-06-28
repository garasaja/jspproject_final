package com.cos.blog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.action.Action;
import com.cos.blog.action.product.ProductChatAction;
import com.cos.blog.action.product.ProductDetailAction;
import com.cos.blog.action.product.ProductRegisterAction;
import com.cos.blog.action.product.ProductRegisterProcAction;
import com.cos.blog.action.product.ProductShopAction;
import com.cos.blog.action.product.ProductUpdateAction;
import com.cos.blog.action.product.ProductUpdateProcAction;




// http://localhost:8000/blog/user
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private final static String TAG = "productController : ";
	private static final long serialVersionUID = 1L;
       
    public ProductController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://localhost:8000/blog/user?cmd=join
		String cmd = request.getParameter("cmd");
		System.out.println(TAG+"router : "+cmd);
		Action action = router(cmd);
		action.execute(request, response);
	}
	
	public Action router(String cmd) {
		 if(cmd.equals("register")) {			
			return new ProductRegisterAction();
		}else if(cmd.equals("registerProc")) {			
			return new ProductRegisterProcAction();
		}else if(cmd.equals("update")) {			
			return new ProductUpdateAction();
		}else if(cmd.equals("updateProc")) {			
			return new ProductUpdateProcAction();
		}else if(cmd.equals("detail")) {			
			return new ProductDetailAction();
		}else if(cmd.equals("chat")) {			
			return new ProductChatAction();
		}else if(cmd.equals("shop")) {			
			return new ProductShopAction();
		}
		return null;
	}
	

}




