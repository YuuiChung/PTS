package cn.nfu.pts.bean;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import cn.nfu.pts.util.Date;

public interface Data extends BaseType{

	/**
	 * @description:return data title
	 * @version:v1.0
	 * @return
	 */
	public String getTitle();
	
	/**
	 * @description:return data description
	 * @version:v1.0
	 * @return
	 */
	public String getDescription();
	
	/**
	 * @description:return data createuser 
	 * @version:v1.0
	 * @return
	 */
	public String getCreateUsername();

	/**
	 * @description:return data create time
	 * @version:v1.0
	 * @return
	 */
	public Timestamp getCreateTime();

	/**
	 * @description:return data last modify time
	 * @version:v1.0
	 * @return
	 */
	public Timestamp getLastModifyTime();

	/**
	 * @description:return data assign user
	 * @version:v1.0
	 * @return
	 */
	public String getAssignUsername();

	/**
	 * @description:return templateid
	 * @version:v1.0
	 * @return
	 */
	public UUID getTemplateId();

	/**
	 * @description:return data current status id
	 * @version:v1.0
	 * @return
	 */
	public UUID getStatusId();

	/**
	 * @description:return data action id
	 * @version:v1.0
	 * @return
	 */
	public UUID getActionId();

	/**
	 * @description:return data action user
	 * @version:v1.0
	 * @return
	 */
	public String getActionUser();

	/**
	 * @description:return data action comment
	 * @version:v1.0
	 * @return
	 */
	public String getActionComment();

	/**
	 * @description:return data last action index
	 * @version:v1.0
	 * @return
	 */
	public int getActionIndex();

	/**
	 * @description:return all field ids
	 * @version:v1.0
	 * @return
	 */
	public UUID[] getValidFieldIds();

	/**
	 * @description:return all field names
	 * @version:v1.0
	 * @return
	 */
	public String[] getValidFieldNames();

	/**
	 * @description:get all change logs
	 * @version:v1.0
	 * @return
	 */
	public ChangeLog[] getChangeLogs();

	/**
	 * @description:get single selection field value id
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public UUID getSingleSelection(UUID field);

	/**
	 * @description:get multiple selection field value id
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public UUID[] getMultiSelection(UUID field);

	/**
	 * @description:get single reference field value id
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public UUID getSingleReference(UUID field);

	/**
	 * @description:get multiple reference field value id
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public UUID[] getMultiReference(UUID field);

	/**
	 * @description:get attachment ids of field
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public UUID[] getAttachments(UUID field);

	/**
	 * @description:get double value of double field value
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public Double getDouble(UUID field);

	/**
	 * @description:get float value of field 
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public Float getFloat(UUID field);

	/**
	 * @description:get int value of field 
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public Integer getInteger(UUID field);

	/**
	 * @description:get long value of field 
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public Long getLong(UUID field);

	/**
	 * @description:get string value of field id
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public String getString(UUID field);

	/**
	 * @description:get String value of field name
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public String getString(String field);

	/**
	 * @description:get object value of field 
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public Object getObject(UUID field);

	/**
	 * @description:set single select field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setSingleSelection(UUID field, UUID x);

	/**
	 * @description:set multi select field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setMultiSelection(UUID field, UUID[] x);

	/**
	 * @description:set single ref field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setSingleReference(UUID field, UUID x);

	/**
	 * @description:set multi ref field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setMultiReference(UUID field, UUID[] x);

	/**
	 * @description:set double field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setDouble(UUID field, Double x);

	/**
	 * @description:set float field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setFloat(UUID field, Float x);

	/**
	 * @description:set int field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setInteger(UUID field, Integer x);

	/**
	 * @description:set long field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setLong(UUID field, Long x);

	/**
	 * @description:set string field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setString(UUID field, String x);

	/**
	 * @description:set double field value by field name
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setString(String field, String x);

	/**
	 * @description:set field value
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setObject(UUID field, Object x);

	/**
	 * @description:set data title
	 * @version:v1.0
	 * @param title
	 */
	public void setTitle(String title);

	/**
	 * @description:set data create user
	 * @version:v1.0
	 * @param username
	 */
	public void setCreateUsername(String username);

	/**
	 * @description:set data description
	 * @version:v1.0
	 * @param description
	 */
	public void setDescription(String description);

	/**
	 * @description:set data assign user
	 * @version:v1.0
	 * @param assignUsername
	 */
	public void setAssignUsername(String assignUsername);

	/**
	 * @description:set data status
	 * @version:v1.0
	 * @param statusId
	 */
	public void setStatusId(UUID statusId);

	/**
	 * @description:set data create time
	 * @version:v1.0
	 * @param createTime
	 */
	public void setCreateTime(Timestamp createTime);

	/**
	 * @description:set data last modify time
	 * @version:v1.0
	 * @param lastModifyTime
	 */
	public void setLastModifyTime(Timestamp lastModifyTime);

	/**
	 * @description:get field value of date type field
	 * @version:v1.0
	 * @param fieldId
	 * @return
	 */
	public Date getDate(UUID fieldId);

	/**
	 * @description:set field value of date type field
	 * @version:v1.0
	 * @param fieldId
	 * @param date
	 */
	public void setDate(UUID fieldId, Date date);

	/**
	 * @description:TODO
	 * @version:v1.0
	 * @param fieldId
	 * @param method
	 * @param c
	 * @param isCurrent
	 * @return
	 */
	public boolean isMatching(String fieldId, Method method, Object c, boolean isCurrent);

	/**
	 * @description:set field value of attach  type field
	 * @version:v1.0
	 * @param field
	 * @param x
	 */
	public void setAttachments(UUID field, UUID[] x);

	/**
	 * @description:get field value by field name
	 * @version:v1.0
	 * @param field
	 * @return
	 */
	public Object getObject(String field);

	/**
	 * @description:set field value by field name
	 * @version:v1.0
	 * @param field
	 * @param value
	 */
	public void setObject(String field, Object value);
	
	/**
	 * @description:set data id
	 * @version:v1.0
	 * @param createUUID
	 */
	public void setId(UUID createUUID);
	
	/**
	 * @description:set data template id
	 * @version:v1.0
	 * @param createUUID
	 */
	public void setTemplateId(UUID createUUID);
	
	/**
	 * @description:set data template type id 
	 * @version:v1.0
	 * @param createUUID
	 */
	public void setTemplateTypeId(UUID createUUID);
	
	/**
	 * @description:set data create user
	 * @version:v1.0
	 * @param string
	 */
	public void setCreateUser(String string);
	
	/**
	 * @description:set data assign user
	 * @version:v1.0
	 * @param string
	 */
	public void setAssignUser(String string);
	
	/**
	 * @description:set data changelogs
	 * @version:v1.0
	 * @param changeLogs
	 */
	public void setChangeLogs(List<ChangeLog> changeLogs);
	
	/**
	 * @description:set data object values map
	 * @version:v1.0
	 * @param objectMapUUID
	 */
	public void setObjectMapUUID(Map<UUID, Object> objectMapUUID);
	
	/**
	 * @description:set data object names map
	 * @version:v1.0
	 * @param objectMapName
	 */
	public void setObjectMapName(Map<String, Object> objectMapName);
	
	/**
	 * @description:return object id value map
	 * @version:v1.0
	 * @return
	 */
	public Map<UUID, Object> getObjectMapUUID();
	
	/**
	 * @description:return object name value map
	 * @version:v1.0
	 * @return
	 */
	public Map<String, Object> getObjectMapName();
	
	/**
	 * @description:add change log
	 * @version:v1.0
	 * @param changeLog
	 */
	public void addChangeLog(ChangeLog changeLog);
	
	/**
	 * @description:get data assign user
	 * @version:v1.0
	 * @return
	 */
	public String getAssignUser();
}
