with EmployeeWithDepart as 
(select d.name department,e.name,e.salary from Employee e
join Department d
on d.id = e.departmentId  
),
HighPack as(
   select h.department,max(h.salary) salary from EmployeeWithDepart as h
   group by h.department
)
select distinct e.department Department ,e.name Employee,e.salary Salary from EmployeeWithDepart e, HighPack h
where e.salary = h.salary and e.department = h.department;