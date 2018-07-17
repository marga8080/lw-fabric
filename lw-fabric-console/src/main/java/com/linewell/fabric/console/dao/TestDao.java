package com.linewell.fabric.console.dao;

import org.springframework.stereotype.Component;

import com.linewell.common.mongodb.dbtemplate.DataViewConfigTemplate;
import com.linewell.fabric.console.bean.Test;

@Component
public class TestDao extends DataViewConfigTemplate<Test> {

    public boolean save(Test test) {
		return this.commonSave(test);
	}
    
    public Test get(String unid) {
    	return commonGet(unid);
    }
}
