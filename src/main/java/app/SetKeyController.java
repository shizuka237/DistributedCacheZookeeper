package smriti.DistCaching;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import zooKeeper.ZooMap;

import java.util.Map;

@RestController
public class SetKeyController {

    private ZooMap zooMap;

    private SetKeyController(){
        this.zooMap = ZooMap.newMap("127.0.0.1:3000", "/test/map1");
    }

    @PostMapping("/SET")
    public String getKey(@RequestBody Map<String, String> body) {
        String key = body.get("key");
        String value = body.get("value");
        return this.zooMap.put(key, value);
    }
}

