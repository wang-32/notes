package com.hspedu.furns.service.impl;

import com.hspedu.furns.dao.FurnDAO;
import com.hspedu.furns.dao.impl.FurnDAOImpl;
import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;

import java.util.List;

public class FurnServiceImpl implements FurnService {

    private FurnDAO furnDAO = new FurnDAOImpl();

    @Override
    public List<Furn> queryFurns() {
        return furnDAO.queryFurns();
    }

    @Override
    public int addFurn(Furn furn) {
        return furnDAO.addFurn(furn);
    }

    @Override
    public int deleteFurnById(int id) {
        return furnDAO.deleteFurnById(id);
    }

    @Override
    public Furn queryFurnById(int id) {
        return furnDAO.queryFurnById(id);
    }

    @Override
    public int updateFurn(Furn furn) {
        return furnDAO.updateFurn(furn);
    }

    @Override
    public Page<Furn> page(int pageNo, int pageSize) {
        Page<Furn> furnPage = new Page<>();
        furnPage.setPageNo(pageNo);
        furnPage.setPageSize(pageSize);
        int pageTotalCount = furnDAO.getTotalRow() / pageSize;
        if (furnDAO.getTotalRow() % pageSize > 0){
            pageTotalCount += 1;
        }
        furnPage.setPageTotalCount(pageTotalCount);
        furnPage.setTotalRow(furnDAO.getTotalRow());
        int begin = (pageNo - 1) * pageSize;
        furnPage.setItems(furnDAO.getPageItems(begin,pageSize));
        return furnPage;
    }
}
