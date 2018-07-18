/*
 * Copyright (c) 2018. Aberic - All Rights Reserved.
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
 * 作者：Aberic on 2018/7/12 21:02
 * 邮箱：abericyang@gmail.com
 */
@Setter
@Getter
@ToString
public class CA extends BeanEntity {

	private static final long serialVersionUID = 1L;

    private String name;
    private String skPath;
    private String certificatePath;
    private String flag; // optional
    private int peerUnid;
    private boolean tls; // required
    private String peerName; // optional
    private String orgName; // optional
    private String leagueName; // optional

}
