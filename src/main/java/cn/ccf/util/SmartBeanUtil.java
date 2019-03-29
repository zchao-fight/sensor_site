package cn.ccf.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class SmartBeanUtil extends BeanUtils {

    public final static <T> T copy(Object source, Class<T> cls) {
        if (source == null) {
            return null;
        }

        T t = null;
        try {
            t = cls.newInstance();
            copyProperties(source, t);
            return t;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public final static <T> List<T> copyList(List<?> list, Class<T> cls) {
        if (list == null || list.isEmpty()) {
            return new ArrayList<>(0);
        }

        List<T> resultList = Lists.newArrayListWithCapacity(list.size());
        for (Object t : list) {
            resultList.add(copy(t, cls));
        }
        return resultList;
    }


}
