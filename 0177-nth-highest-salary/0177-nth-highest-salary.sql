CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
return (
 with Ranks as(
    select *,dense_rank() over (order by salary desc) as r from Employee
)
select case 
   WHEN (SELECT COUNT(id) FROM Ranks WHERE r = N) > 0
   then   (select salary from Ranks
           where r = N
           limit 1) 
   else null
end
);
END