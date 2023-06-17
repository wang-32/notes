package com.hspedu.furns.test;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FurnServiceTest {

    private FurnService furnService = new FurnServiceImpl();

    @Test
    public void queryFurns(){
//        List<Furn> furns = furnService.queryFurns();
//        for(Furn furn:furns){
//            System.out.println(furn);
//        }
        Page<Furn> page = furnService.page(2, 2);
        System.out.println(page);
    }
}
