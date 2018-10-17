package com.service.service.serviceImpl;

import com.service.dao.DeviceModelMapper;
import com.service.model.DeviceModel;
import com.service.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wufangyu
 */
@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceModelMapper deviceModelMapper;

    @Override
    public List<DeviceModel> getDeviceList() {
        DeviceModel deviceModel = deviceModelMapper.selectByPrimaryKey(1);
        List<DeviceModel> list = new ArrayList<>();
        list.add(deviceModel);
        return list;
    }
}
