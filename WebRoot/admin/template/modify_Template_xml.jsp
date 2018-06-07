<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="cn.nfu.pts.bean.DataAccessAction"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>

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

	UUID id = DataAccessFactory.getInstance().createUUID(request.getParameter("id"));
	
	Template template = das.queryTemplate(id);
	if(template == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.template_not_found));
		return;
	}
	
	//备份template
// 	template = (Template)template.clone();
	template.setName(request.getParameter("name"));
	template.setDescription(request.getParameter("description"));
	template.setFlowId(DataAccessFactory.getInstance().createUUID(request.getParameter("flowId")));
	
	ErrorCode errorCode = das.updateTemplate(template);
	if(errorCode.equals(ErrorCode.success)){
		das.updateCache(DataAccessAction.update, template.getId().getValue(),template);
		out.println(ErrorManager.getCorrectXml());
	}else{
		out.println(ErrorManager.getErrorXml(ErrorType.database_update_error));
	}
%>