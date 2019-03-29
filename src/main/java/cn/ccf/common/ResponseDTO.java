package cn.ccf.common;


public class ResponseDTO<T> {

    protected Integer code;

    protected String msg;

    protected boolean success;

    protected T data;

    public ResponseDTO() {
    }

    public ResponseDTO(ResponseCodeConst responseCodeConst, String msg) {
        this.code = responseCodeConst.getCode();
        this.msg = msg;
        this.success = responseCodeConst.getSuccess();
    }

    public ResponseDTO(ResponseCodeConst responseCodeConst, T data) {
        super();
        this.code = responseCodeConst.getCode();
        this.msg = responseCodeConst.getMsg();
        this.data = data;
        this.success = responseCodeConst.getSuccess();
    }

    private ResponseDTO(ResponseCodeConst responseCodeConst) {
        this.code = responseCodeConst.getCode();
        this.msg = responseCodeConst.getMsg();
        this.success = responseCodeConst.getSuccess();
    }

    public ResponseDTO(ResponseDTO responseDTO) {
        this.code = responseDTO.getCode();
        this.msg = responseDTO.getMsg();
        this.success = responseDTO.getSuccess();
    }

    public static <T> ResponseDTO<T> succ() {
        return new ResponseDTO<>(ResponseCodeConst.SUCCESS);
    }

    public static <T> ResponseDTO<T> succ(T data) {
        return new ResponseDTO(ResponseCodeConst.SUCCESS, data);
    }

    public static <T> ResponseDTO succMsg(String msg) {
        return new ResponseDTO(ResponseCodeConst.SUCCESS, msg);
    }


    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst) {
        codeConst.setSuccess(false);
        return new ResponseDTO<>(codeConst);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst, T t) {
        codeConst.setSuccess(false);
        return new ResponseDTO<T>(codeConst, t);
    }

    public static <T> ResponseDTO<T> wrap(ResponseCodeConst codeConst, String msg) {
        codeConst.setSuccess(false);
        return new ResponseDTO<T>(codeConst, msg);
    }

    public String getMsg() {
        return msg;
    }

    public  ResponseDTO setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public int getCode() {
        return code;
    }

    public ResponseDTO setCode(Integer code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseDTO setData(T data) {
        this.data = data;
        return this;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" + "code=" + code + ", msg='" + msg + '\'' + ", success=" + success + ", data=" + data +
                '}';
    }


}
