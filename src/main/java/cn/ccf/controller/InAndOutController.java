package cn.ccf.controller;

import cn.ccf.pojo.CurrentInAndOut;
import cn.ccf.pojo.InAndOutHistory;
import cn.ccf.service.InAndOutService;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Request;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author charles
 * @date 2019/5/9 16:24
 */
@Controller
@RequestMapping("inAndOut")
public class InAndOutController {

    @Resource
    private InAndOutService inAndOutService;

    private String path = "system/inAndOut/";


    @RequestMapping("realtime/list")
    public String listCurrent(HttpServletRequest request) {
        List<CurrentInAndOut> list = inAndOutService.selectAllCurrentInAndOut();
        request.setAttribute("list", list);
        return path + "realtime/list";
    }

    @RequestMapping("history/list")
    public String listHistory(HttpServletRequest request) {
        List<InAndOutHistory> list = inAndOutService.selectAllInAndOutHistory();
        request.setAttribute("list", list);
        return path + "history/list";
    }
}
