package com.kangjian.springbootstudy;
public class Response {
    /**
     *  response code:
     *   200 ok
     *   500 internal error
     *   501 Exceptions
     */
    private Integer status;

    private String msg;

    private Object data;

    private String time;

    public Response(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.time = "23222";
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public static Response ok(){
        return new Response(200, "", "");
    }

    public static Response ok(Object data){
        return new Response(200, "ok", data);
    }

    public static Response error() {
        return new Response(500, "error", "");
    }

    public static Response error(String msg) {
        return new Response(500, msg, "");
    }

    public static Response errorException(String msg){
        return new Response(501, msg, "");
    }
}
