<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="cn.nfu.pts.bean.TimerAction"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="org.w3c.dom.*" %>
<%@ page import="cn.nfu.pts.util.XMLUtil"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Set"%>
<%@ page import="cn.nfu.pts.bean.TemplateType"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Filter"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Role"%>
<%@ page import="cn.nfu.pts.bean.Action"%>
<%@ page import="cn.nfu.pts.bean.Timer"%>

<%@ include file="../filterManage/initMain.function.jsp"%>

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

	DataAccessSession das = DataAccessFactory.getInstance().getSysDas();
	
	UUID statId= null;
	String statIdStr = request.getParameter("statId");
	
	if(statIdStr == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.param_error));
		return;
	}
	statId = DataAccessFactory.getInstance().createUUID(statIdStr);
	
	if(statId == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.param_error));
		return;
	}
	
	TimerAction timerAction = das.queryTimerAction(statId);
	Document document = XMLUtil.string2Document(timerAction.getParam(), "UTF-8");
	
	Node rootNode = XMLUtil.getSingleNode(document, "root");
	
	String templateIdStr = XMLUtil.getSingleNodeTextContent(rootNode, "templateId");
	UUID templateId = DataAccessFactory.getInstance().createUUID(templateIdStr);
	
	Node whereNode = XMLUtil.getSingleNode(rootNode, "queryCondition/where");
	
	Map<String, Set<Object>> whereFieldMap = getWhereFieldMap(whereNode);
	Node conditionsNode = document.createElement("conditions");
	Node queryConditionNode = XMLUtil.getSingleNode(rootNode, "queryCondition");
	XMLUtil.setAttribute(conditionsNode, "betweenField", XMLUtil.getAttribute(queryConditionNode, "betweenField"));
	for(String fieldId : whereFieldMap.keySet())
	{
		if(fieldId == null)
			continue;
		Node fieldNode = document.createElement("field");
		String fieldContent = queryFieldHTML(das,templateId,fieldId,whereFieldMap,null,null,0);
		Node fieldIdNode =document.createElement("fieldId");
		Node fieldContentNode = document.createElement("fieldContent");
		fieldIdNode.setTextContent(fieldId);
		fieldContentNode.setTextContent(fieldContent);
		fieldNode.appendChild(fieldIdNode);
		fieldNode.appendChild(fieldContentNode);
		conditionsNode.appendChild(fieldNode);	
	}
	rootNode.appendChild(conditionsNode);
	rootNode.removeChild(XMLUtil.getSingleNode(rootNode, "queryCondition"));
	
	String xml = XMLUtil.document2String(document, "UTF-8");
	out.println(xml);
%>