package com.xtdoa.base.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xtdoa.base.dao.BaseDao;

/**
 * 公共类
  * @author 作者:  张勇 
  * @version 版本： 1.0 
  * @parameter 
  * @since 
  * @return 
  */
@SuppressWarnings("all")
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clzz;
	
	public BaseDaoImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("获取当前this对象的父类信息" + this.getClass().getSuperclass());  
        System.out.println("获取当前this对象的父类信息(包括泛型信息)" + this.getClass().getGenericSuperclass()); 
        //获取范型参数类型
        Type t = this.getClass().getGenericSuperclass();
        System.out.println(t);
        if (t instanceof ParameterizedType) {
            System.out.println("in if");
            clzz = (Class<T>) ((ParameterizedType)t).getActualTypeArguments()[0];
        }
        
	}
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	/**
	 * 登录
	 */
	@Override
	public Integer userLogin(String userName, String passWord) {
		Number count = (Number) getSession().createCriteria(clzz)
				.setProjection(Projections.rowCount()).add(Restrictions.eq("login", userName))
				.add(Restrictions.eq("passWord", passWord))
				.uniqueResult();
		return count.intValue();
	}
	
	/**
	 * 条件查询或全部查询共有多少条数据
	 * empNo 工号
	 * login 登录帐号
	 * displayName 姓名
	 * deptName 部门名称
	 * userCategory 用户类别
	 */
	@Override
	public Integer queryForInt(Class clzz) {
		Number count = (Number) getSession().createCriteria(clzz)
				.setProjection(Projections.rowCount())
//				.add(Restrictions.and(Restrictions.ilike("empNo", empNo, MatchMode.ANYWHERE),
//						Restrictions.ilike("login", login, MatchMode.ANYWHERE),
//						Restrictions.ilike("displayName", displayName, MatchMode.ANYWHERE),
//						Restrictions.ilike("d.deptName",deptName,MatchMode.ANYWHERE),
//						Restrictions.ilike("empType", userCategory,MatchMode.ANYWHERE)))
//				//关联部门名称起别名
//				.createAlias("dept", "d").add(Restrictions.ilike("d.deptName", deptName,MatchMode.ANYWHERE))
				.uniqueResult();
				return count.intValue();
	}
	
	/**
	 * 条件查询或全部查询返回结果集
	 * currentPage 页码
	 * pageSize 显示条数
	 */
	@Override
	public List<T> queryForLists(Class clzz,Integer currentPage, Integer pageSize) {
		return getSession().createCriteria(clzz)
				.addOrder(Order.desc("userID"))
				.setFirstResult(currentPage).setMaxResults(pageSize).list();
	}
	
	
	/**
	 * 条件查询或全部查询共有多少条数据
	 */
	@Override
	public Integer queryForInts(Class clzz) {
		Number count = (Number) getSession().createCriteria(clzz)
				.setProjection(Projections.rowCount())
				.uniqueResult();
				return count.intValue();
	}

    /**
     * 根据ID查询所有信息
     * @param id
     * @return 对象
     */
    @Override
    public T findById(Class clzz,Serializable id) {
        return (T)getSession().get(clzz,id);
    }

    /**
	 * 条件查询或全部查询返回结果集
	 * currentPage 页码
	 * pageSize 显示条数
	 */
	@Override
	public List<T> queryForList(Class clzz,Integer currentPage, Integer pageSize) {
		return getSession().createCriteria(clzz)
//				.add(Restrictions.and(Restrictions.ilike("empNo", empNo, MatchMode.ANYWHERE),
//						Restrictions.ilike("displayName", displayName, MatchMode.ANYWHERE),
//						Restrictions.ilike("login", login, MatchMode.ANYWHERE),
//						Restrictions.ilike("empType", userCategory, MatchMode.ANYWHERE)))
//				.createAlias("dept", "d").add(Restrictions.ilike("d.deptName",deptName,MatchMode.ANYWHERE))
				.addOrder(Order.desc("userID"))
				.setFirstResult(currentPage).setMaxResults(pageSize).list();
	}
	
	/**
	 * 保存信息
	 * 
	 */
	@Override
	public void saveUser(T t) {
		// TODO Auto-generated method stub
		getSession().save(t);
	}
	
	/**
	 * 获取所有信息
	 */
	@Override
	public List<T> showDept(Class clzz) {
		// TODO Auto-generated method stub
		return getSession().createCriteria(clzz).list();
	}
	
	
	
	/**
	 * shiro验证
	 */
	@Override
	public T get(String hql, List<Object> param) {
		List<T> l = this.find(hql, param);
		if (l != null && l.size() > 0) {
			return l.get(0);
		} else {
			return null;
		}
	}
	
	/**
	 * 根据参数返回对象集合
	 */
	@Override
	public List<T> find(String hql, List<Object> params) {
		Query query = getSession().createQuery(hql);
		if (null != params && params.size() > 0) {
			for (int i = 0; i < params.size(); i++) {
				query.setParameter(i, params.get(i));
			}
		}
		return query.list();
	}	
}
