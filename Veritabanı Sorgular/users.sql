--------------------------------------------------------
--  File created - Salý-Haziran-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "GAZI1"."USERS" 
   (	"ID" VARCHAR2(1000 BYTE), 
	"ISIM" VARCHAR2(50 BYTE), 
	"MAIL" VARCHAR2(50 BYTE), 
	"PROFIL" VARCHAR2(1000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into GAZI1.USERS
SET DEFINE OFF;
Insert into GAZI1.USERS (ID,ISIM,MAIL,PROFIL) values ('yI7IWftf7N','Þeyma Sultan Sözen','sozenseymasultan@gmail.com','https://media-exp1.licdn.com/dms/image/C4E03AQHu5o45WcGYdA/profile-displayphoto-shrink_400_400/0?e=1593043200&v=beta&t=1BJ11PSiDIRmkwjyd97nze0F0RPrO_PCGpbnPYGStKI');
Insert into GAZI1.USERS (ID,ISIM,MAIL,PROFIL) values ('Jvj0vVo5v9','Þükriye ÇAVDAR','sukriye.cvdr@gmail.com','https://media-exp1.licdn.com/dms/image/C4D03AQGuwWa6LsTIYw/profile-displayphoto-shrink_400_400/0?e=1593043200&v=beta&t=QNN1S16OuEnBuGoEmPetZm0maRw6HpqN1Rxlfm1MOQY');
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "GAZI1"."USERS" MODIFY ("PROFIL" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."USERS" MODIFY ("MAIL" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."USERS" MODIFY ("ISIM" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."USERS" MODIFY ("ID" NOT NULL ENABLE);
