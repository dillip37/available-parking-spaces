package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class ParkingDao {

@Autowired
@Qualifier(value = "jdbcTemplate")
private JdbcTemplate jdbcTemplate;

public List<ParkingSpaceResponse> getParking(int zip) {
List<ParkingSpaceResponse> responseList= new ArrayList<ParkingSpaceResponse>();
try {
System.out.println(zip);
System.out.println(jdbcTemplate);
responseList = jdbcTemplate.query("SELECT zip_code, city, street, parking_space FROM parking_spaces WHERE zip_code=?;", preparedStatement -> {
preparedStatement.setInt(1, zip);
}, result -> {
List<ParkingSpaceResponse> list = new ArrayList<>();
while (result.next()) {
ParkingSpaceResponse parking = new ParkingSpaceResponse(result.getInt(1),
result.getString(2),
result.getString(3),
result.getString(4));
list.add(parking);
}
return list;
});
return responseList;
}catch (Exception e) {
e.printStackTrace();
return null;
}
}

public List<ParkingSpaceResponse> getParking(String city, String street) {
List<ParkingSpaceResponse> responseList= new ArrayList<ParkingSpaceResponse>();
try {
System.out.println(city + ", " + street);
System.out.println(jdbcTemplate);
responseList = jdbcTemplate.query("SELECT zip_code, city, street, parking_space FROM parking_spaces WHERE city=? AND street=?;", preparedStatement -> {
preparedStatement.setString(1, city);
preparedStatement.setString(2, street);

}, result -> {
List<ParkingSpaceResponse> list = new ArrayList<>();
while (result.next()) {
ParkingSpaceResponse parking = new ParkingSpaceResponse(result.getInt(1),
result.getString(2),
result.getString(3),
result.getString(4));
list.add(parking);
}
return list;
});
return responseList;
}catch (Exception e) {
e.printStackTrace();
return null;
}
}
}
