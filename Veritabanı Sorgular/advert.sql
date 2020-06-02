--------------------------------------------------------
--  File created - Salý-Haziran-02-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ADVERT
--------------------------------------------------------

  CREATE TABLE "GAZI1"."ADVERT" 
   (	"ID" NUMBER, 
	"HRID" NUMBER, 
	"TITLE" VARCHAR2(100 BYTE), 
	"JOBDESCRIPTION" VARCHAR2(1000 BYTE), 
	"SUMMARY" VARCHAR2(1000 BYTE), 
	"PERSONALINFO" VARCHAR2(200 BYTE), 
	"PROFESSIONALINFO" VARCHAR2(500 BYTE), 
	"ACTIVATIONTIME" VARCHAR2(10 BYTE), 
	"DISABLETIME" VARCHAR2(10 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
REM INSERTING into GAZI1.ADVERT
SET DEFINE OFF;
Insert into GAZI1.ADVERT (ID,HRID,TITLE,JOBDESCRIPTION,SUMMARY,PERSONALINFO,PROFESSIONALINFO,ACTIVATIONTIME,DISABLETIME) values ('10','47','Java Developer /OBSS  Ýstanbul(Asya)','Oracle tecrübesi olan,

Java/J2EE kullanarak yazýlým geliþtirmiþ olan, Nesne tabanlý yazýlým geliþtirmeye hakim

Web framework deneyimine sahip olan. Spring, Spring Boot, Angular, JSF, EJB, Maven, Mikroservis, JPA, Hibernate vb teknolojilerin kullanýldýðý projelerde görev alan

Web Servisleri ile ilgili deneyimi olan (SOAP, Restful, JSON, XML, XSLT)

JavaScript, Ajax, HTML, CSS konularýnda bilgi sahibi

RDBMS ve SQL‘e hakim, MySQL, PostgreSQL, Oracle benzeri veritabanlarýný kullanan

Scrum metodolojilerini kullanan','Þirketimizin  dýþ kaynak saðladýðý çok uluslu kurumsal bir firmada görev alacak, belirtilen niteliklere uygun Java Developer uzmanlarý alýnacaktýr.
Devam eden projelere kolay adapte olacak, 4-5 yýl iþ tecrübesine sahip, yeni geliþtirmeleri üstlenecek, mevcut projelerin bakýmýný yapacak ve problemleri çözmeye yardýmcý olunacaktýr.','Yüksek Motivasyon','Java,JavaScript','2020-02-01','2020-05-15');
Insert into GAZI1.ADVERT (ID,HRID,TITLE,JOBDESCRIPTION,SUMMARY,PERSONALINFO,PROFESSIONALINFO,ACTIVATIONTIME,DISABLETIME) values ('21','47','Css Developer / JOTFORM Yazýlým  Ankara','Bachelor’s degree in CS/CENG or in a related technical field or equivalent practical experience
Proficiency in HTML, CSS3
2+ year experience building web applications
Experience with CSS preprocessors (LESS, SASS)
Experience in responsive UI development
Developing cross-browser and cross-platform compatible solutions
Good understanding of browser-rendering and browser animation costs
Excellent command of English
A passion to learn and keep up with the cutting edge technologies
Demonstrated ability to work independently with minimal supervision
Experience with popular JavaScript frameworks (i.e. React, Node.js and Backbone.js) is a plus
Experience in SaaS is a plus
Experience with HTML email template development is a plus','JotForm is an online form builder with over 7 Million users worldwide. Our offices are located in San Francisco, Ankara and Izmir. We are looking for CSS Developers for one of our cross-functional teams in our Ankara office located at a relaxed fun environment in Hacettepe University Teknokent','High Motivation','Bachelor’s degree in CS/CENG or in a related technical field or equivalent practical experience Proficiency in HTML, CSS3','2020-03-17','2020-12-30');
Insert into GAZI1.ADVERT (ID,HRID,TITLE,JOBDESCRIPTION,SUMMARY,PERSONALINFO,PROFESSIONALINFO,ACTIVATIONTIME,DISABLETIME) values ('22','47','Bilgi Ýþlem Mühendisi Glengo Teknoloji Tic. ve San. A.Þ. Ýstanbul(Avr.)(Esenler)','Microsoft iþletim sistemleri konusunda deneyimli,
Sorun araþtýrmasý ve takibi yapmak,
Yeni teknolojileri takip eden ve sürekli öðrenmeye açýk,
Müþterilerdeki sistemlerin rutin bakým ve yönetim iþlemlerini yürütmek,
Raporlama alýþkanlýðý olan ve dökümantasyona önem veren,
Problem çözmeye odaklý,
Ýyi derecede teknik Ýngilizce bilen,
Takým çalýþmasýna yatkýn,
Dikkatli ve sabýrlý,
Ýnsan iliþkilerinde aktif,
Sorumluluk sahibi,disiplinli,
Teknolojik yeniliklere açýk,
Öðrenmeye hevesli kendini geliþtirmeye açýk,
Esnek çalýþmak saatlerine uyabilecek.','Firmamýzda çalýþmak üzere aþaðýdaki kriterlere uygun ''''Bilgi Ýþlem Mühendisleri'''' aranmaktadýr.Üniversitelerin mühendislik fakültelerinin bilgisayar mühendisliði bölümü mezunu,Microsoft iþletim sistemleri konusunda deneyimli,Raporlama alýþkanlýðý olan ve dökümantasyona önem veren,Teknolojik yeniliklere açýk','Yüksek Motivasyon, Sabýrlý,  Aktif','Ýngilizce','2020-06-05','2020-12-31');
Insert into GAZI1.ADVERT (ID,HRID,TITLE,JOBDESCRIPTION,SUMMARY,PERSONALINFO,PROFESSIONALINFO,ACTIVATIONTIME,DISABLETIME) values ('24','81','Css Developer JOTFORM Yazýlým A.Þ Ýstanbul','Bachelor’s degree in CS/CENG or in a related technical field or equivalent practical experience
Proficiency in HTML, CSS3
2+ year experience building web applications
Experience with CSS preprocessors (LESS, SASS)
Experience in responsive UI development
Developing cross-browser and cross-platform compatible solutions
Good understanding of browser-rendering and browser animation costs
Excellent command of English
A passion to learn and keep up with the cutting edge technologies
Demonstrated ability to work independently with minimal supervision
Experience with popular JavaScript frameworks (i.e. React, Node.js and Backbone.js) is a plus
Experience in SaaS is a plus
Experience with HTML email template development is a plus
','JotForm is an online form builder with over 7 Million users worldwide. Our offices are located in San Francisco, Ankara and Ýstanbul. We are looking for CSS Developers for one of our cross-functional teams in our Ýstanbul office located at a relaxed fun environment in Ýstanbul Technical University Teknokent.','High Motivation','Bachelor’s degree in CS/CENG or in a related technical field or equivalent practical experience Proficiency in HTML, CSS3','2020-05-30','2020-12-31');
--------------------------------------------------------
--  DDL for Index ADVERT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "GAZI1"."ADVERT_PK" ON "GAZI1"."ADVERT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  Constraints for Table ADVERT
--------------------------------------------------------

  ALTER TABLE "GAZI1"."ADVERT" ADD CONSTRAINT "ADVERT_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("DISABLETIME" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("ACTIVATIONTIME" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("PROFESSIONALINFO" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("PERSONALINFO" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("SUMMARY" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("JOBDESCRIPTION" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("TITLE" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("HRID" NOT NULL ENABLE);
  ALTER TABLE "GAZI1"."ADVERT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table ADVERT
--------------------------------------------------------

  ALTER TABLE "GAZI1"."ADVERT" ADD CONSTRAINT "ADVERT_HUMANRESOURCES_FK1" FOREIGN KEY ("HRID")
	  REFERENCES "GAZI1"."HUMANRESOURCES" ("ID") ENABLE;
--------------------------------------------------------
--  DDL for Trigger ADVERT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "GAZI1"."ADVERT_TRG" 
BEFORE INSERT ON ADVERT 
FOR EACH ROW 
BEGIN
  select ADVERT_SEQUENCE.NEXTVAL INTO:NEW.ID FROM DUAL;
END;
/
ALTER TRIGGER "GAZI1"."ADVERT_TRG" ENABLE;
