package cn.nfu.pts.cache;

public class CacheManager {

	/**
	 * 缓存位置
	 *
	 */
	public enum CacheWhere{
		ehcache
	}
	
	private static CacheManager instance = new CacheManager();;
	
	public static CacheManager getInstance()
	{
		return instance;
	}
	
	/**
	 * 设置缓存
	 * @param key：缓存主键
	 * @param value：缓存内容
	 * @param cacheWhere：缓存位置
	 */
	public static void set(String key , Object value , CacheWhere cacheWhere){
		if (cacheWhere.equals(CacheWhere.ehcache)) {
			EhcacheHandler.getInstance().set(EhcacheHandler.FOREVER_CACHE,key, value);
		}
	}

}
