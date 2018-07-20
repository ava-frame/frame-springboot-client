package com.ava.frame.springboot.client.controller;

import com.ava.frame.es.EsDomain;
import com.ava.frame.es.EsQuery;
import com.ava.frame.mongo.Mongo;
import com.ava.frame.springboot.client.domain.SemanticSmartHome;
import com.ava.frame.springboot.client.redis.RedisClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.export.MetricExportProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
//post:/refresh can refresh configs in git
//@RefreshScope
public class SearchController {
    @Autowired
    private RedisClient redisClient;
    private static final Logger log = LoggerFactory.getLogger(SearchController.class);
    @RequestMapping(value = "/mongo", method = RequestMethod.GET)
    public Object mongo(String userid) {
        SemanticSmartHome home=Mongo.build().findOne(SemanticSmartHome.class);
        return home.getWords();
    }
    @RequestMapping(value = "/es", method = RequestMethod.GET)
    public Object es(String userid) {
        EsDomain esDomain=EsQuery.build().query("words","打开冰箱", EsQuery.Link.MUST).one();
        return esDomain.getSource().get("words");
    }
    @RequestMapping(value = "/redis", method = RequestMethod.GET)
    public Object redis(String userid) {
        redisClient.set("redis:test","redistest");
        return redisClient.get("redis:test");
    }

}
