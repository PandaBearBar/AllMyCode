package bar.task.taskBlingBling.service;

import bar.task.taskBlingBling.bins.Cache;
import bar.task.taskBlingBling.bins.Change;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements SystemService {
    private final Cache cache;
    @Value("${web.api}")
    private String webApi;
    private final RestTemplate restTemplate;
    @Override
    public void clearCache() {
        cache.setCache(new HashMap<>());
    }
    @Override
    public double initCache(String from, String to, Double amount){
        if (!cache.getCache().containsKey(from)){
            try {
                Change change =
                        restTemplate.getForObject(webApi + from, Change.class);
                cache.getCache().put(from, change.getRates());
            }catch (Exception exception){
                System.out.println(exception.getMessage());
            }
        }
        double results = cache.getCache().get(from).get(to);
        return (results * amount);
    }
}
