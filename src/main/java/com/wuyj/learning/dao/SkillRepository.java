package com.wuyj.learning.dao;

import com.wuyj.learning.entity.TSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface SkillRepository extends JpaRepository<TSkillEntity,Integer> {
    @Override
    @Query(value="select * from t_skill order by id asc", nativeQuery = true)
    List<TSkillEntity> findAll();
}
