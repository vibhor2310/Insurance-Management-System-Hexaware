CREATE DATABASE IF NOT EXISTS insurance;

USE insurance;

CREATE TABLE User(
userId INT PRIMARY KEY,
username VARCHAR(55),
password VARCHAR(55),
role VARCHAR(55)
);

CREATE TABLE Policy(
 policyId INT PRIMARY KEY,
 policyName VARCHAR(255),
 PolicyType VARCHAR(255),
 coverageAmount DECIMAL(10,2)
);

CREATE TABLE Client(
clientId INT PRIMARY KEY,
clientName VARCHAR(100) NOT NULL,
contactInfo VARCHAR(255) NOT NULL,
policyId INT,
FOREIGN KEY (policyId) REFERENCES Policy(policyId)
);

CREATE TABLE Claim (
    claimId INT PRIMARY KEY,
    claimNumber VARCHAR(20) NOT NULL,
    dateFiled DATE NOT NULL,
    claimAmount DECIMAL(10,2) NOT NULL,
    status varchar(45) NOT NULL,
    policyId INT,
    clientId INT,
    FOREIGN KEY (policyId) REFERENCES Policy(policyId),
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);

create table Payment (
    paymentId INT PRIMARY KEY,
    paymentDate DATE NOT NULL,
    paymentAmount DECIMAL(10,2) NOT NULL,
    clientId INT,
    FOREIGN KEY(clientId) REFERENCES Client(clientId)
);

INSERT INTO User (userID,username,password,role)
VALUES
(1,"Vibhor","Vibhor@123","Admin"),
(2,"Amit","Amit@123","Client"),
(3,"Harshit","Harshit@123","Client"),
(4,"Akshat","Akshat@123","Client");

INSERT INTO Policy (policyID, policyName, policyType, coverageAmount) VALUES
(1, 'Policy 1', 'Health Insurance',10000.00),
(2, 'Policy 2', 'Home Insurance',12000.00),
(3, 'Policy 3', 'Car Insurance',13000.00),
(4, 'Policy 4', 'Health Insurance',14000.00);

INSERT INTO Client (clientId, clientName, contactInfo, policyId) VALUES
(1, 'Harshit', 'Harshit@gmail.com',3),
(2, 'Akshat', 'akshat@gmail.com',4),
(3, 'Vishal', 'vishal@gmail.com',1),
(4, 'Kush', 'Kush@gmail.com',2);

INSERT INTO Claim (claimId, claimNumber, dateFiled, claimAmount, status, policyId, clientId) VALUES
(1, 'Claim 1', '2024-01-01', 1000.00, 'pending', 3, 1),
(2, 'Claim 2', '2024-01-15', 2000.00, 'approved', 4, 2),
(3, 'Claim 3', '2024-02-01', 3000.00, 'rejected', 1, 3),
(4, 'Claim 4', '2024-03-01', 4000.00, 'pending', 2, 4);


INSERT INTO Payment (paymentID, paymentDate, paymentAmount, clientID) VALUES
(1, '2022-02-01', 500.00, 1),
(2, '2022-03-01', 1000.00, 2),
(3, '2022-04-01', 1500.00, 3),
(4, '2022-05-01', 2000.00, 4);

SELECT * FROM Policy;







