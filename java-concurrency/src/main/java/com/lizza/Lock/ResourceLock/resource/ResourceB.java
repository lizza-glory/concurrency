package com.lizza.Lock.ResourceLock.resource;

import com.google.common.collect.Maps;
import com.lizza.Lock.ResourceLock.service.ServiceA;
import com.lizza.Lock.ResourceLock.service.ServiceB;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-05
 */
public class ResourceB extends AbstractResourceFactory {

    private Map<Object, Object> map = Maps.newConcurrentMap();
    private ServiceB serviceB = new ServiceB();
    private ResourceA resourceA = new ResourceA();

    @Override
    Object fetch(String param) {
        Object resultA = resourceA.fetch(param);
        Object result = serviceB.getResult(param);
        return resultA.toString() + result;
    }
}
