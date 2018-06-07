<%@page import="cn.nfu.pts.service.ErrorManager.ErrorType"%>
<%@page import="cn.nfu.pts.service.ErrorManager"%>
<%@ page contentType="text/xml; charset=UTF-8" %>

<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Data"%>
<%@ page import="cn.nfu.pts.bean.Template"%>
<%@ page import="cn.nfu.pts.bean.Field"%>
<%@ page import="cn.nfu.pts.bean.Option"%>
<%@ page import="cn.nfu.pts.bean.Filter"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession.ErrorCode"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.bean.Key"%>

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
	
	//id
	String idStr = request.getParameter("id");
	if(idStr == null){
		response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
		return;
	}
	
	UUID id = DataAccessFactory.getInstance().createUUID(idStr);
	
	DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(), keyId);
	
	Data data = das.queryData(id);
	if(data == null){
		out.println(ErrorManager.getErrorXml(ErrorType.data_not_found_inDb));
		return;
	}
	
	ErrorCode errorCode = das.removeData(data);
	if(errorCode.equals(ErrorCode.success)){
		das.commitTranscation();
		out.println(ErrorManager.getCorrectXml());
	}
	else{
		das.rollbackTranscation();
		out.println(ErrorManager.getErrorXml(ErrorType.database_update_error));
	}
%>