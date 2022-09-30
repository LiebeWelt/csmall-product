package cn.tedu.csmall.product.web;

import cn.tedu.csmall.product.ex.ServiceException;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {

    /**
     * 业务状态码
     */
    @ApiModelProperty("业务状态码")
    private Integer state;

    /**
     * 操作失败时的提示文本
     */
    @ApiModelProperty("操作失败时的提示文本")
    private String message;

    /**
     * 操作成功时响应的数据
     */
    @ApiModelProperty("操作成功时的提示文本")
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer state, String message ,T data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public static final Integer STATE_OK = 100;
    public static final Integer STATE_ERROR_BAD = 400;
    public static final Integer STATE_ERROR_NOT_FOUND = 404;

    public static JsonResult<Void> ok() {
        return ok(null);
    }

    public static <T> JsonResult<T> ok(T data) {
        return new JsonResult(ServiceCode.OK.getValue(), null, data);
    }


    public static JsonResult fail(ServiceException e) {
        return fail(e.getServiceCode(), e.getMessage());
    }

    public static JsonResult fail(ServiceCode serviceCode, String message) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.state = serviceCode.getValue();
        jsonResult.message = message;
        return jsonResult;
    }
}
