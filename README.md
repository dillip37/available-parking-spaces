# available-parking-spaces
Simple spring boot REST Api to fetch the available parking spaces as per zip or city and street as input request


Create Postgres DB, then create parking_spaces table.

-- Table: devdb.parking_spaces

-- DROP TABLE devdb.parking_spaces;

CREATE TABLE devdb.parking_spaces
(
    parking_space character varying(256) COLLATE pg_catalog."default" NOT NULL,
    city character varying(256) COLLATE pg_catalog."default" NOT NULL,
    street character varying(256) COLLATE pg_catalog."default" NOT NULL,
    zip_code integer
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE devdb.parking_spaces
    OWNER to dbuser;

GRANT ALL ON TABLE devdb.parking_spaces TO dbadmin;

GRANT ALL ON TABLE devdb.parking_spaces TO dbuser;

GRANT ALL ON TABLE devdb.parking_spaces TO dbuser_admin_role;

GRANT SELECT ON TABLE devdb.parking_spaces TO dbuser_read_role;


Insert Test Data:

INSERT INTO parking_spaces (zip_code, city, street, parking_space) VALUES (63368, ‘OFallon’, ‘Grenache Ct’, ‘1234 A’);

INSERT INTO parking_spaces (zip_code, city, street, parking_space) VALUES (63368, ‘OFallon’, ‘Grenache Ct’, ‘1277 C’);

INSERT INTO parking_spaces (zip_code, city, street, parking_space) VALUES (63370, ‘OFallon’, ‘Luis Rd’, ‘111 A’);

INSERT INTO parking_spaces (zip_code, city, street, parking_space) VALUES (63372, ‘OFallon’, ‘West Creek’, ‘77 A’);

INSERT INTO parking_spaces (zip_code, city, street, parking_space) VALUES (23294, ‘Henrico’, ‘Cross Country Ct’, ‘3208 C’);

Compile available-parking-spaces api:

mvn clean install

Run :

mvn spring-boot:run


Once service starts successfully on 8080, then open in browser:

localhost:8080/retreive/parking?zip=63368


Response:

[

{

	‘zipcode’: 63368,

	‘city’: ‘OFallon’,

	‘street’: ‘Grenache Ct’,

	‘parkingSpace’: ‘1234 A’

},

{

	‘zipcode’: 63368,

	‘city’: ‘OFallon’,

	‘street’: ‘Grenache Ct’,

	‘parkingSpace’: ‘1277 C’

}

]


localhost:8080/retreive/parking?city=OFallon&street= Grenache Ct

Response:

[

{

	‘zipcode’: 63368,

	‘city’: ‘OFallon’,

	‘street’: ‘Grenache Ct’,

	‘parkingSpace’: ‘1234 A’
  },

{

	‘zipcode’: 63368,

	‘city’: ‘OFallon’,

	‘street’: ‘Grenache Ct’,

	‘parkingSpace’: ‘1277 C’

}

]

localhost:8080/retreive/parking?zip=23294

Response:

[

{

	‘zipcode’: 23294,

	‘city’: ‘Henrico’,

	‘street’: ‘Cross Country Ct’,

	‘parkingSpace’: ‘3208 C’

}

]


