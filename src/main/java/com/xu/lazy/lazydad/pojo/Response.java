package com.xu.lazy.lazydad.pojo;

public class Response<T> {

    public T data;

    public int code;

    public String resultNote;


    public Response() {
    }

    public Response(T data, int code, String resultNote) {
        this.data = data;
        this.code = code;
        this.resultNote = resultNote;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getResultNote() {
        return resultNote;
    }

    public void setResultNote(String resultNote) {
        this.resultNote = resultNote;
    }


    public static <T>Response<T> success(T data)
    {
        return new Response<>(data, 0, "ok");
    }

    public static Response fail(int code,String note){


        return new Response("",code,note);
    }


}
