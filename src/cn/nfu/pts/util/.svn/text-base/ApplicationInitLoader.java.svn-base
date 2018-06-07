package cn.nfu.pts.util;


import javax.servlet.http.HttpServlet;

import cn.nfu.pts.cache.impl.FieldNameCache;
import cn.nfu.pts.cache.impl.FlowCache;
import cn.nfu.pts.cache.impl.TemplateCache;
import cn.nfu.pts.cache.impl.TemplateTypeCache;
import cn.nfu.pts.cache.impl.UserInfoCache;
import cn.nfu.pts.service.ConfigManager;
import cn.nfu.pts.service.UpdateManager;


public class ApplicationInitLoader extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private TimerExecutor timerExecutor = null;
	
	@Override
	public void init() {
		//检测并更新DataBase
		System.out.println("check and update database ....");
		UpdateManager.getInstance().UpdateDataBase();
		System.out.println("check and update database done ....");
		// 加载缓存数据
		System.out.println("init cache start....");
		FieldNameCache.getInstance().putAllDataToCache();
		TemplateCache.getInstance().putAllDataToCache();
		FlowCache.getInstance().putAllDataToCache();
		TemplateTypeCache.getInstance().putAllDataToCache();
		UserInfoCache.getInstance().putAllDataToCache();
		System.out.println("init cache end....");

		if (ConfigManager.getEnableEmail()) {
			timerExecutor = new TimerExecutor(); // 线上的话只能配置一台定时器！
			timerExecutor.start();
		}
		for (int i = 0; i < 5; i++) {
			// 每台机器开5个线程异步执行脚本
			new Thread(new ScriptExecuteThread()).start();
		}
	}

	@Override
	public void destroy() {
		if (timerExecutor != null) {
			timerExecutor.interrupt();
		}
		super.destroy();
	}
}
