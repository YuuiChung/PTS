<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="cn.nfu.pts.bean.Template"%>
<%@page import="cn.nfu.pts.bean.Data"%>
<%@page import="cn.nfu.pts.bean.DataAccessAction"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Flow"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Option"%>
<%@ page import="cn.nfu.pts.bean.Action"%>
<%@ page import="cn.nfu.pts.bean.Role"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.bean.Pair"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Arrays"%>
<%@ page import="java.util.Enumeration"%>

<%!private String getJson(String str)
	{
		 String strTemp = str;
         strTemp = strTemp.replaceAll("[","\\[");
         strTemp = strTemp.replaceAll("]", "\\]");
         strTemp = strTemp.replaceAll("{", "\\{");
         strTemp = strTemp.replaceAll("}", "\\}");
         strTemp = strTemp.replaceAll("\\", "\\\\");
        return strTemp;
	}%>

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
	String errorXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><isError>true</isError></root>";
	DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(), keyId);
	
	UUID taskId = DataAccessFactory.getInstance().createUUID(request.getParameter("id"));
	String valueStr = request.getParameter("value");
	
	Data data = das.queryData(taskId);
	if(data == null){
		out.println(ErrorManager.getErrorXml(ErrorType.data_not_found_inDb));
		return;
	}
	
	if(data.getChangeLogs().length == 0){
		return;
	}
	
	//备份data
	data = (Data)data.clone();
	
	Map<String, Pair<Object, Object>> baseValueMap = new LinkedHashMap<String, Pair<Object, Object>>();
	Map<UUID, Pair<Object, Object>> extValueMap = new LinkedHashMap<UUID, Pair<Object, Object>>();
	
	Template template = das.queryTemplate(data.getTemplateId());
	Field priorityField = template.getField("修改优先级");
	if(priorityField == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.param_error));
		return;
	}	
	
	data.setObject("logCreateUser", key.getUsername());
	
	String actionIdStr = "48";
	if(actionIdStr != null && actionIdStr.length() == 0){
		actionIdStr = null;
	}
	
	if(actionIdStr != null){
		data.setObject("logActionId",DataAccessFactory.getInstance().createUUID(actionIdStr));
	}
	else{
		data.setObject("logActionId", null);
	}
	
	Option fieldValueOption = priorityField.getOption(valueStr);
	UUID oldOptionId = data.getSingleSelection(priorityField.getId());
	extValueMap.put(priorityField.getId(), new Pair<Object, Object>(oldOptionId, fieldValueOption.getId()));
	data.setSingleReference(priorityField.getId(),fieldValueOption.getId());
	data.setObject("logActionComment", null);
	
	data.setObject("logBaseValueMap", baseValueMap);
	data.setObject("logExtValueMap", extValueMap);
	Pair<ErrorCode, String> result = das.modifyData(data);
	if(result.getFirst().equals(ErrorCode.success)){
		das.commitTranscation();
		das.updateCache(DataAccessAction.update, data.getId().getValue(),data);
		out.println(ErrorManager.getCorrectXml());
	}
	else{
		das.rollbackTranscation();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><isError>true</isError>");
		out.println(result.getSecond());
		out.println("</root>");
	}
%>