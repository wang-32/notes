package com.hspedu.furns.web;

import com.hspedu.furns.entity.Furn;
import com.hspedu.furns.entity.Page;
import com.hspedu.furns.service.FurnService;
import com.hspedu.furns.service.impl.FurnServiceImpl;

import com.hspedu.furns.utils.DataUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.List;

public class FurnServlet extends BasicServlet {

    private FurnService furnService = new FurnServiceImpl();


    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = DataUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = DataUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        System.out.println(pageNo+pageSize);
        Page<Furn> page = furnService.page(pageNo, pageSize);
        req.setAttribute("page",page);
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req,resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        furnService.updateFurn(furn);
        resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=list");

    }

    protected void showFurn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        Furn furn = furnService.queryFurnById(id);
        req.setAttribute("furn",furn);
        System.out.println(furn);
        req.getRequestDispatcher("/views/manage/furn_update.jsp").forward(req,resp);
    }

    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = DataUtils.parseInt(req.getParameter("id"), 0);
        furnService.deleteFurnById(id);
        resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=list");

    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws Exception{
        List<Furn> furns = furnService.queryFurns();
        req.setAttribute("furns",furns);
        //请求转发
        req.getRequestDispatcher("/views/manage/furn_manage.jsp").forward(req,resp);
    }


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String name = req.getParameter("name");
//        String maker = req.getParameter("maker");
//        String price = req.getParameter("price");
//        String sales = req.getParameter("sales");
//        String stock = req.getParameter("stock");
//        try {
//            int i = Integer.parseInt(sales);
//        } catch (NumberFormatException e) {
//            req.setAttribute("msg","添加格式不正确");
//            req.getRequestDispatcher("/views/manage/furn_add.jsp").forward(req,resp);
//            return;
//        }
//        Furn furn = new Furn(null, name, maker, new BigDecimal(price), new Integer(sales), new Integer(stock), "assets/images/product-image/default.jpg");
//        Furn furn = new Furn();
//        try {
//            BeanUtils.populate(furn,req.getParameterMap());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        Furn furn = DataUtils.copyParamToBean(req.getParameterMap(), new Furn());
        furnService.addFurn(furn);
//        req.getRequestDispatcher("/manage/furnServlet?action=list").forward(req,resp);
        resp.sendRedirect(req.getContextPath() + "/manage/furnServlet?action=list");
    }
}
