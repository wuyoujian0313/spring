package com.wuyj.learning.dao;

import com.wuyj.learning.entity.TSkillTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkillTypeRepository extends JpaRepository<TSkillTypeEntity,Integer> {
    @Override
    @Query(value="select * from t_skill_type order by id asc", nativeQuery = true)
    List<TSkillTypeEntity> findAll();
}
