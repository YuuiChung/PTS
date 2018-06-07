<%@ page language="java" contentType="text/xml; charset=UTF-8"%>

<%@ page import="cn.nfu.pts.bean.Key"%>
<%@page import="cn.nfu.pts.util.ConfigUtil"%>
<%@page import="cn.nfu.pts.bean.UUID"%>
<%@page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@page import="cn.nfu.pts.service.DataAccessSession"%>
<%@page import="java.util.*"%>

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

String dataIdStr = request.getParameter("dataId");
if(dataIdStr == null || dataIdStr.length() == 0)
	return;

DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(), keyId);
das.deleteFilterUserTasks(DataAccessFactory.getInstance().createUUID(dataIdStr));

%>