<%@page import="cn.nfu.pts.bean.UserInfo.UserRole"%>
<%@page import="cn.nfu.pts.bean.UserInfo"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.util.ArrayUtil"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Stat"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="java.util.TreeMap"%>

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
	
	StringBuffer xmlb = new StringBuffer(64);
	xmlb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	xmlb.append("<root>");
	xmlb.append("<isError>false</isError>");
	UserInfo userInfo = das.queryUserInfoByUserName(key.getUsername());
	if(userInfo != null && userInfo.getUserRole().equals(UserRole.super_admin))
	{
		xmlb.append("<isSuperAdmin>true</isSuperAdmin>");
	}else
	{
		xmlb.append("<isSuperAdmin>false</isSuperAdmin>");
	}
	
	xmlb.append("</root>");
		
	out.println(xmlb.toString());
%>