package spring.dugtrio.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import spring.dugtrio.global.response.status.ErrorStatus;
import spring.dugtrio.global.response.status.SuccessStatus;

public record ApiResponse<T>(
    Boolean isSuccess,
    String code,
    String message,
    T result) {

    public static final ApiResponse<Void> OK = new ApiResponse<>(true, SuccessStatus.OK.getCode(), SuccessStatus.OK.getMessage(), null);

    // 성공 응답
    public static <T> ApiResponse<T> onSuccess(T result) {
        return new ApiResponse<>(true, SuccessStatus.OK.getCode(), SuccessStatus.OK.getMessage(),result);
    }

    // 실패 응답
    public static <T> ApiResponse<T> onFailure(ErrorStatus errorStatus, T data) {
        return new ApiResponse<>(false, errorStatus.getCode(), errorStatus.getMessage(), data);
    }

}


