<%@page import="cn.nfu.pts.util.ArrayUtil"%>
<%@page import="cn.nfu.pts.service.ProjectInvolveManager"%>
<%@page import="cn.nfu.pts.service.ConfigManager"%>
<%@page import="cn.nfu.pts.service.impl.DataFilterMemory"%>
<%@page import="cn.nfu.pts.service.TableRuleManager"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="cn.nfu.pts.util.CynthiaUtil"%>
<%@page import="cn.nfu.pts.util.FileUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="cn.nfu.pts.dao.DataAccessSessionMySQL"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Map"%>
<%@page import="cn.nfu.pts.bean.QueryCondition"%>
<%@page import="cn.nfu.pts.util.FilterDataAssembleUtil"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="cn.nfu.pts.service.FilterQueryManager"%>
<%@page import="cn.nfu.pts.bean.Attachment"%>
<%@page import="cn.nfu.pts.bean.Option"%>
<%@page import="cn.nfu.pts.bean.Field.DataType"%>
<%@page import="cn.nfu.pts.bean.Field.Type"%>
<%@page import="cn.nfu.pts.bean.Field"%>
<%@page import="cn.nfu.pts.service.DbPoolConnection"%>
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

	String searchKey = URLDecoder.decode(request.getParameter("searchKey"),"UTF-8");
	String filterIdStr = request.getParameter("filterId");
	String searchType = request.getParameter("searchType");
	String templateIdStr = request.getParameter("template");

	int start = Integer.parseInt(request.getParameter("start"));
	int limit = Integer.parseInt(request.getParameter("limit"));
	String sort = request.getParameter("sort");
	String dir = request.getParameter("dir");
	
	int	pagenum        = (start/limit) + 1;
	int	count          = limit;

	if(searchType==null||"".equals(searchType))
	{
		response.sendRedirect(ConfigUtil.getCynthiaWebRoot());
		return;
	}

	Set<String> displayFieldsName = new HashSet<String>();
	int totalCount = 0;
	List<Data> dataList = new ArrayList<Data>();
	Set<String> notNewTaskIdSet = new HashSet<String>();
	Map<String,String> userClassifyDataMap = new HashMap<String,String>();
	boolean isSysFilter = true;
	DataAccessSession das = DataAccessFactory.getInstance().createDataAccessSession(username,keyId);
	
	if(filterIdStr == null || filterIdStr.length() == 0){
		displayFieldsName.addAll(Arrays.asList(new String[]{"标题","描述","创建时间","指派人","状态","修改时间","创建人"}));
		//没设置过滤器，则全局查询
		List<String> dataTable = TableRuleManager.getInstance().getAllDataTables();
		StringBuffer sqlBuffer = new StringBuffer();
		StringBuffer whereBuffer = new StringBuffer();
		if(searchKey != null && searchKey.length() >0 ){
			if(searchType.equals("id")){
				whereBuffer.append(" where ").append(searchType).append(" in (").append(searchKey).append(")");
			}else{
				whereBuffer.append(" where ").append(searchType).append(" like '%").append(searchKey).append("%'");
			}
			
			if(ConfigManager.getProjectInvolved()){
				Set<String> allCompanyUser = ProjectInvolveManager.getInstance().getCompanyUserMails(key.getUsername());
				StringBuffer userBuffer = new StringBuffer();
				if(allCompanyUser.size() > 0){
					for(String user : allCompanyUser){
						userBuffer.append(userBuffer.length() > 0 ? "," : "").append("'").append(user).append("'");
					}
					whereBuffer.append(" and createUser in (").append(userBuffer.toString()).append(") ");
				}
			}
		}
		
		for(String tableName : dataTable){
			sqlBuffer.append(sqlBuffer.length() > 0 ? " union " :"").append(" select id , templateId,title,description,createTime, assignUser,statusId,lastModifyTime,createUser from ").append(tableName)
			.append(whereBuffer);
		}
		String orderField = DataFilterMemory.getDbColName(sort, null);
		if(orderField != null && orderField.length() > 0)
			sqlBuffer.append(" order by ").append(DataFilterMemory.getDbColName(sort, null)).append( " " + dir);
		
		List<Data> allData = new DataAccessSessionMySQL().queryDatas(sqlBuffer.toString(), false, null);
		
		totalCount = allData.size();
		if(totalCount > 0){
			int endIndex = start + limit;
			if(endIndex > allData.size())
				endIndex = allData.size();
			dataList = allData.subList(start, endIndex);
		}
		
	}else{
		UUID filterId = DataAccessFactory.getInstance().createUUID(filterIdStr);
		UUID templateTypeId =null;
		UUID templateId = null;
		
		Filter filter = das.queryFilter(filterId);

		if(filter == null)
			return;
		
		displayFieldsName.addAll(Arrays.asList(FilterQueryManager.getDisplayFields(filter.getXml(), das)));
		isSysFilter = FilterQueryManager.isSysFilter(filterIdStr);

		if(!isSysFilter){
			templateId = FilterQueryManager.getFilterTemplateId(filter);
		}

		List<QueryCondition> queryConList = new ArrayList<QueryCondition>();
		QueryCondition queryCon = new QueryCondition(searchType,"like", "'%" +searchKey + "%'");
		queryConList.add(queryCon);

		if (isSysFilter) {
			FilterQueryManager.initFilterEnv(filter,keyId, key.getUsername(), null, das);
		}

		String sql = DataFilterMemory.getFilterSql(filter.getXml(), null , queryConList);

		sql = CynthiaUtil.cancelGroupOrder(sql);
		
		totalCount = DbPoolConnection.getInstance().getSearchResultCount(sql);

		sql = DataFilterMemory.getQuerySql(sql, pagenum,count,sort,dir,templateId == null ? null : templateId.getValue());
		dataList = new DataAccessSessionMySQL().queryDatas(sql, false, templateId);

	}
	
	userClassifyDataMap = das.getUserClassifyDataMap(username);
	StringBuffer result = new StringBuffer();
	result.append("{");
	result.append("\"totalCount\":\"").append(totalCount).append("\",\"rows\":[");

	result.append(FilterQueryManager.assembleFilterDataJson(displayFieldsName.toArray(new String[0]),dataList,notNewTaskIdSet,userClassifyDataMap , das , isSysFilter));

	result.append("]");
	result.append("}");

	out.print(result.toString());
%>
