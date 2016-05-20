
package com.library.servlet.booktype;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.library.domain.BookType;
import com.library.service.BookTypeService;
import com.library.service.impl.BookTypeServiceImpl;
import com.library.util.Map2BeanUtil;

import net.sf.json.JSONObject;

@WebServlet(name = "booktypeupdate", urlPatterns = "/manager/booktypeupdate.do")
public class BookTypeUpdateServlet extends HttpServlet
{
    private static final long serialVersionUID = 3238105215763402257L;

    private Logger logger = Logger.getLogger(BookTypeUpdateServlet.class);

    private BookTypeService<BookType> bookTypeService = new BookTypeServiceImpl();

    public void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        String result = "failure";
        try
        {
            BookType bookType = (BookType) Map2BeanUtil.stringMap2Object(request.getParameterMap(), BookType.class);
            if (bookTypeService.updateBookType(bookType))
            {
                result = String.valueOf(JSONObject.fromObject(bookType));
            }
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            logger.debug("图书类别信息更新失败!");
            e.printStackTrace();
        }
        //防止中文乱码
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().println(result);
        response.getWriter().flush();
    }

}
