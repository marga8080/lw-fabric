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

package com.linewell.fabric.console.bean;

import com.linewell.common.bean.BeanEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 作者：Aberic on 2018/6/27 21:15
 * 邮箱：abericyang@gmail.com
 */
@Setter
@Getter
@ToString
public class Org extends BeanEntity {

	private static final long serialVersionUID = 1L;
	
	public static final String KEY_LEAGUE_UNID = "leagueUnid";

    private String name; // required
    private boolean tls; // required
    private String mspId; // required
    private String domainName; // required
    private String ordererDomainName; // required
    private String leagueUnid; // required
    private String leagueName; // required
    private int peerCount; // required
    private int ordererCount; // required
}
