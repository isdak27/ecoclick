package com.uptctrabajocampo.ecoclickv2.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class MessageRest<T> {
    private int code;
    private String message;
    private int codeHttp;
    private T data;

    public MessageRest(int code, String message, int codeHttp) {
        this.code = code;
        this.message = message;
        this.codeHttp = codeHttp;
    }

    public MessageRest(int code, String message, int codeHttp, T data) {
        this.code = code;
        this.message = message;
        this.codeHttp = codeHttp;
        this.data = data;
    }
}