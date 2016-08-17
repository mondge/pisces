package com.pisces._20160716_20160729.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * Created by jun.xu on 16/8/8.
 */
public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramChannel channel=DatagramChannel.open();
        ByteBuffer byteBuffer=ByteBuffer.wrap("Hello".getBytes("UTF-16"));
        channel.send(byteBuffer,new InetSocketAddress("127.0.0.1",8080));

    }
}
