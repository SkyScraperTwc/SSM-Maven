package com.scut.mybatis.service;

import com.scut.mybatis.entity.ConcurrentBean;
import com.scut.mybatis.mapper.impl.ConcurrentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConcurrentService {

	@Autowired
	private ConcurrentMapper concurrentMapper;

	public ConcurrentBean getById(Integer id) {

		return concurrentMapper.getById(id);
	}
	public boolean add(ConcurrentBean concurrentBean) {
		return concurrentMapper.insert(concurrentBean);
	}

	public boolean updatePositive(ConcurrentBean concurrentBean) {
		return concurrentMapper.updatePositive(concurrentBean);
	}

	public boolean updatePessimistic(ConcurrentBean concurrentBean) {
		return concurrentMapper.updatePessimistic(concurrentBean);
	}

    public boolean updatePositive2(ConcurrentBean concurrentBean) {
		return concurrentMapper.updatePositive2(concurrentBean);
    }
}
