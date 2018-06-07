package cn.nfu.pts.cache.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.nfu.pts.bean.UserInfo;
import cn.nfu.pts.cache.EhcacheHandler;
import cn.nfu.pts.dao.UserInfoAccessSessionMySQL;


public class UserInfoCache {
	private static Logger logger = Logger.getLogger(UserInfoCache.class.getName());
	
	private static class SingletonHolder{
		private static UserInfoCache instance = new UserInfoCache();
	}
	
	/**
	 * @Title:getInstance
	 * @Type:FlowCache
	 * @description:single instance
	 * @version:v1.0
	 * @return
	 */
	public static final UserInfoCache getInstance()
	{
		return SingletonHolder.instance;
	}

	private UserInfoCache()
	{
		super();
	}


	/**
	 * (non-Javadoc)
	 * <p> Title:get</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.cache.Cache#get(java.lang.String)
	 */
	public UserInfo get(String userName){
		UserInfo tmp = null;
		Object user = EhcacheHandler.getInstance().get(EhcacheHandler.FOREVER_CACHE,userName);
		if (user != null){
			if (user instanceof UserInfo) {
				tmp = (UserInfo)user;
			}
		}
		else{
			tmp = new UserInfoAccessSessionMySQL().queryUserInfoByUserName(userName);
			if (tmp != null) {
				EhcacheHandler.getInstance().set(EhcacheHandler.FOREVER_CACHE,userName, tmp);
			}
		}
		if (tmp == null) {
			logger.info("user userName : " + userName + " is not in cache");
		}
		return tmp;
	}


	/**
	 * @Title:putAllDataToCache
	 * @Type:FlowCache
	 * @description:query all users from DB, put to the cache
	 * @version:v1.0
	 */
	public void putAllDataToCache(){
		List<UserInfo> allUsers = new UserInfoAccessSessionMySQL().queryAllUsers();
		EhcacheHandler ehcacheHandler = EhcacheHandler.getInstance();

		for (UserInfo userInfo : allUsers) {
			this.set(userInfo.getUserName(), userInfo);
		}
	}

	/**
	 * @Title: set
	 * @Description: TODO
	 * @param key
	 * @param value
	 * @return: void
	 */
	public void set(String key, Object value) {
		if (value == null) {
			return;
		}
		EhcacheHandler.getInstance().set(EhcacheHandler.FOREVER_CACHE,key, value);
	}

	/**
	 * @description:remove cache by key
	 * @version:v1.0
	 * @param key
	 */
	public void remove(String key) {
		EhcacheHandler.getInstance().delete(EhcacheHandler.FOREVER_CACHE,key);
	}
}
