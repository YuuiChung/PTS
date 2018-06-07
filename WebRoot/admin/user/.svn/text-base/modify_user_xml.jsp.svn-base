<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="cn.nfu.pts.bean.UserInfo.UserRole"%>
<%@page import="cn.nfu.pts.bean.UserInfo"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="java.util.HashMap" %>

<%
	response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
	response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

	out.clear();

	Key key = (Key)session.getAttribute("key");
	Long keyId = (Long)session.getAttribute("kid");

	if(keyId == null || keyId <= 0 || key == null){
		response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
		return;
	}

	DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(), keyId);

	String nameStr = request.getParameter("name");
	String emailStr = request.getParameter("email");
	String userRole = request.getParameter("userRole");
	String password = request.getParameter("password");
	if(emailStr == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.param_error));
		return;
	}
	
	UserInfo userInfo = das.queryUserInfoByUserName(emailStr);
	if(userInfo == null){
		out.println(ErrorManager.getErrorXml(ErrorType.user_not_fount));
		return;
	}
	
	userInfo.setNickName(nameStr);
	userInfo.setUserRole(UserRole.valueOf(userRole));
	userInfo.setUserPassword(password);
	 
	if(das.updateUserInfo(userInfo))
		out.println(ErrorManager.getCorrectXml());
	else
		out.println(ErrorManager.getErrorXml(ErrorType.database_update_error));
%>