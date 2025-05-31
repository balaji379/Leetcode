select name as 'Employee' from Employee e
where managerId is not null and  salary > ( select m.salary from Employee m where m.id = e.managerId);