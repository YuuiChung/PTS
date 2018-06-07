<%@page import="cn.nfu.pts.util.XMLUtil"%>
<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Role"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
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
	
	UUID flowId = DataAccessFactory.getInstance().createUUID(request.getParameter("flowId"));
	
	Flow flow = das.queryFlow(flowId);
	if(flow == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.flow_not_found));
		return;
	}
	
	HashSet<UUID> actionRoleIdSet = new HashSet<UUID>();
	UUID actionId = DataAccessFactory.getInstance().createUUID(request.getParameter("actionId"));
	Role[] actionRoleArray = flow.queryActionRoles(actionId);
	if(actionRoleArray != null)
	{
		for(Role role : actionRoleArray)
	actionRoleIdSet.add(role.getId());
	}
	
	StringBuffer xmlb = new StringBuffer(64);
	xmlb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	xmlb.append("<root>");
	xmlb.append("<isError>false</isError>");
	xmlb.append("<roles>");
	xmlb.append("<role>");
	xmlb.append("<id>").append(Role.everyoneUUID).append("</id>");
	xmlb.append("<name>").append(XMLUtil.toSafeXMLString(Role.everyoneName)).append("</name>");
	xmlb.append("<right>").append(flow.isActionEveryoneRole(actionId) ? "yes" : "no").append("</right>");
	xmlb.append("</role>");
	
	TreeMap<String, Role> roleMap = new TreeMap<String, Role>();
	Role[] roleArray = flow.getRoles();
	if(roleArray != null)
	{
		for(Role role : roleArray)
	roleMap.put(role.getName(), role);
	}
	
	for(Role role : roleMap.values())
	{
		xmlb.append("<role>");
		
		xmlb.append("<id>").append(role.getId()).append("</id>");
		xmlb.append("<name>").append(XMLUtil.toSafeXMLString(role.getName())).append("</name>");
		xmlb.append("<right>").append(actionRoleIdSet.contains(role.getId()) ? "yes" : "no").append("</right>");
	
		xmlb.append("</role>");
	}
		
	xmlb.append("</roles>");
	
	xmlb.append("</root>");
		
	out.println(xmlb.toString());
%>