use world;

# 1.
select code, country.name
from country, city
where country.code = city.countrycode and city.name = "kabul" ;

# 2.
select name, language, percentage
from country, countrylanguage cl
where cl.percentage = 100.0 and cl.isofficial = 'T' and country.code = cl.countrycode
order by name;

# 3.
select city.name, countrylanguage.language, country.name
from city, countrylanguage, country
where city.name = 'amsterdam' and city.countrycode = country.code and country.code = countrylanguage.countrycode
and countrylanguage.isofficial = 't';

# 4.
select co.name, co.capital, ci.name "수도", ci.population "수도인구"
from country co, city ci
where co.name like 'united%'  and co.capital = ci.id;

# 5.
select co.name, co.capital, ifnull(ci.name,"수도없음") "수도" , ifnull(ci.population,"수도없음") "수도인구"
from country co left outer join city ci
on co.capital = ci.id
where co.name like 'united%';

# 6.
select count(distinct(cl.CountryCode)) "국가 수"
from countrylanguage cl
where cl.percentage > (select max(cl.percentage)
						from countrylanguage cl
                        where cl.countrycode = 'che')
and cl.IsOfficial = 't';
                        

# 7.
select cl.language
from countrylanguage cl, country co
where co.name = 'south korea' and co.code = cl.countrycode and cl.isofficial = 't';

# 8.
select co.name, co.code, count(ci.id) "도시개수"
from city ci left outer join country co
on co.code = ci.countrycode
where co.name like 'bo%'
group by co.name;

# 9.
select co.name, co.code, if(count(ci.id)=0,"단독",count(ci.id)) "도시개수"
from country co left outer join city ci
on co.code = ci.countrycode
where co.name like 'bo%'
group by co.name;

# 10.
select countrycode, name, population
from city 
order by population desc
limit 1;

# 11.
select co.name, ci.countrycode, ci.name, ci.population
from city ci, country co
where ci.CountryCode = co.Code
order by ci.population
limit 1;

# 12.
select co.code, ci.name, ci.population
from country co, city ci
where ci.population > (select ci.population
						from city ci
						where ci.name = 'seoul')
and co.Code = ci.countrycode;

# 13.
select cl.CountryCode, cl.language
from countrylanguage cl, city ci
where ci.name = 'san miguel' and ci.CountryCode = cl.CountryCode and cl.IsOfficial = 't';
            
# 14.
select ci.CountryCode, max(ci.population) "max_pop"
from city ci, country co
group by ci.countrycode
having max(ci.population)
order by ci.countrycode;

# 15.
select ci.countrycode, ci.name, ci.population
from city ci
group by ci.countrycode
having max(ci.population);   

# 16.
select ci.countrycode, co.name, ci.name, ci.population
from country co left outer join city ci
on ci.CountryCode = co.Code
group by co.code;

   
#16-2.   
select country.code, country.name, city.name, sum(city.population)
from country left outer join city
on country.code = city.countrycode
group by country.code;
     
# 17.
create view summary as    
select *
from country;

# 18.
select su.code, su.name "co_name", ci.name "ci_name", ci.population
from summary su, city ci
where su.code = ci.CountryCode and su.code = 'kor' and ci.name = 'seoul';
        
select ci.population
from city ci
where ci.name = 'seoul' ;



select *
from country;
