package com.zhz.SocketData;

import com.zhz.createLog.CreateLogTools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 8888);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Flag flag = new Flag();
        new Thread(new Stop(flag)).start();
        while (flag.flag) {
            writer.write(CreateLogTools.create());
            writer.newLine();
            writer.flush();
        }


    }
}
class Flag {
    public boolean flag = true;
}
class Stop implements Runnable{


    public Stop(Flag flag) {
        this.flag = flag;
    }

    private final Flag flag;
    @Override
    public void run() {
        File files = new File("./");
        label:while (true){
            for (File file : files.listFiles()) {
                if (file.getName().equals("stop")){
                    flag.flag = false;
                    boolean delete = file.delete();

                    break label;
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
