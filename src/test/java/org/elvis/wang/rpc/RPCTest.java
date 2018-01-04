package org.elvis.wang.rpc;

import org.elvis.wang.rpc.client.RPCClient;
import org.elvis.wang.rpc.provider.service.HelloService;
import org.elvis.wang.rpc.provider.service.impl.HelloServiceImpl;
import org.elvis.wang.rpc.server.Server;
import org.elvis.wang.rpc.server.ServiceCenter;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by wangzhiqun on 2018/1/4.
 */
public class RPCTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        //注册中心  注册服务
        new Thread(new Runnable() {
            public void run() {
                try {
                    Server serviceServer = new ServiceCenter(8010);
                    serviceServer.register(HelloService.class, HelloServiceImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000L);
        HelloService service = RPCClient.getRemoteProxyObj(HelloService.class, new InetSocketAddress("127.0.0.1", 8010));
        System.out.println(service.sayHi("test"));
    }
}
