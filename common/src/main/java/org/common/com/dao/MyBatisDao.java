package org.common.com.dao;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;


@Repository
@CacheNamespace(implementation=org.mybatis.caches.ehcache.EhcacheCache.class)
public class MyBatisDao extends SqlSessionDaoSupport {

	@Options(flushCache=true)
	public void save(String key, Object obj) {

		getSqlSession().insert(key, obj);
	}

	@Options(flushCache=true)
	public int saveWithKey(String key, Object obj) {

		return  getSqlSession().insert(key, obj);
	}

	@Options(flushCache=true)
	public void delete(String key, Serializable id) {

		getSqlSession().delete(key, id);
	}

	@Options(flushCache=true)
	public void delete(String key, Object obj) {

		getSqlSession().delete(key, obj);
	}

	@Options(flushCache=true)
	public void update(String key, Object obj) {
		getSqlSession().update(key, obj);
	}

	@Options(useCache = true, flushCache = false, timeout = 10000)
	public <T> T get(String key, Object params) {

		return (T) getSqlSession().selectOne(key, params);
	}

	@Options(useCache = true, flushCache = false, timeout = 10000)
	public <T> List<T> getList(String key) {

		return getSqlSession().selectList(key);
	}

	@Options(useCache = true, flushCache = false, timeout = 10000)
	public <T> List<T> getList(String key, Object params) {

		return getSqlSession().selectList(key, params);
	}

	@Options(useCache = true, flushCache = false, timeout = 10000)
	public <T> List<T> getPage(String key, Object params,RowBounds rowBounds) {

		return getSqlSession().selectList(key, params, rowBounds);
	}
}
