package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "tb_spec_group")
public class SpecGroup {

    @KeySql(useGeneratedKeys = true)
    @Id
    private Long id;

    private Long cid;

    private String name;
}