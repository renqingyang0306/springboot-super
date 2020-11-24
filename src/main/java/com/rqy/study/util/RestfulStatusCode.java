package com.rqy.study.util;

/**
 * Created by jiashiran on 2017/9/6.
 */
public enum RestfulStatusCode {

    OK(200,"GET","服务器成功返回用户请求的数据，该操作是幂等的"),

    CREATED(201,"POST/PUT/PATCH","用户新建或修改数据成功"),

    Accepted(202,"*","表示一个请求已经进入后台排队（异步任务）"),

    NO_CONTENT(204,"DELETE","用户删除数据成功"),

    PARTIAL_CONTENT(206, "GET/POST", "处理了部分请求"),

    INVALID_REQUEST(400,"POST/PUT/PATCH","用户发出的请求有错误，服务器没有进行新建或修改数据的操作，参数校验有误，该操作是幂等的"),

    Unauthorized(401,"*","表示用户没有权限（令牌、用户名、密码错误）"),

    Forbidden(403,"*","表示用户得到授权（与401错误相对），但是访问是被禁止的"),

    NOT_FOUND(404,"*","用户发出的请求针对的是不存在的记录，服务器没有进行操作，该操作是幂等的"),

    Not_Acceptable(406,"GET","用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式"),

    REQUEST_TIMEOUT(408,"GET","请求超时。客户端没有在服务器预备等待的时间内完成一个请求的发送。客户端可以随时再次提交这一请求而无需进行任何更改。"),

    Gone(410,"GET","用户请求的资源被永久删除，且不会再得到的"),

    Unprocesable_Entity(422,"POST/PUT/PATCH","当创建一个对象时，发生一个验证错误"),

    INTERNAL_SERVER_ERROR(500,"*","服务器发生错误，用户将无法判断发出的请求是否成功"),
    ;

    private int code;
    private String httpMethod;
    private String desc;
    RestfulStatusCode(int c, String method, String d){
        this.code = c;
        this.httpMethod = method;
        this.desc = d;
    }

    public int code(){
        return this.code;
    }

    public String desc(){
        return this.desc;
    }
}
