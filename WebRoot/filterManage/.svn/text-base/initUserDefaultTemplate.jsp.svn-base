<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.util.ArrayUtil"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Role"%>
<%@ page import="cn.nfu.pts.bean.Action"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.util.XMLUtil"%>
<%@ page import="java.util.*"%>

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
	String userDefaultTemplateId = das.getUserDefaultTemplate(key.getUsername());
	String templateTypeId = null;
	if(userDefaultTemplateId != null && !"".equals(userDefaultTemplateId))
	{
		Template template = das.queryTemplate(DataAccessFactory.getInstance().createUUID(userDefaultTemplateId));
		if (template == null) {
			userDefaultTemplateId = null;
			templateTypeId = null;
		}else{
			templateTypeId = template.getTemplateTypeId().toString();	
		}
	}
	
	StringBuffer xmlb = new StringBuffer(64);
	xmlb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	xmlb.append("<root>");
	xmlb.append("<templateId>").append(userDefaultTemplateId == null?"":userDefaultTemplateId).append("</templateId>");
	xmlb.append("<templateTypeId>").append(templateTypeId == null?"":templateTypeId).append("</templateTypeId>");
	xmlb.append("</root>");
	out.println(xmlb.toString());
%>