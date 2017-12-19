package org.redrock.jsp.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

/**
 * 输入输出流
 * 输入输出是相对于内存而言，将任何地方的数据存到一个变量中那就是输入，反之从一个变量放入到网络连接、文件那就是输出
 * 字节 与 字符 ： 字符 = 字节 + 编码
 * 字符流(reader、writer) 可以看为是对 字节流(InputStream、OutputStream) 的封装
 */
public class CurlUtil {
    /**
     * 爬取文件信息
     * 可能这里加一个设置header参数的部分会更加完整，但是我比较懒
     * 这个方法可能会伴随你的后端生涯，因为数据要么从数据库中来，要么从接口来
     * 看不懂 那就背下来吧
     * @param url       请求路径
     * @param method    http方法
     * @param params    请求参数
     * @return          返回结果
     */
    public static String getData(String url, String method, Map<String, String> params) {
        String result = "";
        try {
            //建立url资源
            URL resourceUrl = new URL(url);
            //创建http连接
            HttpURLConnection connection = (HttpURLConnection) resourceUrl.openConnection();
            method = method.equalsIgnoreCase("get") ? "GET" : "POST";
            connection.setRequestMethod(method);
            //拼接参数
            if (params != null) {
                connection.setDoOutput(true);
                StringBuilder builder = new StringBuilder();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    builder.append(key).append("=").append(value).append("&");
                }
                String paramStr = builder.toString();
                paramStr.substring(0, paramStr.length() - 1);
                //传递参数，将参数写入输出流
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(
                                connection.getOutputStream(), "UTF-8"
                        )
                );
                writer.write(paramStr);
                writer.flush();
                writer.close();
            }
            //获取结果，从输入流获取信息
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            connection.getInputStream(), "UTF-8"
                    )
            );
            String line = null;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            //关闭资源
            reader.close();
            connection.disconnect();
            result = builder.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
