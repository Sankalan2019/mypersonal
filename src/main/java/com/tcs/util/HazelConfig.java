package com.tcs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@Component
public class HazelConfig {

	
	
	public IMap<Object, Object> getMapConfig(String configName) {
		
		HazelcastInstance hazelcastInstanceByName = Hazelcast.getHazelcastInstanceByName("hazelcast-instance");
		hazelcastInstanceByName.getConfig().addMapConfig(new MapConfig().setName(configName)
				.setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
				.setEvictionPolicy(EvictionPolicy.LRU).setTimeToLiveSeconds(3000));
		 return hazelcastInstanceByName.getMap(configName);
	}
	
	
	public IMap<Object, Object> getCacheDetails(String cacheName) {
		HazelcastInstance hazelcastInstanceByName = Hazelcast.getHazelcastInstanceByName("hazelcast-instance");
		return hazelcastInstanceByName.getMap(cacheName);
	}
}
