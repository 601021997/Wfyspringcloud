package com.service.controller;

import com.service.model.DeviceModel;
import com.service.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wufangyu
 */
@RestController
@RequestMapping("/taolinDevice")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping("/getDeviceList")
    public List<DeviceModel> getDeviceList() {
        return deviceService.getDeviceList();
    }

}
