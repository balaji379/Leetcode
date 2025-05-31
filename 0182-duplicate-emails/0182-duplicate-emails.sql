with duplicateEmail as (select email ,count(email) c from person
group by email
having c > 1
)select email from duplicateEmail;