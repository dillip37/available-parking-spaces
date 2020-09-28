package com.example.restservice;

public class ParkingSpaceResponse {

private final int zipcode;
private final String city;
private final String street;
private final String parkingSpace;

public ParkingSpaceResponse(int zipcode, String city, String street, String parkingSpace) {
this.zipcode = zipcode;
this.city = city;
this.street = street;
this.parkingSpace = parkingSpace;
}

public int getZipCode() {
return zipcode;
}

public String getCity() {
return city;
}

public String getStreet() {
return street;
}

public String getParkingSpace() {
return parkingSpace;
}
}
