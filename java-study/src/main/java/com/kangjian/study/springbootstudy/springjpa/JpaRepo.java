/*
 * Copyright (c) 2019. website www.ziyuele.com
 */

package com.kangjian.study.springbootstudy.springjpa;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

@Component
public interface JpaRepo extends JpaRepository<TableBean, Long> {

    // add update(need id to keep only one)
    @Override
    <S extends TableBean> S save(S s);

    // delete
    @Override
    void deleteById(Long aLong);

    void deleteByName(String name);

    // get
    List<TableBean> findAllByAge(String age);

    TableBean findByAge(String age);

    @Query("SELECT c.id, c.name, c.age FROM TableBean c")
    List<TableBean> get();
}
