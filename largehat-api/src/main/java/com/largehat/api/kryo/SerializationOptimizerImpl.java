package com.largehat.api.kryo;



import com.largehat.common.core.utils.PageUtil;
import org.apache.dubbo.common.serialize.support.SerializationOptimizer;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SerializationOptimizerImpl implements SerializationOptimizer {
    public Collection<Class> getSerializableClasses() {
        List<Class> classes = new LinkedList<Class>();
        classes.add(Page.class);
        classes.add(PageUtil.class);
        return classes;
    }
}