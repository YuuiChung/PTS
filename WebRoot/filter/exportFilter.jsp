<%@page import="cn.nfu.pts.service.ExportDataManager"%>
<%@page import="cn.nfu.pts.util.CynthiaUtil"%>
<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"%>

<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.text.SimpleDateFormat"%>

<%@ page import="org.apache.commons.httpclient.HttpClient"%>
<%@ page import="org.apache.commons.httpclient.NameValuePair"%>
<%@ page import="org.apache.commons.httpclient.methods.PostMethod"%>
<%@ page import="org.w3c.dom.*"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@page import="org.apache.poi.xssf.usermodel.XSSFWorkbook"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFCell"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFRow"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFSheet"%>
<%@page import="org.apache.poi.hssf.usermodel.HSSFWorkbook"%>

<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Filter"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.bean.Attachment"%>
<%@ page import="cn.nfu.pts.bean.TemplateType"%>
<%
response.setContentType("application/vnd.ms-excel;charset=UTF-8");
response.setHeader("Content-Disposition","attachment; filename="+CynthiaUtil.getToday()+".xls");

out.clear();
Key key = (Key)session.getAttribute("key");
Long keyId = (Long)session.getAttribute("kid");


if(keyId == null || keyId <= 0 || key == null){
	response.sendRedirect(ConfigUtil.getCynthiaWebRoot() + "user/logou.do?targetUrl=" + ConfigUtil.getTargetUrl(request));
	return;
}
String filterIdStr = request.getParameter("filterId");

String beforeNumStr = request.getParameter("beforeNum"); //前N条数据

int beforeNum = 0;
if(beforeNumStr != null && beforeNumStr.length() > 0){
	try{
		beforeNum = Integer.parseInt(beforeNumStr);	
	}catch(Exception e){
		e.printStackTrace();
	}
}


String[] dataIds = request.getParameterValues("dataIds");

if(filterIdStr == null||"".equals(filterIdStr))
{
	response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
	return;
}

DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(),keyId);
UUID filterId = DataAccessFactory.getInstance().createUUID(filterIdStr);
Filter filter = das.queryFilter(filterId);

if(filter==null)
{
	response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
	return;
}

ExportDataManager.excelExport(das,filter, keyId, key.getUsername(), dataIds, beforeNum , response.getOutputStream());
response.getOutputStream().flush();
response.getOutputStream().close();
%>





















