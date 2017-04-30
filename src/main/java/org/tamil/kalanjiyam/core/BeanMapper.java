package org.tamil.kalanjiyam.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Manages copying values between POJO's
 */
@Component
public final class BeanMapper implements IBeanMapper
{
    @Autowired
    private DozerBeanMapper mapper;

    @Override
    public <F, T> T map(F fromBean, Class<T> clazz)
    {
        return fromBean != null ? mapper.map(fromBean, clazz) : null;

    }

    @Override
    public <F, T> Collection<T> map(Collection<F> fromBeans, Class<T> clazz)
    {
        List<T> list = new ArrayList<T>();
        for (F fromBean : fromBeans)
        {
            if (fromBean != null)
            {
                list.add(mapper.map(fromBean, clazz));
            }
        }
        return list;
    }

    @Override
    public <F, T> List<T> map(List<F> fromBeans, Class<T> clazz)
    {
        List<T> list = new ArrayList<T>();
        for (F fromBean : fromBeans)
        {
            if (fromBean != null)
            {
                list.add(mapper.map(fromBean, clazz));
            }
        }
        return list;
    }

    @Override
    public <F, T> void map(F fromBean, T toBean)
    {
        if ((fromBean != null) && (toBean != null))
        {
            mapper.map(fromBean, toBean);
        }
    }

    @Override
    public <F, T> void map(List<F> fromBeans, List<T> toBeans)
    {
        for (int index = 0; index < fromBeans.size(); index++)
        {
            if (fromBeans.get(index) != null)
            {
                mapper.map(fromBeans.get(index), toBeans.get(index));
            }
        }
    }

    @Override
    public <F, T> T map(F fromBean, Class<T> clazz, String mapId)
    {
        return fromBean != null ? mapper.map(fromBean, clazz, mapId) : null;
    }
}
