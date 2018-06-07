package cn.nfu.pts.cache;

import cn.nfu.pts.bean.BaseType;
import cn.nfu.pts.bean.UUID;

public interface Cache<T extends BaseType> {
	/**
	 * @description:set cache value
	 * @version:v1.0
	 * @param key
	 * @param value
	 */
	public void set(String key, Object value);
	
	/**
	 * @description:get cache data by id
	 * @version:v1.0
	 * @param uuid
	 * @return
	 */
	public T get(UUID uuid);
	
	/**
	 * @description:get cache data by id
	 * @version:v1.0
	 * @param id
	 * @return
	 */
	public T get(String id);
	
	/**
	 * @description:remove data from cache by ids
	 * @version:v1.0
	 * @param uuids
	 */
	public void remove(UUID[] uuids);
}
