package cn.nfu.pts.bean;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @description:user info bean
 * @version:v1.0
 */
public interface UserInfo extends Serializable{
	
	/**
	 * user role
	 * normal：normal user
	 * admin:normal admin
	 * super_admin:super admin
	 */
	public enum UserRole
	{
		normal, admin, super_admin
	}
	
	/**
	 * user status
	 * normal:noraml
	 * lock:lock can not login
	 * not_auth:register not auth
	 * quit:quit
	 */
	public enum UserStat
	{
		normal,lock,not_auth,quit
	}
	
	public String getPicId();
	
	public void setPicId(String picId);
	
	public String getPicUrl();
	
	public void setPicUrl(String picUrl);
		
	public void setId(int id);
	
	public int getId();
	
	public String getUserName();
	
	public void setUserName(String userName);
	
	public String getNickName();
	
	public void setNickName(String nickName);
	
	public String getUserPassword();
	
	public void setUserPassword(String userPassword);
	
	public UserRole getUserRole();
	
	public void setUserRole(UserRole userRole);
	
	public UserStat getUserStat();
	
	public void setUserStat(UserStat userStat);
	
	public Timestamp getLastLoginTime();
	
	public void setLastLoginTime(Timestamp lastLoginTime);
	
	public Timestamp getCreateTime();
	
	public void setCreateTime(Timestamp createTime);
}
