package com.pisces._20160716_20160729.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by jun.xu on 16/8/9.
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        Selector selector= Selector.open();
        ServerSocketChannel channel=ServerSocketChannel.open();
        channel.bind(new InetSocketAddress(8004));
        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            if(selector.select(3000)==0){
                System.out.print(".");
                continue;
            }
            Iterator<SelectionKey> keyIterator=selector.selectedKeys().iterator();
            while (keyIterator.hasNext()){
                SelectionKey key=keyIterator.next();
                if(key.isAcceptable()){
                    SocketChannel channel1=((ServerSocketChannel)key.channel()).accept();
                    channel1.configureBlocking(false);
                    channel1.register(key.selector(),SelectionKey.OP_READ, ByteBuffer.allocate(3000));
                }
                if(key.isReadable()){
                    SocketChannel channel2=(SocketChannel)key.channel();
                    ByteBuffer buffer=(ByteBuffer)key.attachment();
                    int bytesRead=channel2.read(buffer);
                    if(bytesRead==-1)
                    {
                        channel2.close();
                    }else if(bytesRead>0){
                        System.out.println(new String(buffer.array(),0,bytesRead));
                        key.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
                    }
                }
                if(key.isWritable()){
                    ByteBuffer buffer=(ByteBuffer)key.attachment();
                    buffer.flip();
                    SocketChannel channel3=(SocketChannel)key.channel();
                    channel3.write(buffer);
                    if(!buffer.hasRemaining()){
                        key.interestOps(SelectionKey.OP_READ);
                    }
                    buffer.compact();
                }
                keyIterator.remove();
            }
        }


    }
}
