package cn.pengyi.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T>{

	
	
	private Class pclass;
	
	public BaseDaoImpl() {
		//�õ���ǰ�������class
		Class clazz = this.getClass();
		
		//�õ�������ĸ���Ĳ���������
		  //ʹ��Type�ӽӿ�ParameterizedType
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		
		//�õ�ʵ�����Ͳ���
		Type[] types = ptype.getActualTypeArguments();
		this.pclass = (Class) types[0];
		
	}

	@Override
	public void add(T t) {
		
		this.getHibernateTemplate().save(t);
	}

	@Override
	public void update(T t) {
		
		this.getHibernateTemplate().update(t);
	}

	@Override
	public void delete(T t) {
		
		this.getHibernateTemplate().delete(t);
	}

	@Override
	public T findOne(int id) {
		// TODO Auto-generated method stub
		return (T) this.getHibernateTemplate().get(pclass, id);
	}

	@Override
	public List<T> findAll() {
		
		return (List<T>) this.getHibernateTemplate().find("from "+pclass.getSimpleName());
	}

}
