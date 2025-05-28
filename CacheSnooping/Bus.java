package CacheSnooping;

import java.util.LinkedList;

public class Bus {
    
    private Long trasactionId;
    private byte[] transactionData;
    private Long addr;
    private String opration;
    private LinkedList<CoreCache> coreCaches;
    private Memory memory;


    public Bus(Long trnsactionId , byte[] transactionData, Long addr, String opration) {
        this.trasactionId = trnsactionId;
        this.transactionData = transactionData;
        this.addr = addr;
        this.opration = opration;
        this.memory = new Memory();
    }

    public void addCoreCaches(Long coreId) {
        this.coreCaches.add(new CoreCache(coreId));
    }

    public byte[] checkOperation(){
        switch (this.opration) {
            case "READ":
                byte[] cached = consultCaches(this.addr);
                if (cached == null) {
                   byte[] data = memory.read(this.addr);
                   return data;
                }
                return cached;
                
            case "WRITE":
                writeToMemory(this.addr, this.transactionData);

            default:
            return null;
        }
    }

    private byte[] consultCaches(Long addr){
        for (CoreCache coreCache : coreCaches) {
            byte[] data = coreCache.read(addr);
            if (data != null) {
               return data;
            }
        }
        return null;
    }


    // invoked only for wites, it refresh the mem and all caches  
    public void writeToMemory(Long addr, byte[] data){
         memory.write(addr, data);
        
         for (CoreCache coreCache : coreCaches) {
                coreCache.write(addr, data);
         }
    }

    public Long getTrasactionId() {
        return trasactionId;
    }

    public byte[] getTransactionData() {
        return transactionData;
    }

    public Long getAddr() {
        return addr;
    }

    public String getOpration() {
        return opration;
    }

}
