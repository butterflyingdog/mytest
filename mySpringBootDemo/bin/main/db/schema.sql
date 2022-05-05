drop TABLE USER_INFOMATION if exists;  
create TABLE USER_INFOMATION --if not exists
(
    person_id INTEGER PRIMARY KEY,
    person_name VARCHAR(100), 
    person_sex VARCHAR(2)
);