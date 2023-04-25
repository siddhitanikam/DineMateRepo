create login sql123 with password = 'sql123'


use AP;
create user sql123 for login sql123;

EXEC sp_addrolemember 'db_datareader', 'sql123';
EXEC sp_addrolemember 'db_datawriter', 'sql123';
EXEC sp_addrolemember 'db_ddladmin', 'sql123';