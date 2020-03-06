package com.ym.hygg.huyagg.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object object;
    public static final Integer SUCCESS = 200;
    public static final Integer Fail = 404;
    /**
     * 拒绝访问
     */
    public static final Integer Reject = 401;
}
