select 'Yangest' as "Typ" , "NAME", BIRTHDAY
from worker
where BIRTHDAY=(select min(BIRTHDAY)from worker)
UNION all
select 'ELDEST' AS "TYPE", "NAME", BIRTHDAY
from worker
where BIRTHDAY=(select max(BIRTHDAY)from worker);