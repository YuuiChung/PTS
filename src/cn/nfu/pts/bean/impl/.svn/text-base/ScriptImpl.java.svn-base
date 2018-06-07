package cn.nfu.pts.bean.impl;

import java.sql.Timestamp;

import cn.nfu.pts.bean.Script;
import cn.nfu.pts.bean.UUID;

public class ScriptImpl implements Script
{
	private static final long serialVersionUID = -2214193288219527376L;
	private UUID id = null;
	private String name = null;
	private String createUser = null;
	private Timestamp createTime = null;
	private UUID[] templateTypeIdArray = null;
	private UUID[] templateIdArray = null;
	private UUID[] flowIdArray = null;
	private UUID[] beginStatIdArray = null;
	private UUID[] endStatIdArray = null;
	private UUID[] actionIdArray = null;
	private boolean isAsync = false;
	private boolean isBeforeCommit = false;
	private boolean isAfterSuccess = false;
	private boolean isAfterFail = false;
	private boolean isAfterQuery = false;
	private boolean isStatEdit = false;
	private boolean isActionEdit = false;
	private boolean isValid = false;
	private UUID[]  allowedTemplateIds = null;
	private String script = null;

	/**
	 * <h1> Title:</h1>
	 * <p> Description:init script</p>
	 * @param id
	 * @param createUser
	 * @param createTime
	 */
	public ScriptImpl(UUID id, String createUser, Timestamp createTime)
	{
		super();

		this.id = id;
		this.createUser = createUser;
		this.createTime = createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getActionIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getActionIds()
	 */
	public UUID[] getActionIds()
	{
		return actionIdArray;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setActionIds</p>
	 * @param actionIdArray
	 * @see cn.nfu.pts.bean.Script#setActionIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setActionIds(UUID[] actionIdArray)
	{
		this.actionIdArray = actionIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateTime</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getCreateTime()
	 */
	public Timestamp getCreateTime()
	{
		return createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setCreateTime</p>
	 * @param createTime
	 * @see cn.nfu.pts.bean.Script#setCreateTime(java.sql.Timestamp)
	 */
	public void setCreateTime(Timestamp createTime)
	{
		this.createTime = createTime;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateUser</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getCreateUser()
	 */
	public String getCreateUser()
	{
		return createUser;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setCreateUser</p>
	 * @param createUser
	 * @see cn.nfu.pts.bean.Script#setCreateUser(java.lang.String)
	 */
	public void setCreateUser(String createUser)
	{
		this.createUser = createUser;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getEndStatIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getEndStatIds()
	 */
	public UUID[] getEndStatIds()
	{
		return endStatIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setEndStatIds</p>
	 * @param endStatIdArray
	 * @see cn.nfu.pts.bean.Script#setEndStatIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setEndStatIds(UUID[] endStatIdArray)
	{
		this.endStatIdArray = endStatIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFlowIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getFlowIds()
	 */
	public UUID[] getFlowIds()
	{
		return flowIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setFlowIds</p>
	 * @param flowIdArray
	 * @see cn.nfu.pts.bean.Script#setFlowIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setFlowIds(UUID[] flowIdArray)
	{
		this.flowIdArray = flowIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getId()
	 */
	public UUID getId()
	{
		return id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isAfterFail</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isAfterFail()
	 */
	public boolean isAfterFail()
	{
		return isAfterFail;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setAfterFail</p>
	 * @param isAfterFail
	 * @see cn.nfu.pts.bean.Script#setAfterFail(boolean)
	 */
	public void setAfterFail(boolean isAfterFail)
	{
		this.isAfterFail = isAfterFail;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isAfterQuery</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isAfterQuery()
	 */
	public boolean isAfterQuery()
	{
		return isAfterQuery;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setAfterQuery</p>
	 * @param isAfterQuery
	 * @see cn.nfu.pts.bean.Script#setAfterQuery(boolean)
	 */
	public void setAfterQuery(boolean isAfterQuery)
	{
		this.isAfterQuery = isAfterQuery;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isAfterSuccess</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isAfterSuccess()
	 */
	public boolean isAfterSuccess()
	{
		return isAfterSuccess;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setAfterSuccess</p>
	 * @param isAfterSuccess
	 * @see cn.nfu.pts.bean.Script#setAfterSuccess(boolean)
	 */
	public void setAfterSuccess(boolean isAfterSuccess)
	{
		this.isAfterSuccess = isAfterSuccess;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isAsync</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isAsync()
	 */
	public boolean isAsync()
	{
		return isAsync;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setAsync</p>
	 * @param isAsync
	 * @see cn.nfu.pts.bean.Script#setAsync(boolean)
	 */
	public void setAsync(boolean isAsync)
	{
		this.isAsync = isAsync;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isBeforeCommit</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isBeforeCommit()
	 */
	public boolean isBeforeCommit()
	{
		return isBeforeCommit;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setBeforeCommit</p>
	 * @param isBeforeCommit
	 * @see cn.nfu.pts.bean.Script#setBeforeCommit(boolean)
	 */
	public void setBeforeCommit(boolean isBeforeCommit)
	{
		this.isBeforeCommit = isBeforeCommit;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getName()
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Script#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getScript</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getScript()
	 */
	public String getScript()
	{
		return script;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setScript</p>
	 * @param script
	 * @see cn.nfu.pts.bean.Script#setScript(java.lang.String)
	 */
	public void setScript(String script)
	{
		this.script = script;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getBeginStatIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getBeginStatIds()
	 */
	public UUID[] getBeginStatIds()
	{
		return beginStatIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setBeginStatIds</p>
	 * @param beginStatIdArray
	 * @see cn.nfu.pts.bean.Script#setBeginStatIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setBeginStatIds(UUID[] beginStatIdArray)
	{
		this.beginStatIdArray = beginStatIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getTemplateIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getTemplateIds()
	 */
	public UUID[] getTemplateIds()
	{
		return templateIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setTemplateIds</p>
	 * @param templateIdArray
	 * @see cn.nfu.pts.bean.Script#setTemplateIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setTemplateIds(UUID[] templateIdArray)
	{
		this.templateIdArray = templateIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getTemplateTypeIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getTemplateTypeIds()
	 */
	public UUID[] getTemplateTypeIds()
	{
		return templateTypeIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setTemplateTypeIds</p>
	 * @param templateTypeIdArray
	 * @see cn.nfu.pts.bean.Script#setTemplateTypeIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setTemplateTypeIds(UUID[] templateTypeIdArray)
	{
		this.templateTypeIdArray = templateTypeIdArray;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isStatEdit</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isStatEdit()
	 */
	public boolean isStatEdit() {
		return isStatEdit;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setStatEdit</p>
	 * @param isStatEdit
	 * @see cn.nfu.pts.bean.Script#setStatEdit(boolean)
	 */
	public void setStatEdit(boolean isStatEdit) {
		this.isStatEdit = isStatEdit;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isActionEdit</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isActionEdit()
	 */
	public boolean isActionEdit() {
		return isActionEdit;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setActionEdit</p>
	 * @param isActionEdit
	 * @see cn.nfu.pts.bean.Script#setActionEdit(boolean)
	 */
	public void setActionEdit(boolean isActionEdit) {
		this.isActionEdit = isActionEdit;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getAllowedTemplateIds</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#getAllowedTemplateIds()
	 */
	public UUID[] getAllowedTemplateIds() {
		return allowedTemplateIds;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setAllowedTemplateIds</p>
	 * @param allowedTemplateIds
	 * @see cn.nfu.pts.bean.Script#setAllowedTemplateIds(cn.nfu.pts.bean.UUID[])
	 */
	public void setAllowedTemplateIds(UUID[] allowedTemplateIds) {
		this.allowedTemplateIds = allowedTemplateIds;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:isValid</p>
	 * @return
	 * @see cn.nfu.pts.bean.Script#isValid()
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setValid</p>
	 * @param isValid
	 * @see cn.nfu.pts.bean.Script#setValid(boolean)
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	
}
