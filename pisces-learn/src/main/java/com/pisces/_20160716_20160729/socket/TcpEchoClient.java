package com.pisces._20160716_20160729.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by jun.xu on 16/7/20.
 */
public class TcpEchoClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8004);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        outputStream.write("xujun1234".getBytes());

        byte[] bytes=new byte[3];

        int readSize=0;
        while((readSize=inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,readSize));
        }

        socket.close();
    }
}
