package cn.nfu.pts.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import cn.nfu.pts.bean.Attachment;
import cn.nfu.pts.bean.ChangeLog;
import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.DataAccessAction;
import cn.nfu.pts.bean.Filter;
import cn.nfu.pts.bean.GuideBean;
import cn.nfu.pts.bean.JSTree;
import cn.nfu.pts.bean.Script;
import cn.nfu.pts.bean.TagBean;
import cn.nfu.pts.bean.Timer;
import cn.nfu.pts.bean.TimerAction;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.bean.UserInfo;
import cn.nfu.pts.bean.impl.UserInfoImpl;
import cn.nfu.pts.dao.AttachmentAccessSessionMySQL;
import cn.nfu.pts.dao.BackRightAccessSessionMySQL;
import cn.nfu.pts.dao.DataAccessSessionMySQL;
import cn.nfu.pts.dao.DefaultValueAccessSessionMySQL;
import cn.nfu.pts.dao.EventUserAccessSessionMySQL;
import cn.nfu.pts.dao.FieldNameAccessSessionMySQL;
import cn.nfu.pts.dao.FilterAccessSessionMySQL;
import cn.nfu.pts.dao.FlowAccessSessionMySQL;
import cn.nfu.pts.dao.GuideAccessSessionMySQL;
import cn.nfu.pts.dao.HomeFilterAccessSessionMySQL;
import cn.nfu.pts.dao.JSTreeAccessSessionMySQL;
import cn.nfu.pts.dao.LogAccessSessionMySQL;
import cn.nfu.pts.dao.NewDataNotifyAccessSessionMySQL;
import cn.nfu.pts.dao.ScriptAccessSessionMySQL;
import cn.nfu.pts.dao.TagAccessSessionMySQL;
import cn.nfu.pts.dao.TimerAccessSessionMySQL;
import cn.nfu.pts.dao.TimerActionAccessSessionMySQL;
import cn.nfu.pts.dao.UserDefaultTemplateMySQL;
import cn.nfu.pts.dao.UserInfoAccessSessionMySQL;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.factory.ScriptAccessFactory;
import cn.nfu.pts.service.ConfigManager;
import cn.nfu.pts.service.DataFilter;
import cn.nfu.pts.service.ProjectInvolveManager;
import cn.nfu.pts.service.ScriptAccessSession;
import cn.nfu.pts.util.ConfigUtil;
import cn.nfu.pts.util.CynthiaUtil;
import cn.nfu.pts.util.XMLUtil;


public class DataAccessSessionMemory extends AbstractDataAccessSession
{
	/**
	 * <h1> Title:</h1>
	 * <p> Description:</p>
	 * @param username
	 * @param agent
	 * @param keyId
	 */
	public DataAccessSessionMemory(String username, String agent, long keyId)
	{
		super(username, agent, keyId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getDataFilter</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getDataFilter()
	 */
	public DataFilter getDataFilter()
	{
		if (dataFilter == null)
			dataFilter = new DataFilterMemory(this);

		return dataFilter;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:createScriptAccessSession</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createScriptAccessSession()
	 */
	public ScriptAccessSession createScriptAccessSession()
	{
		return ScriptAccessFactory.getInstance().createScriptAccessSession(username, keyId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:createAttachment</p>
	 * @param name
	 * @param data
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createAttachment(java.lang.String, byte[])
	 */
	public Attachment createAttachment(String name, byte[] data)
	{
		return new AttachmentAccessSessionMySQL().createAttachment(name, username, data);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryAttachment</p>
	 * @param id
	 * @param needData
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAttachment(cn.nfu.pts.bean.UUID, boolean)
	 */
	public Attachment queryAttachment(UUID id, boolean needData)
	{
		Attachment[] attachmentArray = this.queryAttachments(new UUID[]{id}, needData);
		if(attachmentArray.length > 0){
			return attachmentArray[0];
		}
		
		return null;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryAttachments</p>
	 * @param ids
	 * @param needData
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAttachments(cn.nfu.pts.bean.UUID[], boolean)
	 */
	public Attachment[] queryAttachments(UUID[] ids, boolean needData)
	{
		return new AttachmentAccessSessionMySQL().queryAttachments(ids, needData);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:addFilter</p>
	 * @param filter
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addFilter(cn.nfu.pts.bean.Filter)
	 */
	public Filter addFilter(Filter filter)
	{
		return new FilterAccessSessionMySQL().addFilter(filter);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryFilters</p>
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFilters(java.lang.String)
	 */
	public Filter[] queryFilters(String username)
	{
		return new FilterAccessSessionMySQL().queryFilters(username);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryFilterIdNameMap</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFilterIdNameMap(java.lang.String)
	 */
	public Map<String,String> queryFilterIdNameMap(String userName)
	{
		return new FilterAccessSessionMySQL().queryFilterIdAndName(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:querySysFilters</p>
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#querySysFilters(java.lang.String)
	 */
	public Filter[] querySysFilters(String username)
	{
		return new FilterAccessSessionMySQL().querySysFilters(username, this);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryFocusFilters</p>
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFocusFilters(java.lang.String)
	 */
	public Filter[] queryFocusFilters(String username)
	{
		return new FilterAccessSessionMySQL().queryFocusFilters(username, this);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryFilter</p>
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFilter(cn.nfu.pts.bean.UUID)
	 */
	public Filter queryFilter(UUID filterId)
	{
		return new FilterAccessSessionMySQL().queryFilter(filterId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryAllFilters</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAllFilters()
	 */
	@Override
	public List<Filter> queryAllFilters()
	{
		return new FilterAccessSessionMySQL().queryAllFilters();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeFilter</p>
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeFilter(cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode removeFilter(UUID filterId)
	{
		Filter filter = this.queryFilter(filterId);
		if(filter == null){
			return ErrorCode.success;
		}
		
		return new FilterAccessSessionMySQL().removeFilter(filterId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:updateFilter</p>
	 * @param filter
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateFilter(cn.nfu.pts.bean.Filter)
	 */
	public ErrorCode updateFilter(Filter filter)
	{
		Document doc = null;
		try {
			doc = XMLUtil.string2Document(filter.getXml(), "UTF-8");
			if (doc != null) {
				String fieldSql = DataFilterMemory.getFilterSql(filter);
				
				if (fieldSql != null && fieldSql != "") {
					try {
						doc = XMLUtil.string2Document(filter.getXml(), "UTF-8");
						if (doc != null) {
							Node queryNode = XMLUtil.getSingleNode(doc, "query");
							Node sqlNode = XMLUtil.getSingleNode(queryNode, "sql");
							Node envNode = XMLUtil.getSingleNode(queryNode, "env");
							
							if (sqlNode != null ) {
								sqlNode.setTextContent(fieldSql);
							}else {
								Node sqlElement = doc.createElement("sql");  //将查询语句作为节点放到filter中
								sqlElement.setTextContent(fieldSql);
								queryNode.insertBefore(sqlElement, envNode);
							}
							
							filter.setXml(XMLUtil.document2String(doc, "UTF-8"));
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}  catch (Exception e) {
			e.printStackTrace();
		}
		return new FilterAccessSessionMySQL().updateFilter(filter);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:createFilter</p>
	 * @param createUser
	 * @param createTime
	 * @param fatherId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createFilter(java.lang.String, java.sql.Timestamp, cn.nfu.pts.bean.UUID)
	 */
	public Filter createFilter(String createUser, Timestamp createTime, UUID fatherId)
	{
		return new FilterAccessSessionMySQL().createFilter(createUser, createTime, fatherId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryFlowSvg</p>
	 * @param flowId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFlowSvg(cn.nfu.pts.bean.UUID)
	 */
	public String queryFlowSvg(UUID flowId)
	{
		return new FlowAccessSessionMySQL().querySvg(flowId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:createTempFilter</p>
	 * @param createUser
	 * @param createTime
	 * @param fatherId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createTempFilter(java.lang.String, java.sql.Timestamp, cn.nfu.pts.bean.UUID)
	 */
	public Filter createTempFilter(String createUser, Timestamp createTime, UUID fatherId)
	{
		return new FilterAccessSessionMySQL().creatTempFilter(createUser, createTime, fatherId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryUserFocusFilters</p>
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryUserFocusFilters(java.lang.String)
	 */
	public UUID[] queryUserFocusFilters(String username)
	{
		return new FilterAccessSessionMySQL().queryUserFocusFilters(username);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:removeUserFocusFilter</p>
	 * @param username
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeUserFocusFilter(java.lang.String, cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode removeUserFocusFilter(String username, UUID filterId)
	{
		return new FilterAccessSessionMySQL().removeUserFocusFilter(username, filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeUserFocusFilter</p>
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeUserFocusFilter(cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode removeUserFocusFilter(UUID filterId)
	{
		return new FilterAccessSessionMySQL().removeUserFocusFilter(filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addUserFocusFilter</p>
	 * @param username
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addUserFocusFilter(java.lang.String, cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode addUserFocusFilter(String username, UUID filterId)
	{
		return new FilterAccessSessionMySQL().addUserFocusFilter(username, filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeRelatedUser</p>
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeRelatedUser(java.lang.String)
	 */
	public ErrorCode removeRelatedUser(String username)
	{
		return new UserInfoAccessSessionMySQL().removeRelatedUser(username);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getNewTaskIdsByFilterAndUser</p>
	 * @param filterIdArray
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getNewTaskIdsByFilterAndUser(cn.nfu.pts.bean.UUID[], java.lang.String)
	 */
	public String getNewTaskIdsByFilterAndUser(UUID[] filterIdArray, String username)
	{
		return new NewDataNotifyAccessSessionMySQL(this).getNewTaskIdsByFilterAndUser(filterIdArray, username);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:deleteFilterUserTasks</p>
	 * @param dataId
	 * @see cn.nfu.pts.service.DataAccessSession#deleteFilterUserTasks(cn.nfu.pts.bean.UUID)
	 */
	public void deleteFilterUserTasks(UUID dataId)
	{
		new NewDataNotifyAccessSessionMySQL(this).deleteFilterUserTasks(dataId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:cleanNewTagByTaskIds</p>
	 * @param filterId
	 * @param taskIdArray
	 * @param username
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#cleanNewTagByTaskIds(cn.nfu.pts.bean.UUID, cn.nfu.pts.bean.UUID[], java.lang.String)
	 */
	public String cleanNewTagByTaskIds(UUID filterId, UUID[] taskIdArray, String username)
	{
		return new NewDataNotifyAccessSessionMySQL(this).cleanNewTagByTaskIds(filterId, taskIdArray, username);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:createTimer</p>
	 * @param createUser
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createTimer(java.lang.String)
	 */
	public Timer createTimer(String createUser)
	{
		return new TimerAccessSessionMySQL().createTimer(createUser);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addTimer</p>
	 * @param timer
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addTimer(cn.nfu.pts.bean.Timer)
	 */
	public ErrorCode addTimer(Timer timer)
	{
		return new TimerAccessSessionMySQL().addTimer(timer);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeTimer</p>
	 * @param timerId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeTimer(cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode removeTimer(UUID timerId)
	{
		return new TimerAccessSessionMySQL().removeTimer(timerId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:modifyTimer</p>
	 * @param timer
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#modifyTimer(cn.nfu.pts.bean.Timer)
	 */
	public ErrorCode modifyTimer(Timer timer)
	{
		return new TimerAccessSessionMySQL().modifyTimer(timer);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimer</p>
	 * @param timerId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimer(cn.nfu.pts.bean.UUID)
	 */
	public Timer queryTimer(UUID timerId)
	{
		return new TimerAccessSessionMySQL().queryTimer(timerId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimers</p>
	 * @param createUser
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimers(java.lang.String)
	 */
	public Timer[] queryTimers(String createUser)
	{
		return new TimerAccessSessionMySQL().queryTimers(createUser);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimers</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimers()
	 */
	public Timer[] queryTimers()
	{
		return new TimerAccessSessionMySQL().queryTimers();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimersByActionId</p>
	 * @param timerActionId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimersByActionId(cn.nfu.pts.bean.UUID)
	 */
	public Timer[] queryTimersByActionId(UUID timerActionId)
	{
		return new TimerAccessSessionMySQL().queryTimersByActionId(timerActionId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:createTimerAction</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createTimerAction()
	 */
	public TimerAction createTimerAction()
	{
		return new TimerActionAccessSessionMySQL().createTimerAction();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addTimerAction</p>
	 * @param timerAction
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addTimerAction(cn.nfu.pts.bean.TimerAction)
	 */
	public ErrorCode addTimerAction(TimerAction timerAction)
	{
		return new TimerActionAccessSessionMySQL().addTimerAction(timerAction);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeTimerAction</p>
	 * @param timerActionId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeTimerAction(cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode removeTimerAction(UUID timerActionId)
	{
		return new TimerActionAccessSessionMySQL().removeTimerAction(timerActionId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:modifyTimerAction</p>
	 * @param timerAction
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#modifyTimerAction(cn.nfu.pts.bean.TimerAction)
	 */
	public ErrorCode modifyTimerAction(TimerAction timerAction)
	{
		return new TimerActionAccessSessionMySQL().modifyTimerAction(timerAction);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimerAction</p>
	 * @param timerActionId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimerAction(cn.nfu.pts.bean.UUID)
	 */
	public TimerAction queryTimerAction(UUID timerActionId)
	{
		return new TimerActionAccessSessionMySQL().queryTimerAction(timerActionId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimerActions</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimerActions()
	 */
	public TimerAction[] queryTimerActions()
	{
		return new TimerActionAccessSessionMySQL().queryTimerActions();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isDataExist</p>
	 * @param dataId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#isDataExist(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public boolean isDataExist(UUID dataId) {
		return new DataAccessSessionMySQL().isExist(dataId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryFocusUsersByFilter</p>
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFocusUsersByFilter(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public List<String> queryFocusUsersByFilter(UUID filterId) {
		return new FilterAccessSessionMySQL().queryFocusUsersByFilter(filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryChilderNodes</p>
	 * @param id
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryChilderNodes(int, java.lang.String)
	 */
	@Override
	public List<JSTree> queryChilderNodes(int id,String userName) {
		return new JSTreeAccessSessionMySQL().getNodeChilden(id, userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryJSTreeNodeById</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryJSTreeNodeById(int)
	 */
	@Override
	public JSTree queryJSTreeNodeById(int id) {
		return new JSTreeAccessSessionMySQL().getNodeById(id);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addJSTreeNode</p>
	 * @param parentId
	 * @param position
	 * @param title
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addJSTreeNode(int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public int addJSTreeNode(int parentId, int position, String title,String userName) {
		return new JSTreeAccessSessionMySQL().addNode(parentId, position, title,userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removJSTreeNode</p>
	 * @param id
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removJSTreeNode(int, java.lang.String)
	 */
	@Override
	public boolean removJSTreeNode(int id,String userName) {
		return new JSTreeAccessSessionMySQL().removeNode(id,userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:moveJSTreeNode</p>
	 * @param id
	 * @param refId
	 * @param position
	 * @param title
	 * @param copy
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#moveJSTreeNode(int, int, int, java.lang.String, boolean, java.lang.String)
	 */
	@Override
	public boolean moveJSTreeNode(int id, int refId, int position,
			String title, boolean copy, String userName) {
		return new JSTreeAccessSessionMySQL().moveNode(id, refId, position, title, copy,userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateJSTreeNode</p>
	 * @param id
	 * @param title
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateJSTreeNode(int, java.lang.String)
	 */
	@Override
	public boolean updateJSTreeNode(int id, String title) {
		return new JSTreeAccessSessionMySQL().updateNodeName(id, title);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTimerByFilterId</p>
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTimerByFilterId(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public Timer[] queryTimerByFilterId(UUID filterId) {
		return new TimerAccessSessionMySQL().queryTimersByFilterId(filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryAllFolderFilters</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAllFolderFilters(java.lang.String)
	 */
	@Override
	public List<String> queryAllFolderFilters(String userName) {
		return new JSTreeAccessSessionMySQL().getAllFolderFilters(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryFolderFilters</p>
	 * @param nodeId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFolderFilters(int)
	 */
	@Override
	public List<String> queryFolderFilters(int nodeId) {
		return new JSTreeAccessSessionMySQL().getFolderFilters(nodeId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:moveFilterNode</p>
	 * @param filterId
	 * @param refId
	 * @param parentId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#moveFilterNode(int, int, int)
	 */
	@Override
	public boolean moveFilterNode(int filterId, int refId, int parentId) {
		return new JSTreeAccessSessionMySQL().moveFilter(filterId, refId, parentId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryRootNode</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryRootNode(int)
	 */
	@Override
	public List<JSTree> queryRootNode(int id) {
		return new JSTreeAccessSessionMySQL().getRootNode(id);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeFilterId</p>
	 * @param filterId
	 * @param parentId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeFilterId(int, int)
	 */
	@Override
	public boolean removeFilterId(int filterId, int parentId) {
		return new JSTreeAccessSessionMySQL().removeFilterId(filterId, parentId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryFavoriteFilters</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryFavoriteFilters(java.lang.String)
	 */
	@Override
	public String[] queryFavoriteFilters(String userName) {
		return new JSTreeAccessSessionMySQL().getFavorateFilters(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addFavoriteFilter</p>
	 * @param userName
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addFavoriteFilter(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addFavoriteFilter(String userName, String filterId) {
		return new JSTreeAccessSessionMySQL().addFavoriteFilters(userName, filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeFavoriteFilter</p>
	 * @param userName
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeFavoriteFilter(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean removeFavoriteFilter(String userName, String filterId) {
		return new JSTreeAccessSessionMySQL().removeFavoriteFilters(userName, filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updataFavoriteFilters</p>
	 * @param filterarrays
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updataFavoriteFilters(java.lang.String, java.lang.String)
	 */
	public boolean updataFavoriteFilters(String filterarrays,String userName){
		return new JSTreeAccessSessionMySQL().updateFavoriteFilters(filterarrays,userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addHomeFilter</p>
	 * @param userName
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addHomeFilter(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addHomeFilter(String userName, String filterId) {
		return new HomeFilterAccessSessionMySQL().addHomeFilter(userName, filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryHomeFilter</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryHomeFilter(java.lang.String)
	 */
	@Override
	public String queryHomeFilter(String userName) {
		return new HomeFilterAccessSessionMySQL().getHomeFilter(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateHomeFilter</p>
	 * @param userName
	 * @param filterId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateHomeFilter(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateHomeFilter(String userName, String filterId) {
		return new HomeFilterAccessSessionMySQL().updateHomeFilter(userName, filterId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateFavoritesFilters</p>
	 * @param filterId
	 * @param position
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateFavoritesFilters(java.lang.String, int, java.lang.String)
	 */
	@Override
	public boolean updateFavoritesFilters(String filterId, int position,
			String userName) {
		return new JSTreeAccessSessionMySQL().updateFavorites(filterId, position, userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addFilterToFolder</p>
	 * @param fitlerId
	 * @param nodeId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addFilterToFolder(java.lang.String, int)
	 */
	@Override
	public boolean addFilterToFolder(String fitlerId, int nodeId) {
		return new JSTreeAccessSessionMySQL().addFilterToFolder(fitlerId, nodeId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryAllScripts</p>
	 * @param userName
	 * @param keyId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAllScripts(java.lang.String, long)
	 */
	@Override
	public List<Script> queryAllScripts(String userName,long keyId) {
		return new ScriptAccessSessionMySQL(userName,keyId).queryAllScripts();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateFilterOrders</p>
	 * @param folderId
	 * @param userName
	 * @param newOrders
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateFilterOrders(int, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateFilterOrders(int folderId, String userName,
			String newOrders) {
		return new JSTreeAccessSessionMySQL().updateFiltersOrder(folderId, userName, newOrders);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryDefaultFilters</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryDefaultFilters(java.lang.String)
	 */
	@Override
	public List<String> queryDefaultFilters(String userName) {
		return  new JSTreeAccessSessionMySQL().getDefaultFilters(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateDefaultFilters</p>
	 * @param userName
	 * @param filters
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateDefaultFilters(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateDefaultFilters(String userName, String filters) {
		return  new JSTreeAccessSessionMySQL().updateDefaultFilters(userName, filters);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addEvent</p>
	 * @param eventName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addEvent(java.lang.String)
	 */
	@Override
	public boolean addEvent(String eventName) {
		return new EventUserAccessSessionMySQL().addEvent(eventName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addEventUser</p>
	 * @param userName
	 * @param eventId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addEventUser(java.lang.String, int)
	 */
	@Override
	public boolean addEventUser(String userName, int eventId) {
		return new EventUserAccessSessionMySQL().addEventUser(userName, eventId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeEventUser</p>
	 * @param userName
	 * @param eventId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeEventUser(java.lang.String, int)
	 */
	@Override
	public boolean removeEventUser(String userName, int eventId) {
		return new EventUserAccessSessionMySQL().deleteEventUser(userName, eventId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateEvent</p>
	 * @param eventName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateEvent(java.lang.String)
	 */
	@Override
	public boolean updateEvent(String eventName) {
		return new EventUserAccessSessionMySQL().updateEvent(eventName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isValidUser</p>
	 * @param userName
	 * @param eventId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#isValidUser(java.lang.String, int)
	 */
	@Override
	public boolean isValidUser(String userName, int eventId) {
		return new EventUserAccessSessionMySQL().isValidUser(userName, eventId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addScript</p>
	 * @param script
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addScript(cn.nfu.pts.bean.Script)
	 */
	@Override
	public UUID addScript(Script script) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).addScript(script);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryAllScripts</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAllScripts()
	 */
	@Override
	public List<Script> queryAllScripts() {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).queryAllScripts();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryScript</p>
	 * @param scriptId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryScript(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public Script queryScript(UUID scriptId) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).queryScript(scriptId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryScriptNoImport</p>
	 * @param scriptId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryScriptNoImport(cn.nfu.pts.bean.UUID)
	 */
	public Script queryScriptNoImport(UUID scriptId){
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).queryScriptNoImport(scriptId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeScript</p>
	 * @param scriptId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeScript(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public ErrorCode removeScript(UUID scriptId) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).removeScript(scriptId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateScript</p>
	 * @param script
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateScript(cn.nfu.pts.bean.Script)
	 */
	@Override
	public ErrorCode updateScript(Script script) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).updateScript(script);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:createScript</p>
	 * @param createUser
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#createScript(java.lang.String)
	 */
	@Override
	public Script createScript(String createUser) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).createScript(createUser);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryAllowedTemplateScripts</p>
	 * @param templateId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAllowedTemplateScripts(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public Script[] queryAllowedTemplateScripts(UUID templateId) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).queryAllowedTemplateScripts(templateId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryTemplateScripts</p>
	 * @param templateId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryTemplateScripts(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public Script[] queryTemplateScripts(UUID templateId) {
		return new ScriptAccessSessionMySQL(ConfigUtil.sysEmail,DataAccessFactory.magic).queryTemplateScripts(templateId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addOrUpdateUserDefaultTemplate</p>
	 * @param userName
	 * @param templateId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addOrUpdateUserDefaultTemplate(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addOrUpdateUserDefaultTemplate(String userName,
			String templateId) {
		return new UserDefaultTemplateMySQL().addOrUpdateUserDefaultTemplate(userName, templateId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getUserDefaultTemplate</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getUserDefaultTemplate(java.lang.String)
	 */
	@Override
	public String getUserDefaultTemplate(String userName) {
		return new UserDefaultTemplateMySQL().getDefaultTemplateId(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addUserInfo</p>
	 * @param userInfo
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addUserInfo(cn.nfu.pts.bean.UserInfo)
	 */
	@Override
	public boolean addUserInfo(UserInfo userInfo) {
		return new UserInfoAccessSessionMySQL().addUserInfo(userInfo);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:isUserExisted</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#isUserExisted(java.lang.String)
	 */
	@Override
	public boolean isUserExisted(String userName) {
		return new UserInfoAccessSessionMySQL().isUserExisted(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryUserInfoById</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryUserInfoById(int)
	 */
	@Override
	public UserInfo queryUserInfoById(int id) {
		return new UserInfoAccessSessionMySQL().queryUserInfoById(id);
	}
	
	/**0
	 * (non-Javadoc)
	 * <p> Title:queryUserInfoByUserName</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryUserInfoByUserName(java.lang.String)
	 */
	public UserInfo queryUserInfoByUserName(String userName) {
		if (ConfigManager.getEnableSso()) {
			return ProjectInvolveManager.getInstance().getUserInfoByMail(userName);
		}else {
			return new UserInfoAccessSessionMySQL().queryUserInfoByUserName(userName);
		}
	}
	
	/**
	 * 
	 * @description:TODO
	 * @version:v1.0
	 * @param userMails
	 * @return
	 */
	public Map<String, UserInfo> queryUserInfoByUserNames(String[] userMails){
		return new UserInfoAccessSessionMySQL().queryUserInfoByUserNames(userMails);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeUserInfo</p>
	 * @param userInfo
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#removeUserInfo(cn.nfu.pts.bean.UserInfo)
	 */
	@Override
	public boolean removeUserInfo(UserInfo userInfo) {
		return new UserInfoAccessSessionMySQL().removeUserInfo(userInfo);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateUserInfo</p>
	 * @param userInfo
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateUserInfo(cn.nfu.pts.bean.UserInfo)
	 */
	@Override
	public boolean updateUserInfo(UserInfo userInfo) {
		return new UserInfoAccessSessionMySQL().updateUserInfo(userInfo);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getUserClassifyDataMap</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getUserClassifyDataMap(java.lang.String)
	 */
	@Override
	public Map<String, String> getUserClassifyDataMap(String userName) {
		return new TagAccessSessionMySQL().getUserTagDataMap(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateSvg</p>
	 * @param flowId
	 * @param svgCode
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateSvg(cn.nfu.pts.bean.UUID, java.lang.String)
	 */
	@Override
	public boolean updateSvg(UUID flowId, String svgCode) {
		return new FlowAccessSessionMySQL().updateSvg(flowId, svgCode);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addTag</p>
	 * @param userName
	 * @param tagName
	 * @param tagColor
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addTag(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int addTag(String userName, String tagName, String tagColor){
		return new TagAccessSessionMySQL().addTag(userName, tagName,tagColor);
	}
	
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateTag</p>
	 * @param tagId
	 * @param tagName
	 * @param tagColor
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateTag(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean updateTag(String tagId, String tagName, String tagColor){
		return new TagAccessSessionMySQL().updateTag(tagId, tagName,tagColor);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:deleteTag</p>
	 * @param tagId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#deleteTag(java.lang.String)
	 */
	@Override
	public boolean deleteTag(String tagId){
		return new TagAccessSessionMySQL().deleteTag(tagId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getAllTag</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getAllTag(java.lang.String)
	 */
	@Override
	public List<TagBean> getAllTag(String userName){
		return new TagAccessSessionMySQL().getAllTag(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addTagData</p>
	 * @param toTagId
	 * @param dataIds
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addTagData(java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean addTagData(String toTagId, String[] dataIds){
		return new TagAccessSessionMySQL().addTagData(toTagId, dataIds);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:deleteTagData</p>
	 * @param tagId
	 * @param dataIds
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#deleteTagData(java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean deleteTagData(String tagId, String[] dataIds){
		return new TagAccessSessionMySQL().deleteTagData(tagId, dataIds);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getTagDataById</p>
	 * @param tagId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getTagDataById(java.lang.String)
	 */
	@Override
	public String[] getTagDataById(String tagId){
		return new TagAccessSessionMySQL().getTagDataById(tagId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getDataTags</p>
	 * @param userName
	 * @param dataId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getDataTags(java.lang.String, java.lang.String)
	 */
	@Override
	public List<TagBean> getDataTags(String userName,String dataId){
		return new TagAccessSessionMySQL().getDataTags(userName,dataId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setDefaultValues</p>
	 * @param userName
	 * @param templateId
	 * @param defaultValueJson
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#setDefaultValues(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean setDefaultValues(String userName, String templateId, String defaultValueJson){
		return new DefaultValueAccessSessionMySQL().setDefaultValues(userName,templateId,defaultValueJson);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getDefaultValues</p>
	 * @param userName
	 * @param templateId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getDefaultValues(java.lang.String, java.lang.String)
	 */
	@Override
	public String getDefaultValues(String userName, String templateId){
		return new DefaultValueAccessSessionMySQL().getDefaultValues(userName,templateId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getBackRightUsers</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getBackRightUsers()
	 */
	@Override
	public List<UserInfo> getBackRightUsers(){
		return new BackRightAccessSessionMySQL().getBackRightUsers();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addBackRightUser</p>
	 * @param userMail
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addBackRightUser(java.lang.String)
	 */
	@Override
	public boolean addBackRightUser(String userMail){
		return new BackRightAccessSessionMySQL().addBackRightUser(userMail);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:delBackRightUser</p>
	 * @param userMail
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#delBackRightUser(java.lang.String)
	 */
	@Override
	public boolean delBackRightUser(String userMail){
		return new BackRightAccessSessionMySQL().delBackRightUser(userMail);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getTemplateRightUser</p>
	 * @param templateId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getTemplateRightUser(java.lang.String)
	 */
	@Override
	public List<UserInfo> getTemplateRightUser(String templateId){
		
		if (ConfigManager.getProjectInvolved()) {
			List<UserInfo> allUsers = new ArrayList<UserInfo>();
			Set<String> users = new BackRightAccessSessionMySQL().getTemplateRightUserMails(templateId);
			for (String user : users) {
				UserInfo userInfo = new UserInfoImpl();
				userInfo.setUserName(user);
				userInfo.setNickName(CynthiaUtil.getUserAlias(user));
				allUsers.add(userInfo);
			}
			return allUsers;
		}else {
			return new BackRightAccessSessionMySQL().getTemplateRightUser(templateId);
		}
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:delUserTemplateRight</p>
	 * @param templateId
	 * @param userMail
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#delUserTemplateRight(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean delUserTemplateRight(String templateId, String userMail){
		return new BackRightAccessSessionMySQL().delUserTemplateRight(templateId,userMail);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addUserTemplateRight</p>
	 * @param templateIds
	 * @param userMail
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addUserTemplateRight(java.lang.String[], java.lang.String)
	 */
	@Override
	public boolean addUserTemplateRight(String[] templateIds, String userMail){
		return new BackRightAccessSessionMySQL().addUserTemplateRight(templateIds,userMail);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryUserTemplateRights</p>
	 * @param userMail
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryUserTemplateRights(java.lang.String)
	 */
	@Override
	public Map<String, String> queryUserTemplateRights(String userMail){
		return new BackRightAccessSessionMySQL().queryUserTemplateRights(userMail);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setSystemOption</p>
	 * @param systemJson
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#setSystemOption(java.lang.String)
	 */
	@Override
	public boolean setSystemOption(String systemJson){
		return new BackRightAccessSessionMySQL().setSystemOption(systemJson);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getSystemOption</p>
	 * @param userMail
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getSystemOption(java.lang.String)
	 */
	@Override
	public String getSystemOption(String userMail){
		return new BackRightAccessSessionMySQL().getSystemOption(userMail);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addFieldColName</p>
	 * @param templateId
	 * @param fieldColName
	 * @param fieldId
	 * @param fieldType
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addFieldColName(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean addFieldColName(String templateId,String fieldColName,String fieldId,String fieldType){
		return new FieldNameAccessSessionMySQL().addFieldColName(templateId,fieldColName,fieldId,fieldType);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryStatisticByUser</p>
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryStatisticByUser(java.lang.String)
	 */
	@Override
	public TimerAction[] queryStatisticByUser(String userName)
	{
		return new TimerActionAccessSessionMySQL().queryStatisticByUser(userName);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateDataLog</p>
	 * @param dataId
	 * @param logIndex
	 * @param logContent
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateDataLog(cn.nfu.pts.bean.UUID, int, java.lang.String)
	 */
	public boolean updateDataLog(UUID dataId, int logIndex, String logContent){
		Data data = queryData(dataId);
		if (data == null) {
			return false;
		}
		try {
			ChangeLog changeLog = data.getChangeLogs()[logIndex-1];
			changeLog.setActionComment(logContent);
			updateCache(DataAccessAction.update, dataId.getValue(), data);
			return new LogAccessSessionMySQL().updateLogComment(dataId, data.getTemplateId(), logIndex, logContent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:queryAllUsersByStatAndName</p>
	 * @param userStat
	 * @param userName
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#queryAllUsersByStatAndName(java.lang.String, java.lang.String)
	 */
	public List<UserInfo> queryAllUsersByStatAndName(String curUser,String userStat,String queryUser){
		if (ConfigManager.getProjectInvolved()) {
			return ProjectInvolveManager.getInstance().getCompanyUsersByMail(curUser);
		}else {
			return new UserInfoAccessSessionMySQL().queryAllUsersByStatAndName(userStat,queryUser);
		}
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:updateAttachment</p>
	 * @param attachment
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#updateAttachment(cn.nfu.pts.bean.Attachment)
	 */
	public boolean updateAttachment(Attachment attachment){
		return new AttachmentAccessSessionMySQL().updateAttachment(attachment);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:addtemplateUserRight</p>
	 * @param templateId
	 * @param users
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#addtemplateUserRight(java.lang.String, java.lang.String[])
	 */
	public boolean addtemplateUserRight(String templateId,String[] users){
		return new BackRightAccessSessionMySQL().addtemplateUserRight(templateId, users);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:delTemplateUserRight</p>
	 * @param templateId
	 * @param user
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#delTemplateUserRight(java.lang.String, java.lang.String)
	 */
	public boolean delTemplateUserRight(String templateId,String user){
		return new BackRightAccessSessionMySQL().deltemplateUserRight(templateId, user);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getAllGuide</p>
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getAllGuide()
	 */
	public List<GuideBean> queryAllGuide(){
		return new GuideAccessSessionMySQL().getAll();
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getGuideHtmlByGuideId</p>
	 * @param guideId
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#getGuideHtmlByGuideId(java.lang.String)
	 */
	public String queryGuideHtmlByGuideId( String guideId){
		return new GuideAccessSessionMySQL().getGuideHtmlByGuideId(guideId);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setValidDataOfTemplate</p>
	 * @param templateId
	 * @param isValid
	 * @see cn.nfu.pts.service.DataAccessSession#setValidDataOfTemplate(UUID, boolean)
	 */
	public boolean setValidDataOfTemplate(UUID templateId , boolean isValid){
		return new DataAccessSessionMySQL().setValidDataOfTemplate(templateId,isValid);
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:saveGuideHtml</p>
	 * @param guideId
	 * @param guideHtml
	 * @return
	 * @see cn.nfu.pts.service.DataAccessSession#saveGuideHtml(java.lang.String, java.lang.String)
	 */
	public boolean saveGuideHtml(String guideId , String guideHtml){
		return new GuideAccessSessionMySQL().saveGuideHtml(guideId, guideHtml);
	}
}
