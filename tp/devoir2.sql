set serveroutput on 

declare
	type tab is varray(10) of int(10);

	array tab := tab(1,30,6,4,12,18,34,55,8,78);

	temp int;
	
	pos int;

begin
	
		
	for i in 1..1 loop
		temp := array(i);
	end loop;

	for i in 1..array.count loop
		if temp < array(i) then
			
			pos := i;
		end if;
	end loop;

	dbms_output.put_line('la position du plus grand element est : '|| pos);
end;
/