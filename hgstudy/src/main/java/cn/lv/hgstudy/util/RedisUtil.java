package cn.lv.hgstudy.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**  
 * <p> (这里用一句话描述这个类的作用) </p>
 *   
 * @author: xiucai（xiucai@maihaoche.com） 
 * @date: 2018/4/11 15:02   
 * @since V1.0
 */
@Component
public class RedisUtil {
	@Autowired
	private JedisPool jedisPool;

	private Jedis getJedis() {
		try {
			return jedisPool.getResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getString(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.get(key);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String set(String key,String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.set(key,value);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}


	public List<String> getStrings(List<String> keys) {
		Jedis jedis = getJedis();
		try {
			String[] toBeStored = keys.toArray(new String[keys.size()]);
			return jedis.mget(toBeStored);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String put(String key, String json, int second) {
		Jedis jedis = getJedis();
		try {
			return jedis.setex(key, second, json);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}

	public String putJson(String key, String json) {
		Jedis jedis = getJedis();
		try {
			return jedis.set(key, json);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}

	public Long delete(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.del(key);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}


	public boolean delete(List<String> keys) {
		Jedis jedis = getJedis();
		try {
			String[] toBeStored = keys.toArray(new String[keys.size()]);
			jedis.del(toBeStored);
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			close(jedis);
		}
	}


	public boolean exists(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.exists(key);
		} catch (Exception e) {

			return false;
		} finally {
			close(jedis);
		}
	}


	public Long addWithSet(String key, String... value) {
		Jedis jedis = getJedis();
		try {
			return jedis.sadd(key, value);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}


	public Long hash(String key, String field, String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.hset(key, field, value);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String getHash(String key, String field) {
		Jedis jedis = getJedis();
		try {
			return jedis.hget(key, field);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public Boolean hasHashByKey(String key, String field) {
		Jedis jedis = getJedis();
		try {
			return jedis.hexists(key, field);
		} catch (Exception e) {
			return false;
		} finally {
			close(jedis);
		}
	}


	public Long delHash(String key, String field) {
		Jedis jedis = getJedis();
		try {
			return jedis.hdel(key, field);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}

	public List<String> getHash(String key, String... field) {
		Jedis jedis = getJedis();
		try {
			return jedis.hmget(key, field);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}


	public Set<String> getAllHashKey(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.hkeys(key);
		} catch (Exception e) {

			return null;
		} finally {
			close(jedis);
		}
	}

	public Map<String, String> getAllHash(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.hgetAll(key);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String putHash(String key, Map<String, String> map) {

		Jedis jedis = getJedis();
		try {
			return jedis.hmset(key, map);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public Long getIndexByMember(String key, String member) {
		Jedis jedis = getJedis();
		try {
			return jedis.zrank(key, member);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public boolean setNX(String key, String value, int expire) {
		Jedis jedis = getJedis();
		try {
			Long result = jedis.setnx(key, value);
			if (result == 1L) {
				if(expire > 0) {
					jedis.expire(key, expire);
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		} finally {
			close(jedis);
		}
	}


	public Long expire(String key, int second) {
		Jedis jedis = getJedis();
		try {
			return jedis.expire(key, second);
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}

	public Long addList(String key, String... value) {
		Jedis jedis = getJedis();
		try {
			return jedis.rpush(key, value);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String getListByIndex(String key, int index) {
		Jedis jedis = getJedis();
		try {
			return jedis.lindex(key, index);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public Long remList(String key, long count, String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.lrem(key, count, value);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String lSet(String key, long count, String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.lset(key, count, value);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public Collection<String> getList(String key, int length) {
		Jedis jedis = getJedis();
		try {
			return jedis.lrange(key, 0, length);
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}

	public Long addSet(String key, String value) {
		Jedis jedis = getJedis();
		try {
			return jedis.sadd(key, value);
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}

	public Long delSetByValue(String key, String... value) {
		Jedis jedis = getJedis();
		try {
			return jedis.srem(key, value);
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}

	public Set<String> getSet(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.smembers(key);
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}

	public Long incr(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.incr(key);
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}

	public Long incr(String key, int expire) {
		Jedis jedis = getJedis();
		try {
			Long l= jedis.incr(key);
			jedis.expire(key,expire);
			return l;
		} catch (Exception e) {
		} finally {
			close(jedis);
		}
		return null;
	}


	public String rankSet(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.srandmember(key);
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	private void close(Jedis jedis) {
		try {
			if (jedis != null) {
				jedis.close();
			}
		} catch (Exception e) {
			//ignore
		}
	}

	public Collection<String> getKeys(String prefix) {
		Jedis jedis = getJedis();
		try {
			return jedis.keys(prefix+"*");
		} catch (Exception e) {
			return null;
		} finally {
			close(jedis);
		}
	}

	public String getStringValue(String key) {
		Jedis jedis = getJedis();
		try {
			return jedis.get(key);
		} finally {
			close(jedis);
		}
	}


}
