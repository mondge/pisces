package com.pisces._20160716_20160729.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * Created by jun.xu on 16/8/8.
 */
public class UdpClient {

    public static void main(String[] args) throws IOException {
        DatagramChannel channel=DatagramChannel.open();
        channel.socket().bind(new InetSocketAddress(8080));
        ByteBuffer byteBuffer=ByteBuffer.allocateDirect(20);
        SocketAddress address=channel.receive(byteBuffer);
        byteBuffer.flip();
        String received= Charset.forName("UTF-16").newDecoder().decode(byteBuffer).toString();
        System.out.println(received);

    }
}
