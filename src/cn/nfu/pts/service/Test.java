package cn.nfu.pts.service;

public class Test {

	/**
	 * @Title: main
	 * @Description: TODO
	 * @param args
	 * @return: void
	 */
	public static void main(String[] args) {
		System.out.println(DataManager.getInstance().queryUserTemplates("1123934927@qq.com").length);
		
	}

}
