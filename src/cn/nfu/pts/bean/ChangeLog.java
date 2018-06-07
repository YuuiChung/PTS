package cn.nfu.pts.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Map;

public interface ChangeLog extends Serializable{
	/**
	 * @description:get change log id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();
	
	/**
	 * @description:get change log create user
	 * @version:v1.0
	 * @return
	 */
	public String getCreateUser();
	
	/**
	 * @Title: setCreateUser
	 * @Description: set change log create user
	 * @param createUser
	 * @return
	 * @return: String
	 */
	public void setCreateUser(String createUser);
	
	/**
	 * @description:get change log create time
	 * @version:v1.0
	 * @return
	 */
	public Timestamp getCreateTime();
	
	/**
	 * @description:get change log action id
	 * @version:v1.0
	 * @return
	 */
	public UUID getActionId();
	
	/**
	 * @description:get change log action comment
	 * @version:v1.0
	 * @return
	 */
	public String getActionComment();
	
	/**
	 * @description:set change log action comment
	 * @version:v1.0
	 * @param actionComment
	 */
	public void setActionComment(String actionComment);
	
	/**
	 * @description:return change log base field map
	 * @version:v1.0
	 * @return
	 */
	public Map<String, Pair<Object, Object>> getBaseValueMap();
	
	/**
	 * @description:return change log extension field map
	 * @version:v1.0
	 * @return
	 */
	public Map<UUID, Pair<Object, Object>> getExtValueMap();
	
	/**
	 * @description:get basic field value by name(such as logcomment ,action id etc.)
	 * @version:v1.0
	 * @param name
	 * @return
	 */
	public Object getObject(String name);
	
	/**
	 * @description:get extension field value by field id
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public Object getObject(UUID id);
	
	/**
	 * @description:check base value map contains field 
	 * @version:v1.0
	 * @param name
	 * @return
	 */
	public boolean containsObject(String name);
	
	/**
	 * @description:check ext value map contains field 
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public boolean containsObject(UUID id);
}
