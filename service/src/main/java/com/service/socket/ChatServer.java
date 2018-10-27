package com.service.socket;

import com.service.model.DeviceModel;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatServer {

    private static List<Socket> sockets = new ArrayList<>();

    /**
     * 启动socket连接
     *
     * @throws IOException 
     */
    public static void startServer() throws IOException {
        int port = 8888;
        ServerSocket ss = new ServerSocket(port);
        while (true) {
            Socket socket = ss.accept();
            sockets.add(socket);
            System.out.println("连接成功:" + socket.getInetAddress());
            new WorkThread(socket).start();
        }

    }

    static class WorkThread extends Thread {
        private Socket socket;

        public WorkThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                while (true) {
                    for (Socket s : sockets) {
                        byte buf[] = new byte[1024];
                        inputStream.read(buf);
                        System.out.println("read info: " + new String(buf));
                        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                        DeviceModel deviceModel = new DeviceModel();
                        deviceModel.setCreateTime(new Date());
                        deviceModel.setModelName("精品高科");
                        deviceModel.setUpdateTime(new Date());
                        dos.writeUTF(deviceModel.toString());
                        dos.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                sockets.remove(socket);
            }
        }
    }


}