package com.zhz.SocketData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while (true){
                Socket accept = serverSocket.accept();
                new Thread(new Haddle(accept)).start();
            }


        } catch (IOException e) {
            System.out.println("端口异常");
        }
    }
}

class Haddle implements Runnable{
    private Socket socket;

    public Haddle(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                System.out.println(br.readLine());
            }

        } catch (IOException e) {
            System.out.println("连接退出");
        }
    }
}
