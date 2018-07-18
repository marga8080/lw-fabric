/*
 * Copyright (c) 2018. Aberic - aberic@qq.com - All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.linewell.fabric.console.dao;

import java.util.List;

import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import com.linewell.common.mongodb.dbtemplate.DataViewConfigTemplate;
import com.linewell.common.page.Page;
import com.linewell.common.page.PageHelper;
import com.linewell.fabric.console.bean.League;
import com.mongodb.WriteResult;

@Component
public class LeagueDao extends DataViewConfigTemplate<League> {

	// @Insert("insert into league (name,date,version) values
	// (#{l.name},#{l.date},#{l.version})")
	public boolean add(League league) {
		return this.commonSave(league);
	}

	// @Update("update league set name=#{l.name},version=#{l.version} where
	// rowid=#{l.id}")
	public boolean update(League league) {
		return this.commonUpdate(league);
	}

	// @Delete("delete from league where rowid=#{id}")
	public boolean delete(String unid) {
		return this.commonDelete(unid);
	}

	// @Select("select rowid,name,date,version from league where rowid=#{id}")
	// @Results({
	// @Result(property = "id", column = "rowid"),
	// @Result(property = "name", column = "name"),
	// @Result(property = "date", column = "date"),
	// @Result(property = "version", column = "version")
	// })
	public League get(String unid) {
		return this.commonGet(unid);
	}

	// @Select("select rowid,name,date,version from league")
	// @Results({
	// @Result(property = "id", column = "rowid"),
	// @Result(property = "name", column = "name"),
	// @Result(property = "date", column = "date"),
	// @Result(property = "version", column = "version")
	// })
	public List<League> listAll() {
		Query<League> query = this.getDatastore().createQuery(League.class);
		return query.asList();
	}

	public Page<League> findPage(Page<League> page) {
		Query<League> query = this.getDatastore().createQuery(League.class);
		return PageHelper.pageResult(page, query);
	}

	public boolean deleteBatch(List<String> unidList) {
		WriteResult writeResult = this.getDatastore().delete(League.class, unidList);
		if(writeResult.getN() > 0){
			return true;
		}else{
			return false;
		}
	}
}
