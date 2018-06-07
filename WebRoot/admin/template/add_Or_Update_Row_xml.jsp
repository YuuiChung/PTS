<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="cn.nfu.pts.bean.TemplateOperateLog"%>
<%@page import="cn.nfu.pts.dao.FieldNameAccessSessionMySQL"%>
<%@page import="cn.nfu.pts.cache.impl.FieldNameCache"%>
<%@page import="cn.nfu.pts.dao.FieldNameMapMySQL"%>
<%@page import="cn.nfu.pts.bean.DataAccessAction"%>
<%@ page contentType="text/xml; charset=UTF-8" %>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.util.ArrayUtil"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Field.Type"%>
<%@ page import="cn.nfu.pts.bean.Field.DataType"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.LinkedHashSet"%>
<%@ page import="java.util.Arrays"%>

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
	
	UUID templateId = DataAccessFactory.getInstance().createUUID(request.getParameter("templateId"));
	
	Template template = das.queryTemplate(templateId);
	
	if(template == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.template_not_found));
		return;
	}
	
	//备份template
// 	template = (Template)template.clone();
	String flag = request.getParameter("flag");
	if("remove".equals(flag))
	{
		int rowIndex = Integer.parseInt(request.getParameter("rowIndex"));
		template.removeFieldRow(rowIndex);
	}else if("add".equals(flag))
	{
		int rowIndex = Integer.parseInt(request.getParameter("rowIndex"));
		int columnCount = Integer.parseInt(request.getParameter("columnCount"));
		template.addFieldRow(rowIndex, columnCount);
	}
	
	ErrorCode errorCode = das.updateTemplate(template);
	if(errorCode.equals(ErrorCode.success)){
		das.updateCache(DataAccessAction.update, template.getId().getValue(), template);
		out.println(ErrorManager.getCorrectXml());
	}
	else{
		out.println(ErrorManager.getErrorXml(ErrorType.database_update_error));
	}
	
	
%>