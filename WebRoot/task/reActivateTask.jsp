<%@page import="cn.nfu.pts.bean.DataAccessAction"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Data"%>
<%@ page import="cn.nfu.pts.bean.impl.DataImpl"%>
<%@ page import="cn.nfu.pts.bean.ChangeLog"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Field.Type"%>
<%@ page import="cn.nfu.pts.bean.Field.DataType"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.sql.Timestamp"%>
<%@ page import="java.util.LinkedHashMap"%>
<%@ page import="cn.nfu.pts.bean.Pair"%>

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
	
	String taskIdStr = request.getParameter("taskId");
	UUID taskId = DataAccessFactory.getInstance().createUUID(taskIdStr);
	DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(),keyId);
	Data data = das.queryData(taskId);
	
	data = (Data)data.clone();
	data.setCreateTime(new Timestamp(System.currentTimeMillis()));
	
	data.setObject("logCreateUser", "script");
	data.setObject("logActionComment", "reActicate person :"+key.getUsername());
	data.setObject("logActionId", null);
	
	Pair<ErrorCode, String> result = das.modifyData(data);
	if(result.getFirst().equals(ErrorCode.success)){
		das.commitTranscation();
		das.updateCache(DataAccessAction.update, data.getId().getValue(),data);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><isError>false</isError>";
		xml += "<taskId>" + data.getId() + "</taskId></root>";
		out.println(xml);
	}
	else{
		das.rollbackTranscation();
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?><root><isError>true</isError>");
		out.println(result.getSecond());
		out.println("</root>");
	}
%>