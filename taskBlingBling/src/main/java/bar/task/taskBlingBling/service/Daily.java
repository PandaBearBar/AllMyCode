package bar.task.taskBlingBling.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Daily {
    private final SystemService service;
    private final String toCron = "0 45 15 * * *";
    @Scheduled(cron = toCron)
    public void ClearCacheOnTime(){
        System.out.println("YAY");
        service.clearCache();
    }
}
