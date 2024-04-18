package win.zhangzhixing.order.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ResponseData<T> implements Serializable {
    public static final Integer SUCCESS = 0;
    public static final Integer FAIL = 1;
    private Integer status;
    @JsonProperty(value = "errorCode")
    private String errorCode;
    private T data;
    @JsonProperty(value = "errorMsg")
    private String errorMsg;

    public ResponseData() {
    }
}
