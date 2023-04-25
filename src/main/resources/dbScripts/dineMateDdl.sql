Create DATABASE DineMate;

create login sql123 with password = 'sql123'

use DineMate;
create user sql123 for login sql123;

EXEC sp_addrolemember 'db_datareader', 'sql123';
EXEC sp_addrolemember 'db_datawriter', 'sql123';
EXEC sp_addrolemember 'db_ddladmin', 'sql123';


USE DineMate
GO

CREATE TABLE Status (
  StatusId INT NOT NULL PRIMARY KEY,
  Status VARCHAR(255) NOT NULL
);	
CREATE TABLE Task (
  TaskId INT NOT NULL PRIMARY KEY,
  TaskType VARCHAR(255) NOT NULL,
  TaskDescription VARCHAR(255) NOT NULL
);

CREATE TABLE Role (
  RoleId INT NOT NULL PRIMARY KEY,
  RoleDesc VARCHAR(255) NOT NULL
);

CREATE TABLE Employee (
  EmpId INT NOT NULL PRIMARY KEY,
  SUId BIGINT NOT NULL,
  FName VARCHAR(255) NOT NULL,
  LName VARCHAR(255) NOT NULL,
  EmailId VARCHAR(255) NOT NULL,
  PhoneNo VARCHAR(20) NOT NULL,
  DWPoints INT NOT NULL,
  RoleId INT NOT NULL,
  FOREIGN KEY (RoleId) REFERENCES Role(RoleId)
);

CREATE TABLE Shift (
  ShiftId INT NOT NULL PRIMARY KEY,
  StartTime TIME NOT NULL,
  EndTime TIME NOT NULL,
  Day VARCHAR(10) NOT NULL,
  RoleId INT NOT NULL,
  EmployeeId INT,
  FOREIGN KEY (RoleId) REFERENCES Role(RoleId),
  FOREIGN KEY (EmployeeId) REFERENCES Employee(EmpId)
);

CREATE TABLE Dailyschedule (
  ScheduleId INT NOT NULL PRIMARY KEY,
  EmployeeId INT NOT NULL,
  ShiftId INT NOT NULL,
  ShiftDate DATE NOT NULL,
  TaskId INT NOT NULL,
  StatusId INT NOT NULL,
  FOREIGN KEY (EmployeeId) REFERENCES Employee(EmpId),
  FOREIGN KEY (ShiftId) REFERENCES Shift(ShiftId),
  FOREIGN KEY (TaskId) REFERENCES Task(TaskId),
  FOREIGN KEY (StatusId) REFERENCES Status(StatusId)
);