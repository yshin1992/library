package com.library.servlet.frame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;

@WebServlet(name="menu",urlPatterns="/manager/menu.do")
public class MenuServlet extends HttpServlet
{

    private static final long serialVersionUID = -1497530680068072449L;

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(UrlConstants.FRAME_MENU_PAGE).forward(request, response);
    }
    
}
