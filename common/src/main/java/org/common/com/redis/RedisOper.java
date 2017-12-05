package org.common.com.redis;


import com.google.gson.reflect.TypeToken;
import org.common.com.utils.GsonUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * author:zky
 * info:redis操作类
 */
public class RedisOper {

	/*
	 * 判断是否存在key
	 */
	public static boolean existsKey(String key) {
		boolean flag = false;

		boolean broken = false;
		Jedis jedis = RedisClient.getJedis();
		try {
			flag = jedis.exists(key);
		} catch (Exception e) {
			broken = true;
			e.printStackTrace();
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
		return flag;
	}

	/*
	 * 设置key的有效时长
	 */
	public static void setExpire(String key, int seconds) {
		boolean broken = false;
		Jedis jedis = RedisClient.getJedis();
		try {
			jedis.expire(key, seconds);
		} catch (Exception e) {
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static <T> T get(String key, TypeToken<T> token) {
		try {

			String res = get(key);
			if (res == null) {
				return null;
			}
			return GsonUtil.strToObj(res, token);
		} catch (Exception e) {
			return null;
		}

	}

	public static <T> T get(String key, Class<T> clazz) {
		try {

			String res = get(key);
			if (res == null) {
				return null;
			}
			return GsonUtil.strToObj(res, clazz);
		} catch (Exception e) {
			return null;
		}

	}

	public static String get(String key) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {

			String res = jedis.get(key);

			return res;
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static <T> void save(String key, T obj) {
		String val = GsonUtil.objToStr(obj);
		save(key, val);
	}

	public static void save(String key, String value) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			jedis.set(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static void del(String key) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			jedis.del(key);
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/*--------------哈希表----------------*/

	public static boolean hexists(String key, String field) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.hexists(key, field);
		} catch (Exception e) {
			broken = true;
			return false;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static void saveHMNew(String mapName, Map<String, String> map) {
		saveHM(mapName, map, true);
	}

	public static void saveHMAppend(String mapName, Map<String, String> map) {
		saveHM(mapName, map, false);
	}

	public static void saveHM(String mapName, Map<String, String> map, boolean isClearBefore) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			if (isClearBefore) {
				jedis.del(mapName);
			}

			jedis.hmset(mapName, map);
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static Map<String, String> getHMAll(String mapName) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.hgetAll(mapName);
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}

	}

	public static String getHMOneValByKey(String mapName, String mapKey) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.hget(mapName, mapKey);
		} catch (Exception e) {
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static List<String> getHMValsByKeys(String mapName, String... keys) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.hmget(mapName, keys);
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static void delHMFileds(String mapName, String... keys) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			jedis.hdel(mapName, keys);
		} catch (Exception e) {
			e.printStackTrace();
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}

	}

	/*---------------哈希操作end----------------------*/

	/*-list操作begin---------------*/

	public static <T> void saveListAppend(String listName, List<T> list) {
		saveList(listName, list, false);
	}

	public static <T> void saveListNew(String listName, List<T> list) {
		saveList(listName, list, true);
	}

	public static <T> void saveList(String listName, List<T> list, boolean isNew) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			if (isNew) {
				jedis.del(listName);
			}
			for (T t : list) {
				String val = GsonUtil.objToStr(t);
				jedis.lpush(listName, val);
			}

		} catch (Exception e) {
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static List<String> getList(String listName) {
		return getList(listName, 0, -1);
	}

	public static List<String> getList(String listName, int startIndex, int endIndex) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.lrange(listName, startIndex, endIndex);
		} catch (Exception e) {
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/*------------list操作end---------------*/

	/************* 集合操作 ***************/

	/*
	 * 获取set中元素数量
	 */
	public static Long getSetCount(String setName) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.scard(setName);
		} catch (Exception e) {
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/*
	 * 删除set中元素
	 */
	public static <T> void delSetVal(String setName, T val) {
		String valStr = GsonUtil.objToStr(val);
		delSetVal(setName, valStr);
	}

	/*
	 * 删除set中元素
	 */
	public static void delSetVal(String setName, String val) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			jedis.srem(setName, val);
		} catch (Exception e) {
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/*
	 * 判断set中是否存在 val
	 */
	public static <T> boolean sismember(String setName, T val) {
		String valStr = GsonUtil.objToStr(val);
		return sismember(setName, valStr);
	}

	/*
	 * 判断set中是否存在 val
	 */
	public static boolean sismember(String setName, String val) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.sismember(setName, val);
		} catch (Exception e) {
			broken = true;
			return false;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/*
	 * 获取set集合
	 */
	public static Set<String> getSet(String setName) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.smembers(setName);
		} catch (Exception e) {
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/*
	 * 将元素存入set
	 */
	public static <T> void saveSet(String setName, T val) {
		String valStr = GsonUtil.objToStr(val);
		saveSet(setName, valStr);
	}

	/*
	 * 将元素存入set
	 */
	public static void saveSet(String setName, String setVal) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			jedis.sadd(setName, setVal);
		} catch (Exception e) {
			broken = true;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	// 累加有序集合
	public static double zincrby(String key, double score, String member) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.zincrby(key, score, member);
		} catch (Exception e) {
			broken = true;
			return 0;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	// 获取有序集合成员
	public static double zscore(String key, String member) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.zscore(key, member);
		} catch (Exception e) {
			broken = true;
			return 0;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	// 获取有序集合成员排名
	public static long zrank(String key, String member) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.zrank(key, member);
		} catch (Exception e) {
			broken = true;
			return 0;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	// 获取有序集合所有排名(倒叙)
	public static Set<Tuple> zrangeWithScores(String key) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.zrevrangeWithScores(key, 0, -1);
		} catch (Exception e) {
			broken = true;
			return null;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	/***************************/
	// 累加计数器
	public static long incr(String key) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.incr(key);
		} catch (Exception e) {
			broken = true;
			return 0;
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	public static String getIncr(String key) {
		Jedis jedis = RedisClient.getJedis();
		boolean broken = false;
		try {
			return jedis.get(key);
		} catch (Exception e) {
			broken = true;
			return "0";
		} finally {
			RedisClient.returnResource(jedis, broken);
		}
	}

	//保存对象并设置有效时间
	public static <T> void save(String key, T obj,int seconds) {
		String val = GsonUtil.objToStr(obj);
		save(key, val);
		if(seconds!=0){
			setExpire(key, seconds);
		}
	}

}