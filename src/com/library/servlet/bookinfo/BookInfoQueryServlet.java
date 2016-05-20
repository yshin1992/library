package com.library.servlet.bookinfo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;

@WebServlet(name="bookinfo",urlPatterns="/manager/bookinfo.do")
public class BookInfoQueryServlet extends HttpServlet
{
    private static final long serialVersionUID = -7308508207643760481L;
    
    @Override
    protected void doGet(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException
    {
        req.getRequestDispatcher(UrlConstants.BOOKINFO_PAGE).forward(req, resp);
    }

}
