package smriti.DistCaching;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CacheController {

    @RequestMapping("/")
    public String index() {
        return "Congratulations from BlogController.java";
    }

}
