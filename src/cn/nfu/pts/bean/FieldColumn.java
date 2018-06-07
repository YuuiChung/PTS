package cn.nfu.pts.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldColumn implements Serializable{
	
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = -1132748374781195055L;
	
	/**
	 *	all fields belong to one column 
	 */
	private List<Field> fields;
	
	public FieldColumn() {
		fields = new ArrayList<Field>();
	}
	
	/**
	 * @description:add a field to column
	 * @version:v1.0
	 * @param field
	 */
	public void addField(Field field)
	{
		this.fields.add(field);
	}
	
	/**
	 * @description:get all field of column
	 * @version:v1.0
	 * @return
	 */
	public List<Field> getFields()
	{
		return this.fields;
	}
}
