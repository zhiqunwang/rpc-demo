package org.elvis.wang.rpc.server;

import java.io.IOException;

/**
 * Created by wangzhiqun on 2018/1/4.
 */
public interface Server {

    public void stop();

    public void start() throws IOException;

    public void register(Class serviceInterface, Class impl);

    public boolean isRunning();

    public int getPort();
}
