# Write your MySQL query statement below
select unique_id , e.name 
from Employees e
left join EmployeeUNI em on e.id = em.id
