import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //1.创建一个服务器端Socket
            ServerSocket serverSocket = new ServerSocket(8888);
            //2.调用accpet()方法开始监听，等待客户端的连接
            System.out.println("Server is starting, waiting for connecting from client");
            Socket socket = serverSocket.accept();
            //3.获取输入流，并读取客户端信息
            InputStream is = socket.getInputStream();//字节输入流
            InputStreamReader isr = new InputStreamReader(is);//转化字符流（提高效率）
            BufferedReader br = new BufferedReader(isr);//为输入流添加缓冲
            String info = null;
            while((info = br.readLine()) != null)
            {
                System.out.println("I am Server, the Client say " + info);
            }
            socket.shutdownInput();//关闭输入流

            //4.关闭资源
            br.close();
            isr.close();
            is.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        

    }
}