<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@page import="cn.nfu.pts.bean.UserInfo"%>
<%@page import="cn.nfu.pts.bean.DataAccessAction"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="cn.nfu.pts.bean.Flow" %>
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
		
	String userId = request.getParameter("userId");
	if(userId=="" || userId == null)
	{
		out.println(ErrorManager.getErrorXml(ErrorType.param_error));
		return;
	}
	UserInfo userInfo = das.queryUserInfoById(Integer.parseInt(userId));
	//删除该用户在所有流程中的相关信息
	Flow[] flowArray = das.queryAllFlows();
	for(Flow flow : flowArray)
	{
		flow.removeRight(userInfo.getUserName());	
		das.updateFlow(flow);
		das.updateCache(DataAccessAction.update, flow.getId().getValue(), flow);
	}
	
	if(das.removeUserInfo(userInfo)){
		das.updateCache(DataAccessAction.delete, userInfo.getUserName(), userInfo);
		out.println(ErrorManager.getCorrectXml());
	}else
		out.println(ErrorManager.getErrorXml(ErrorType.database_update_error));
%>