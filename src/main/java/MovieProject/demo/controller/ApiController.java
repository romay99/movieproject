package MovieProject.demo.controller;

import MovieProject.demo.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class ApiController {
    private final ApiService apiService;

    @RequestMapping("/test")
    @ResponseBody
    public String testApi(){
        return "test";
    }

}
