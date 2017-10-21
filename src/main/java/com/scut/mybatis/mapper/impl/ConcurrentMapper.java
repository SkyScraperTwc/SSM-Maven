package com.scut.mybatis.mapper.impl;

import com.scut.mybatis.entity.ConcurrentBean;
import com.scut.mybatis.mapper.IBaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ConcurrentMapper extends IBaseMapper<ConcurrentBean> {

    boolean updatePositive(ConcurrentBean concurrentBean);

    boolean updatePessimistic(ConcurrentBean concurrentBean);

    boolean updatePositive2(ConcurrentBean concurrentBean);
}
