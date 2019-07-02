package com.leyou.item.web;

import com.leyou.common.vo.PageResult;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: zwb
 * @Date: 2019-07-01 23:26
 */
@RequestMapping("brand")
@RestController
public class BrandController {

    @Autowired
    private BrandService brandService;

    /**
     * 分页查询品牌
     * @param page
     * @param rows
     * @param desc
     * @param sortBy
     * @param key
     * @return
     */
    @GetMapping("page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value = "page" ,defaultValue = "1")Integer page,
            @RequestParam(value = "rows" ,defaultValue = "5")Integer rows,
            @RequestParam(value = "desc" ,defaultValue = "false")Boolean desc,
            @RequestParam(value = "sortBy" ,required = false)String sortBy,
            @RequestParam(value = "key" ,required = false)String key
    ){
        return ResponseEntity.ok(brandService.queryBrandByPage(page,rows,desc,sortBy,key));
    }

    /**
     * 新增品牌
     * @param brand
     * @param cids
     * @return
     */
    @PostMapping()
    public ResponseEntity<Void> saveBrand(Brand brand,@RequestParam("cids") List<Long> cids){
        brandService.saveBrand(brand , cids);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
