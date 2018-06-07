package cn.nfu.pts.bean.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import cn.nfu.pts.bean.Field;
import cn.nfu.pts.bean.Field.DataType;
import cn.nfu.pts.bean.Field.Type;
import cn.nfu.pts.bean.FieldColumn;
import cn.nfu.pts.bean.FieldRow;
import cn.nfu.pts.bean.Option;
import cn.nfu.pts.bean.Option.Forbidden;
import cn.nfu.pts.bean.Template;
import cn.nfu.pts.bean.TemplateConfig;
import cn.nfu.pts.bean.TemplateMailOption;
import cn.nfu.pts.bean.UUID;
import cn.nfu.pts.dao.DataAccessSessionMySQL;
import cn.nfu.pts.dao.FieldNameAccessSessionMySQL;
import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.util.CynthiaUtil;
import cn.nfu.pts.util.XMLUtil;


public class TemplateImpl implements Template
{
	private String createUser = "";
	private UUID id = null;
	private UUID templateTypeId = null;
	private UUID flowId = null;
	private Set<Field> fieldSet = new LinkedHashSet<Field>();
	private List<FieldRow> fieldRowList = new ArrayList<FieldRow>();
	private String name = null;
	private String description = null;
	private static final long serialVersionUID = -1L;
	private TemplateMailOption tmo = new TemplateMailOption();
	private TemplateConfig templateConfig = new TemplateConfig();
	
	public TemplateConfig getTemplateConfig()
	{
		return this.templateConfig;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:getCreateUser</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getCreateUser()
	 */
	@Override
	public String getCreateUser(){
		return createUser;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:setCreateUser</p>
	 * @param createUser
	 * @see cn.nfu.pts.bean.Template#setCreateUser(java.lang.String)
	 */
	@Override
	public void setCreateUser(String createUser){
		this.createUser = createUser;
	}

	/**
	 * <h1> Title:</h1>
	 * <p> Description:(init template)</p>
	 * @param doc
	 * @param createUser
	 */
	public TemplateImpl(Document doc,String createUser)
	{
		init(doc,createUser);
	}

	/**
	 * <h1> Title:</h1>
	 * <p> Description:init template from node</p>
	 * @param node
	 * @param createUser
	 */
	public TemplateImpl(Node node,String createUser)
	{
		init(node,createUser);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFieldRowList</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getFieldRowList()
	 */
	public List<FieldRow> getFieldRowList() {
		return fieldRowList;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setFieldRowList</p>
	 * @param fieldRowList
	 * @see cn.nfu.pts.bean.Template#setFieldRowList(java.util.List)
	 */
	public void setFieldRowList(List<FieldRow> fieldRowList) {
		this.fieldRowList = fieldRowList;
	}

	/**
	 * @description:init field from field node
	 * @version:v1.0
	 * @param fieldNode
	 * @return
	 */
	protected Field initFieldNode(Node fieldNode)
	{
		Field field = null;
		try
		{
			String fieldIdStr = XMLUtil.getSingleNode(fieldNode, "id").getTextContent();
			UUID fieldId = DataAccessFactory.getInstance().createUUID(fieldIdStr);

			String typeStr = XMLUtil.getSingleNode(fieldNode, "type").getTextContent();
			Type type = Type.valueOf(typeStr);

			DataType dataType = null;
			String dataTypeStr = XMLUtil.getSingleNode(fieldNode, "dataType").getTextContent();
			if (dataTypeStr.length() > 0)
				dataType = DataType.valueOf(dataTypeStr);

			field = new FieldImpl(fieldId, id, type, dataType);

			String fieldName = XMLUtil.getSingleNode(fieldNode, "name").getTextContent();
			field.setName(fieldName);
			
			String timeFormat = XMLUtil.getSingleNodeTextContent(fieldNode, "timeFormat");
			if(timeFormat!=null)
				field.setTimestampFormat(timeFormat);
			
			String dateCurTime = XMLUtil.getSingleNodeTextContent(fieldNode, "dateCurTime");
			if(dateCurTime!=null)
				field.setDateCurTime(Boolean.parseBoolean(dateCurTime));

			String fieldDescription = XMLUtil.getSingleNode(fieldNode, "description").getTextContent();
			if (fieldDescription.length() > 0)
				field.setDescription(fieldDescription);

			String fieldTip = XMLUtil.getSingleNodeTextContent(fieldNode, "fieldTip");
			if(fieldTip!=null)
				field.setFieldTip(fieldTip);

			String fieldSize = XMLUtil.getSingleNodeTextContent(fieldNode, "fieldSize");
			if(fieldSize!=null)
				field.setFieldSize(fieldSize);

			String defaultValue = XMLUtil.getSingleNode(fieldNode, "defaultValue").getTextContent();
			if (defaultValue.length() > 0)
				field.setDefaultValue(defaultValue);

			String controlFieldIdStr = XMLUtil.getSingleNode(fieldNode, "controlFieldId").getTextContent();
			if (controlFieldIdStr.length() > 0)
				field.setControlFieldId(DataAccessFactory.getInstance().createUUID(controlFieldIdStr));


			//////////////////////////////////////////////////////////////////////////////////////////////////////////////
			try {
				Node controlHiddenFieldIdNode = XMLUtil.getSingleNode(fieldNode, "controlHiddenFieldId");
				String controlHiddenFieldIdStr = "";
				if (controlHiddenFieldIdNode != null) {
					controlHiddenFieldIdStr = controlHiddenFieldIdNode.getTextContent();
				}
				if (controlHiddenFieldIdStr.length() > 0) {
					field.setControlHiddenFieldId(DataAccessFactory.getInstance().createUUID(controlHiddenFieldIdStr));
				}

				Set<UUID> controlHiddenFieldsSet = new LinkedHashSet<UUID>();
				List<Node> controlHiddenFieldsList = XMLUtil.getNodes(fieldNode, "controlHiddenFields/controlHiddenField");
				if (controlHiddenFieldsList != null && controlHiddenFieldsList.size() > 0) {
					for (Node controlHiddenFieldNode : controlHiddenFieldsList) {
						UUID controlHiddenFieldId = DataAccessFactory.getInstance().createUUID(controlHiddenFieldNode.getTextContent());
						controlHiddenFieldsSet.add(controlHiddenFieldId);
					}
					field.setControlHiddenFieldsIds(controlHiddenFieldsSet);
				}


				Set<UUID> controlHiddenStatesSet = new LinkedHashSet<UUID>();
				List<Node> controlHiddenStatesList = XMLUtil.getNodes(fieldNode, "controlHiddenStates/controlHiddenState");
				if(controlHiddenStatesList != null && controlHiddenStatesList.size() > 0 ){
					for (Node controlHiddenStateNode : controlHiddenStatesList) {
						UUID controlHiddenStateId = DataAccessFactory.getInstance().createUUID(controlHiddenStateNode.getTextContent());
						controlHiddenStatesSet.add(controlHiddenStateId);
					}
					field.setControlHiddenStatesIds(controlHiddenStatesSet);
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("init 表单出错");
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////


			Set<Option> optionSet = new LinkedHashSet<Option>();

			List<Node> optionNodeList = XMLUtil.getNodes(fieldNode, "options/option");
			for (Node optionNode : optionNodeList)
			{
				String optionIdStr = XMLUtil.getSingleNode(optionNode, "id").getTextContent();
				UUID optionId = DataAccessFactory.getInstance().createUUID(optionIdStr);

				OptionImpl optionImpl = new OptionImpl(optionId, fieldId);

				String optionName = XMLUtil.getSingleNode(optionNode, "name").getTextContent();
				optionImpl.setName(optionName);

				String optionDescription = XMLUtil.getSingleNode(optionNode, "description").getTextContent();
				if (optionDescription.length() > 0)
					optionImpl.setDescription(optionDescription);

				String controlOptionIdStr = XMLUtil.getSingleNode(optionNode, "controlOptionId").getTextContent();
				if (controlOptionIdStr.length() > 0)
					optionImpl.setControlOptionId(DataAccessFactory.getInstance().createUUID(controlOptionIdStr));

				String forbiddenStr = XMLUtil.getSingleNode(optionNode, "forbidden").getTextContent();
				Forbidden forbidden = Forbidden.valueOf(forbiddenStr);
				optionImpl.setForbidden(forbidden);

				String indexOrderStr = XMLUtil.getSingleNode(optionNode, "indexOrder").getTextContent();
				int indexOrder = Integer.parseInt(indexOrderStr);
				optionImpl.setIndexOrder(indexOrder);

				optionSet.add(optionImpl);
			}

			field.setOptions(optionSet);

			Set<UUID> controlOptionIdSet = new LinkedHashSet<UUID>();

			List<Node> controlOptionIdNodeList = XMLUtil.getNodes(fieldNode, "controlOptionIds/controlOptionId");
			for (Node controlOptionIdNode : controlOptionIdNodeList)
			{
				UUID controlOptionId = DataAccessFactory.getInstance().createUUID(controlOptionIdNode.getTextContent());
				controlOptionIdSet.add(controlOptionId);
			}

			field.setControlOptionIds(controlOptionIdSet);

			Set<String> controlRoleIdSet = new LinkedHashSet<String>();

			List<Node> controlRoleIdNodeList = XMLUtil.getNodes(fieldNode, "controlRoleIds/controlRoleId");
			for (Node controlRoleIdNode : controlRoleIdNodeList)
			{
				controlRoleIdSet.add(controlRoleIdNode.getTextContent());
			}

			field.setControlRoleIds(controlRoleIdSet);

			Set<UUID> actionIdSet = new LinkedHashSet<UUID>();

			Set<String> controlActionIdSet = new LinkedHashSet<String>();

			List<Node> controlActionIdNodeList = XMLUtil.getNodes(fieldNode, "controlActionIds/controlActionId");
			for (Node controlActionIdNode : controlActionIdNodeList)
			{
				actionIdSet.add(DataAccessFactory.getInstance().createUUID(controlActionIdNode.getTextContent().split("\\_")[0]));
				controlActionIdSet.add(controlActionIdNode.getTextContent());
			}

			field.setControlActionIds(controlActionIdSet);

			List<Node> actionIdNodeList = XMLUtil.getNodes(fieldNode, "actionIds/actionId");
			for (Node actionIdNode : actionIdNodeList)
				actionIdSet.add(DataAccessFactory.getInstance().createUUID(actionIdNode.getTextContent()));
			field.setActionIds(actionIdSet);

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return field;

	}

	/**
	 * @description:init new template xml from node
	 * @version:v1.0
	 * @param node
	 */
	protected void initTemplateXml(Node node)
	{
		try {
			org.w3c.dom.Node templateNode = XMLUtil.getSingleNode(node, "template");
			String idStr = XMLUtil.getSingleNode(templateNode, "id").getTextContent();
			UUID id = DataAccessFactory.getInstance().createUUID(idStr);
			String templateTypeIdStr = XMLUtil.getSingleNode(templateNode, "templateTypeId").getTextContent();
			UUID templateTypeId = DataAccessFactory.getInstance().createUUID(templateTypeIdStr);

			String name = XMLUtil.getSingleNode(templateNode, "name").getTextContent();

			this.id = id;
			this.templateTypeId = templateTypeId;
			this.name = name;
			this.description = XMLUtil.getSingleNodeTextContent(templateNode, "description");

			String flowIdStr = XMLUtil.getSingleNode(templateNode, "flowId").getTextContent();
			this.flowId = DataAccessFactory.getInstance().createUUID(flowIdStr);

			List<Node> rowNodes = XMLUtil.getNodes(templateNode, "layout/rows/row");
			for(Node rowNode : rowNodes)
			{
				List<Node> columnNodes = XMLUtil.getNodes(rowNode, "column");
				FieldRow fieldRow = new FieldRow();
				for(Node columnNode : columnNodes)
				{
					List<Node> fieldNodes = XMLUtil.getNodes(columnNode, "field");
					FieldColumn fieldColumn = new FieldColumn();
					for(Node fieldNode : fieldNodes)
					{
						Field tempField = initFieldNode(fieldNode);
						fieldColumn.addField(tempField);
						this.fieldSet.add(tempField);
					}
					fieldRow.addColumn(fieldColumn);
				}

				fieldRowList.add(fieldRow);
			}
			
			
			//初始化表单邮件配置
			this.tmo.setTemplateId(id);
			Node templateMailNode = XMLUtil.getSingleNode(templateNode, "mail");
			if (templateMailNode != null) {
				String subject = XMLUtil.getSingleNodeTextContent(templateMailNode, "subject");
				this.tmo.setMailSubject(CynthiaUtil.isNull(subject) ? "" : subject);
				String sendMailStr = XMLUtil.getSingleNodeTextContent(templateMailNode, "sendMail");
				this.tmo.setSendMail( sendMailStr != null && sendMailStr.equals("true"));
				List<Node> allActionMailNodes = XMLUtil.getNodes(templateMailNode, "actions/action");
				for (Node actionMailNode : allActionMailNodes) {
					this.tmo.setActionUser(XMLUtil.getAttribute(actionMailNode, "id"), actionMailNode.getTextContent());
				}
			}
			
			//初始化表单配置
			Node templateConfigNode = XMLUtil.getSingleNode(templateNode, "config");
			if (templateConfigNode != null) {
				this.templateConfig.setIsProjectInvolve(XMLUtil.getSingleNodeTextContent(templateConfigNode, "isProjectInvolve").equals("true"));
				this.templateConfig.setProductInvolveId(XMLUtil.getSingleNodeTextContent(templateConfigNode, "productInvolveId"));
				this.templateConfig.setProjectInvolveId(XMLUtil.getSingleNodeTextContent(templateConfigNode, "projectInvolveId"));
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @description:init template from node
	 * @version:v1.0
	 * @param node
	 * @param createUser
	 */
	protected void init(Node node,String createUser)
	{
		try {
			this.createUser = createUser;
			initTemplateXml(node);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * <h1> Title:</h1>
	 * <p> Description:</p>
	 * @param id
	 * @param templateTypeId
	 */
	public TemplateImpl(UUID id, UUID templateTypeId)
	{
		this.id = id;
		this.templateTypeId = templateTypeId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:clone</p>
	 * @return
	 * @see java.lang.Object#clone()
	 */
	public Template clone()
	{
		TemplateImpl templateImpl = new TemplateImpl(this.id, this.templateTypeId);

		templateImpl.flowId = this.flowId;
		templateImpl.name = this.name;
		templateImpl.description = this.description;
		templateImpl.createUser = this.createUser;

		templateImpl.fieldRowList = new ArrayList<FieldRow>();
		for(FieldRow fieldRow : fieldRowList)
		{
			FieldRow newFieldRow = new FieldRow();
			for(FieldColumn fieldColumn : fieldRow.getFieldColumns())
			{
				FieldColumn newFieldColumn = new FieldColumn();
				for(Field field : fieldColumn.getFields())
				{
					Field newField = field.clone();
					newFieldColumn.addField(newField);
					templateImpl.fieldSet.add(newField);
				}
				newFieldRow.addColumn(newFieldColumn);
			}
			templateImpl.fieldRowList.add(newFieldRow);
		}

		TemplateMailOption tmo = this.tmo.clone();
		templateImpl.setTemplateMailOption(tmo);
		templateImpl.templateConfig = this.templateConfig;
		return templateImpl;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getDescription</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getDescription()
	 */
	public String getDescription()
	{
		return this.description;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFlowId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getFlowId()
	 */
	public UUID getFlowId()
	{
		return this.flowId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getName</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getName()
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getTemplateTypeId</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getTemplateTypeId()
	 */
	public UUID getTemplateTypeId()
	{
		return this.templateTypeId;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.BaseType#getId()
	 */
	public UUID getId()
	{
		return this.id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setName</p>
	 * @param name
	 * @see cn.nfu.pts.bean.Template#setName(java.lang.String)
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setDescription</p>
	 * @param description
	 * @see cn.nfu.pts.bean.Template#setDescription(java.lang.String)
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setFlowId</p>
	 * @param id
	 * @see cn.nfu.pts.bean.Template#setFlowId(cn.nfu.pts.bean.UUID)
	 */
	public void setFlowId(UUID id)
	{
		this.flowId = id;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setFields</p>
	 * @param fieldSet
	 * @see cn.nfu.pts.bean.Template#setFields(java.util.Set)
	 */
	public void setFields(Set<Field> fieldSet)
	{
		this.fieldSet = fieldSet;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:addField</p>
	 * @param type
	 * @param dataType
	 * @return
	 * @see cn.nfu.pts.bean.Template#addField(cn.nfu.pts.bean.Field.Type, cn.nfu.pts.bean.Field.DataType)
	 */
	public Field addField(Type type, DataType dataType)
	{
		UUID fieldId = DataAccessFactory.getInstance().newUUID("FIEL");
		Field field = new FieldImpl(fieldId, this.id, type, dataType);
		this.fieldSet.add(field);
		return field;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:addField</p>
	 * @param field
	 * @param rowIndex
	 * @param columnIndex
	 * @param positionIndex
	 * @see cn.nfu.pts.bean.Template#addField(cn.nfu.pts.bean.Field, int, int, int)
	 */
	public void addField(Field field, int rowIndex, int columnIndex, int positionIndex)
	{
		for(int i = 0; i < fieldRowList.size() ; i++)
		{
			if(rowIndex == i)
			{
				List<FieldColumn> fieldColumns = fieldRowList.get(i).getFieldColumns();
				for(int j = 0 ; j < fieldColumns.size() ; j++)
				{
					if(j == columnIndex)
					{
						List<Field> fields = fieldColumns.get(j).getFields();
						fields.add(positionIndex, field);
					}
				}
			}
		}
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:moveField</p>
	 * @param field
	 * @param rowIndex
	 * @param columnIndex
	 * @param positionIndex
	 * @return
	 * @see cn.nfu.pts.bean.Template#moveField(cn.nfu.pts.bean.Field, int, int, int)
	 */
	public boolean moveField(Field field,int rowIndex, int columnIndex, int positionIndex)
	{
		for(int i = 0; i < fieldRowList.size() ; i++)
		{
			List<FieldColumn> fieldColumns = fieldRowList.get(i).getFieldColumns();
			for(int j = 0 ; j < fieldColumns.size() ; j++)
			{
				List<Field> fields = fieldColumns.get(j).getFields();
				Iterator<Field> fieldsItr = fields.iterator();
				while(fieldsItr.hasNext())
				{
					Field tmpField = fieldsItr.next();
					if(tmpField.getId().equals(field.getId()))
					{
						fieldsItr.remove();
						this.addField(field, rowIndex, columnIndex, positionIndex);
						return true;
					}
				}
			}
		}

		return false;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getFields</p>
	 * @return
	 * @see cn.nfu.pts.bean.Template#getFields()
	 */
	public Set<Field> getFields()
	{
		return this.fieldSet;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getField</p>
	 * @param name
	 * @return
	 * @see cn.nfu.pts.bean.Template#getField(java.lang.String)
	 */
	public Field getField(String name)
	{
		for (Field field : this.fieldSet)
		{
			if (field.getName().equals(name))
				return field;
		}

		return null;
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:getField</p>
	 * @param id
	 * @return
	 * @see cn.nfu.pts.bean.Template#getField(cn.nfu.pts.bean.UUID)
	 */
	public Field getField(UUID id)
	{
		for (Field field : this.fieldSet)
		{
			if (field.getId().equals(id))
				return field;
		}

		return null;
	}
	
	/**
	 * (non-Javadoc)
	 * <p> Title:removeField</p>
	 * @param fieldId
	 * @param templateId
	 * @see cn.nfu.pts.bean.Template#removeField(cn.nfu.pts.bean.UUID, cn.nfu.pts.bean.UUID)
	 */
	public void removeField(UUID fieldId , UUID templateId)
	{
		Iterator<Field> fieldSetItr = this.fieldSet.iterator();
		while (fieldSetItr.hasNext())
		{
			Field field = fieldSetItr.next();
			if (field.getId().equals(fieldId))
				fieldSetItr.remove();
		}

		for(int i = 0; i < fieldRowList.size() ; i++)
		{
			List<FieldColumn> fieldColumns = fieldRowList.get(i).getFieldColumns();
			for(int j = 0 ; j < fieldColumns.size() ; j++)
			{
				List<Field> fields = fieldColumns.get(j).getFields();
				Iterator<Field> fieldsItr = fields.iterator();
				while(fieldsItr.hasNext())
				{
					Field tmpField = fieldsItr.next();
					if(tmpField.getId().equals(fieldId))
						fieldsItr.remove();
				}
			}
		}

		//从数据库中删除关于该字段数据
		new DataAccessSessionMySQL().removeFieldData(templateId , fieldId);
		new FieldNameAccessSessionMySQL().removeFieldColNameById(fieldId.getValue(),templateId.getValue());
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:toXMLDocument</p>
	 * @return
	 * @throws Exception
	 * @see cn.nfu.pts.bean.BaseType#toXMLDocument()
	 */
	public Document toXMLDocument() throws Exception
	{
		return XMLUtil.string2Document(toXMLString(), "UTF-8");
	}


	/**
	 * (non-Javadoc)
	 * <p> Title:toXMLString</p>
	 * @return
	 * @see cn.nfu.pts.bean.BaseType#toXMLString()
	 */
	public String toXMLString()
	{
		StringBuffer xmlb = new StringBuffer(64);
		xmlb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		xmlb.append("<template>");
		xmlb.append("<id>").append(this.getId()).append("</id>");
		xmlb.append("<templateTypeId>").append(this.getTemplateTypeId()).append("</templateTypeId>");
		xmlb.append("<name>").append(XMLUtil.toSafeXMLString(this.getName())).append("</name>");
		xmlb.append("<description>").append(XMLUtil.toSafeXMLString(this.getDescription())).append("</description>");
		xmlb.append("<flowId>").append(this.getFlowId()).append("</flowId>");
		if(this.fieldRowList.size() == 0)
		{
			xmlb.append("<layout><rows></rows></layout>");
		}else
		{
			xmlb.append("<layout>");
			xmlb.append("<rows>");
			for(FieldRow fieldRow : this.fieldRowList)
			{
				xmlb.append("<row>");
				for(FieldColumn fieldColumn : fieldRow.getFieldColumns())
				{
					xmlb.append("<column>");
					for(Field field: fieldColumn.getFields())
					{
						xmlb.append(field.toXMLString());
					}
					xmlb.append("</column>");
				}
				xmlb.append("</row>");
			}
			xmlb.append("</rows>");
			xmlb.append("</layout>");
		}

		xmlb.append("<mail>");
		xmlb.append("<sendMail>").append(this.tmo.isSendMail()).append("</sendMail>");
		xmlb.append("<subject>").append(this.tmo.getMailSubject()).append("</subject>");
		xmlb.append("<actions>");
		for (String actionId : this.tmo.getActionUsers().keySet()) {
			xmlb.append("<action id='" + actionId + "'>").append(this.tmo.getActionUsers().get(actionId)).append("</action>");
		}
		xmlb.append("</actions>");
		xmlb.append("</mail>");
		
		xmlb.append("<config>");
		xmlb.append("<isProjectInvolve>").append(this.templateConfig.isProjectInvolve()).append("</isProjectInvolve>");
		xmlb.append("<productInvolveId>").append(this.templateConfig.getProductInvolveId()).append("</productInvolveId>");
		xmlb.append("<projectInvolveId>").append(this.templateConfig.getProjectInvolveId()).append("</projectInvolveId>");
		xmlb.append("</config>");
		
		xmlb.append("</template>");
		return xmlb.toString();

	}

	/**
	 * (non-Javadoc)
	 * <p> Title:addFieldRow</p>
	 * @param rowIndex
	 * @param columnCount
	 * @see cn.nfu.pts.bean.Template#addFieldRow(int, int)
	 */
	public void addFieldRow(int rowIndex, int columnCount)
	{
		FieldRow fieldRow = new FieldRow();
		for(int i = 0; i < columnCount ; i++)
		{
			FieldColumn fieldColumn = new FieldColumn();
			fieldRow.addColumn(fieldColumn);
		}
		this.fieldRowList.add(rowIndex, fieldRow);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:removeFieldRow</p>
	 * @param rowIndex
	 * @see cn.nfu.pts.bean.Template#removeFieldRow(int)
	 */
	public void removeFieldRow(int rowIndex)
	{
		this.fieldRowList.remove(rowIndex);
	}

	/**
	 * (non-Javadoc)
	 * <p> Title:setId</p>
	 * @param id
	 * @see cn.nfu.pts.bean.Template#setId(cn.nfu.pts.bean.UUID)
	 */
	@Override
	public void setId(UUID id) {
		this.id = id;
	}
	
	@Override
	public void setTemplateMailOption(TemplateMailOption tmo) {
		this.tmo = tmo;
	}

	@Override
	public TemplateMailOption getTemplateMailOption() {
		return tmo;
	}
}
