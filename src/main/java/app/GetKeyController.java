package smriti.DistCaching;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import zooKeeper.ZooMap;


@RestController
public class GetKeyController {

    private ZooMap zooMap;

    private GetKeyController(){
        this.zooMap = ZooMap.newMap("127.0.0.1:3000", "/test/map1");
    }

    @GetMapping("/GET/{id}")
    public String getKey(@PathVariable String id) {
        System.out.println( "GET " + id + " : " + this.zooMap.get(id));
        return this.zooMap.get(id);
    }
}
