package cn.nfu.pts.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.nfu.pts.bean.Action;
import cn.nfu.pts.bean.Attachment;
import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.DataAccessAction;
import cn.nfu.pts.bean.Field;
import cn.nfu.pts.bean.Filter;
import cn.nfu.pts.bean.Flow;
import cn.nfu.pts.bean.GuideBean;
import cn.nfu.pts.bean.JSTree;
import cn.nfu.pts.bean.Option;
import cn.nfu.pts.bean.Pair;
import cn.nfu.pts.bean.QueryCondition;
import cn.nfu.pts.bean.Role;
import cn.nfu.pts.bean.Script;
import cn.nfu.pts.bean.Stat;
import cn.nfu.pts.bean.TagBean;
import cn.nfu.pts.bean.Template;
import cn.nfu.pts.bean.TemplateOperateLog;
import cn.nfu.pts.bean.TemplateType;
import cn.nfu.pts.bean.Timer;
import cn.nfu.pts.bean.TimerAction;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.bean.UserInfo;

public interface DataAccessSession
{
	/**
	 * @description:update cache
	 * @version:v1.0
	 * @param daa: delete update 
	 * @param key:cache data key
	 * @param object:cache data 
	 */
	public void updateCache(DataAccessAction daa, String key ,Object object);
	
	/**
	 * @description:return data filter interface
	 * @version:v1.0
	 * @return
	 */
	public DataFilter getDataFilter();

	/**
	 * @description:return current user
	 * @version:v1.0
	 * @return
	 */
	public String getUsername();

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @return
	 */
	public long getKeyId();

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @return
	 */
	public String getAgent();
	
	/**
	 * @description:remove flow from database
	 * @version:v1.0
	 * @param flowId
	 * @return
	 */
	public ErrorCode removeFlow(UUID flowId);

	/**
	 * @description:begin transcation
	 * @version:v1.0
	 * @return
	 */
	public ErrorCode beginTranscation();

	/**
	 * @description:transcation rollback
	 * @version:v1.0
	 * @return
	 */
	public ErrorCode rollbackTranscation();

	/**
	 * @description:commit transcation
	 * @version:v1.0
	 * @return
	 */
	public ErrorCode commitTranscation();

	/**
	 * @description:query data by data id
	 * @version:v1.0
	 * @param id:data id
	 * @return
	 */
	public Data queryData(UUID id); 
	
	/**
	 * @description:query data from data id and template id
	 * @version:v1.0
	 * @param id
	 * @param templateId
	 * @return
	 */
	public Data queryData(UUID id , UUID templateId);   
	
	/**
	 * @description:query data from sql
	 * @version:v1.0
	 * @param sql
	 * @param needLog:need data log
	 * @param templateId
	 * @return
	 */
	public List<Data> queryDataBySql(String sql , boolean needLog, UUID templateId);

	/**
	 * @description:add data, get data uuid
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Data addData(UUID templateId);
	
	/**
	 * @description:copy data
	 * @version:v1.0
	 * @param dataId
	 * @param templateId
	 * @param actionId
	 * @param actionUser
	 * @param actionComment
	 * @param baseValueMap
	 * @param extValueMap
	 * @return
	 */
	public Data copyData(UUID dataId, UUID templateId, UUID actionId, String actionUser, String actionComment,
			Map<String, Pair<Object, Object>> baseValueMap, Map<UUID, Pair<Object, Object>> extValueMap); 

	/**
	 * @description:remove template from database
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public ErrorCode removeTemplate(Template templateId);

	/**
	 * @description:query template from cache or database
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Template queryTemplate(UUID templateId); 
	
	/**
	 * @description:query all templates by templatetype
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public List<Template> queryTemplates(UUID templateTypeId); 

	/**
	 * @description:query field from templates by fieldId
	 * @version:v1.0
	 * @param fieldId
	 * @return
	 */
	public Field queryField(UUID fieldId); 
	
	/**
	 * @description:query field from template
	 * @version:v1.0
	 * @param fieldId
	 * @param templateId
	 * @return
	 */
	public Field queryField(UUID fieldId , UUID templateId); 

	/**
	 * @description:query option from template by template id
	 * @version:v1.0
	 * @param optionId
	 * @param templateId
	 * @return
	 */
	public Option queryOption(UUID optionId ,UUID templateId);
	
	/**
	 * @description:query option from template
	 * @version:v1.0
	 * @param optionId
	 * @param template
	 * @return
	 */
	public Option queryOption(UUID optionId, Template template); 
	
	/**
	 * @description:query datas by template id and other query conditions
	 * @version:v1.0
	 * @param templateId
	 * @param queryConditions
	 * @param needLog
	 * @return
	 */
	public Data[] queryDatas(UUID templateId, List<QueryCondition> queryConditions,boolean needLog);

	/**
	 * @description:query template type by templatetype id
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public TemplateType queryTemplateType(UUID templateTypeId); 

	/**
	 * @description:create attachment from name and atta data
	 * @version:v1.0
	 * @param name
	 * @param data
	 * @return
	 */
	public Attachment createAttachment(String name, byte[] data); 

	/**
	 * @description:query attachement by id 
	 * @version:v1.0
	 * @param id
	 * @param needData:if attachment data need
	 * @return
	 */
	public Attachment queryAttachment(UUID id, boolean needData);

	/**
	 * @description: query attachments by ids
	 * @version:v1.0
	 * @param ids
	 * @param needData:if attachment data need
	 * @return
	 */
	public Attachment[] queryAttachments(UUID[] ids, boolean needData); 

	/**
	 * @description:modify data
	 * @version:v1.0
	 * @param data
	 * @return
	 */
	public Pair<ErrorCode, String> modifyData(Data data);  

	/**
	 * @description:remove data
	 * @version:v1.0
	 * @param data
	 * @return
	 */
	public ErrorCode removeData(Data data); 

	/**
	 * @description:set all Template Data valid true or false
	 * @version:v1.0
	 * @param templateId
	 * @param isValid
	 */
	public boolean setValidDataOfTemplate(UUID templateId , boolean isValid);
	
	/**
	 * @description:remove data from cache
	 * @version:v1.0
	 * @param data
	 * @return
	 */
	public ErrorCode removeDataFromCache(Data data);   

	/**
	 * @description:close and commit transcation
	 * @version:v1.0
	 */
	public void close();  

	/**
	 * @description:return is transcation is commit automatic
	 * @version:v1.0
	 * @return
	 */
	public boolean isAutoCommit();   

	/**
	 * @description:set transcation if commit automatic 
	 * @version:v1.0
	 * @param b:true auto ,  false not
	 */
	public void setAutoCommit(boolean b);   

	/**
	 * @description:return script process interface
	 * @version:v1.0
	 * @return
	 */
	public ScriptAccessSession createScriptAccessSession(); 

	/**
	 * @description:create flow
	 * @version:v1.0
	 * @param userName:create user name
	 * @return
	 */
	public Flow createFlow(String userName); 

	/**
	 * @description:create template
	 * @version:v1.0
	 * @param templateTypeId:template type
	 * @return
	 */
	public Template createTemplate(UUID templateTypeId); 

	/**
	 * @description:update template
	 * @version:v1.0
	 * @param template
	 * @return
	 */
	public ErrorCode updateTemplate(Template template);   

	/**
	 * @description:query flow by flow id
	 * @version:v1.0
	 * @param flowId
	 * @return
	 */
	public Flow queryFlow(UUID flowId);  
	
	/**
	 * @description:update flow svgcode
	 * @version:v1.0
	 * @param flowId
	 * @param svgCode
	 * @return
	 */
	public boolean updateSvg(UUID flowId,String svgCode);
	
	/**
	 * @description:query flow svgcode
	 * @version:v1.0
	 * @param flowId
	 * @return
	 */
	public String queryFlowSvg(UUID flowId); 

	/**
	 * @description:query stat from flow
	 * @version:v1.0
	 * @param statId
	 * @param flowId
	 * @return
	 */
	public Stat queryStat(UUID statId , UUID flowId); 

	/**
	 * @description:query action from flow
	 * @version:v1.0
	 * @param actionId
	 * @param flowId
	 * @return
	 */
	public Action queryAction(UUID actionId , UUID flowId); 
	
	/**
	 * @description:query role from flow
	 * @version:v1.0
	 * @param roleId
	 * @param flowId
	 * @return
	 */
	public Role queryRole(UUID roleId , UUID flowId); 

	/**
	 * @description:query flows by from ids
	 * @version:v1.0
	 * @param flowIdArray
	 * @return
	 */
	public Flow[] queryFlows(UUID[] flowIdArray); 

	/**
	 * @description:query templates by template ids
	 * @version:v1.0
	 * @param templateIdArray
	 * @return
	 */
	public Template[] queryTemplates(UUID[] templateIdArray); 

	/**
	 * @description:query templatetypes by templatetype ids
	 * @version:v1.0
	 * @param templateTypeIdArray
	 * @return
	 */
	public TemplateType[] queryTemplateTypes(UUID[] templateTypeIdArray);

	/**
	 * @description:update flow
	 * @version:v1.0
	 * @param flow
	 * @return
	 */
	public ErrorCode updateFlow(Flow flow);  

	/**
	 * @description:query all flows
	 * @version:v1.0
	 * @return
	 */
	public Flow[] queryAllFlows();  

	/**
	 * @Title: queryAllFlows
	 * @Description: query user all flows
	 * @param userMail
	 * @return
	 * @return: Flow[]
	 */
	public Flow[] queryAllFlows(String userMail);  
	/**
	 * @description:query all templates
	 * @version:v1.0
	 * @return
	 */
	public Template[] queryAllTemplates(); 
 
	/**
	 * @description:query all templatetypes
	 * @version:v1.0
	 * @return
	 */
	public TemplateType[] queryAllTemplateTypes(); 

	/**
	 * @description:add filter to database
	 * @version:v1.0
	 * @param filter
	 * @return
	 */
	public Filter addFilter(Filter filter); 

	/**
	 * @description:query filter by filter id
	 * @version:v1.0
	 * @param filterId
	 * @return
	 */
	public Filter queryFilter(UUID filterId); 

	/**
	 * @description:query all filters of user
	 * @version:v1.0
	 * @param username
	 * @return
	 */
	public Filter[] queryFilters(String username); 

	/**
	 * @description:query filter id and name of user
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public Map<String,String> queryFilterIdNameMap(String userName);
	
	/**
	 * @description:query system filters
	 * @version:v1.0
	 * @param username
	 * @return
	 */
	public Filter[] querySysFilters(String username);  

	/**
	 * @description:query all focus filter of user
	 * @version:v1.0
	 * @param username
	 * @return
	 */
	public Filter[] queryFocusFilters(String username); 

	/**
	 * @description:query all filters
	 * @version:v1.0
	 * @return
	 */
	public List<Filter> queryAllFilters();  

	/**
	 * @description:remove filter by filter id
	 * @version:v1.0
	 * @param filterId
	 * @return
	 */
	public ErrorCode removeFilter(UUID filterId);  

	/**
	 * 	@description:update filter 
	 * @version:v1.0
	 * @param filter
	 * @return
	 */
	public ErrorCode updateFilter(Filter filter); 

	/**
	 * @description:create filter 
	 * @version:v1.0
	 * @param createUser
	 * @param createTime
	 * @param fatherId:father folder id
	 * @return
	 */
	public Filter createFilter(String createUser, Timestamp createTime, UUID fatherId); 

	/**
	 * @description:create tmp filter
	 * @version:v1.0
	 * @param createUser
	 * @param createTime
	 * @param fatherId
	 * @return
	 */
	public Filter createTempFilter(String createUser, Timestamp createTime, UUID fatherId); 

	/**
	 * @description:get filters new and old datas
	 * @version:v1.0
	 * @param filterIdArray
	 * @param username
	 * @return:xml
	 */
	public String getNewTaskIdsByFilterAndUser(UUID[] filterIdArray, String username); 

	/**
	 * @description:set data old of filter
	 * @version:v1.0
	 * @param filterId
	 * @param taskIdArray
	 * @param username
	 * @return
	 */
	public String cleanNewTagByTaskIds(UUID filterId, UUID[] taskIdArray, String username);  

	/**
	 * @description:remove old data
	 * @version:v1.0
	 * @param dataId
	 */
	public void deleteFilterUserTasks(UUID dataId);
	
	/**
	 * @description:query filters focused by user
	 * @version:v1.0
	 * @param username
	 * @return
	 */
	public UUID[] queryUserFocusFilters(String username);   

	/**
	 * @description:remove user focus filter
	 * @version:v1.0
	 * @param username
	 * @param filterId
	 * @return
	 */
	public ErrorCode removeUserFocusFilter(String username, UUID filterId);  

	/**
	 * @description:remove all focus filter
	 * @version:v1.0
	 * @param filterId
	 * @return
	 */
	public ErrorCode removeUserFocusFilter(UUID filterId);  
	/**
	 * @description:add user focus filter
	 * @version:v1.0
	 * @param username
	 * @param filterId
	 * @return
	 */
	public ErrorCode addUserFocusFilter(String username, UUID filterId);  

	/**
	 * @description:remove user by username
	 * @version:v1.0
	 * @param username
	 * @return
	 */
	public ErrorCode removeRelatedUser(String username); 

	/**
	 * @description:create timer return uuid
	 * @version:v1.0
	 * @param createUser
	 * @return
	 */
	public Timer createTimer(String createUser);  

	/**
	 * @description:add timer to database
	 * @version:v1.0
	 * @param timer
	 * @return
	 */
	public ErrorCode addTimer(Timer timer); 

	/**
	 * @description:remove timer from database
	 * @version:v1.0
	 * @param timerId
	 * @return
	 */
	public ErrorCode removeTimer(UUID timerId); 

	/**
	 * @description:modify timer
	 * @version:v1.0
	 * @param timer
	 * @return
	 */
	public ErrorCode modifyTimer(Timer timer); 

	/**
	 * @description:query timer from timer id
	 * @version:v1.0
	 * @param timerId
	 * @return
	 */
	public Timer queryTimer(UUID timerId); 

	/**
	 * @description:query timers by user
	 * @version:v1.0
	 * @param username
	 * @return
	 */
	public Timer[] queryTimers(String username); 

	/**
	 * @description:query all timers
	 * @version:v1.0
	 * @return
	 */
	public Timer[] queryTimers(); 
	
	/**
	 * @description:query timer by timer action id
	 * @version:v1.0
	 * @param timerActionId
	 * @return
	 */
	public Timer[] queryTimersByActionId(UUID timerActionId);

	/**
	 * @description:create timer action
	 * @version:v1.0
	 * @return
	 */
	public TimerAction createTimerAction();  

	/**
	 * @description:add timer action to database
	 * @version:v1.0
	 * @param timerAction
	 * @return
	 */
	public ErrorCode addTimerAction(TimerAction timerAction); 

	/**
	 * @description:remove timer action from database
	 * @version:v1.0
	 * @param timerActionId
	 * @return
	 */
	public ErrorCode removeTimerAction(UUID timerActionId); 

	/**
	 * @description:modify timer action from database
	 * @version:v1.0
	 * @param timerAction
	 * @return
	 */
	public ErrorCode modifyTimerAction(TimerAction timerAction); 

	/**
	 * @description:query timer action from timer action id
	 * @version:v1.0
	 * @param timerActionId
	 * @return
	 */
	public TimerAction queryTimerAction(UUID timerActionId); 

	/**
	 * @description:query all timer actions
	 * @version:v1.0
	 * @return
	 */
	public TimerAction[] queryTimerActions(); 

	/**
	 * @description:query data create users by templatetype id
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public String[] queryTemplateTypeCreateUsers(UUID templateTypeId); 

	/**
	 * @description:query all assign users by templatetype id
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public String[] queryTemplateTypeAssignUsers(UUID templateTypeId); 

	/**
	 * @description:query all statu names by template type id
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public String[] queryTemplateTypeStats(UUID templateTypeId);  
	
	/**
	 * @description:query all datas by template id(need datalog)
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Data[] queryTemplateDatas(UUID templateId);  
	
	/**
	 * @description:query all datas by template id
	 * @version:v1.0
	 * @param templateId
	 * @param needLog:if need data log
	 * @return
	 */
	public Data[] queryTemplateDatas(UUID templateId , boolean needLog);  
	
	/**
	 * @description:query datas by template id and create time 
	 * @version:v1.0
	 * @param templateId
	 * @param needLog
	 * @param startTime:createTime start
	 * @param endTime:createTime end
	 * @return
	 */
	public Data[] queryTemplateDatas(UUID templateId , boolean needLog , Timestamp startTime , Timestamp endTime);  
	
	/**
	 * @description:query datas by template id
	 * @version:v1.0
	 * @param templateId
	 * @param needLog
	 * @param startTime
	 * @param endTime
	 * @param allQueryList:other query conditions
	 * @return
	 */
	public Data[] queryTemplateDatas(UUID templateId , boolean needLog , Timestamp startTime, Timestamp endTime , List<QueryCondition> allQueryList);

	/**
	 * @description:query datas of template by lastmodifytime
	 * @version:v1.0
	 * @param templateId
	 * @param needLog
	 * @param startTime:last modify time start
	 * @param endTime:last modify time end
	 * @return
	 */
	public Data[] queryTemplateDatasByLastModifyTime(UUID templateId , boolean needLog , Timestamp startTime , Timestamp endTime);  
	
	/**
	 * @description:query all createusers by template id
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public String[] queryTemplateCreateUsers(UUID templateId); 

	/**
	 * @description:query all assign users by template id
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public String[] queryTemplateAssignUsers(UUID templateId);  

	/**
	 * @description:query all stats by template id
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Stat[] queryTemplateStats(UUID templateId);  

	/**
	 * @description:query all reference datas by template id and reference field id
	 * @version:v1.0
	 * @param templateId
	 * @param fieldId
	 * @return
	 */
	public Data[] queryTemplateFieldReferences(UUID templateId, UUID fieldId); 

	/**
	 * @description:query all attachments by template and field id
	 * @version:v1.0
	 * @param templateId
	 * @param fieldId
	 * @return
	 */
	public Attachment[] queryTemplateFieldAttachments(UUID templateId, UUID fieldId); 

	/**
	 * @description:check user privilege of data
	 * @version:v1.0
	 * @param data
	 * @param action
	 * @return
	 */
	public boolean checkUserPrivilege(Data data, DataAccessAction action);
			
	/**
	 * @description:check user privilege
	 * @version:v1.0
	 * @param data
	 * @param action
	 * @param template
	 * @param flow
	 * @return
	 */
	public boolean checkUserPrivilege(Data data, DataAccessAction action ,Template template , Flow flow); 

	/**
	 * @description:check if data exist
	 * @version:v1.0
	 * @param dataId
	 * @return
	 */
	public boolean isDataExist(UUID dataId); 

	/**
	 * @description:query all focus user of filter
	 * @version:v1.0
	 * @param filterId
	 * @return
	 */
	public List<String> queryFocusUsersByFilter(UUID filterId); 

	/**
	 * @description:query all children nodes by node id and user
	 * @version:v1.0
	 * @param id
	 * @param userName
	 * @return
	 */
	public List<JSTree> queryChilderNodes(int nodeId ,String userName); 

	/**
	 * @description:query JStree node by nodeId
	 * @version:v1.0
	 * @param nodeId
	 * @return
	 */
	public JSTree queryJSTreeNodeById(int nodeId); 

	/**
	 * @description:add jstree node
	 * @version:v1.0
	 * @param parentId
	 * @param position
	 * @param title
	 * @param userName
	 * @return
	 */
	public int addJSTreeNode(int parentId,int position,String title,String userName); 

	/**
	 * @description:remove jstree node
	 * @version:v1.0
	 * @param id
	 * @param userName
	 * @return
	 */
	public boolean removJSTreeNode(int id,String userName); 
 
	/**
	 * @description:update jstree node title 
	 * @version:v1.0
	 * @param id
	 * @param title
	 * @return
	 */
	public boolean updateJSTreeNode(int id,String title); 

	/**
	 * @description:move jstree node
	 * @version:v1.0
	 * @param id
	 * @param refId
	 * @param position
	 * @param title
	 * @param copy
	 * @param userName
	 * @return
	 */
	public boolean moveJSTreeNode(int id,int refId,int position,String title, boolean copy,String userName); 

	/**
	 * @description:move filter position in jstree
	 * @version:v1.0
	 * @param filterId
	 * @param refId
	 * @param parentId
	 * @return
	 */
	public boolean moveFilterNode(int filterId,int refId,int parentId);  

	/**
	 * @description:query all filters from jstree
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public List<String> queryAllFolderFilters(String userName); 

	/**
	 * @description:query timers by filter id
	 * @version:v1.0
	 * @param filterId
	 * @return
	 */
	public Timer[] queryTimerByFilterId(UUID filterId); 

	/**
	 * @description:query filters by folder node if
	 * @version:v1.0
	 * @param nodeId
	 * @return
	 */
	public List<String> queryFolderFilters(int nodeId); 

	/**
	 * @description:query all root node of jstree
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public List<JSTree> queryRootNode(int id); 

	/**
	 * @description:remove filter from jstree
	 * @version:v1.0
	 * @param filterId
	 * @param parentId
	 * @return
	 */
	public boolean removeFilterId(int filterId,int parentId); 

	/**
	 * @description:query all favorite filters by user
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public String[] queryFavoriteFilters(String userName); 

	/**
	 * @description:add favorite filter of user
	 * @version:v1.0
	 * @param userName
	 * @param filterId
	 * @return
	 */
	public boolean addFavoriteFilter(String userName,String filterId); 

	/**
	 * @description:remove favorite filter of user
	 * @version:v1.0
	 * @param userName
	 * @param filterId
	 * @return
	 */
	public boolean removeFavoriteFilter(String userName,String filterId); 

	/**
	 * @description:update all favorite filters of user
	 * @version:v1.0
	 * @param filterarrays
	 * @param userName
	 * @return
	 */
	public boolean updataFavoriteFilters(String filterarrays,String userName); 

	/**
	 * @description:query user home filter
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public String queryHomeFilter(String userName); 

	/**
	 * @description:add home filter 
	 * @version:v1.0
	 * @param userName
	 * @param filterId
	 * @return
	 */
	public boolean addHomeFilter(String userName,String filterId); 
 
	/**
	 * @description:update home filter
	 * @version:v1.0
	 * @param userName
	 * @param filterId
	 * @return
	 */
	public boolean updateHomeFilter(String userName,String filterId); 

	/**
	 * @description:update favoriter filter position
	 * @version:v1.0
	 * @param filterId
	 * @param position
	 * @param userName
	 * @return
	 */
	public boolean updateFavoritesFilters(String filterId,int position,String userName); 

	/**
	 * @description:add filter to jstree node
	 * @version:v1.0
	 * @param fitlerId
	 * @param nodeId
	 * @return
	 */
	public boolean addFilterToFolder(String fitlerId,int nodeId); 

	/**
	 * @description:query all scripts of user
	 * @version:v1.0
	 * @param userName
	 * @param keyId
	 * @return
	 */
	public List<Script> queryAllScripts(String userName,long keyId); 

	/**
	 * @description:update filter orders of node
	 * @version:v1.0
	 * @param folderId
	 * @param userName
	 * @param newOrders
	 * @return
	 */
	public boolean updateFilterOrders(int folderId,String userName,String newOrders); 

	/**
	 * @description:update default filters
	 * @version:v1.0
	 * @param userName
	 * @param filters
	 * @return
	 */
	public boolean updateDefaultFilters(String userName,String filters); 

	/**
	 * @description:query all default filters
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public List<String> queryDefaultFilters(String userName); 
 
	/**
	 * @description:add event
	 * @version:v1.0
	 * @param eventName
	 * @return
	 */
	public boolean addEvent(String eventName);  

	/**
	 * @description:update event
	 * @version:v1.0
	 * @param eventName
	 * @return
	 */
	public boolean updateEvent(String eventName); 

	/**
	 * @description:add event user
	 * @version:v1.0
	 * @param userName
	 * @param eventId
	 * @return
	 */
	public boolean addEventUser(String userName,int eventId); 

	/**
	 * @description:remove event user
	 * @version:v1.0
	 * @param userName
	 * @param eventId
	 * @return
	 */
	public boolean removeEventUser(String userName,int eventId); 

	/**
	 * @description:query if user is valid of event
	 * @version:v1.0
	 * @param userName
	 * @param eventId
	 * @return
	 */
	public boolean isValidUser(String userName,int eventId); 

	/**
	 * @description:query template by template name
	 * @version:v1.0
	 * @param templateName
	 * @return
	 */
	public Template queryTemplateByName(String templateName); 

	/**
	 * @description:query all scripts
	 * @version:v1.0
	 * @return
	 */
	public List<Script> queryAllScripts(); 

	/**
	 * @description:add script
	 * @version:v1.0
	 * @param script
	 * @return
	 */
	public UUID addScript(Script script); 

	/**
	 * @description:update script to database
	 * @version:v1.0
	 * @param script
	 * @return
	 */
	public ErrorCode updateScript(Script script); 

	/**
	 * @description:query script by id
	 * @version:v1.0
	 * @param scriptId
	 * @return
	 */
	public Script queryScript(UUID scriptId); 
	
	/**
	 * @description:query script not contain import info
	 * @version:v1.0
	 * @param scriptId
	 * @return
	 */
	public Script queryScriptNoImport(UUID scriptId); 

	/**
	 * @description:remove script
	 * @version:v1.0
	 * @param scriptId
	 * @return
	 */
	public ErrorCode removeScript(UUID scriptId); 

	/**
	 * @description:create script by user
	 * @version:v1.0
	 * @param createUser
	 * @return
	 */
	public Script createScript(String createUser); 

	/**
	 * @description:query allow template scripts
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Script[] queryAllowedTemplateScripts(UUID templateId); 

	/**
	 * @description:query template scripts
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Script[] queryTemplateScripts(UUID templateId); 

	/**
	 * @description:query user default template
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public String getUserDefaultTemplate(String userName); 

	/**
	 * @description:add or update user default template
	 * @version:v1.0
	 * @param userName
	 * @param templateId
	 * @return
	 */
	public boolean addOrUpdateUserDefaultTemplate(String userName,String templateId); 

	/**
	 * @description:add user
	 * @version:v1.0
	 * @param userInfo
	 * @return
	 */
	public boolean addUserInfo(UserInfo userInfo); 

	/**
	 * @description:update user
	 * @version:v1.0
	 * @param userInfo
	 * @return
	 */
	public boolean updateUserInfo(UserInfo userInfo); 

	/**
	 * @description:query user by userid
	 * @version:v1.0
	 * @param userId
	 * @return
	 */
	public UserInfo queryUserInfoById(int userId); 

	/**
	 * @description:query user by userMail
	 * @version:v1.0
	 * @param userMail
	 * @return
	 */
	public UserInfo queryUserInfoByUserName(String userMail); 
	
	/**
	 * @description:query userInfo by usermails
	 * @version:v1.0
	 * @param userMails
	 * @return
	 */
	public Map<String, UserInfo> queryUserInfoByUserNames(String[] userMails); 

	/**
	 * @description:remove user
	 * @version:v1.0
	 * @param userInfo
	 * @return
	 */
	public boolean removeUserInfo(UserInfo userInfo); 

	/**
	 * @description:query if user is exist
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public boolean isUserExisted(String userName); 
	

	/*******************************tag data start****************************************/
	/**
	 * @description:return all user tag datas
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public Map<String,String> getUserClassifyDataMap(String userName); 
	
	/**
	 * @description:add tag
	 * @version:v1.0
	 * @param userName
	 * @param tagName
	 * @param tagColor
	 * @return
	 */
	public int addTag(String userName, String tagName, String tagColor);
	
	/**
	 * @description:update tag
	 * @version:v1.0
	 * @param tagId
	 * @param tagName
	 * @param tagColor
	 * @return
	 */
	public boolean updateTag(String tagId, String tagName, String tagColor);
	
	/**
	 * @description:delete tag
	 * @version:v1.0
	 * @param tagId
	 * @return
	 */
	public boolean deleteTag(String tagId);
	
	/**
	 * @description:get all tags of user
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public List<TagBean> getAllTag(String userName);
	
	/**
	 * @description:add datas to tag
	 * @version:v1.0
	 * @param toTagId
	 * @param dataIds
	 * @return
	 */
	public boolean addTagData(String toTagId, String[] dataIds);
	
	/**
	 * @description:delete datas from tag
	 * @version:v1.0
	 * @param tagId
	 * @param dataIds
	 * @return
	 */
	public boolean deleteTagData(String tagId, String[] dataIds);
	
	/**
	 * @description:get all datas of tag
	 * @version:v1.0
	 * @param tagId
	 * @return
	 */
	public String[] getTagDataById(String tagId);
	
	/**
	 * @description:get all tags of data
	 * @version:v1.0
	 * @param userName
	 * @param dataId
	 * @return
	 */
	public List<TagBean> getDataTags(String userName,String dataId);
	/*****************************tag data end**********************************************/
	
	/*****************************user start************************************************/
	/**
	 * @description:query all users by user array
	 * @version:v1.0
	 * @param userArray
	 * @return
	 */
	public List<UserInfo> queryAllUserInfo(String[] userArray);
	
	/**
	 * @description:query all users by user array
	 * @version:v1.0
	 * @param userArray
	 * @param isQuit:user is quit
	 * @return
	 */
	public List<UserInfo> queryAllUserInfo(String[] userArray, boolean isQuit);
	/*****************************user end**************************************************/
	
	
	
	/**
	 * @description:query database colname of field
	 * @version:v1.0
	 * @param fieldId
	 * @param templateId
	 * @return
	 */
	public String getDbFieldName(UUID fieldId, UUID templateId);  
	
	/**
	 * @description:add template operate log
	 * @version:v1.0
	 * @param templateOperateLog
	 * @return
	 */
	public boolean addTemplateOpreateLog(TemplateOperateLog templateOperateLog);
	
	
	
	/*****************************default values start******************************************/
	/**
	 * @description:set user template default values
	 * @version:v1.0
	 * @param userName
	 * @param templateId
	 * @param defaultValueJson
	 * @return
	 */
	public boolean setDefaultValues(String userName, String templateId, String defaultValueJson);
	
	/**
	 * @description:get user template default values
	 * @version:v1.0
	 * @param userName
	 * @param templateId
	 * @return
	 */
	public String getDefaultValues(String userName, String templateId);
	/*****************************default values end********************************************/
	
	/**
	 * @description:return all users has back rights
	 * @version:v1.0
	 * @return
	 */
	public List<UserInfo> getBackRightUsers();  //查询所有后台权限人员
	
	/**
	 * @description:add back right of user
	 * @version:v1.0
	 * @param userMail
	 * @return
	 */
	public boolean addBackRightUser(String userMail);  //添加后台权限人员 
	  
	/**
	 * @description:remove back right of user
	 * @version:v1.0
	 * @param userMail
	 * @return
	 */
	public boolean delBackRightUser(String userMail);  //删除后台权限人员
	
	/**
	 * @description:get template operate right users
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public List<UserInfo> getTemplateRightUser(String templateId);
	
	/**
	 * @description:remove user template operate right
	 * @version:v1.0
	 * @param templateId
	 * @param userMail
	 * @return
	 */
	public boolean delUserTemplateRight(String templateId, String userMail);
	
	/**
	 * @description:add user template operate right
	 * @version:v1.0
	 * @param templateId
	 * @param userMail
	 * @return
	 */
	public boolean addUserTemplateRight(String[] templateId, String userMail);
	
	/**
	 * @description:query all template rights of user
	 * @version:v1.0
	 * @param userMail
	 * @return
	 */
	public Map<String, String> queryUserTemplateRights(String userMail);
	
	
	/**
	 * @description:set system setting(json)
	 * @version:v1.0
	 * @param systemJson
	 * @return
	 */
	public boolean setSystemOption(String systemJson);
	
	/**
	 * @description:get system setting(json)
	 * @version:v1.0
	 * @param userMail
	 * @return
	 */
	public String getSystemOption(String userMail);  //系统设置
	
	/**
	 * @description:update data log
	 * @version:v1.0
	 * @param dataId
	 * @param logIndex
	 * @param logContent
	 * @return
	 */
	public boolean updateDataLog(UUID dataId, int logIndex, String logContent);
	
	/**
	 * @description:add field database colname to database
	 * @version:v1.0
	 * @param templateId
	 * @param fieldColName
	 * @param fieldId
	 * @param fieldType
	 * @return
	 */
	public boolean addFieldColName(String templateId,String fieldColName,String fieldId,String fieldType);
	
	/**
	 * @description:query all statistics of user
	 * @version:v1.0
	 * @param userName
	 * @return
	 */
	public TimerAction[] queryStatisticByUser(String userName);
	
	/**
	 * @description:query all users by user status
	 * @version:v1.0
	 * @param userStat
	 * @param userName
	 * @return
	 */
	public List<UserInfo> queryAllUsersByStatAndName(String curUser,String userStat,String queryUserName);
	
	/**
	 * @description:update attachment
	 * @version:v1.0
	 * @param attachment
	 * @return
	 */
	public boolean updateAttachment(Attachment attachment);
	
	/**
	 * @description:add template right user
	 * @version:v1.0
	 * @param templateId
	 * @param userMails
	 * @return
	 */
	public boolean addtemplateUserRight(String templateId,String[] userMails);
	
	/**
	 * @description:remove template operate user
	 * @version:v1.0
	 * @param templateId
	 * @param user
	 * @return
	 */
	public boolean delTemplateUserRight(String templateId,String user);
	
	/********************使用说明开始********************************************/
	/**
	 * @description:get all guide
	 * @version:v1.0
	 * @return
	 */
	public List<GuideBean> queryAllGuide();
	
	/**
	 * @description：get guide by guideId
	 * @version:v1.0
	 * @param guideId
	 * @return
	 */
	public String queryGuideHtmlByGuideId( String guideId);
	
	/**
	 * @description:save guide by guideid
	 * @version:v1.0
	 * @param guideId
	 * @param guideHtml
	 * @return
	 */
	public boolean saveGuideHtml(String guideId , String guideHtml);
	/********************使用说明结束********************************************/
	
	public enum ErrorCode
	{
		success, privilegeFail, dbFail, scriptBeforeFail, scriptAfterFail, nullClientFail, unknownFail, noSuchTemplateFail, noSuchTemplateTypeFail, alreadyDeleted, alreadyUpdate, autoCommitted;
	}

	
}
