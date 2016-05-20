
package com.library.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.constants.UrlConstants;

@WebServlet(name = "managerinfo", urlPatterns = "/manager/managerinfo.do")
public class ManagerInfoServlet extends HttpServlet
{
    private static final long serialVersionUID = -9206895528290277226L;

    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException
    {
        request.getRequestDispatcher(UrlConstants.MANAGER_INFO_PAGE).forward(request, response);
    }
}
