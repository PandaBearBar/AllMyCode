package bar.task.taskBlingBling.service;

import org.springframework.stereotype.Service;

public interface SystemService {
    void clearCache();
    double initCache(String from, String to, Double amount);
}
