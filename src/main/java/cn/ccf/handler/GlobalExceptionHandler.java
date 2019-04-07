package cn.ccf.handler;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseDTO<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM, objectError.getDefaultMessage());
    }


    /**
     * @Valid 处理
     * @param e
     * @return
     */
  /*  @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseDTO<String> handleBindException(BindException e) {
        //LOG.info("", e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM, objectError.getDefaultMessage());
    } */

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseDTO<String> handleBindException(BindException e) {
        //LOG.info("", e);
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM, objectError.getDefaultMessage());
    }

    /**
     * 全局异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public ResponseDTO<String> handlerException(Throwable e) {
        LOGGER.error("", e);
        return ResponseDTO.wrap(ResponseCodeConst.SYSTEM_ERROR, "系统错误,请联系运维：915749631@126.com");
    }
}
