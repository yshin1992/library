package com.library.servlet.frame;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;

@WebServlet(name="head",urlPatterns="/manager/head.do")
public class HeadServlet extends HttpServlet
{

    private static final long serialVersionUID = 3107566456251287582L;

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(UrlConstants.FRAME_HEAD_PAGE).forward(request, response);
    }

}
