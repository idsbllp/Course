package org.redrock.jsp.servlet;

import com.google.gson.Gson;
import org.redrock.jsp.bean.JsonData;
import org.redrock.jsp.service.FileService;
import org.redrock.jsp.service.impl.FileServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 文件查询接口
 * 什么教接口？
 * 简单讲就是一个方法你需要传参数去调用以达到一定功能(没有返回值) 或者 获取一定返回格式的数据(有返回值)
 * 放到一个简单的工具类里面它叫方法，但是我们规定好请求参数 与 数据格式，放到网络环境下
 * 用链接做方法名，用http请求做方法调用，这种调用就是请求接口
 *
 * 接口怎么写？
 * 规定好返回字符串的组织形式，写好的返回数据类型
 *
 * servlet 注解配置 name=> servlet名  value=> servlet对应的请求路径
 */
@WebServlet(name = "FileServlet", value = "/findFile")
public class FindFileServlet extends HttpServlet {

    FileService fileService = new FileServiceImpl();

    /**
     * 获取文件全路径
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF8");
        //mime-type: http://tool.oschina.net/commons/
        response.setContentType("application/json;charset=utf8");
        String name = request.getParameter("file");
        List<String> filePath = fileService.getFilePath(name);
        JsonData<List<String>> result = new JsonData<>();

        result.setStatus(200);
        result.setInfo("结果集");
        result.setData(filePath);
        // json
        String data = new Gson().toJson(result);
        response.getWriter().print(data);
    }
}