--drop TABLE USER_INF;  
create TABLE USER_INF if not exists
(
    person_id INTEGER PRIMARY KEY,
    person_name VARCHAR(100), 
    person_sex VARCHAR(2)
    );