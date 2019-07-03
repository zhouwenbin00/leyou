package com.leyou.item.service;

import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.mapper.SpecParamMapper;
import com.leyou.item.mapper.SpecificationMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.pojo.SpecParam;
import com.leyou.item.pojo.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Author: zwb
 * @Date: 2019-07-02 23:40
 */

@Service
public class SpecificationService {

    @Autowired
    private SpecGroupMapper specGroupMapper;

    @Autowired
    private SpecParamMapper specParamMapper;

    public List<SpecGroup> queryGroupByCid(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> list = specGroupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnums.SPEC_GROUP_NOT_FOUND);
        }
        return list;
    }

    public void saveGroup(Long cid, String name) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        specGroup.setName(name);
        specGroup.setId(null);
        int count = specGroupMapper.insert(specGroup);
        if (count != 1){
            throw new LyException(ExceptionEnums.SPEC_GROUP_SAVE_ERROR);
        }
    }

    public List<SpecParam> queryParamByGid(Long gid) {
        SpecParam specParam = new SpecParam();
        specParam.setGroupId(gid);
        List<SpecParam> list = specParamMapper.select(specParam);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnums.SPEC_PARAM_NOT_FOUND);
        }
        return list;
    }

    public void saveParam(SpecParam specParam) {
        specParam.setId(null);
        int count = specParamMapper.insert(specParam);
        if (count != 1){
            throw new LyException(ExceptionEnums.SPEC_GROUP_SAVE_ERROR);
        }
    }
}
