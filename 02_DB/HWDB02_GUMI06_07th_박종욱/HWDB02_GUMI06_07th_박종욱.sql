use empdept;

# 1.
select emp.ename, dept.dname, emp.sal
from emp, dept
where dept.loc = 'CHICAGO';

# 2.
select emp.empno, emp.ename, dept.dname, dept.deptno
from emp, dept
where emp.mgr is null;

# 3.
select emp.ename, dept.dname, emp.mgr
from emp, dept
where emp.mgr = (select emp.mgr
				from emp
                where emp.ename ='blake');
                
# 4.
select *
from emp
order by hiredate
limit 5;

# 5.
select emp.ename, emp.job, dept.dname
from emp, dept
where emp.mgr = (select emp.empno
				from emp
                where emp.ename ='jones');

select *
from emp;
