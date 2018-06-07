package cn.nfu.pts.bean;

import java.io.Serializable;

/**
 * @description:timer action interface
 * @version:v1.0
 */
public interface TimerAction extends Serializable
{
	/**
	 * @description:get timer action create user
	 * @version:v1.0
	 * @return
	 */
	public String getCreateUser();
	
	/**
	 * @description:set timer action create user
	 * @version:v1.0
	 * @param createUser
	 */
	public void setCreateUser(String createUser);
	
	/**
	 * @description:get timer action class name
	 * @version:v1.0
	 * @return
	 */
	public String getClassName();

	/**
	 * @description:set timer action class name
	 * @version:v1.0
	 * @param className
	 */
	public void setClassName(String className);

	/**
	 * @description:get timer action method
	 * @version:v1.0
	 * @return
	 */
	public String getMethod();

	/**
	 * @description:set timer action  method
	 * @version:v1.0
	 * @param method
	 */
	public void setMethod(String method);

	/**
	 * @description:get timer action  param
	 * @version:v1.0
	 * @return
	 */
	public String getParam();

	/**
	 * @description:set timer action param
	 * @version:v1.0
	 * @param param
	 */
	public void setParam(String param);

	/**
	 * @description:get timer action  id
	 * @version:v1.0
	 * @return
	 */
	public UUID getId();

	/**
	 * @description:get timer action name
	 * @version:v1.0
	 * @return
	 */
	public String getName();

	/**
	 * @description:set timer action name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * @description:get timer action public
	 * @version:v1.0
	 * @return
	 */
	public boolean getIsPublic();
	
	/**
	 * @description:set timer action public
	 * @version:v1.0
	 * @param isPublic
	 */
	public void setIsPublic(boolean isPublic);
}
