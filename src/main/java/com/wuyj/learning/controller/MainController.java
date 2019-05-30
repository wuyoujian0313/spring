package com.wuyj.learning.controller;

import com.wuyj.learning.dao.SkillLevelRepository;
import com.wuyj.learning.dao.SkillRepository;
import com.wuyj.learning.dao.SkillTypeRepository;
import com.wuyj.learning.entity.TSkillEntity;
import com.wuyj.learning.entity.TSkillLevelEntity;
import com.wuyj.learning.entity.TSkillTypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    protected SkillLevelRepository skillLevelRepository;

    @Autowired
    protected SkillRepository skillRepository;

    @Autowired
    protected SkillTypeRepository skillTypeRepository;

    @GetMapping(value = "/skill/{userId}")
    public ResponseEntity<Object> getSkill(@RequestParam String condition, @PathVariable int userId,HttpServletRequest request) {
        List<TSkillEntity> skillList = skillRepository.findAll();
        List<TSkillTypeEntity> skillTypeList = skillTypeRepository.findAll();

        List<Map> resultList = new ArrayList<>();
        for (TSkillTypeEntity type : skillTypeList) {
            Map<String, Object> itemMap = new HashMap<>();
            List<Map> skills = new ArrayList<>();
            for (TSkillEntity skill : skillList) {
                Map<String, Object> tempMap = new HashMap<>();
                if (skill.getSkillType().equals(type.getId())) {
                    tempMap.put("value", skill.getId());
                    tempMap.put("label", skill.getSkillName());
                    skills.add(tempMap);
                }
            }

            itemMap.put("skillType",type.getTypeName());
            itemMap.put("skillList",skills);

            resultList.add(itemMap);
        }
        return new ResponseEntity<>(resultList, HttpStatus.OK);
    }

    @PostMapping(value = "/level")
    public ResponseEntity<Object> getSkillLevel(@RequestBody TSkillLevelEntity levelEntity,HttpServletRequest request) {
        List<TSkillLevelEntity> skillList = skillLevelRepository.findAll();
        return new ResponseEntity<>(skillList, HttpStatus.OK);
    }
}
