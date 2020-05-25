package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaDataImporter {

    @RequestMapping("/kafkadata")
    public String demo(
            @RequestParam(value="database") String database
    ){
        database = database.replace("\"", "");
        KafkaDataThread demoDataThread = new KafkaDataThread(database);
        demoDataThread.start();

        return "kafka data started";
    }
}
