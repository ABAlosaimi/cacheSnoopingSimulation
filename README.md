# Cache Snooping Simulation

This project simulates a basic cache snooping protocol in a multiprocessor system. It demonstrates how multiple CPU cores with private caches interact with a shared memory through a bus, maintaining cache coherence.

## Overview

- **Memory.java**: Represents the main memory as a map from addresses to data.
- **CoreCache.java**: Simulates a private cache for each core, storing cache lines as address-data pairs.
- **Bus.java**: Acts as the communication medium between caches and memory. It handles read and write transactions, checks caches for data, and updates memory and all caches on writes.

## How It Works

1. **Read Operation**:
   - The bus checks all core caches for the requested address.
   - If found in any cache, it returns the cached data.
   - If not found, it reads from memory.

2. **Write Operation**:
   - The bus writes the data to memory.
   - It then updates all core caches with the new data for the given address, simulating a snooping protocol where all caches observe the write.


## Example Usage

1. Create a `Bus` instance with a transaction ID, data, address, and operation ("READ" or "WRITE").
2. Add core caches to the bus using `addCoreCaches(coreId)`.
3. Use `checkOperation()` to perform the transaction (read or write).

## Notes

- This is a simplified simulation for educational purposes. It does not implement advanced cache coherence protocols (like MESI), but demonstrates the basic idea of snooping and cache updates.
- The simulation uses `Long` for addresses and `byte[]` for data, but can be adapted for other types.

## Requirements

- Java 8 or higher

## Compilation

Compile all Java files:

```sh
javac CacheSnooping/*.java
```
