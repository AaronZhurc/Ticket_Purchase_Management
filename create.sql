--�˿ͣ�֤���ţ�֤�����ͣ��������Ա���ϵ��ʽ���˺ţ����룬��������
create table Passenger(
    IDNum varchar(30) primary key,
    IDType varchar(20),
    UserName varchar(20),
    Contact varchar(30),
    UserAccount varchar(30),
    UserPassword varchar(20),
    TicketHold int
)
--���ࣨ����ţ�ִ�ɺ�˾�����ͣ���ɻ���������������ǻ��ڣ����ʱ�䣬����ʱ�䣬��λ�����˿�����
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
--��λ����λ�ţ��ȼ���Ʊ�ۣ�״̬�������)
create table Seat(
    SeatNum varchar(4) primary key,
    SeatLevel varchar(10),
    Price float,
    Status char(6) default('����'),
    FlightNum varchar(10) not null,
    CONSTRAINT SEAT_STATUS_CONS check(Status in('����','����')),
    CONSTRAINT FK_SEAT_FN foreign key(FlightNum) REFERENCES Flight(FlightNum)
)
--��Ʊ����Ʊ��ţ�֤���ţ���λ�ţ�����ţ�
create table Ticket(
    TicketNum varchar(30) primary key,
    IDNum varchar(30),
    SeatNum varchar(4),
    FlightNum varchar(10),
    CONSTRAINT FK_TICKET_ID foreign key(IDNum) REFERENCES Passenger(IDNum),
    CONSTRAINT FK_TICKET_SN foreign key(SeatNum) REFERENCES Seat(SeatNum),
    CONSTRAINT FK_TICKET_FN foreign key(FlightNum) REFERENCES Flight(FlightNum)
)