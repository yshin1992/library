
package com.library.servlet.booktype;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.domain.BookType;
import com.library.service.BookTypeService;
import com.library.service.impl.BookTypeServiceImpl;

import net.sf.json.JSONObject;

@WebServlet(name = "booktypedetail", urlPatterns = "/manager/booktypedetail.do")
public class BookTypeDetailServlet extends HttpServlet
{
    private static final long serialVersionUID = -2704462784131409898L;

    private BookTypeService<BookType> bookTypeService = new BookTypeServiceImpl();

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        String strId = request.getParameter("id");
        String result = "";
        if (strId != null)
        {
            BookType bookType = new BookType();
            bookType.setId(Integer.parseInt(strId));
            bookType = bookTypeService.queryById(bookType);
            if (bookType != null)
            {
                result = JSONObject.fromObject(bookType).toString();
            }
        }
        //防止中文乱码
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println(result);
        response.getWriter().flush();
    }
}
