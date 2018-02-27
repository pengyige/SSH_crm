package cn.pengyi.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.pengyi.dao.LinkManDao;
import cn.pengyi.entity.LinkMan;

@Transactional
public class LinkManService {
	
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public void addLinkMan(LinkMan linkMan) {
		
		linkManDao.add(linkMan);
		
	}

	public List<LinkMan> listLinkMan() {
		// TODO Auto-generated method stub
		return linkManDao.list();
	}

	public LinkMan findOne(int linkid) {
		// TODO Auto-generated method stub
		return linkManDao.findOne(linkid);
	}

	public void updateLinkMan(LinkMan linkMan) {
		
		linkManDao.updateLinkMan(linkMan);
		
	}
	
}
