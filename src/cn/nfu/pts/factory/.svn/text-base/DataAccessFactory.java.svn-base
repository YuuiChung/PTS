package cn.nfu.pts.factory;

import org.apache.log4j.Logger;

import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.bean.impl.UUIDImpl;
import cn.nfu.pts.dao.DataAccessSessionMySQL;
import cn.nfu.pts.dao.UUIDAccessSessionMySQL;
import cn.nfu.pts.service.DataAccessSession;
import cn.nfu.pts.service.impl.DataAccessSessionMemory;
import cn.nfu.pts.util.ConfigUtil;

public class DataAccessFactory
{
	public static final long magic = 0x8f67e3a;

	private static Logger logger = Logger.getLogger(DataAccessFactory.class.getName());
	
	private static class SingletonHolder{
		private static DataAccessFactory instance = new DataAccessFactory();
	}

	public static final DataAccessFactory getInstance()
	{
		return SingletonHolder.instance;
	}

	private DataAccessFactory()
	{
		super();
	}
	
	/**
	 * @description:get a new UUID
	 * @version:v1.0
	 * @param str
	 * @return
	 */
	public synchronized UUID newUUID(String str)
	{
		String newUUIDStr = new UUIDAccessSessionMySQL().add(str);
		return createUUID(newUUIDStr);
	}
	
	public synchronized UUID newDataUUID(String templateId)
	{
		String newUUIDStr = new DataAccessSessionMySQL().createUUID(templateId);
		return createUUID(newUUIDStr);
	}
	
	/**
	 * @description:get the data process interface by username
	 * @version:v1.0
	 * @param username:current login user
	 * @param keyId
	 * @return:data process interface
	 */
	public synchronized DataAccessSession createDataAccessSession(String username, long keyId)
	{
		return createDataAccessSession(username, null, keyId);
	}

	public synchronized DataAccessSession createDataAccessSession(String username, String agent, long keyId)
	{
		return new DataAccessSessionMemory(username, agent, keyId);
	}

	/**
	 * @description: return the UUID by string
	 * @version:v1.0
	 * @param str:uuid string
	 * @return:UUID
	 */
	public UUID createUUID(String str)
	{
		try{
			return new UUIDImpl(Integer.parseInt(str));
		}
		catch(Exception e){
			return null;
		}
	}
	
	/**
	 * @description:return the system data process interface
	 * @version:v1.0
	 * @return
	 */
	public DataAccessSession getSysDas()
	{
		return this.createDataAccessSession(ConfigUtil.sysEmail, ConfigUtil.magic);
	}
	
	/**
	 * system user
	 */
	public static final String sysUser = "admin@sohu-rd.com";
}
