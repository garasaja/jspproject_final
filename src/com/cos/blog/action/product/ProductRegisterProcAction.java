package com.cos.blog.action.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.action.Action;
import com.cos.blog.model.Product;
import com.cos.blog.model.Users;
import com.cos.blog.repository.ProductRepository;
import com.cos.blog.util.Script;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class ProductRegisterProcAction implements Action{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 0번 인증 확인
				HttpSession session = request.getSession();
				if(session.getAttribute("principal") == null) {
					Script.getMessage("잘못된 접근입니다.", response);
					return; //여기서 return이 었으면 코드를 아래를 타고 내려간다.
				}
				Users principal = (Users)session.getAttribute("principal");
				
				if
				(
					request.getParameter("ptitle") == null ||
					request.getParameter("ptitle").equals("") ||
					request.getParameter("category") == null ||
					request.getParameter("category").equals("") ||
					request.getParameter("pplace") == null || 
					request.getParameter("pplace").equals("") ||
					request.getParameter("pprice") == null ||
					request.getParameter("pprice").equals("") ||
					request.getParameter("pcontent") == null ||
					request.getParameter("pcontent").equals("") ||
					request.getParameter("pprofile") == null ||
					request.getParameter("pprofile").equals("")
						
				) {
					return;
				}
				
		
		String ptitle = request.getParameter("ptitle");
		String category = request.getParameter("category");
		String pplace = request.getParameter("pplace");
		int pprice = Integer.parseInt(request.getParameter("pprice"));
		String pcontent = request.getParameter("pcontent");
		String pprofile = request.getParameter("pprofile");
		
		String realPath = 
				request.getServletContext().getRealPath("image");
		int pid;
		String fileName = null;
		String contextPath = request.getServletContext().getContextPath();
		String userProfile = null; //DB에 들어갈 변수 : 위치
		
		System.out.println("realPath : "+realPath);
		System.out.println("contextPath : "+contextPath);
		
		try {
			MultipartRequest multi = new MultipartRequest
					(
						request, 
						realPath,
						1024*1024*2,
						"UTF-8",
						new DefaultFileRenamePolicy()
					);
			fileName = multi.getFilesystemName("productProfile");
			System.out.println("fileName : "+fileName);
			pid = Integer.parseInt(multi.getParameter("pid"));
			
			userProfile = contextPath+"/image/"+fileName;
		}catch (Exception e) {
			e.printStackTrace();
			Script.getMessage("오류 : "+e.getMessage(), response);
		}
		Product product = Product.builder()
				.puserId(principal.getId())
				.ptitle(ptitle)
				.pcategory(category)
				.pplace(pplace)
				.pprice(pprice)
				.pcontent(pcontent)
				.pprofile(pprofile)
				.preadCount(0)
				.build();
		
		// 4번 BoardRepository연결해서 save(board)함수 호출
		ProductRepository productRepository = 
				ProductRepository.getInstance();
		int result = productRepository.register(product);
		
		// 5번 result == 1이면 성공로직(index.jsp로 이동)
		// 6번 result != 1이면 실패로직(history.back())
		if(result == 1) {
			Script.href("글쓰기 성공", "index.jsp", response);
		}else {
			Script.back("글쓰기에 실패하였습니다.", response);
		}
	
		
		
			
			
		 
	}
}
