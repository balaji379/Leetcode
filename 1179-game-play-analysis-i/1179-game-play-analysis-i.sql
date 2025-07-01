select a.player_id,a.event_date first_login from activity a
where a.event_date = ALL (select min(event_date)
from activity s 
where a.player_id = s.player_id);