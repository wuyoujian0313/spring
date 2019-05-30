package com.wuyj.learning.dao;


import com.wuyj.learning.entity.TSkillLevelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillLevelRepository extends JpaRepository<TSkillLevelEntity,Integer> {

    @Override
    @Query(value="select * from t_skill_level order by level asc", nativeQuery = true)
    List<TSkillLevelEntity> findAll();
}
