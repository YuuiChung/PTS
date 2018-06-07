package cn.nfu.pts.service;

import java.io.File;
import java.io.IOException;
import org.apache.log4j.Logger;
import cn.nfu.pts.util.CynthiaUtil;
import cn.nfu.pts.util.FileUtil;

public class UpdateManager {
	
	private static Logger logger = Logger.getLogger(UpdateManager.class);
	
	private static UpdateManager instance = new UpdateManager();;
	
	public static UpdateManager getInstance()
	{
		return instance;
	}
	
	
	/**
	 * @Title: UpdateDataBase
	 * @Description: 升级数据库
	 * @return: void
	 * @throws IOException 
	 */
	public void UpdateDataBase(){
		try {
			String sqlPath = new File(UpdateManager.class.getClassLoader().getResource("update.sql").getPath()).getAbsolutePath().replace("%20", " ");
				
			String sqlStr = FileUtil.readStringFromFile(sqlPath);
			if (sqlStr == null || sqlStr.equals("")) {
				return;
			}
			
			String[] allSql = sqlStr.split("\r\n");
			if (allSql != null && allSql.length > 0) {
				for (String sql : allSql) {
					if (!CynthiaUtil.isNull(sql)) {
						if (!DbPoolConnection.getInstance().executeUpdateSql(sql)) {
							return;
						}
					}
				}
			}
			FileUtil.writeToFile(sqlPath, "", false);
			FileUtil.deleteFile(sqlPath);
		} catch (Exception e) {
			return;
		}
	}
}
