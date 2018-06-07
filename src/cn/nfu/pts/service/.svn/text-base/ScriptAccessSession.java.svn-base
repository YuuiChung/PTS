package cn.nfu.pts.service;

import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.ExecuteTime;
import cn.nfu.pts.bean.Flow;
import cn.nfu.pts.bean.Script;
import cn.nfu.pts.bean.Template;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.service.DataAccessSession.ErrorCode;

public interface ScriptAccessSession
{
	/**
	 * @description:create script
	 * @version:v1.0
	 * @param createUser
	 * @return
	 */
	public Script createScript(String createUser);
	
	/**
	 * @description:get script import string
	 * @version:v1.0
	 * @return
	 */
	public String getScriptImportStr();

	/**
	 * @description:add script to db
	 * @version:v1.0
	 * @param script
	 * @return
	 */
	public UUID addScript(Script script);

	/**
	 * @description:update script
	 * @version:v1.0
	 * @param script
	 * @return
	 */
	public ErrorCode updateScript(Script script);

	/**
	 * @description:remove script
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public ErrorCode removeScript(UUID id);

	/**
	 * @description:query script by script id
	 * @version:v1.0
	 * @param scriptId
	 * @return
	 */
	public Script queryScript(UUID scriptId);

	/**
	 * @description:query all script create by user
	 * @version:v1.0
	 * @param createUser
	 * @return
	 */
	public Script[] queryScripts(String createUser);

	/**
	 * @description:query all executable scripts
	 * @version:v1.0
	 * @param data
	 * @param executeTime
	 * @param das
	 * @param template
	 * @param flow
	 * @return
	 */
	public Script[] queryScripts(Data data, ExecuteTime executeTime, DataAccessSession das , Template template , Flow flow);
}