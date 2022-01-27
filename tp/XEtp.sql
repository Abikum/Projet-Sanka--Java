set serveroutput on 

declare
	type tab is varray(3) of varchar2(10);

	array tab := tab('franck', 'judes', 'dump');


	''' type tab is table of varchar2(10) (permet de creer un tableau de taille illimiter)'''
begin
	dbms_output.put_line('Hello');

	for i in 1..array.count loop
		dbms_output.put_line(array(i));
	end loop;

	
end;
/