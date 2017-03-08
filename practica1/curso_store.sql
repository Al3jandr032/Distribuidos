
DELIMITER $$
CREATE PROCEDURE AsignacionCreate(IN _id_alumno INT,IN _id_curso date ,IN _horario VARCHAR(50) ,IN _tipo INT)
BEGIN
   insert into practica1.Asignacion (id_alumno,id_curso,horario,tipoCurso)
	values (_id_alumno,_id_curso,_horario,_tipo);
END $$
DELIMITER ;
 
DELIMITER $$
CREATE PROCEDURE AsignacionDelete(IN  _id INT)
BEGIN
   DELETE FROM Asignacion WHERE id_Asignacion = _id;
END $$
DELIMITER ;
 
DELIMITER $$
CREATE PROCEDURE AsignacionUpdate(IN  _id INT,IN _nombre VARCHAR(50),IN _paterno VARCHAR(50),IN _materno VARCHAR(50),IN _email VARCHAR(50)
,IN _calle VARCHAR(50),IN _numero VARCHAR(50),IN _colonia VARCHAR(50),IN _delegacion VARCHAR(50),
IN _entidad VARCHAR(50),IN _noTelefono VARCHAR(50))
BEGIN
   UPDATE Asignacion SET nombre=_nombre,paterno=_paterno,materno=_materno,email=_email,calle=_calle,numero=_numero,
	colonia=_colonia,delegacion=_delegacion,entidad=_entidad,noTelefono=_noTelefono
	WHERE id_Asignacion = _id;
END $$
DELIMITER ;
 
DELIMITER $$
CREATE PROCEDURE AsignacionFind(IN  _id INT)
BEGIN
   SELECT * FROM Asignacion WHERE id_Asignacion = _id;
END $$
DELIMITER ;
DELIMITER $$
CREATE PROCEDURE AsignacionSelectAll()
BEGIN
   SELECT * FROM Asignacion; 
END $$
DELIMITER ;