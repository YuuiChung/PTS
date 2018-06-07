<%@ page language="java" contentType="text/xml; charset=UTF-8"%>

<%@page import="cn.nfu.pts.bean.Key"%>
<%@page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@page import="cn.nfu.pts.service.DataAccessSession"%>
<%@page import="cn.nfu.pts.util.ConfigUtil"%>
  
<%
  	response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
  response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
  response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
  response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

  out.clear();

  Long keyId = (Long)session.getAttribute("kid");
  Key key = (Key)session.getAttribute("key");

  if(keyId == null || keyId <= 0 || key == null){
  	response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
  	return;
  }

  String[] userArray = request.getParameterValues("user");
  if(userArray == null || userArray.length == 0){
  	response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
  	return;
  }

  DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(), keyId);

  for(String user : userArray){
  	das.removeRelatedUser(key.getUsername());
  }

  out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><success>true</success>");
  %>