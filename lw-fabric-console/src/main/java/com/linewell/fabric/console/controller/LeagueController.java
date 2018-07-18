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

package com.linewell.fabric.console.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.linewell.common.BaseController;
import com.linewell.common.http.ResponseResult;
import com.linewell.common.page.Page;
import com.linewell.common.page.PageHelper;
import com.linewell.fabric.console.bean.League;
import com.linewell.fabric.console.service.LeagueService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//@CrossOrigin
@RestController
@RequestMapping("web/league")
@Api(value = "联盟", description = "联盟")
public class LeagueController extends BaseController {

   
    @Autowired
    private LeagueService leagueService;


    @GetMapping(value = "")
    @ApiOperation(value = "获取联盟")
    public ResponseResult<Object> get(String unid) {
    	ResponseResult<Object> result = new ResponseResult<Object>();
    	League league = leagueService.get(unid);
    	result.setData(league);
    	return result;
    }
    
    
    @PostMapping(value = "")
    @ApiOperation(value = "新增联盟")
    public ResponseResult<Object> add(@RequestBody League league) {
    	ResponseResult<Object> result = new ResponseResult<Object>();
    	leagueService.add(league);
    	return result;
    }

    @PutMapping(value = "")
    @ApiOperation(value = "修改联盟")
    public ResponseResult<Object> edit(@RequestBody League league) {
    	ResponseResult<Object> result = new ResponseResult<Object>();
    	leagueService.update(league);
    	return result;
    }

    @DeleteMapping(value = "")
    @ApiOperation(value = "删除联盟")
    public ResponseResult<Object> delete(String unid) {
    	ResponseResult<Object> result = new ResponseResult<Object>();
        leagueService.delete(unid);
        return result;
    }
    
    
    @PostMapping(value = "deleteBatch")
    @ApiOperation(value = "批量删除联盟")
    public ResponseResult<Object> deleteBatch(@RequestBody List<String> unids) {
    	ResponseResult<Object> result = new ResponseResult<Object>();
    	leagueService.deleteBatch(unids);
    	return result;
    }

    @GetMapping(value = "list")
    @ApiOperation(value = "联盟列表")
    public ResponseResult<Object> list(HttpServletRequest request) {
    	ResponseResult<Object> result = new ResponseResult<Object>();
    	Page<League> page = PageHelper.startPage(getPageNo(request), getPageSize(request));
        page = leagueService.findPage(page);
        result.setData(page);
        return result;
    }

}
