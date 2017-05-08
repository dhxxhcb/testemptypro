package com.xoa.service.workflow;

import com.xoa.util.common.L;

/**
 * Created by 王曰岐 on 2017/5/8.
 */
public class JobClassifyException extends RuntimeException {

    public JobClassifyException() {
        super();
    }

    public JobClassifyException(String message) {
        super(message);
        L.w(message);
    }
}
