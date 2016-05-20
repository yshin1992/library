
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

@WebServlet(name = "booktypeadd", urlPatterns = "/manager/booktypeadd.do")
public class BookTypeAddServlet extends HttpServlet
{
    private static final long serialVersionUID = -409390450739993261L;

    private Logger logger = Logger.getLogger(BookTypeAddServlet.class);

    private BookTypeService<BookType> bookTypeService = new BookTypeServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        String result = "failure";
        try
        {
            BookType bookType = (BookType) Map2BeanUtil.stringMap2Object(req.getParameterMap(), BookType.class);
            Integer id = bookTypeService.addBookType(bookType);
            if (id != null)
            {
                result = String.valueOf(id);
            }
        }
        catch (InstantiationException | IllegalAccessException | InvocationTargetException e)
        {
            logger.error("类型转换出错！");
            e.printStackTrace();
        }
        resp.getWriter().println(result);
        resp.getWriter().flush();
    }

}
