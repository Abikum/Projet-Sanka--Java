set serveroutput on
declare
	nom  varchar2(30) :='INNOCENTS NJIEMOUN';
	prenom  varchar2(15) := 'JUDES FRANCK';
	matricule  varchar2(15) := '20V2436';
	telephone   int(15) := 656938482;
	sexe varchar2(15) := 'Masculin';
begin 

		dbms_output.put_line('Nom : '|| nom);
		dbms_output.put_line('Prenom : '|| prenom);
		dbms_output.put_line('matricule : '|| matricule);
		dbms_output.put_line('telephone : '|| telephone);
		dbms_output.put_line('sexe : '|| sexe);
end;
/