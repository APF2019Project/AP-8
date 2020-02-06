package client;

import java.net.InetAddress;

public class Config {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public Config(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public int getPort() {
        return port;
    }


}
