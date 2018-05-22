/*TABLAS*/
    
/*Tabla Equipo con suma salarios jugadores,jugadores refenciados en la tabla anterior y maximo 6 miembros*/
create table equipo (

    nEquipo varchar2(20), 
    constraint eq_nEq_pk primary key(nEquipo));
alter table equipo add ( punto number(2));
select * from equipo;  

/*Tabla Jugador con sueldo mayor a 735.90€*/
create table jugador (

    nJugador varchar2(10), 
    nickname varchar2(10),
    sueldo number(6),
    nEquipo varchar2(20)
    constraint jug_nEq_fk references equipo(nEquipo),
    CONSTRAINT jug_nJu_pk primary key(nJugador),
    CONSTRAINT jug_suemin_ck check (sueldo>=735.90)
    );


/*Tabla dueño equipo referenciando*/
create table dueñoEquipo (
    nombre varchar2(20) constraint due_nom_pk primary key,
    nEquipo varchar2(20) constraint due_nEq_fk references equipo(nEquipo) on delete set null
)

/*Tabla Partido nombres equipos que juegan y ganador referenciados*/
create table partido (
    nPartido number(4) constraint par_nPa_pk primary key,
    fecha date CONSTRAINT par_fec_uk unique ,
    nEquipo1 varchar2(20) constraint par_nEq_fk references equipo on delete cascade,
    nEquipo2 varchar2(20) constraint par_nEqQ_fk references equipo on delete cascade,
    ganador varchar2(20) constraint par_gan_fk references equipo(nEquipo)
);

/*Tabla Jornada fecha y nº partido referenciados*/
create table jornada (
    nJornada number(3) constraint jor_nJo_pk primary key,
    fecha date constraint jor_fec_fk references partido(fecha) on delete set null,
    nPartido number(4) constraint jor_nPa_fk references partido on delete cascade
);

/*Tabla Calendario con jornadas y fechas referenciadas, num de jornadas equipo -1 elevado al cuadrado*/
create table calendario (
    nJornada number(3) constraint cal_nJo_fk references jornada on delete set null,
    fecha date ,
    nLiga varchar2(20) constraint cal_nLig_pk primary key
);


/*Restricciones*/
set serveroutput on;

/*Los equipos deveran estar formados por 6 miembros como maximo*/
create or replace trigger introducirUsuario
after insert on jugador for each row
declare
t_nJugador jugador.nJugador%type;
t_nEquipo jugador.nEquipo%type;
t_sueldo jugador.sueldo%type;
t_nickname jugador.nickname%type;
t_maxjugador number := 7;
t_contador number;
begin
select count(nJugador) into t_contador
from jugador where nJugador=t_nJugador;
if t_contador < t_maxjugador
then commit;
else dbms_output.put_line('No se pueden introducir mas jugadores');
end if;
end;


   
    
/*El salario total del equipo no podra ser superior a 200000€*/
create or replace trigger validarSueldo
after insert on jugador for each row
declare 
tt_sueldo jugador.sueldo%type;
tt_suma number(6);
begin 
tt_suma := tt_suma + tt_sueldo;
if tt_suma < 200000
then commit;
else dbms_output.put_line('El sueldo total del equipo supera lo posible');
end if;
end;





/*La liga constara de nEquipos - 1 elevado al cuadrado jornadas*/
/* NO SE QUE DE INTRODUZCA VALOR DE SUSTITUCION*/
create or replace trigger numJornadas
after insert on nJornada for each row
declare 
tt_nEquipo equipo.nEquipo%type;
tt_nJornada nJornada jornada.nJornada&type;
tt_contador number(3);
tt_contadorJ number(3);
begin
select count(nEquipo) into tt_contador
from equipo where tt_nEquipo = nEquipo;
select count (nJornada) into tt_contadorJ
from jornada where tt_nJornada = nJornada;
if tt_contadorJ <= ((tt_contador-1)*2)
then commit;
else dbms_output.put_line('No puede haber mas jornadas');
end if;
end;

/*EMPEZAR A INSERTAR VALORES*/

