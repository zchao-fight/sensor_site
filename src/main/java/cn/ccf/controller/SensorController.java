package cn.ccf.controller;

import cn.ccf.common.ResponseCodeConst;
import cn.ccf.common.ResponseDTO;
import cn.ccf.pojo.Sensor;
import cn.ccf.service.SensorService;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class SensorController {

    @Resource
    private SensorService sensorService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/sensor/index")
    public String listSensor(HttpServletRequest request, String type) {
        List<Sensor> sensors = sensorService.queryByType(type);
        request.setAttribute("sensors", sensors);
        request.setAttribute("type", type);
        return "sensor/list";
    }

    @RequestMapping("/sensor/addSensorUI")
    public String addSensorUI(HttpServletRequest request, String type) {
        List<Sensor> sensors = sensorService.queryByType(type);
        request.setAttribute("sensors", sensors);
        request.setAttribute("type", type);
        return "sensor/add";
    }

    @RequestMapping("/sensor/addSensor")
    @ResponseBody
    public ResponseDTO<Sensor> addSensor(@Valid @RequestBody Sensor sensor) {

        Sensor temp = sensorService.queryBySensorNumber(sensor.getSensorNumber());

        if (temp == null) {
            sensorService.insert(sensor);
            return ResponseDTO.succ(sensor);
        }
        return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
    }

    @RequestMapping("/sensor/deleteSensor")
    @ResponseBody
    public ResponseEntity<Void> deleteSensor(String id) {

        try {
            sensorService.deleteSensor(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping("/sensor/editSensorUI")
    public String editSensorUI(HttpServletRequest request, String id) {
        request.setAttribute("sensor", sensorService.queryById(id));
        return "/sensor/edit";
    }

    @RequestMapping("/sensor/editSensor")
    @ResponseBody
    public ResponseDTO<Sensor> editSensor(@RequestBody @Valid Sensor sensor) {

        Sensor temp = sensorService.queryBySensorNumber(sensor.getSensorNumber());

        if (temp == null) {
            sensorService.updateSelective(sensor);
            return ResponseDTO.succ(sensor);
        } else {
            if (StringUtils.equals(temp.getId(), sensor.getId())) {
                sensorService.updateSelective(sensor);
                return ResponseDTO.succ(sensor);
            }
            return ResponseDTO.wrap(ResponseCodeConst.ERROR_PARAM);
        }
    }
}
