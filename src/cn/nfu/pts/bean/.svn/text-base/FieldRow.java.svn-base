package cn.nfu.pts.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldRow implements Serializable {
	
	/**
	 * @Fields:serialVersionUID
	 * @Fields_Type:long
	 * @description:TODO
	 */
	private static final long serialVersionUID = 3649817054399364460L;
	
	/**
	 * all field column belong to one row
	 */
	private List<FieldColumn> columns;
	
	public FieldRow() {
		columns = new ArrayList<FieldColumn>();
	}
	
	/**
	 * @description:add field column to row
	 * @version:v1.0
	 * @param column
	 */
	public void addColumn(FieldColumn column)
	{
		this.columns.add(column);
	}
	
	/**
	 * @description:get all field column of row
	 * @version:v1.0
	 * @return
	 */
	public List<FieldColumn> getFieldColumns()
	{
		return this.columns;
	}

}
