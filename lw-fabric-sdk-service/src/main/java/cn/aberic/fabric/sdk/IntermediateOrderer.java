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

package cn.aberic.fabric.sdk;

/**
 * 描述：中继Orderer排序服务对象
 *
 * @author : Aberic 【2018/5/4 15:30】
 */
class IntermediateOrderer {

    /** orderer 排序服务器的域名 */
    private String ordererName;
    /** orderer 排序服务器的访问地址 */
    private String ordererLocation;
    /** tls请求证书 */
    private String serverCrtPath;

    IntermediateOrderer(String ordererName, String ordererLocation, String serverCrtPath) {
        super();
        this.ordererName = ordererName;
        this.ordererLocation = ordererLocation;
        this.serverCrtPath = serverCrtPath;
    }

    String getOrdererName() {
        return ordererName;
    }

    void setOrdererLocation(String ordererLocation) {
        this.ordererLocation = ordererLocation;
    }

    String getOrdererLocation() {
        return ordererLocation;
    }

    String getServerCrtPath() {
        return serverCrtPath;
    }
}
