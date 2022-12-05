DROP DATABASE IF EXISTS MovieTheater;
CREATE DATABASE MovieTheater;
Use MovieTheater;
DROP table IF EXISTS THEATER;
DROP table IF EXISTS SHOWTIMES1;
DROP table IF EXISTS SHOWTIMES2;
DROP table IF EXISTS SEATMAP1_1;
DROP table IF EXISTS SEATMAP1_2;
DROP table IF EXISTS SEATMAP2_1;
DROP table IF EXISTS SEATMAP2_2;

CREATE TABLE Theater(
	Movies			VARCHAR(150) NOT NULL,
	showtimeLocation	int unsigned NOT NULL
);
INSERT INTO THEATER(Movies, showtimeLocation) VALUES
    ('Movie1',1),
    ('Movie2',2);
SELECT * from THEATER;
CREATE TABLE SHOWTIMES1(
	date				VARCHAR(150) NOT NULL,
	time				VARCHAR(150) NOT NULL,
        showRoom			VARCHAR(150) NOT NULL,
        showtimesIdentifier	int unsigned NOT NULL,
        seatLocation		int unsigned NOT NULL
);

CREATE TABLE SHOWTIMES2(
    date    			VARCHAR(150) NOT NULL,
    time                        VARCHAR(150) NOT NULL,
    showRoom			VARCHAR(150) NOT NULL,
    showtimesIdentifier	int unsigned NOT NULL,
    seatLocation		int unsigned NOT NULL
);
INSERT INTO SHOWTIMES1 (date,time,showRoom, showtimesIdentifier,seatLocation) VALUES
    ('2023-01-01','18:00','room1',1,1),
    ('2023-02-10','11:20','room2',1,2);
INSERT INTO SHOWTIMES2 (date,time, showRoom, showtimesIdentifier,seatLocation) VALUES
    ('2023-12-25','23:59','room1',2,1),
    ('2022-12-31','00:01','room2',2,2);
CREATE TABLE SEATMAP1_1(
    seatNumber                          int unsigned NOT NULL,
    vacant				int unsigned NOT NULL
);
CREATE TABLE SEATMAP1_2(
    seatNumber                          int unsigned NOT NULL,
    vacant				int unsigned NOT NULL
);
CREATE TABLE SEATMAP2_1(
    seatNumber                          int unsigned NOT NULL,
    vacant				int unsigned NOT NULL
);
CREATE TABLE SEATMAP2_2(
    seatNumber                          int unsigned NOT NULL,
    vacant				int unsigned NOT NULL
);


INSERT INTO SEATMAP1_1 (seatNumber,vacant) VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,1),
    (6,1),
    (7,1),
    (8,1),
    (9,1),
    (10,1),
    (11,1),
    (12,1),
    (13,1),
    (14,1),
    (15,1),
    (16,1),
    (17,1),
    (18,1),
    (19,1),
    (20,1);

INSERT INTO SEATMAP1_2 (seatNumber,vacant) VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,1),
    (6,1),
    (7,1),
    (8,1),
    (9,1),
    (10,1),
    (11,1),
    (12,1),
    (13,1),
    (14,1),
    (15,1),
    (16,1),
    (17,1),
    (18,1),
    (19,1),
    (20,1);
INSERT INTO SEATMAP2_1 (seatNumber,vacant) VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,1),
    (6,1),
    (7,1),
    (8,1),
    (9,1),
    (10,1),
    (11,1),
    (12,1),
    (13,1),
    (14,1),
    (15,1),
    (16,1),
    (17,1),
    (18,1);
INSERT INTO SEATMAP2_2 (seatNumber,vacant) VALUES
    (1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,1),
    (6,1),
    (7,1),
    (8,1),
    (9,1),
    (10,1),
    (11,1),
    (12,1),
    (13,1),
    (14,1),
    (15,1),
    (16,1),
    (17,1),
    (18,1);
SELECT * from THEATER;
SELECT * from SHOWTIMES1;
#SELECT * from SHOWTIMES2;
#SELECT * from SEATMAP1_1;
#SELECT * from SEATMAP1_2;
#SELECT * from SEATMAP2_1;
#SELECT * from SEATMAP2_2;

CREATE TABLE RegisteredUser
(
  firstname       VARCHAR(150) NOT NULL,                # First Name of the Registered User
  lastname        VARCHAR(150) NOT NULL,                # Last Name of the Registered User
  email           VARCHAR(150) NOT NULL,                # Email of the Registered User
  password        VARCHAR(150) NOT NULL,                # Password of the Registered User
  postal          VARCHAR(150) NOT NULL,                   # Postal Code of the Registered User
  cardnumber      VARCHAR(150) NOT NULL,                # Credit Card number of the Registered User
  cvv             VARCHAR(150) NOT NULL,                # Credit Card cvv of the Registered User
  expirationdate  VARCHAR(150) NOT NULL,                          # Credit Card expiration date of the Registered User
  nextpayment     VARCHAR(150) NOT NULL,                      # Next payment date for the Registered User
  PRIMARY KEY     (email)                                  # Make the id the primary key
);

