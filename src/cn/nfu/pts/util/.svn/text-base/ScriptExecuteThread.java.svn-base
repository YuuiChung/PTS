package cn.nfu.pts.util;

import bsh.EvalError;
import bsh.Interpreter;

import cn.nfu.pts.bean.Script;
import cn.nfu.pts.service.ScriptExecuteManager;


public class ScriptExecuteThread implements Runnable {

	public void run() {
		while (true) {
			Interpreter interpreter = null;
			// 提取值，需要锁住对象
			synchronized (ScriptExecuteManager.allDeamonScript) {
				if (ScriptExecuteManager.allDeamonScript.size() == 0) {
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					continue;
				}
				interpreter = ScriptExecuteManager.allDeamonScript.remove(0);
			}

			if (interpreter != null) {
				try {
					Script script = (Script) interpreter.get("script");
					if (script == null)
						continue;

					String content = script.getScript();
					if (content == null)
						continue;
					
					interpreter.eval(content);
				} catch (EvalError e) {
					e.printStackTrace();
				}
			}

		}

	}

}
