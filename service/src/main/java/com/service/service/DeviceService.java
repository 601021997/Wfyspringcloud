package com.service.service;

import com.service.model.DeviceModel;

import java.util.List;

/**
 * @author wufangyu
 */
public interface DeviceService {
    /**
     * 获取设备列表
     *
     * @return
     */
    List<DeviceModel> getDeviceList();
}
