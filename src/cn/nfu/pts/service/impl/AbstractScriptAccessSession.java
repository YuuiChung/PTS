package cn.nfu.pts.service.impl;

import java.sql.Timestamp;

import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.ExecuteTime;
import cn.nfu.pts.bean.Script;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.bean.impl.ScriptImpl;
import cn.nfu.pts.dao.ScriptImportAccessSessionMySQL;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.DataAccessSession;
import cn.nfu.pts.service.ScriptAccessSession;
import cn.nfu.pts.service.DataAccessSession.ErrorCode;

abstract public class AbstractScriptAccessSession implements ScriptAccessSession
{
	protected String username = null;

	protected long keyId = 0;

	/**
	 * <h1> Title:</h1>
	 * <p> Description:</p>
	 * @param username
	 * @param keyId
	 */
	public AbstractScriptAccessSession(String username, long keyId)
	{
		super();

		this.username = username;
		this.keyId = keyId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:createScript</p>
	 * @param createUser
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#createScript(java.lang.String)
	 */
	public Script createScript(String createUser)
	{
		UUID scriptId = DataAccessFactory.getInstance().newUUID("SCRI");
		Timestamp createTime = new Timestamp(System.currentTimeMillis());
		return new ScriptImpl(scriptId,createUser,createTime);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:addScript</p>
	 * @param script
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#addScript(cn.nfu.pts.bean.Script)
	 */
	public UUID addScript(Script script)
	{
		return addScriptInternal(script);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:updateScript</p>
	 * @param script
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#updateScript(cn.nfu.pts.bean.Script)
	 */
	public ErrorCode updateScript(Script script)
	{
		return updateScriptInternal(script);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:removeScript</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#removeScript(cn.nfu.pts.bean.UUID)
	 */
	public ErrorCode removeScript(UUID id)
	{
		return removeScriptInternal(id);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryScript</p>
	 * @param scriptId
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#queryScript(cn.nfu.pts.bean.UUID)
	 */
	public Script queryScript(UUID scriptId)
	{
		return queryScriptInternal(scriptId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:queryScripts</p>
	 * @param createUser
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#queryScripts(java.lang.String)
	 */
	public Script[] queryScripts(String createUser)
	{
		return queryScriptsInternal(createUser);
	}

	/**
	 * @description:query scripts by data and executetime
	 * @version:v1.0
	 * @param data
	 * @param executeTime
	 * @param das
	 * @return
	 */
	public Script[] queryScripts(Data data, ExecuteTime executeTime, DataAccessSession das)
	{
		return queryScriptsInternal(data, executeTime, das);
	}

	/**
	 * @description:query all allowd scripts of template
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Script[] queryAllowedTemplateScripts(UUID templateId)
	{
		return this.queryAllowedTemplateScriptsInternal(templateId);
	}
	
	/**
	 * @description:query all scripts of template
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Script[] queryTemplateScripts(UUID templateId)
	{
		return this.queryTemplateScriptsInternal(templateId);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getScriptImportStr</p>
	 * @return
	 * @see cn.nfu.pts.service.ScriptAccessSession#getScriptImportStr()
	 */
	@Override
	public String getScriptImportStr()
	{
		return new ScriptImportAccessSessionMySQL().query();
	}

	/**
	 * @description:query all script from db by template
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	abstract protected Script[] queryTemplateScriptsInternal(UUID templateId);
	
	/**
	 * @description:query all allowed script by template 
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	abstract protected Script[] queryAllowedTemplateScriptsInternal(UUID templateId);
	
	/**
	 * @description:add script to db
	 * @version:v1.0
	 * @param script
	 * @return
	 */
	abstract protected UUID addScriptInternal(Script script);

	/**
	 * @description:update script from db
	 * @version:v1.0
	 * @param script
	 * @return
	 */
	abstract protected ErrorCode updateScriptInternal(Script script);

	/**
	 * @description:remove script from db
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	abstract protected ErrorCode removeScriptInternal(UUID id);

	/**
	 * @description:query script by script id
	 * @version:v1.0
	 * @param scriptId
	 * @return
	 */
	abstract protected Script queryScriptInternal(UUID scriptId);
	
	/**
	 * @description:query all scripts create by user
	 * @version:v1.0
	 * @param createUser
	 * @return
	 */
	abstract protected Script[] queryScriptsInternal(String createUser);
	
	/**
	 * @description:query all scripts executable by data and executeTime
	 * @version:v1.0
	 * @param data
	 * @param executeTime
	 * @param das
	 * @return
	 */
	abstract protected Script[] queryScriptsInternal(Data data, ExecuteTime executeTime, DataAccessSession das);
}
