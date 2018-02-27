package cn.pengyi.dao;

import java.util.List;

import cn.pengyi.entity.Visit;

public interface VisitDao {

	void add(Visit visit);

	List<Visit> findAll();

}
