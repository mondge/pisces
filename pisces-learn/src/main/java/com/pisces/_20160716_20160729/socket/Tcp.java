package com.pisces._20160716_20160729.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by jun.xu on 16/8/9.
 */
public class Tcp {
    public static void main(String[] args) throws IOException {
        SocketChannel clntChannel=SocketChannel.open();
        clntChannel.configureBlocking(false);
        if(!clntChannel.connect(new InetSocketAddress("127.0.0.1",8004))){
            while   (!clntChannel.finishConnect()){
                System.out.print(".");
            }
        }
        ByteBuffer writeBuffer=ByteBuffer.wrap("Hello World".getBytes());
        ByteBuffer readBuffer=ByteBuffer.allocate(3000);
        int byteRcvd=0;
        while (true){
            if(writeBuffer.hasRemaining()){
                clntChannel.write(writeBuffer);
            }
            if((byteRcvd=clntChannel.read(readBuffer))>0){
                System.out.println(new String(readBuffer.array(),0,byteRcvd));
            }
        }
    }
}
