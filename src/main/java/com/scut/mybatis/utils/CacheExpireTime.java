package com.scut.mybatis.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;

/**
 * @author twc
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheExpireTime {

    /**
     * 缓存超时时间
     */
    private Integer timeOut;

    /**
     * 缓存时间种类(分钟)
     */
    private TimeUnit timeUnit;

}
