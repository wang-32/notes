package com.hspedu.furns.test;

import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.dao.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class FurnDAOTest {


    private FurnDAO furnDAO = new FurnDAOImpl();
    @Test
    public void queryFurns(){

        List<Furn> furns = furnDAO.queryFurns();
        for (Furn furn:furns) {
            System.out.println(furn);
        }
        //测试总行数
        int totalRow = furnDAO.getTotalRow();
        System.out.println(totalRow);
        System.out.println(furnDAO.getPageItems(0,3));
    }

    @Test
    public void add(){
        Furn furn = new Furn(null, "qqqq", "11111", new BigDecimal(9999.99), 100, 999, "assets/images/product-image/default.jpg");
        System.out.println(furnDAO.addFurn(furn));
    }

}
