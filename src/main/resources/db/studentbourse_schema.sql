create table university (
                            id serial primary key,
                            name varchar(255) unique not null,
                            rank int not null
);

create table users (
                       id serial primary key,
                       role varchar(20) not null check (role in ('student','evaluator','admin')),
                       first_name varchar(100) not null,
                       last_name varchar(100) not null,
                       email varchar(255) unique not null,
                       phone varchar(20),
                       password varchar(255) not null
);

create table scholarship (
                             id serial primary key,
                             title varchar(255) not null,
                             amount int not null,
                             deadline date not null,
                             max_applicants int not null,
                             level varchar(20) not null check (level in ('undergraduate','postgraduate','phd'))
);

create table scholarship_criteria (
                                      id serial primary key,
                                      scholarship_id int references scholarship(id) on delete cascade,
                                      academic_weight float default 0,
                                      financial_weight float default 0,
                                      exam_weight float default 0,
                                      extracurricular_weight float default 0,
                                      university_weight float default 0
);

create table application (
                             id serial primary key,
                             user_id int references users(id) on delete cascade,
                             scholarship_id int references scholarship(id) on delete cascade,
                             status varchar(30) check (status in ('submitted','in_process','picked','rejected')),
                             total_score float default 0,
                             comments text,
                             created_at timestamp default now()
);

create table document (
                          id serial primary key,
                          user_id int references users(id) on delete cascade,
                          application_id int references application(id) on delete cascade,
                          name varchar(255),
                          file_path text,
                          uploaded_at timestamp default now()
);

create table evaluation (
                            id serial primary key,
                            application_id int references application(id) on delete cascade,
                            evaluator_id int references users(id),
                            academic_score float,
                            financial_score float,
                            exam_score float,
                            extracurricular_score float,
                            university_score float,
                            total_score float,
                            comments text,
                            evaluated_at timestamp default now()
);

create table application_preference (
                                        id serial primary key,
                                        application_id int references application(id) on delete cascade,
                                        priority int
);

create table statistics_snapshot (
                                     id serial primary key,
                                     scholarship_id int references scholarship(id) on delete cascade,
                                     week int,
                                     students_awarded int,
                                     funds_awarded int,
                                     created_at timestamp default now()
);

-- mock data
insert into university (name, rank) values
                                        ('University of Oxford', 1),
                                        ('University of Cambridge', 2),
                                        ('ETH Zurich', 7),
                                        ('Imperial College London', 6),
                                        ('University of Amsterdam', 60),
                                        ('TU Munich', 50),
                                        ('Sorbonne University', 72),
                                        ('KU Leuven', 45),
                                        ('University of Bologna', 90),
                                        ('University of Vienna', 170);

insert into users (role, first_name, last_name, email, phone, password) values
                                                                            ('student','Alice','Martin','alice@student.com','+331111111','pass123'),
                                                                            ('student','Bob','Keller','bob@student.com','+491111111','pass123'),
                                                                            ('student','Carla','Rossi','carla@student.com','+391111111','pass123'),
                                                                            ('student','David','Smith','david@student.com','+441111111','pass123'),
                                                                            ('student','Eva','Novak','eva@student.com','+431111111','pass123'),
                                                                            ('evaluator','Dr','Brown','brown@uni.com',null,'admin123'),
                                                                            ('evaluator','Dr','Muller','muller@uni.com',null,'admin123'),
                                                                            ('admin','Admin','One','admin@system.com',null,'root'),
                                                                            ('student','Lucas','Moreau','lucas@student.com','+331222222','pass123'),
                                                                            ('student','Nina','Schmidt','nina@student.com','+491222222','pass123');

insert into scholarship (title, amount, deadline, max_applicants, level) values
                                                                             ('Merit Excellence Award',5000,'2026-06-30',50,'undergraduate'),
                                                                             ('Global Achiever',8000,'2026-07-15',30,'postgraduate'),
                                                                             ('Research Fellowship',12000,'2026-08-01',10,'phd'),
                                                                             ('Women in STEM',6000,'2026-05-30',40,'undergraduate'),
                                                                             ('AI Innovation Grant',10000,'2026-09-01',20,'postgraduate'),
                                                                             ('Green Energy Scholars',7000,'2026-07-01',25,'undergraduate'),
                                                                             ('EU Mobility Grant',4000,'2026-06-01',60,'undergraduate'),
                                                                             ('Tech Leaders Program',9000,'2026-08-15',15,'postgraduate'),
                                                                             ('Health Sciences Fund',8500,'2026-07-20',20,'postgraduate'),
                                                                             ('Doctoral Excellence',15000,'2026-10-01',5,'phd');

insert into scholarship_criteria
(scholarship_id, academic_weight, financial_weight, exam_weight, extracurricular_weight, university_weight)
select id, 30, 30, 20, 10, 10 from scholarship;

