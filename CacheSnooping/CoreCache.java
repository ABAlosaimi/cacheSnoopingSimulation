package CacheSnooping;

import java.util.HashMap;
import java.util.Map;

public class CoreCache {

    private Map<Long, byte[]> cacheLine;
    private Long cacheId;

    public CoreCache(Long cacheId) {
        this.cacheLine = new HashMap<>();
        this.cacheId = cacheId;
    }

    public byte[] read(Long addr){
        return cacheLine.get(addr);
    }

    public void write(Long addr, byte[] data){
        cacheLine.put(addr, data);
    }

    public Long getCacheId() {
        return cacheId;
    }

}
