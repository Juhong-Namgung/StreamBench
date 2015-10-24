package fi.aalto.dmg.workloads;

import fi.aalto.dmg.Workload;
import fi.aalto.dmg.datasource.KafkaSource;
import fi.aalto.dmg.exceptions.WorkloadException;

/**
 * Created by yangjun.wang on 14/10/15.
 * The workload would have different implementations
 */
abstract public class WordCountWorkload extends Workload{
    // Word count workload has one stream source
    protected KafkaSource kafkaSource;

    public WordCountWorkload() throws WorkloadException {
        super();
        Init();
    }

    public WordCountWorkload(String configure) throws WorkloadException {
        super();
        this.setConfigFile(configure);
        Init();
    }

    public void Init() throws WorkloadException {
        kafkaSource = new KafkaSource();
        // Default configure file
        this.setConfigFile("WordCountWorkload.properties");
        // read data source configure
        // topic, partations, nodes
    }

    public String getTopic() throws WorkloadException {
        return this.getProperties().getProperty("systems.kafka.topic");
    }

    public int getSourceNum() throws WorkloadException {
        String sourceNumStr = this.getProperties().getProperty("systems.workload.sources");
        return Integer.parseInt(sourceNumStr);
    }

    public int getSpliterNum() throws WorkloadException {
        String spliterNumStr = this.getProperties().getProperty("systems.workload.spliter");
        return Integer.parseInt(spliterNumStr);
    }

    public int getCounterNum() throws WorkloadException {
        return Integer.parseInt(this.getProperties().getProperty("systems.workload.counters"));
    }
}
