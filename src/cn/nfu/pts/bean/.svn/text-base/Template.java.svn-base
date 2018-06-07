package cn.nfu.pts.bean;

import java.util.List;
import java.util.Set;

/**
 * @description:template interface
 * @version:v1.0
 */
public interface Template extends BaseType{
	
	/**
	 * @description:set template id
	 * @version:v1.0
	 * @param id
	 */
	public void setId(UUID id);
	
	/**
	 * @Title: getTemplateConfig
	 * @Description: TODO
	 * @return
	 * @return: TemplateConfig
	 */
	public TemplateConfig getTemplateConfig();
	
	/**
	 * @description:get template templatetype id
	 * @version:v1.0
	 * @return
	 */
	public UUID getTemplateTypeId();
	
	/**
	 * @description:get template create user
	 * @version:v1.0
	 * @return
	 */
	public String getCreateUser();
	
	/**
	 * @description:set template create user
	 * @version:v1.0
	 * @param createUser
	 */
	public void setCreateUser(String createUser);
	
	/**
	 * @description:get template flow id
	 * @version:v1.0
	 * @return
	 */
	public UUID getFlowId();
	
	/**
	 * @description:set template flow id
	 * @version:v1.0
	 * @param flowId
	 */
	public void setFlowId(UUID flowId);
	
	/**
	 * @description:get template name
	 * @version:v1.0
	 * @return
	 */
	public String getName();
	
	/**
	 * @description:set template name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);
	
	/**
	 * @description:get template description
	 * @version:v1.0
	 * @return
	 */
	public String getDescription();
	
	/**
	 * @description:set template description
	 * @version:v1.0
	 * @param description
	 */
	public void setDescription(String description);
	
	/**
	 * @description:get field from template by field id
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public Field getField(UUID id);
	
	/**
	 * @description:get field from template by field name(not recommended!!)
	 * @version:v1.0
	 * @param name
	 * @return
	 */
	public Field getField(String name);
	
	/**
	 * @description:add field to template
	 * @version:v1.0
	 * @param type
	 * @param dataType
	 * @return
	 */
	public Field addField(Field.Type type, Field.DataType dataType);
	
	/**
	 * @description:remove field from template
	 * @version:v1.0
	 * @param id
	 * @param templateId
	 */
	public void removeField(UUID id , UUID templateId);
	
	/**
	 * @description:get all fields from template
	 * @version:v1.0
	 * @return
	 */
	public Set<Field> getFields();
	
	/**
	 * @description:set template fields
	 * @version:v1.0
	 * @param fieldSet
	 */
	public void setFields(Set<Field> fieldSet);
	
	/**
	 * @description:add field to template
	 * @version:v1.0
	 * @param field
	 * @param rowIndex
	 * @param columnIndex
	 * @param positionIndex
	 */
	public void addField(Field field, int rowIndex, int columnIndex, int positionIndex);
	
	/**
	 * @description:move field to new position
	 * @version:v1.0
	 * @param field
	 * @param rowIndex
	 * @param columnIndex
	 * @param positionIndex:index in column
	 * @return
	 */
	public boolean moveField(Field field, int rowIndex, int columnIndex, int positionIndex);

	/**
	 * @description:add field row
	 * @version:v1.0
	 * @param rowIndex
	 * @param columnCount
	 */
	public void addFieldRow(int rowIndex, int columnCount);
	
	/**
	 * @description:remove field row from template
	 * @version:v1.0
	 * @param rowIndex
	 */
	public void removeFieldRow(int rowIndex);
	
	/**
	 * @description:get all field rows
	 * @version:v1.0
	 * @return
	 */
	public List<FieldRow> getFieldRowList();
	
	/**
	 * @description:set field rows of template
	 * @version:v1.0
	 * @param fieldRowList
	 */
	public void setFieldRowList(List<FieldRow> fieldRowList);
	
	/**
	 * @Title: setTemplateMailOption
	 * @Description: TODO
	 * @param tmo
	 * @return: void
	 */
	public void setTemplateMailOption(TemplateMailOption tmo);
	
	/**
	 * @Title: getTemplateMailOption
	 * @Description: TODO
	 * @return
	 * @return: TemplateMailOption
	 */
	public TemplateMailOption getTemplateMailOption();
}
