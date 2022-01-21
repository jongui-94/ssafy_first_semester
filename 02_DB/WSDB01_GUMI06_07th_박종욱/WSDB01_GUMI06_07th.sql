# 1.
use world;

# 2.
desc city;
desc country;
desc countrylanguage;

# 3. 
select code, name, continent, region
from country
where Code = "KOR";

# 4.
select code, name, GNP as gnp , GNPOLD as gnpold, GNP - GNPOLD as gnp변동량
from country
where gnp - gnpold >= 0
order by  GNP - GNPOLD;

# 5.
select distinct continent
from country
order by char_length(continent);

# 6. select 
select concat(name, '은 ', region, '에 속하며 인구는 ', population, '명이다.')
from country
where continent like '%asia%'
order by name;

# 7.
select name, continent, gnp, population
from country
where population >= 10000 and IndepYear is NULL
order by population;

# 8.
select code, name, population
from country
where population between 100000000 and 200000000
order by population desc
limit 3;

# 9.
select code, name, indepyear
from country
where indepyear in(800, 1810, 1811,1901)
order by indepyear, code desc;

# 10.
select code, name, region
from country
where region like '%asia%' and name like '_o%';

# 11.
select (char_length('홍길동')) "한글", (char_length('hong')) "영문";

# 12.
select code, name, governmentform
from country
where governmentform like '%republic%' and char_length(name) >= 10
order by char_length(name) desc
limit 10;

# 13.
select code, name
from country
where code like 'a%' or code like 'e%' or code like 'i%' or code like 'o%' or code like 'u%'
order by name
limit 2,3;

# 14
select name, concat(left(name,2), repeat('*',char_length(name)-4),right(name,2)) guess
from country;

# 15
select distinct replace(region, ' ', '_') "지역들"
from country
order by char_length(region) desc;

# 16
select name, surfacearea, population, round(surfacearea/population, 3) as "1인당 점유면적"
from country
where population >= 100000000
order by surfacearea/population;

# 17
select curdate() "오늘", dayofyear(date_sub(curdate(), interval 2022 year)) "올해 지난 날",
date_add(curdate(), interval 100 day) "100일 후" ;

# 18
select name, continent, LifeExpectancy, 
	case when LifeExpectancy > 80 then '장수국가' 
		when LifeExpectancy > 60 then '일반국가'
        else '단명국가'
	end "구분"
from country
where continent like '%asia%'
order by lifeexpectancy;

# 19
select name, gnp, gnpold, if(gnpold is null,"신규"),gnp-gnpold "gnp 향상"
from country
order by name;

# 20

 