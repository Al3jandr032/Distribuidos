SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `practica1` DEFAULT CHARACTER SET latin1 ;
USE `practica1` ;

-- -----------------------------------------------------
-- Table `practica1`.`Alumno`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practica1`.`Alumno` ;

CREATE TABLE IF NOT EXISTS `practica1`.`Alumno` (
  `id_Alumno` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(65) NOT NULL,
  `paterno` VARCHAR(65) NOT NULL,
  `materno` VARCHAR(65) NOT NULL,
  `email` VARCHAR(65) NOT NULL,
  `calle` VARCHAR(65) NOT NULL,
  `numero` VARCHAR(65) NOT NULL,
  `colonia` VARCHAR(65) NOT NULL,
  `delegacion` VARCHAR(65) NOT NULL,
  `entidad` VARCHAR(65) NOT NULL,
  `noTelefono` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id_Alumno`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `practica1`.`Curso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practica1`.`Curso` ;

CREATE TABLE IF NOT EXISTS `practica1`.`Curso` (
  `id_Curso` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(65) NOT NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NOT NULL,
  `coutaDeRecuperacion` DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (`id_Curso`))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `practica1`.`Asignacion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `practica1`.`Asignacion` ;

CREATE TABLE IF NOT EXISTS `practica1`.`Asignacion` (
  `id_Alumno` INT(11) NOT NULL,
  `id_Curso` INT(11) NOT NULL,
  `horario` VARCHAR(65) NOT NULL,
  `tipoCurso` INT(11) NOT NULL,
  PRIMARY KEY (`id_Alumno`, `id_Curso`),
  INDEX `id_Curso` (`id_Curso` ASC),
  CONSTRAINT `Asignacion_ibfk_1`
    FOREIGN KEY (`id_Alumno`)
    REFERENCES `practica1`.`Alumno` (`id_Alumno`),
  CONSTRAINT `Asignacion_ibfk_2`
    FOREIGN KEY (`id_Curso`)
    REFERENCES `practica1`.`Curso` (`id_Curso`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

USE `practica1` ;

-- -----------------------------------------------------
-- procedure AsignacionCreate
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`AsignacionCreate`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `AsignacionCreate`(IN _id_alumno INT,IN _id_curso INT ,IN _horario VARCHAR(50) ,IN _tipo INT)
BEGIN
   insert into Asignacion (id_alumno,id_curso,horario,tipoCurso)
	values (_id_alumno,_id_curso,_horario,_tipo);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure AsignacionDelete
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`AsignacionDelete`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `AsignacionDelete`(IN _id_alumno INT  )
BEGIN
   DELETE FROM Asignacion WHERE id_alumno  = _id_alumno ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure AsignacionDeleteCurso
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`AsignacionDeleteCurso`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `AsignacionDeleteCurso`(IN _id_curso INT  )
BEGIN
   DELETE FROM Asignacion WHERE  id_curso=_id_curso;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure AsignacionFind
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`AsignacionFind`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `AsignacionFind`(IN _id_alumno INT,IN _id_curso INT)
BEGIN
   SELECT * FROM Asignacion WHERE id_Alumno=_id_alumno and id_Curso=_id_curso;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure AsignacionSelectAll
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`AsignacionSelectAll`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `AsignacionSelectAll`()
BEGIN
   SELECT * FROM Asignacion; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure AsignacionUpdate
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`AsignacionUpdate`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `AsignacionUpdate`(IN _id_alumno INT,IN _id_curso INT ,IN _horario VARCHAR(50) ,IN _tipo INT)
BEGIN
   UPDATE Asignacion SET horario=_horario, tipoCurso=_tipo WHERE id_Alumno=_id_alumno and id_Curso=_id_curso;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure alumnoCreate
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`alumnoCreate`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `alumnoCreate`(IN _nombre VARCHAR(50),IN _paterno VARCHAR(50),IN _materno VARCHAR(50),IN _email VARCHAR(50)
,IN _calle VARCHAR(50),IN _numero VARCHAR(50),IN _colonia VARCHAR(50),IN _delegacion VARCHAR(50),
IN _entidad VARCHAR(50),IN _noTelefono VARCHAR(50))
BEGIN
   insert into Alumno (nombre,paterno,materno,email,calle,numero,colonia,delegacion,entidad,noTelefono)
values (_nombre,_paterno,_materno,_email,_calle,_numero,_colonia,_delegacion,_entidad,_noTelefono);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure alumnoDelete
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`alumnoDelete`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `alumnoDelete`(IN  _id INT)
BEGIN
   DELETE FROM Alumno WHERE id_Alumno = _id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure alumnoFind
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`alumnoFind`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `alumnoFind`(IN  _id INT)
BEGIN
   SELECT * FROM Alumno WHERE id_Alumno = _id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure alumnoSelectAll
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`alumnoSelectAll`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `alumnoSelectAll`()
BEGIN
   SELECT * FROM Alumno; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure alumnoUpdate
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`alumnoUpdate`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `alumnoUpdate`(IN  _id INT,IN _nombre VARCHAR(50),IN _paterno VARCHAR(50),IN _materno VARCHAR(50),IN _email VARCHAR(50)
,IN _calle VARCHAR(50),IN _numero VARCHAR(50),IN _colonia VARCHAR(50),IN _delegacion VARCHAR(50),
IN _entidad VARCHAR(50),IN _noTelefono VARCHAR(50))
BEGIN
   UPDATE Alumno SET nombre=_nombre,paterno=_paterno,materno=_materno,email=_email,calle=_calle,numero=_numero,
	colonia=_colonia,delegacion=_delegacion,entidad=_entidad,noTelefono=_noTelefono
	WHERE id_Alumno = _id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure cursoCreate
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`cursoCreate`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `cursoCreate`(IN _nombre VARCHAR(50),IN _fechaInicio date ,IN _fechaFin date ,IN _coutaDeRecuperacion DECIMAL(10,2))
BEGIN
   insert into Curso (nombre,paterno,materno,email,calle,numero,colonia,delegacion,entidad,noTelefono)
values (_nombre,_paterno,_materno,_email,_calle,_numero,_colonia,_delegacion,_entidad,_noTelefono);
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure cursoDelete
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`cursoDelete`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `cursoDelete`(IN  _id INT)
BEGIN
   DELETE FROM Curso WHERE id_Curso = _id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure cursoFind
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`cursoFind`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `cursoFind`(IN  _id INT)
BEGIN
   SELECT * FROM Curso WHERE id_Curso = _id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure cursoSelectAll
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`cursoSelectAll`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `cursoSelectAll`()
BEGIN
   SELECT * FROM Curso; 
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure cursoUpdate
-- -----------------------------------------------------

USE `practica1`;
DROP procedure IF EXISTS `practica1`.`cursoUpdate`;

DELIMITER $$
USE `practica1`$$
CREATE DEFINER=`debian`@`%` PROCEDURE `cursoUpdate`(IN  _id INT,IN _nombre VARCHAR(50),IN _paterno VARCHAR(50),IN _materno VARCHAR(50),IN _email VARCHAR(50)
,IN _calle VARCHAR(50),IN _numero VARCHAR(50),IN _colonia VARCHAR(50),IN _delegacion VARCHAR(50),
IN _entidad VARCHAR(50),IN _noTelefono VARCHAR(50))
BEGIN
   UPDATE Curso SET nombre=_nombre,paterno=_paterno,materno=_materno,email=_email,calle=_calle,numero=_numero,
	colonia=_colonia,delegacion=_delegacion,entidad=_entidad,noTelefono=_noTelefono
	WHERE id_Curso = _id;
END$$

DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
