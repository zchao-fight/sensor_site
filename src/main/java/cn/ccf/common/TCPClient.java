package cn.ccf.common;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TCPClient.class);

    public  Socket socket;

    public OutputStream os;

    public  void startClient(final String address, int port, String msg) throws Exception{
        if (StringUtils.isEmpty(address)) {
            return;
        }
        new Thread(() -> {
            try {
                LOGGER.info("tcp:启动客户端");
                socket = new Socket(address, port);
                LOGGER.info("tcp:客户端连接成功");
                try {
                    System.out.println(msg);
                    os = socket.getOutputStream();
                    os.write(msg.getBytes("utf-8"));
                    os.flush();
                    os.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                /**
                 InputStream inputStream = socket.getInputStream();

                 byte[] buffer = new byte[1024];
                 int len = -1;
                 while ((len = inputStream.read(buffer)) != -1) {
                 String data = new String(buffer, 0, len);
                 Log.i("tcp", "收到服务器的数据---------------------------------------------:" + data);
                 EventBus.getDefault().post(new MessageClient(data));
                 }
                 */

            } catch (Exception e) {
                LOGGER.error("客户端无法连接服务器");
            }
        }).start();
    }

}
