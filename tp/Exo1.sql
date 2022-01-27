set serveroutput on 

declare
	type tableau is varray(8) of int(10);

	array tableau := tableau(1,30,6,4,12,18,34,55,8);

	t int;
	
	p int;

begin
	
		
	for i in 1..1 loop
		t := array(i);
	end loop;

	for i in 1..array.count loop
		if t < array(i) then
			
			p := i;
		end if;
	end loop;

	dbms_output.put_line('la position du plus grand element est : '|| p);
end;
/