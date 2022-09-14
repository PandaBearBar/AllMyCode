package bar.task.taskBlingBling.bins;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Cache {
    private Map<String,Map<String,Double>> Cache = new HashMap<>();
}
