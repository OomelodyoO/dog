package win.zhangzhixing.order.advice;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import win.zhangzhixing.order.util.ResponseData;

@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {
    @ExceptionHandler(value = {RuntimeException.class})
    protected ResponseEntity<String> runtimeExceptionHandler(RuntimeException ex) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", ResponseData.FAIL);
        jsonObject.put("errorMsg", ex.getMessage());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        log.error(jsonObject.toString());
        return new ResponseEntity(jsonObject.toString(), headers, HttpStatus.OK);
    }
}
