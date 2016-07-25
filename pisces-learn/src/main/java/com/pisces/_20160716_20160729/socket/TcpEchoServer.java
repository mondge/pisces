package com.pisces._20160716_20160729.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by jun.xu on 16/7/20.
 */
public class TcpEchoServer {

    public static void main(String[] args) throws IOException {


        ServerSocket serverSocket = new ServerSocket(8001);

        System.out.println(serverSocket.getLocalSocketAddress());

        byte[] receiveBuf = new byte[1000];

        int recvMsgSize=0;

        while (true) {
            Socket clientSocket = serverSocket.accept();
            SocketAddress clientAddress=clientSocket.getRemoteSocketAddress();

            System.out.println("ip:"+clientAddress);

            InputStream inputStream=clientSocket.getInputStream();

            OutputStream outputStream=clientSocket.getOutputStream();

            while((recvMsgSize=inputStream.read(receiveBuf))!=-1){
                outputStream.write(receiveBuf,0,recvMsgSize);
            }

            clientSocket.close();

        }
    }


}
