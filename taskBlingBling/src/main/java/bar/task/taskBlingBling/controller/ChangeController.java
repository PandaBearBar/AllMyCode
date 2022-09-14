package bar.task.taskBlingBling.controller;

import bar.task.taskBlingBling.bins.Cache;
import bar.task.taskBlingBling.service.SystemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money/")
@RequiredArgsConstructor
public class ChangeController {
    private final SystemService service;
    @GetMapping("convert/")
    public double converter(@RequestParam String from,@RequestParam String to,@RequestParam double amount){
        return service.initCache(from, to, amount);
    }
}
