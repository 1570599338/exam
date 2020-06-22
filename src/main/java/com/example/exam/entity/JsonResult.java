package com.example.exam.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JsonResult {
    int code;
    String message;
    Object data;

    public JsonResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = null;
    }

    public JsonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
