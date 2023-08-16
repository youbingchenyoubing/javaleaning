package design.chainOfResposibilty.adapter;

import design.chainOfResposibilty.application.common.dto.TestResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr_chen
 * @date 2023/8/16
 * @Project javaleaning
 **/
@RestController
public class TestController {
    @GetMapping("/hello/{id}")
    public TestResponse getTestResponse(@PathVariable(value="id") Long id){
        return new TestResponse(id);
    }
}
