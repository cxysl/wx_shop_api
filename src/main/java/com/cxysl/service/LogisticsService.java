package com.cxysl.service;

import com.cxysl.dao.LogisticsDAOImpl;
import com.cxysl.entity.Logistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogisticsService {
    @Autowired
    private LogisticsDAOImpl dao;

    /**
     * 查
     * 根据订单ID查找对应的物流
     * @param orderId
     * @return
     */
    public Logistics getLogisticsOneByOrderId(Integer orderId)
    {
        return dao.getLogisticsOneByOrderId(orderId);
    }

    /**
     * 查
     * 查找单个物流信息（根据物流单号找）
     * @param expressId
     * @return
     */
    public Logistics getLogisticsOne(String expressId)
    {
        return dao.getLogisticsOne(expressId);
    }

    /**
     * 添加新物流信息
     * @param p
     * @return
     */
    public int add_Logistics(Logistics p)
    {
        return dao.add_Logistics(p);
    }

    /**
     * 修改物流状态信息
     * @param state
     * @param id
     * @return
     */
    public int Update_LogisticsState(String state, String id)
    {
        return dao.Update_LogisticsState(state,id);
    }
}
