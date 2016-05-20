package com.library.servlet.frame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;

@WebServlet(name="main",urlPatterns="/manager/main.do")
public class MainServlet extends HttpServlet
{
    private static final long serialVersionUID = -5283759324547363002L;

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(UrlConstants.FRAME_MAIN_PAGE).forward(request, response);
    }
}
