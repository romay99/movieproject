package MovieProject.demo.controller;

import MovieProject.demo.service.ApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;


}
