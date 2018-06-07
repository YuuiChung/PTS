package cn.nfu.pts.controller;

import cn.nfu.pts.factory.DataAccessFactory;
import cn.nfu.pts.service.DataAccessSession;

public abstract class BaseController {
	
	/**
	 * base data process interface 
	 */
	protected DataAccessSession das = DataAccessFactory.getInstance().getSysDas();
	
	protected String baseXml = "<?xml version='1.0' encoding='UTF-8'?>";
	
	protected static String correctJson = "{\"success\" : true}";
	protected static String errorJson   = "{\"success\" : false}";
	
}
