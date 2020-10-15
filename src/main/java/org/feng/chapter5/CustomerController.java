package org.feng.chapter5;

import org.feng.framework.annotation.Action;
import org.feng.framework.annotation.Controller;
import org.feng.framework.bean.Param;
import org.feng.framework.bean.View;

import java.util.List;

@Controller
public class CustomerController {
    /*
    * 进入客服列表界面
    * */
    @Action("get:/customer")
    public View index(){
        List<Customer> customerList= customerService.getCustomerList();
        return new View("customer.jsp").addModel("customerList",customerList);
    }
}
