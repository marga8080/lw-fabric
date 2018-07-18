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

package com.linewell.fabric.console.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.linewell.common.page.Page;
import com.linewell.fabric.console.bean.League;
import com.linewell.fabric.console.dao.LeagueDao;

@Service("leagueService")
public class LeagueService  {

    @Autowired
    private LeagueDao leagueDao;
//    @Resource
//    private OrgMapper orgMapper;
//    @Resource
//    private PeerMapper peerMapper;
//    @Resource
//    private CAMapper caMapper;
//    @Resource
//    private OrdererMapper ordererMapper;
//    @Resource
//    private ChannelMapper channelMapper;
//    @Resource
//    private ChaincodeMapper chaincodeMapper;
//    @Resource
//    private AppMapper appMapper;

    public boolean add(League leagueInfo) {
        return leagueDao.add(leagueInfo);
    }

    public boolean update(League leagueInfo) {
//        CacheUtil.removeFlagCA(leagueInfo.getId(), peerMapper, caMapper);
        return leagueDao.update(leagueInfo);
    }

    public List<League> listAll() {
        return leagueDao.listAll();
    }

    public League get(String unid) {
        return leagueDao.get(unid);
    }

    public boolean delete(String unid) {
    	return leagueDao.delete(unid);
//        return DeleteUtil.obtain().deleteLeague(id, leagueMapper, orgMapper, ordererMapper, peerMapper, caMapper, channelMapper, chaincodeMapper, appMapper);
    }

    public Page<League> findPage(Page<League> page) {
    	return leagueDao.findPage(page);
    }

	public boolean deleteBatch(List<String> unids) {
		return leagueDao.deleteBatch(unids);
	}
    
}
