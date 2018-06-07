package cn.nfu.pts.factory;

import cn.nfu.pts.dao.ScriptAccessSessionMySQL;
import cn.nfu.pts.service.ScriptAccessSession;

public class ScriptAccessFactory
{
	private static ScriptAccessFactory instance = null;

	public static synchronized final ScriptAccessFactory getInstance()
	{
		if (instance == null)
			instance = new ScriptAccessFactory();

		return instance;
	}

	private ScriptAccessFactory()
	{
		super();
	}

	/**
	 * @description:return script process interface
	 * @version:v1.0
	 * @param username
	 * @param keyId
	 * @return
	 */
	public synchronized ScriptAccessSession createScriptAccessSession(String username, long keyId)
	{
		return new ScriptAccessSessionMySQL(username, keyId);
	}
}
