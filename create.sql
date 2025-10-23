--乘客（证件号，证件类型，姓名，性别，联系方式，账号，密码，持有数）
create table Passenger(
    IDNum varchar(30) primary key,
    IDType varchar(20),
    UserName varchar(20),
    Contact varchar(30),
    UserAccount varchar(30),
    UserPassword varchar(20),
    TicketHold int
)
--航班（航班号，执飞航司，机型，起飞机场，降落机场，登机口，起飞时间，降落时间，座位数，乘客数）
create table Flight(
    FlightNum varchar(10) primary key,
    Airline varchar(20),
    PlaneModel varchar(10),
    Departure varchar(20),
    Landing varchar(20),
    Boarding varchar(10),
    DepartTime Date,
    LandTime Date,
    SeatsQuan int,
    PassengQuan int
)
--座位（座位号，等级，票价，状态，航班号)
create table Seat(
    SeatNum varchar(4) primary key,
    SeatLevel varchar(10),
    Price float,
    Status char(6) default('空座'),
    FlightNum varchar(10) not null,
    CONSTRAINT SEAT_STATUS_CONS check(Status in('空座','有人')),
    CONSTRAINT FK_SEAT_FN foreign key(FlightNum) REFERENCES Flight(FlightNum)
)
--机票（机票编号，证件号，座位号，航班号）
create table Ticket(
    TicketNum varchar(30) primary key,
    IDNum varchar(30),
    SeatNum varchar(4),
    FlightNum varchar(10),
    CONSTRAINT FK_TICKET_ID foreign key(IDNum) REFERENCES Passenger(IDNum),
    CONSTRAINT FK_TICKET_SN foreign key(SeatNum) REFERENCES Seat(SeatNum),
    CONSTRAINT FK_TICKET_FN foreign key(FlightNum) REFERENCES Flight(FlightNum)
)