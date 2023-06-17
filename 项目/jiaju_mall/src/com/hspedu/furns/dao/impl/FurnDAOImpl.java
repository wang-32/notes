package com.hspedu.furns.dao.impl;

import com.hspedu.furns.dao.BasicDAO;
import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;

import java.util.List;

public class FurnDAOImpl extends BasicDAO<Furn> implements FurnDAO {

    @Override
    public List<Furn> queryFurns() {
        String sql = "SELECT id,name,maker,price,sales,stock,img_path imgPath from furn";
        return queryMulti(sql,Furn.class);
    }

    @Override
    public int addFurn(Furn furn) {
        String sql = "INSERT INTO furn(`id` , `name` , `maker` , `price` , `sales` , `stock` , `img_path`) VALUES(NULL ,? , ? , ? ,? , ? ,?)";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath());
    }

    @Override
    public int deleteFurnById(int id) {
        String sql = "delete from furn where id = ?";
        return update(sql,id);
    }

    @Override
    public Furn queryFurnById(int id) {
        String sql = "SELECT id,name,maker,price,sales,stock,img_path imgPath from furn where id = ?";
        return querySingle(sql,Furn.class,id);
    }

    @Override
    public int updateFurn(Furn furn) {
        String sql = "update furn set name= ?,maker = ?,price = ?,sales = ?,stock = ?,img_path = ? where id = ?";
        return update(sql,furn.getName(),furn.getMaker(),furn.getPrice(),furn.getSales(),furn.getStock(),furn.getImgPath(),furn.getId());
    }

    @Override
    public int getTotalRow() {
        String sql = "select count(*) from furn";
        return ((Number)queryScalar(sql)).intValue();
    }

    @Override
    public List<Furn> getPageItems(int begin, int pageSize) {
        String sql = "SELECT id,name,maker,price,sales,stock,img_path imgPath from furn limit ?,?";
        return queryMulti(sql,Furn.class,begin,pageSize);
    }


}
