package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restservice.ParkingSpaceRequest;
import com.example.restservice.ParkingSpaceResponse;

@RestController
public class ParkingSpaceController {

@Autowired
private ParkingServiceImpl impl;

@GetMapping("/retreive/parking")
public List<ParkingSpaceResponse> parking(@RequestParam(value = "zip", defaultValue = "0") int zip,
@RequestParam(value = "city", defaultValue = "") String city,
@RequestParam(value = "street", defaultValue = "") String street) {
ParkingSpaceRequest request = new ParkingSpaceRequest(zip, city, street);

return impl.processParking(request);
}
}
