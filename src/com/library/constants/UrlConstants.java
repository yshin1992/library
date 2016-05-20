package com.library.constants;

public class UrlConstants {
	/**
	 * 定义页面跳转的常量
	 */
	public static final String LOGIN_PAGE = "/login.jsp";

	public static final String LOGIN_FAULT_PAGE = LOGIN_PAGE;

	public static final String LOGIN_SUCCESS_PAGE = "/WEB-INF/content/manager/init/frame.html";

	public static final String MANAGER_INFO_PAGE = "/WEB-INF/content/manager/managerinfo.jsp";

	public static final String INIT_UPDATE_PAGE = "/WEB-INF/content/manager/updateMgrInfo.jsp";

	public static final String UPDATE_SUCCESS_PAGE = MANAGER_INFO_PAGE;

	public static final String BOOKTYPE_PAGE = "/WEB-INF/content/booktype/booktype.jsp";

	public static final String BOOKINFO_PAGE = "/WEB-INF/content/bookinfo/bookinfo.jsp";
	/**
	 * Frameset的初始化页面
	 */
	public static final String FRAME_HEAD_PAGE = "/WEB-INF/content/manager/init/head.jsp";

	public static final String FRAME_MENU_PAGE = "/WEB-INF/content/manager/init/menu.jsp";

	public static final String FRAME_MAIN_PAGE = "/WEB-INF/content/manager/init/main.jsp";

	public static final String FRAME_FOOT_PAGE = "/WEB-INF/content/manager/init/foot.jsp";
}
