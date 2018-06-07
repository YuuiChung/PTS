package cn.nfu.pts.bean;

/**
 * @description:template type interface
 * @version:v1.0
 */
public interface TemplateType extends BaseType{

	/**
	 * @description:set template type id
	 * @version:v1.0
	 * @param id
	 */
	public void setId(UUID id);

	/**
	 * (non-Javadoc)
	 * <p> Title:getId</p>
	 * @return
	 * @see cn.nfu.pts.bean.BaseType#getId()
	 */
	public UUID getId();

	/**
	 * @description:get template type name
	 * @version:v1.0
	 * @return
	 */
	public String getName();

	/**
	 * @description:set template type name
	 * @version:v1.0
	 * @param name
	 */
	public void setName(String name);

	/**
	 * @description: get template type description
	 * @version:v1.0
	 * @return
	 */
	public String getDescription();

	/**
	 * @description:set template type description
	 * @version:v1.0
	 * @param description
	 */
	public void setDescription(String description);

	/**
	 * @description:get template type display index
	 * @version:v1.0
	 * @return
	 */
	public int getDisplayIndex();

	/**
	 * @description:set template type display index
	 * @version:v1.0
	 * @param displayIndex
	 */
	public void setDisplayIndex(int displayIndex);
}
