package com.leyou.item.service;

import com.leyou.item.pojo.Item;
import org.springframework.stereotype.Service;

/**
 * @Author: zwb
 * @Date: 2019-07-01 1:10
 */
@Service
public class ItemService {

    public Item saveItem(Item item){
        int id =(int) Math.random() * 10;
        item.setId(id);
        return item;
    }

}
