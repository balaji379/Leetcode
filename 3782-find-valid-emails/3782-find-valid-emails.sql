select user_id,email
from Users 
where email regexp '^[a-z0-9A-Z]+@+[a-zA-Z]+.com'