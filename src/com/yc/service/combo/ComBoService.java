package com.yc.service.combo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cplatform.dbhelp.DbHelper;
import com.yc.dao.combo.ComBoDao;
import com.yc.entity.ComBo;


@Service
public class ComBoService {
	@Autowired
	private DbHelper dbHelper;
	@Autowired
	private ComBoDao dao;
	
	//通过产品 Id查询 产品 
	public ComBo findbyId (Long id){
		return dao.findOne(id);
	}
	
	//增加产品
	public ComBo addOrUpdateComBo(ComBo combo){
		return dao.save(combo);
	}
	
   //删除产品
	public void delCombo(Long id){
    dao.delete(id);		
	}
	
	
}
