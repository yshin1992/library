
package com.library.servlet.booktype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;
import com.library.domain.BookType;
import com.library.service.BookTypeService;
import com.library.service.impl.BookTypeServiceImpl;

import net.sf.json.JSONArray;

@WebServlet(name = "booktype", urlPatterns = "/manager/booktype.do")
public class BookTypeServlet extends HttpServlet
{

    private static final long serialVersionUID = 3107566456251287582L;

    private BookTypeService<BookType> bookTypeService = new BookTypeServiceImpl();

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        //初始化查询出所有的一级分类
        request.setAttribute("bookTypeList", bookTypeService.queryListByLevel(1));
        request.getRequestDispatcher(UrlConstants.BOOKTYPE_PAGE).forward(request, response);
    }
    
    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        String parentId = request.getParameter("pid");
        //当点击上一级分类时，查询出所有的下一级分类
        Integer pid = parentId == null ? 1 : Integer.parseInt(parentId);
        //防止中文乱码
        response.setContentType("text/html; charset=utf-8"); 
        response.getWriter().println(JSONArray.fromObject(bookTypeService.queryListByPID(pid)));
        response.getWriter().flush();
    }
}