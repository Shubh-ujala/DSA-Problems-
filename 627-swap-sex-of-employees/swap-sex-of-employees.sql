# Write your MySQL query statement below
UPDATE salary set sex = 
CASE sex 
    WHEN 'm' THEN 'f'
    ELSE 'm'
END
