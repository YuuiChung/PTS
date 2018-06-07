package cn.nfu.pts.service;

import java.sql.Timestamp;
import java.util.List;

import cn.nfu.pts.bean.Attachment;
import cn.nfu.pts.bean.Data;
import cn.nfu.pts.bean.QueryCondition;
import cn.nfu.pts.bean.Stat;
import cn.nfu.pts.bean.UUID;

public interface DataFilter
{
	/**
	 * @description:return data process interface
	 * @version:v1.0
	 * @return
	 */
	public DataAccessSession getDataAccessSession(); 

	/**
	 * @description:query data by data id
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public Data queryData(UUID id); 
	
	/**
	 * @description:query datas by filter xml
	 * @version:v1.0
	 * @param xml
	 * @return
	 */
	public Data[] queryDatas(String xml);
	
	/**
	 * @description:query data by filter xml and other query conditions
	 * @version:v1.0
	 * @param xml
	 * @param queryConList
	 * @return
	 */
	public Data[] queryDatas(String xml,List<QueryCondition> queryConList);
	
	/**
	 * @description:query datas by xml and limit count
	 * @version:v1.0
	 * @param xml
	 * @param pageNumber:page number
	 * @param lineAccount:count of page
	 * @param queryConList
	 * @return
	 */
	public Data[] queryDatas(String xml, int pageNumber, int lineAccount , List<QueryCondition> queryConList);
	
	/**
	 * @description:query datas by xml and limit count ,sort
	 * @version:v1.0
	 * @param xml
	 * @param pageNumber
	 * @param lineAccount
	 * @param sort
	 * @param dir
	 * @param queryConList
	 * @return
	 */
	public Data[] queryDatas(String xml, int pageNumber, int lineAccount, String sort, String dir , List<QueryCondition> queryConList);

	/**
	 * @description:query all createUsers by template type
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public String[] queryTemplateTypeCreateUsers(UUID templateTypeId);
	
	/**
	 * @description:query all assignusers by template type
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public String[] queryTemplateTypeAssignUsers(UUID templateTypeId);
	
	/**
	 * @description:query all status names by template type
	 * @version:v1.0
	 * @param templateTypeId
	 * @return
	 */
	public String[] queryTemplateTypeStats(UUID templateTypeId);
	
	/**
	 * @description:query datas by template id
	 * @version:v1.0
	 * @param templateId
	 * @param needLog:if need log
	 * @param startTime:createTime start
	 * @param endTime:createTime end
	 * @return
	 */
	public Data[] queryTemplateDatas(UUID templateId , boolean needLog , Timestamp startTime , Timestamp endTime);
	
	/**
	 * @description:query datas by template id and other query conditions
	 * @version:v1.0
	 * @param templateId
	 * @param needLog
	 * @param startTime:createTime start
	 * @param endTime:createTime end
	 * @param allQueryList
	 * @return
	 */
	public Data[] queryTemplateDatas(UUID templateId , boolean needLog , Timestamp startTime, Timestamp endTime , List<QueryCondition> allQueryList);
	
	/**
	 * @description:query all createusers by template
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public String[] queryTemplateCreateUsers(UUID templateId);
	
	/**
	 * @description:query all assignUsers by template
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public String[] queryTemplateAssignUsers(UUID templateId);
	
	/**
	 * @description:query all status by template
	 * @version:v1.0
	 * @param templateId
	 * @return
	 */
	public Stat[] queryTemplateStats(UUID templateId);
	
	/**
	 * @description:query all reference datas of template and field
	 * @version:v1.0
	 * @param templateId
	 * @param fieldId
	 * @return
	 */
	public Data[] queryTemplateFieldReferences(UUID templateId, UUID fieldId);
	
	/**
	 * @description:query all attachments of template
	 * @version:v1.0
	 * @param templateId
	 * @param fieldId
	 * @return
	 */
	public Attachment[] queryTemplateFieldAttachments(UUID templateId, UUID fieldId);

	/**
	 * @description:query datas by template and lastmodifytime
	 * @version:v1.0
	 * @param templateId
	 * @param needLog
	 * @param startTime:lastmodifytime start
	 * @param endTime:lastmodifytime end
	 * @return
	 */
	public Data[] queryTemplateDatasByLastModifyTime(UUID templateId,boolean needLog, Timestamp startTime, Timestamp endTime);

	/**
	 * @description:query datas by template id and other query conditions
	 * @version:v1.0
	 * @param templateId
	 * @param queryConditions
	 * @param needLog
	 * @return
	 */
	public Data[] queryDatas(UUID templateId, List<QueryCondition> queryConditions, boolean needLog);
	
}
