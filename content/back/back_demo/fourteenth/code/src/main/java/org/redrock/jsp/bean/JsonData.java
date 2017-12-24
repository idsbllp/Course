package org.redrock.jsp.bean;

import lombok.Getter;
import lombok.Setter;

/**
 * json返回格式类
 * 用到了范型有兴趣的自己查资料
 * @param <T>
 */
public class JsonData<T> {
    //状态码 一般 200 success 400 failed
    @Getter @Setter
    private int status;

    //提示信息
    @Getter @Setter
    private String info;

    //数据负载
    @Getter @Setter
    private T data;
}
