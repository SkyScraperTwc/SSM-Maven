package com.scut.mybatis.mapper;

public interface IBaseMapper<T> {

    T getById(Integer id);

    T getByStep(Integer id);

    boolean insert(T t);

    boolean update(T t);

    boolean delete(Integer id);
}
