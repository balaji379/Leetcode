select o.employee_id from Employees o where not exists (select e.employee_id from Salaries  e where e.employee_id  = o.employee_id)
union
select o.employee_id from Salaries  o where not exists (select e.employee_id from Employees e where e.employee_id  = o.employee_id)
order by employee_id ;