--------------------------------------------------------
--  File created - Salý-Haziran-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BASVURANLAR
--------------------------------------------------------

  CREATE TABLE "GAZI1"."BASVURANLAR" 
   (	"USERID" VARCHAR2(1000 BYTE), 
	"HRID" NUMBER, 
	"ADVERTID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into GAZI1.BASVURANLAR
SET DEFINE OFF;
Insert into GAZI1.BASVURANLAR (USERID,HRID,ADVERTID) values ('yI7IWftf7N','47','11');
Insert into GAZI1.BASVURANLAR (USERID,HRID,ADVERTID) values ('yI7IWftf7N','47','10');
Insert into GAZI1.BASVURANLAR (USERID,HRID,ADVERTID) values ('Jvj0vVo5v9','47','10');
Insert into GAZI1.BASVURANLAR (USERID,HRID,ADVERTID) values ('Jvj0vVo5v9','47','21');
Insert into GAZI1.BASVURANLAR (USERID,HRID,ADVERTID) values ('Jvj0vVo5v9','47','11');
--------------------------------------------------------
--  Constraints for Table BASVURANLAR
--------------------------------------------------------

  ALTER TABLE "GAZI1"."BASVURANLAR" MODIFY ("ADVERTID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."BASVURANLAR" MODIFY ("HRID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."BASVURANLAR" MODIFY ("USERID" NOT NULL ENABLE);
