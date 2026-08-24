# Write your MySQL query statement below
select d.name as Department , e.name as Employee , e.salary as Salary
from employee e 
Left join department d on e.departmentId = d.id
where e.salary = (
    select max(salary) as salary from Employee
    group by departmentId
    having d.id = departmentId
)
