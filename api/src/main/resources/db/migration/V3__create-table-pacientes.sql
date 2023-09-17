CREATE TABLE pacientes(
                          id_paciente BIGINT NOT NULL AUTO_INCREMENT,
                          id_medico BIGINT NOT NULL, -- Tipo de dato añadido
                          nombre VARCHAR(100) NOT NULL,
                          apellido VARCHAR(100) NOT NULL UNIQUE,
                          documento VARCHAR(6) NOT NULL UNIQUE,
                          especialidad VARCHAR(100) NOT NULL,
                          calle VARCHAR(100) NOT NULL,
                          distrito VARCHAR(100) NOT NULL,
                          complemento VARCHAR(100),
                          numero VARCHAR(20),
                          ciudad VARCHAR(100) NOT NULL,

                          PRIMARY KEY (id_paciente), -- Corregido el nombre de la clave primaria
                          FOREIGN KEY (id_medico) REFERENCES medicos(id) -- Clave externa para relacionar con medicos
);
