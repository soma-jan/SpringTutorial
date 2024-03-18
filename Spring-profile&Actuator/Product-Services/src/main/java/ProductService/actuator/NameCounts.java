package ProductService.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.web.annotation.RestControllerEndpoint;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@RestControllerEndpoint(id="namecounts")
public class NameCounts {
    Map<String,Integer> hashmap =new ConcurrentHashMap<>() ;

    @GetMapping
    public Map<String,Integer> getHashmap()
    {
        return hashmap;
    }
    @PostMapping
    public void addtoHashmap(@Selector String name)
    {
         hashmap.put(name,hashmap.computeIfAbsent(name,s->0)+1);
    }

}
