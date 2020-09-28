package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ParkingServiceImpl {

@Autowired
private ParkingDao dao;

public List<ParkingSpaceResponse> processParking(ParkingSpaceRequest req) {
List<ParkingSpaceResponse> response;
if(req.getZipCode() == 0 && !StringUtils.isEmpty(req.getCity()) && ! StringUtils.isEmpty(req.getStreet())) {
//TODO search on city and street
response = dao.getParking(req.getCity(), req.getStreet());
}else {
response = dao.getParking(req.getZipCode());
}

return response;
}

}
