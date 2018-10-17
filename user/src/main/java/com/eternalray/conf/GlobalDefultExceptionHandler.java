package com.eternalray.conf;

import com.eternalray.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: Eternalray
 */
@ControllerAdvice
@Slf4j
public class GlobalDefultExceptionHandler {

    /**
     * 全局异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object defultExcepitonHandler(Exception e) {
        log.error("执行出错！",e);
        return Result.set(false, e.getStackTrace());
    }

}
