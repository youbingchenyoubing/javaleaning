package design.chainOfResposibilty.channel1;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mr_chen
 * @date 2023/1/30
 * @Project algorithm
 **/
@Getter
public class Result {
   private static Result SUCCESS = new Result(200,"success");
    private int code;
    private String message;


    public static  Result success() {
        return SUCCESS;
    }

    public static Result failure(ErrorCode error){
        return new Result(error.getCode(),error.getMessage());
    }

    Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return code == 200;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
