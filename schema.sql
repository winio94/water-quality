CREATE DATABASE if NOT EXISTS austria;
use austria;

DROP TABLE IF EXISTS measure_station, region, factors, measurement;

CREATE TABLE region (
  ID              INT         NOT NULL,
  ECONOMY_PROFILE VARCHAR(30) NOT NULL,
  POPULATION      BIGINT      NOT NULL,
  TOPOLOGY        VARCHAR(30) NOT NULL,
  TERITORY        BIGINT      NOT NULL,
  ECONOMIC_SYSTEM VARCHAR(30) NOT NULL,
  INDUSTRY_TYPE   VARCHAR(30) NOT NULL,
  primary key (ID)
);

CREATE TABLE measure_station (
  ID        INT         NOT NULL,
  REGION_ID INT         NOT NULL,
  CODE      VARCHAR(30) NOT NULL,
  NAME      VARCHAR(30) NOT NULL,
  primary key (ID)
);

CREATE TABLE measurement (
  ID           INT  NOT NULL,
  STATION_ID   INT  NOT NULL,
  FACTORS_ID   INT  NOT NULL,
  MEASURE_DAYE DATE NOT NULL,
  primary key (ID)
);

CREATE TABLE factors (
  ID                           INT   NOT NULL,
  TEMPERATURE                  FLOAT NOT NULL,
  TURBIDITY                    INT,
  DISSOLVED_OXYGEN             INT,
  DISSOLVED_INORGANIC_NITROGEN FLOAT,
  HARDNESS                     INT,
  KHJELDANS_NITROGEN           FLOAT,
  PH                           FLOAT,
  NITRITE                      INT,
  TOTAL_ORGANIC_CARBON         INT,
  SUSPENDED_SOLIDS             INT,
  PHOSPHORUS                   INT,
  primary key (ID)
);

ALTER TABLE measure_station
  ADD CONSTRAINT station_region
  FOREIGN KEY (REGION_ID)
  REFERENCES region (ID) ON DELETE CASCADE;

ALTER TABLE measurement
  ADD CONSTRAINT measurement_station
  FOREIGN KEY (STATION_ID)
  REFERENCES measure_station (ID) ON DELETE CASCADE;

ALTER TABLE measurement
  ADD CONSTRAINT measurement_factors
  FOREIGN KEY (FACTORS_ID)
  REFERENCES factors (ID) ON DELETE CASCADE;