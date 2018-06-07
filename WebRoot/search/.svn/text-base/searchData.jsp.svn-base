<%@page import="cn.nfu.pts.util.ArrayUtil"%>
<%@page import="cn.nfu.pts.service.StatisticerManager"%>
<%@page import="cn.nfu.pts.util.QueryUtil"%>
<%@page import="cn.nfu.pts.service.FilterQueryManager"%>
<%@page import="cn.nfu.pts.service.impl.DataFilterMemory"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="cn.nfu.pts.dao.DataAccessSessionMySQL"%>
<%@page import="cn.nfu.pts.service.DbPoolConnection"%>
<%@page import="cn.nfu.pts.util.CynthiaUtil"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Set"%>
<%@page import="cn.nfu.pts.bean.QueryCondition"%>
<%@page import="cn.nfu.pts.util.FilterDataAssembleUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page contentType="text/json;charset=utf-8"  %>

<%@ page import="cn.nfu.pts.bean.Key"%>
<%@ page import="cn.nfu.pts.factory.DataAccessFactory"%>
<%@ page import="cn.nfu.pts.service.DataAccessSession"%>
<%@ page import="cn.nfu.pts.bean.UUID"%>
<%@ page import="cn.nfu.pts.bean.Data" %>
<%@ page import="cn.nfu.pts.bean.Flow" %>
<%@ page import="cn.nfu.pts.bean.Filter" %>
<%@ page import="cn.nfu.pts.bean.Stat" %>
<%@ page import="cn.nfu.pts.bean.Template" %>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="cn.nfu.pts.util.ConfigUtil"%>
<%@ page import="cn.nfu.pts.util.CommonUtil"%>
<%@ page import="cn.nfu.pts.util.EscapeUtil"%>
<%@ page import="cn.nfu.pts.util.XMLUtil"%>
<%@ page import="org.w3c.dom.Document"%>
<%@ page import="org.w3c.dom.Node"%>
<%@ page import="org.w3c.dom.Element"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@page import="java.net.URLDecoder"%>

<%
response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility    

out.clear();

request.setCharacterEncoding("utf-8");

Key key = (Key)session.getAttribute("key");
Long keyId = (Long)session.getAttribute("kid");
String username = request.getParameter("username");

if(keyId == null || keyId <= 0 || key == null){
	response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
	return;
}

if(key!=null)
	username = key.getUsername();

int start = request.getParameter("start")==null?0:Integer.parseInt(request.getParameter("start"));
int limit = request.getParameter("limit")==null?50:Integer.parseInt(request.getParameter("limit"));
int	pagenum        = (start/limit) + 1;
int	count          = limit;
String sort = request.getParameter("sort");
String dir = request.getParameter("dir");


UUID templateId = null;
String templateIdStr = request.getParameter("templateId");
if(templateIdStr != null && templateIdStr.length() > 0)
	templateId = DataAccessFactory.getInstance().createUUID(templateIdStr);

DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(key.getUsername(), keyId);
List<Data> dataList = new ArrayList<Data>();
int totalCount = 0;
Set<String> notNewTaskIdSet = new HashSet<String>();

Map<String,List<String>> allRequestPair = QueryUtil.getRequestParams(request);

if(allRequestPair.get("projectId") != null){
	//项目管理查询
	String projectId = allRequestPair.get("projectId").get(0);
	Map<String,Set<String>> projectDataMap = FilterQueryManager.queryProjectDataIds(allRequestPair.get("projectId"));
	Set<String> allDataId = projectDataMap.get(projectId);
	totalCount = allDataId.size();
	String[] allDataIdStrs = allDataId.toArray(new String[0]);
	allDataIdStrs = ArrayUtil.splitArray(allDataIdStrs,start,start+limit);
	
	dataList = new DataAccessSessionMySQL().queryDataByDataIds(allDataIdStrs, false, null);
}else{
	String sql = "";
	if(allRequestPair.get("statisticId") != null && allRequestPair.get("statisticVal") != null){
		//通过统计器查询 一般为统计页面的链接
		String statisticId = allRequestPair.get("statisticId").get(0);
		String statisticVal = allRequestPair.get("statisticVal").get(0);
		sql = StatisticerManager.getSqlOfStat(statisticId,statisticVal,key.getUsername());
		allRequestPair.remove("statisticId");
		allRequestPair.remove("statisticVal");
		//其它条件查询如标题 描述等
		List<QueryCondition> queryConditionList = QueryUtil.getQueryCondition(allRequestPair,templateId);
		for(QueryCondition queryCondition : queryConditionList){
			sql += " and " + queryCondition.getQueryField() + " " + queryCondition.getQueryMethod() + " " + queryCondition.getQueryValue() + " ";
		}
		System.out.println("query statistic sql :" + sql);
	}else{
		//其它条件查询
		List<QueryCondition> queryConditionList = QueryUtil.getQueryCondition(allRequestPair,templateId);
		sql = QueryUtil.getQuerySql(templateId, queryConditionList);
	}

	totalCount = DbPoolConnection.getInstance().getSearchResultCount(sql);
	sql = DataFilterMemory.getQuerySql(sql, pagenum,count,sort,dir,templateId == null ? null : templateId.getValue());
	dataList = new DataAccessSessionMySQL().queryDatas(sql, false, templateId);
}

Set<String> displayFieldsName = new HashSet(Arrays.asList(new String[]{"标题","描述","创建时间","指派人","状态","修改时间","创建人"}));

Map<String,String> userClassifyDataMap = new HashMap<String,String>();

StringBuffer result = new StringBuffer();
result.append("{");
result.append("\"totalCount\":").append(totalCount).append(",\"rows\":[");

result.append(FilterQueryManager.assembleFilterDataJson(displayFieldsName.toArray(new String[0]),dataList,notNewTaskIdSet,userClassifyDataMap , das , false));

result.append("]");
result.append("}");

String callback = request.getParameter("callback");
if (callback != null && !callback.equals("")) {
	String jsonp = callback + "(" + result.toString() + ")";
	response.setContentType("application/javascript;charset=UTF-8");
	response.getWriter().print(jsonp);
	response.getWriter().flush();
	response.getWriter().close();
}else {
	response.getWriter().write(result.toString());
}
%>