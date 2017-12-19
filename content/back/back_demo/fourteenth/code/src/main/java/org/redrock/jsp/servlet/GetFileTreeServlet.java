package org.redrock.jsp.servlet;
import com.google.gson.Gson;
import org.redrock.jsp.bean.FileInfo;
import org.redrock.jsp.bean.JsonData;
import org.redrock.jsp.service.FileService;
import org.redrock.jsp.service.impl.FileServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件目录树查询接口
 * 这两个servlet都是返回的json字符串
 * 前端主要是通过两个东西去判断返回数据类型
 * 第一个是返回数据的格式，参考xml与json
 * 第二个是header种的content-type，type一般是mime类型 mime-type: http://tool.oschina.net/commons/
 *
 * 不要被什么格式给吓倒
 * 格式是什么？就是以一定规则排列的字符串(json字符转) 加 一个类型标识(mime-type)
 * 所以不管什么格式，只要字符串的组织顺序达到一致，header的content-type格式设置正确，相应的格式解析就不会出错
 *
 * json的格式
 * 对象 类似于 map {key : value}
 * 数组 类似于 list [item1, item2, item3 ...]
 */
@WebServlet(name = "GetFileTreeServlet", value = "/getFileTree")
public class GetFileTreeServlet extends HttpServlet {

    FileService fileService = new FileServiceImpl();

    /**
     * 返回文件路径信息json结果树
     * 相似的思想可以应用于留言板、说说评论实现
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf8");
        FileInfo root = fileService.getRootFileInfo();
        JsonData<FileInfo> result = new JsonData<>();
        result.setStatus(200);
        result.setInfo("success");
        result.setData(root);
        String data = new Gson().toJson(result);
        response.getWriter().print(data);
    }
}