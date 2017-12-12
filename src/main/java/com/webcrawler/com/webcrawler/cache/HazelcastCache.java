package com.webcrawler.com.webcrawler.cache;

import com.hazelcast.cache.ICache;
import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by sjanga on 12/11/2017.
 */
@Configuration
@Component
public class HazelcastCache {

  HazelcastInstance hazelcastInstance;

  public HazelcastCache(){
    this.hazelcastInstance = Hazelcast.newHazelcastInstance(hazelCastConfig());
  }

  public Config hazelCastConfig(){
    return new Config()
        .setInstanceName("hazelcast-instance")
        .addMapConfig(
            new MapConfig()
                .setName("instruments")
                .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
                .setEvictionPolicy(EvictionPolicy.LRU)
                .setTimeToLiveSeconds(20));
  }

  public HazelcastInstance getHazelcastInstance() {
    return hazelcastInstance;
  }

}
