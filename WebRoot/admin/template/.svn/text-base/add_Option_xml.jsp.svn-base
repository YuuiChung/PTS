<%@page import="cn.nfu.pts.util.CynthiaUtil"%>
<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="cn.nfu.pts.bean.DataAccessAction"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="cn.nfu.pts.bean.TemplateOperateLog"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Option"%>
<%@ page import="cn.nfu.pts.bean.Option.Forbidden"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Key"%>

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
	
	UUID fieldId = DataAccessFactory.getInstance().createUUID(request.getParameter("fieldId"));
	
	Field field = template.getField(fieldId);
	
	String fieldXmlBefore = field.toXMLString();
	
	if(field == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.field_update_error));
		return;
	}
	
	Option option = field.addOption();
	if(option == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.field_update_error));
		return;
	}
	
	option.setName(request.getParameter("name"));
	option.setDescription(request.getParameter("description"));
	option.setForbidden(Forbidden.f_permit);
	
	String controlOptionIdStr = request.getParameter("controlOptionId");
	if(controlOptionIdStr != null)
		option.setControlOptionId(DataAccessFactory.getInstance().createUUID(controlOptionIdStr));
	
	ErrorCode errorCode = das.updateTemplate(template);
	if(errorCode.equals(ErrorCode.success)){
		das.updateCache(DataAccessAction.update, template.getId().getValue(),template);
		
		//记录修改日志
		TemplateOperateLog tol = new TemplateOperateLog();
		tol.setTemplateId(templateId.getValue());
		tol.setFieldId(field.getId().getValue());
		tol.setFieldName(field.getName());
		tol.setOperateType(TemplateOperateLog.MODIFY);
		tol.setCreateTime(Timestamp.valueOf(CynthiaUtil.toLocalDateString(null)));
		tol.setCreateUser(key.getUsername());
		tol.setBefore(fieldXmlBefore);
		tol.setAfter(field.toXMLString());
		das.addTemplateOpreateLog(tol);
		
		out.println(ErrorManager.getCorrectXml());
	}else{
		out.println(ErrorManager.getErrorXml(ErrorType.database_update_error));
	}
%>