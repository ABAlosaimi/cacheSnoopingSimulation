package CacheSnooping;

import java.util.HashMap;
import java.util.Map;

public class Memory {

    private Map<Long, byte[]> data;

    public Memory() {
        this.data = new HashMap<>();
    }

    public void write(Long addr, byte[] data){
        this.data.put(addr, data);
    }

    public byte[] read(Long addr) {
        return this.data.get(addr);
    }

}