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

import com.linewell.common.mongodb.dbtemplate.DataViewConfigTemplate;
import com.linewell.fabric.console.bean.Org;


public class OrgDao extends DataViewConfigTemplate<Org> {

//    @Insert("insert into org (name,tls,msp_id,domain_name,orderer_domain_name,league_id,date)" +
//            "values (#{o.name},#{o.tls},#{o.mspId},#{o.domainName}," +
//            "#{o.ordererDomainName},#{o.leagueId},#{o.date})")
    public boolean add(Org org) {
    	return this.commonSave(org);
    }

//    @Update("update org set name=#{o.name}, tls=#{o.tls}, msp_id=#{o.mspId}, " +
//            "domain_name=#{o.domainName}, orderer_domain_name=#{o.ordererDomainName}, league_id=#{o.leagueId}" +
//            " where rowid=#{o.id}")
    public boolean update(Org org) {
    	return this.commonUpdate(org);
    }

    //@Select("select count(name) from org where league_id=#{id}")
    public int count(String unid) {
    	Query<Org> query = this.getDatastore().createQuery(Org.class);
    	query.field(Org.FK_BEAN_NAME_FIELD).equal(unid);
    	return (int) query.count();
    }

    //@Select("select count(name) from org")
    public int countAll() {
    	Query<Org> query = this.getDatastore().createQuery(Org.class);
    	return (int) query.count();
    }

    //@Delete("delete from org where rowid=#{id}")
    public boolean delete(String unid) {
    	return this.commonDelete(unid);
    }

    //@Delete("delete from org where league_id=#{leagueId}")
    public boolean deleteByLeague(String leagueUnid) {
    	Query<Org> query = this.getDatastore().createQuery(Org.class);
    	query.field(Org.KEY_LEAGUE_UNID).equal(leagueUnid);
    	return this.commonDelete(query);
    }

//    @Select("select rowid,name,tls,msp_id,domain_name,orderer_domain_name,league_id,date from org where rowid=#{id}")
//    @Results({
//            @Result(property = "id", column = "rowid"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "tls", column = "tls"),
//            @Result(property = "mspId", column = "msp_id"),
//            @Result(property = "domainName", column = "domain_name"),
//            @Result(property = "ordererDomainName", column = "orderer_domain_name"),
//            @Result(property = "leagueId", column = "league_id"),
//            @Result(property = "date", column = "date")
//    })
    public Org get(String unid) {
    	return this.commonGet(unid);
    }

//    @Select("select rowid,name,tls,msp_id,domain_name,orderer_domain_name,league_id,date from org where league_id=#{id}")
//    @Results({
//            @Result(property = "id", column = "rowid"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "tls", column = "tls"),
//            @Result(property = "mspId", column = "msp_id"),
//            @Result(property = "domainName", column = "domain_name"),
//            @Result(property = "ordererDomainName", column = "orderer_domain_name"),
//            @Result(property = "leagueId", column = "league_id"),
//            @Result(property = "date", column = "date")
//    })
    public List<Org> list(String leagueUnid) {
    	Query<Org> query = this.getDatastore().createQuery(Org.class);
    	query.field(Org.KEY_LEAGUE_UNID).equal(leagueUnid);
    	return query.asList();
    }

//    @Select("select rowid,name,tls,msp_id,domain_name,orderer_domain_name,league_id,date from org")
//    @Results({
//            @Result(property = "id", column = "rowid"),
//            @Result(property = "name", column = "name"),
//            @Result(property = "tls", column = "tls"),
//            @Result(property = "mspId", column = "msp_id"),
//            @Result(property = "domainName", column = "domain_name"),
//            @Result(property = "ordererDomainName", column = "orderer_domain_name"),
//            @Result(property = "leagueId", column = "league_id"),
//            @Result(property = "date", column = "date")
//    })
    public List<Org> listAll() {
    	Query<Org> query = this.getDatastore().createQuery(Org.class);
    	return query.asList();
    }

}
