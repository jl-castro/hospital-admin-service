insert into hospital_table (hospitalid, name, address, isdeleted, createdat, updatedat, createdby, updatedby) values (1, 'Hospital General', 'Zona Miraflores, Av. Saavedra', false, NOW(), null, 1, null);
insert into hospital_table (hospitalid, name, address, isdeleted, createdat, updatedat, createdby, updatedby) values (2, 'Hospital Agramont', 'Villa Dolores, C. Francisco Vega', false, NOW(), null, 1, null);
insert into hospital_table (hospitalid, name, address, isdeleted, createdat, updatedat, createdby, updatedby) values (3, 'Hospital del Norte', 'Zona Rio Seco, Av. Juan Pablo II', false, NOW(), null, 1, null);

insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (1, 'dermatology', 'works on night shift', 1, 1, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (2, 'diabetes', 'works on night shift', 2, 1, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (3, 'hematology', 'works on morning shift', 3, 1, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (4, 'neurology', 'works on afternoon shift 24x7', 4, 2, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (5, 'optometry', 'works on afternoon shift 24x7', 4, 2, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (6, 'orl', 'works on afternoon shift 24x7', 4, 2, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (7, 'orthopedics', 'works on afternoon shift 24x7', 4, 3, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (8, 'pediatrics', 'works on afternoon shift 24x7', 4, 1, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (9, 'psychiatry', 'works on afternoon shift 24x7', 4, 3, false, NOW(), null, 1, null);
insert into speciality_table (specialityid, name, description, avatarid, hospitalid, isdeleted, createdat, updatedat, createdby, updatedby) values (10, 'surgery', 'works on afternoon shift 24x7', 4, 3, false, NOW(), null, 1, null);

insert into patient_table (patientid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (1, 'Mario', 'Castañeda', 'Springfield','1999-02-03', 1,  '618a9bddedca070d24a12572', false, NOW(), null, 1, null);
insert into patient_table (patientid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (2, 'Mario', 'Bros', 'Chuquisaca, Camargo','1988-04-18',  1, '618a9be1edca070d24a12573', false, NOW(), null, 1, null);
insert into patient_table (patientid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (3, 'Daniela', 'Gonzales', 'La Paz, Miraflores','2001-01-23', 2,  '618a92c6edca071138406517', false, NOW(), null, 1, null);
insert into patient_table (patientid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (4, 'Gloria', 'Casas', 'Cochabamba, Quillacollo','2003-02-13',  3, '618a9bd3edca070d24a12571', false, NOW(), null, 1, null);
insert into patient_table (patientid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (5, 'Pedro', 'Ramirez', 'La Paz, Villa Fatima','1996-03-25',  2, '618a9c8bedca070d24a12574', false, NOW(), null, 1, null);

insert into doctor_table (doctorid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (1,'MacFadin' ,'Gavra', '77945 Melby Avenue', '2001-11-04', 1, '618a9c97edca070d24a12575', false, NOW(), null, 1, null);
insert into doctor_table (doctorid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (2,'Ellerey' ,'Roma', '86729 Northland Center', '1993-04-08', 1,'618a9d5fedca070d24a12578',  false, NOW(), null, 1, null);
insert into doctor_table (doctorid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (3,'Barney', 'Anallise', '8406 Bonner Crossing', '1992-11-20', 2,'618a9c9cedca070d24a12576',  false, NOW(), null, 1, null);
insert into doctor_table (doctorid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (4,'Gheorghie', 'Yetta', '98 Welch Crossing', '2001-04-22', 2,'618a9caaedca070d24a12577',  false, NOW(), null, 1, null);
insert into doctor_table (doctorid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (5,'McGougan', 'Karia', '08 Village Green Junction', '2002-06-13', 3, '618a9d69edca070d24a12579', false, NOW(), null, 1, null);
insert into doctor_table (doctorid, name, lastname, address, birthday, hospitalid, profileid, isdeleted, createdat, updatedat, createdby, updatedby) values (6,'Elies' ,'Guillemette', '44 Dovetail Way', '2006-03-09', 3, '618a9d75edca070d24a1257a', false, NOW(), null, 1, null);

insert into speciality_doctor_table(doctorid, specialityid) values (1,1);
insert into speciality_doctor_table(doctorid, specialityid) values (2,2);
insert into speciality_doctor_table(doctorid, specialityid) values (2,4);
insert into speciality_doctor_table(doctorid, specialityid) values (3,3);
insert into speciality_doctor_table(doctorid, specialityid) values (4,1);
insert into speciality_doctor_table(doctorid, specialityid) values (4,2);
insert into speciality_doctor_table(doctorid, specialityid) values (4,4);
insert into speciality_doctor_table(doctorid, specialityid) values (5,2);
insert into speciality_doctor_table(doctorid, specialityid) values (5,3);
insert into speciality_doctor_table(doctorid, specialityid) values (6,3);


