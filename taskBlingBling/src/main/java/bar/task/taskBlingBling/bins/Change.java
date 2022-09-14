package bar.task.taskBlingBling.bins;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "provider",
        "WARNING_UPGRADE_TO_V6",
        "terms",
        "base",
        "date",
        "time_last_updated",
        "rates"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Change {

    public String provider;
    @JsonProperty("WARNING_UPGRADE_TO_V6")
    public String warningUpgradeToV6;

    public String terms;

    public String base;

    public String date;
    @JsonProperty("time_last_updated")
    public int timeLastUpdated;

    public Map<String,Double> rates = new HashMap<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}