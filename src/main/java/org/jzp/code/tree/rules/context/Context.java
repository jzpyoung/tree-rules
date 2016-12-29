package org.jzp.code.tree.rules.context;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 上下文
 * <p>强类型
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-11-08
 */
public class Context {

    /**
     * 内部保存K-V的哈希表
     */
    private Map<String, Object> hashMap = Maps.newHashMap();

    /**
     * 通过Name取值
     *
     * @param name 名称
     * @return 上下文中名称对应的值
     */
    @SuppressWarnings("unchecked")
    public <V> V get(Name<V> name) {
        return (V) hashMap.get(name.name());
    }

    /**
     * 通过Name取值
     * <p>如果没有取到值，返回给定的默认值
     *
     * @param name         名称
     * @param defaultValue 默认值
     * @return 上下文中名称对应的值
     */
    @SuppressWarnings("unchecked")
    public <V> V get(Name<V> name, V defaultValue) {
        V value = (V) hashMap.get(name.name());
        return value == null ? defaultValue : value;
    }

    /**
     * 设置名称和对应的值到上下文
     *
     * @param name  键
     * @param value 值
     */
    public <V> void put(Name<V> name, V value) {
        hashMap.put(name.name(), value);
    }

    /**
     * 表示名称的对象，会同时带上对应值的类型
     */
    public static class Name<V> {

        /**
         * 创建一个Name实例
         *
         * @param name Name的字符串名称
         * @return Name实例
         */
        public static <V> Name<V> create(String name) {
            return new Name<V>(name);
        }

        private Name(String name) {
            this.name = name;
        }

        private String name;

        /**
         * 获取Name的字符串名称
         *
         * @return
         */
        public String name() {
            return name;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }

        @SuppressWarnings("rawtypes")
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Name other = (Name) obj;
            if (name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!name.equals(other.name)) {
                return false;
            }
            return true;
        }

    }

    @Override
    public String toString() {
        return "Context [innerMap=" + hashMap + "]";
    }
}
