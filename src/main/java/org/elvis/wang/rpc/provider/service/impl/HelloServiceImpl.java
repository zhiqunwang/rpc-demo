package org.elvis.wang.rpc.provider.service.impl;

import org.elvis.wang.rpc.provider.service.HelloService;

/**
 * Created by wangzhiqun on 2018/1/4.
 */
public class HelloServiceImpl implements HelloService {

    public String sayHi(String name) {
        return "Hi.."+name;
    }
}
