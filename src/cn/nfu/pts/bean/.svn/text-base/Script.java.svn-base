package cn.nfu.pts.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @description:script interface
 * @version:v1.0
 */
public interface Script extends Serializable
{

	/**
	 * @description:get script action ids
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getActionIds();

	/**
	 * @description:set script action ids
	 * @version:v1.0
	 * @param actionIdArray
	 */
	public void setActionIds(UUID[] actionIdArray);

	/**
	 * @description:get script create time
	 * @version:v1.0
	 * @return
	 */
	public Timestamp getCreateTime();

	/**
	 * @description:get script create user
	 * @version:v1.0
	 * @return
	 */
	public String getCreateUser();

	/**
	 * @description:get script end stat ids(after these stats execute script)
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getEndStatIds();

	/**
	 * @description:set script end stat ids
	 * @version:v1.0
	 * @param endStatIdArray
	 */
	public void setEndStatIds(UUID[] endStatIdArray);

	/**
	 * @description:get script flow id
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getFlowIds();

	/**
	 * @description:set script flow id
	 * @version:v1.0
	 * @param flowIdArray
	 */
	public void setFlowIds(UUID[] flowIdArray);

	/**
	 * @description:get script id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();
	
	/**
	 * @description:get script name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);

	/**
	 * @description:get if after data modify fail execute
	 * @version:v1.0
	 * @return
	 */
	public boolean isAfterFail();

	/**
	 * @description:set after fail execute
	 * @version:v1.0
	 * @param isAfterFail
	 */
	public void setAfterFail(boolean isAfterFail);

	/**
	 * @description:get if after query
	 * @version:v1.0
	 * @return
	 */
	public boolean isAfterQuery();

	/**
	 * @description:set after query execute script
	 * @version:v1.0
	 * @param isAfterQuery
	 */
	public void setAfterQuery(boolean isAfterQuery);

	/**
	 * @description:get after success
	 * @version:v1.0
	 * @return
	 */
	public boolean isAfterSuccess();

	/**
	 * @description:set after success execute script
	 * @version:v1.0
	 * @param isAfterSuccess
	 */
	public void setAfterSuccess(boolean isAfterSuccess);

	/**
	 * @description:get if async execute
	 * @version:v1.0
	 * @return
	 */
	public boolean isAsync();

	/**
	 * @description:set if async execute
	 * @version:v1.0
	 * @param isAsync
	 */
	public void setAsync(boolean isAsync);

	/**
	 * @description:get if before commit execute
	 * @version:v1.0
	 * @return
	 */
	public boolean isBeforeCommit();

	/**
	 * @description:set if before commit execute
	 * @version:v1.0
	 * @param isBeforeCommit
	 */
	public void setBeforeCommit(boolean isBeforeCommit);

	/**
	 * @description:get script name
	 * @version:v1.0
	 * @return
	 */
	public String getName();

	/**
	 * @description:get script xml string
	 * @version:v1.0
	 * @return
	 */
	public String getScript();

	/**
	 * @description:set script content
	 * @version:v1.0
	 * @param script
	 */
	public void setScript(String script);

	/**
	 * @description:get begin stat ids
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getBeginStatIds();

	/**
	 * @description:set begin stat ids
	 * @version:v1.0
	 * @param startStatIdArray
	 */
	public void setBeginStatIds(UUID[] startStatIdArray);

	/**
	 * @description:get template ids
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getTemplateIds();

	/**
	 * @description:set script template ids
	 * @version:v1.0
	 * @param templateIdArray
	 */
	public void setTemplateIds(UUID[] templateIdArray);

	/**
	 * @description:get script template type ids
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getTemplateTypeIds();

	/**
	 * @description:set script template type ids
	 * @version:v1.0
	 * @param templateTypeIdArray
	 */
	public void setTemplateTypeIds(UUID[] templateTypeIdArray);
	
	/**
	 * @description:set stat edit
	 * @version:v1.0
	 * @param isStatEdit
	 */
	public void setStatEdit(boolean isStatEdit);
	
	/**
	 * @description:get stat edit
	 * @version:v1.0
	 * @return
	 */
	public boolean isStatEdit();
	
	/**
	 * @description:set action edit
	 * @version:v1.0
	 * @param isActionEdit
	 */
	public void setActionEdit(boolean isActionEdit);
	
	/**
	 * @description:get action edit
	 * @version:v1.0
	 * @return
	 */
	public boolean isActionEdit();
	
	/**
	 * @description:set script create time
	 * @version:v1.0
	 * @param createTime
	 */
	public void setCreateTime(Timestamp createTime);
	
	/**
	 * @description:set script create user
	 * @version:v1.0
	 * @param createUser
	 */
	public void setCreateUser(String createUser);
	
	/**
	 * @description:set script valid
	 * @version:v1.0
	 * @param isValid
	 */
	public void setValid(boolean isValid);
	
	/**
	 * @description:get script valid
	 * @version:v1.0
	 * @return
	 */
	public boolean isValid();
	
	/**
	 * @description:set script allowed templates
	 * @version:v1.0
	 * @param templateIdsArray
	 */
	public void setAllowedTemplateIds(UUID[] templateIdsArray);
	
	/**
	 * @description:get script allowed templates
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getAllowedTemplateIds();
}
