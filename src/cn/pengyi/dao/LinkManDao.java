package cn.pengyi.dao;

import java.util.List;

import cn.pengyi.entity.LinkMan;

public interface LinkManDao {

	void add(LinkMan linkMan);

	List<LinkMan> list();

	LinkMan findOne(int linkid);

	void updateLinkMan(LinkMan linkMan);

}