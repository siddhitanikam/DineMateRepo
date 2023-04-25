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

CREATE TABLE Schedule (
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


-- Inserting data into Status table
INSERT INTO Status (StatusId, Status)
VALUES (1, 'Working'),
       (2, 'Pending'),
	   (3, 'Available'),
	   (4, 'Worked'),
	   (5, 'No Show'),
	   (6, 'Sick');

-- Inserting data into Task table
INSERT INTO Task (TaskId, TaskType, TaskDescription)
VALUES (1, 'Dining', 'Clean the tables and dining area.'),
       (2, 'Deli', 'Counter 3. Make sandwiches and wraps as per order'),
       (3, 'MTO', 'Counter 2. Made to order- make burgers'),
	   (4, 'Salads', 'Counter 4. Fill the empty or half-filled containers and clean the counter.'),
	   (5, 'Express', 'Counter 5. Fill the empty or half-filled containers and clean the counter.'),
	   (6, 'Hotline', 'Counter 1. Fill the empty or half-filled containers and clean the counter.'),
	   (7, 'Dish', 'Arrange washed utensils');

-- Inserting data into Role table
INSERT INTO Role (RoleId, RoleDesc)
VALUES (1, 'Manager'),
       (2, 'Supervisor'),
       (3, 'General Employee');

-- Inserting data into Employee table
INSERT INTO Employee (EmpId, SUId, FName, LName, EmailId, PhoneNo, DWPoints, RoleId)
VALUES (1, 1234567890, 'John', 'Doe', 'johndoe@example.com', '555-555-5555', 10, 1),
       (2, 1234567891, 'Jane', 'Doe', 'janedoe@example.com', '555-555-5556', 8, 2),
       (3, 1234567892, 'Bob', 'Smith', 'bobsmith@example.com', '555-555-5557', 5, 3);

-- Inserting data into Shift table
INSERT INTO Shift (ShiftId, StartTime, EndTime, Day, RoleId, EmployeeId)
VALUES (1, '08:00:00', '11:00:00', 'Sunday', 1, NULL),
       (2, '14:00:00', '17:00:00', 'Sunday', 2, 2),
       (3, '17:00:00', '20:00:00', 'Sunday', 3, 3);

-- Inserting data into Dailyschedule table
INSERT INTO Schedule (ScheduleId, EmployeeId, ShiftId, ShiftDate, TaskId, StatusId)
VALUES (1, 1, 1, '2023-04-23', 1, 1),
       (2, 2, 2, '2023-04-23', 2, 2),
       (3, 3, 3, '2023-04-23', 3, 1);
