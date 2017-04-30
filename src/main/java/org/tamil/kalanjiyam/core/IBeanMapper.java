/**
 *
 */
package org.tamil.kalanjiyam.core;

import java.util.Collection;
import java.util.List;

/**
 * Adaptor to manage copying values between POJO's
 * 
 */
public interface IBeanMapper
{

    /**
     * Maps one bean into a specified bean object.
     * 
     * @param fromBean
     * @param clazz
     * @return ToBean
     */
    <F, T> T map(F fromBean, Class<T> clazz);

    /**
     * Maps list of beans into a specified beans objects.
     * 
     * @param beans
     * @param clazz
     * @return list
     */
    <F, T> Collection<T> map(Collection<F> beans, Class<T> clazz);

    /**
     * Maps list of beans into a specified beans objects.
     * 
     * @param beans
     * @param clazz
     * @return list
     */
    <F, T> List<T> map(List<F> beans, Class<T> clazz);

    /**
     * Maps one bean into a specified bean object.
     * 
     * @param fromBean
     * @param toBean
     */
    <F, T> void map(F fromBean, T toBean);

    /**
     * Maps list of beans into a specified beans objects.
     * 
     * @param fromBeans
     * @param toBeans
     */
    <F, T> void map(List<F> fromBeans, List<T> toBeans);

    /**
     * @param fromBean
     * @param clazz
     * @param mapId
     * @return
     */
    <F, T> T map(F fromBean, Class<T> clazz, String mapId);

}