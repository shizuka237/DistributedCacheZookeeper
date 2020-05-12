package smriti.DistCaching;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import zooKeeper.ZooMap;


@RestController
public class ExpireKey {

    private ZooMap zooMap;

    private ExpireKey(){
        this.zooMap = ZooMap.newMap("127.0.0.1:3000", "/test/map1");
    }

    @DeleteMapping("/DELETE/{id}")
    public String expireKey(@PathVariable String id) {
        String removed = this.zooMap.remove(id);
        System.out.println( "GET " + id + " : " + this.zooMap.get(id));
        return removed;
    }
}