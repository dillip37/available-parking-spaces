package com.example.restservice;

public class ParkingSpaceRequest {

private final int zipcode;
private final String city;
private final String street;

public ParkingSpaceRequest(int zipcode, String city, String street) {
this.zipcode = zipcode;
this.city = city;
this.street = street;
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
}
