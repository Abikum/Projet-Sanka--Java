declare
	
	type tab is varray(3) of varray2(10);

	array tab := tab();

	begin
		for i in 1..3 loop
			array.extend();
			array(i) := 'x';
		end loop;
	end;	