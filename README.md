# Sistema de Gestión de Reuniones

Este proyecto da solución a la necesidad de implementar un sistema orientado a objetos para la gestión de reuniones, contemplando el registro de participantes, asistencias, retrasos, notas y generación de informes. Las reuniones pueden ser presenciales o virtuales, y los asistentes pueden ser empleados (aunque no necesariamente).

---
# Integrantes

- Ariel Fernandez – [@ArielFloo](https://github.com/ArielFloo)  
- Benjamin Lopez – [@FurioStyle](https://github.com/FurioStyle)  
- Kurt Koserak – [@koserak](https://github.com/koserak)

---

## Funcionalidad general del sistema

Nuestra implementación cumple con los siguientes objetivos:
- Crear reuniones con fecha, hora y duración prevista.
- Invitar personas individualmente o por departamento completo.
- Registrar asistencia (con detección de retraso) y notas durante la reunión.
- Calcular estadísticas de participación.
- Generar un informe .txt detallado con toda la información de la reunión.

---

## Estructura (muy generalmente hablando...)

- modelo/: contiene las clases del dominio (Empleado, Reunion, Invitacion, etc.).
- util/: clase Informe para generar reporte .txt.
- excepciones/: clases personalizadas para control de errores.
- test/: pruebas unitarias para validar comportamiento y excepciones.
- Main.java: flujo de uso demostrativo.

---

## Métodos y clases agregadas que no estaban en el UML:

### 1. invitarDepartamento(Departamento)
- El UML contempla que pueden invitarse personas (Invitable), pero no ofrecía una forma eficiente de invitar a todos los empleados de un área.
- Esta implementación facilita su utilidad sin romper el encapsulamiento ni modificar listas manualmente.
- Mejora la posible implementación a una escala mayor.

### 2. registrarAsistenciaDepartamento(Departamento)
- Permite marcar como presentes a todos los miembros de un departamento de forma controlada.
- Evita escribir múltiples líneas para empleados que ya fueron invitados por departamento.

### 3. Excepciones personalizadas:
- EmpleadoNoInvitadoException
- AsistenciaDuplicadaException
- ReunionNoIniciadaException


- La pauta exigía manejo de errores y consideramos que estas excepciones ayudan a mantener el sistema de pie frente a casos de desborde.
- Permiten detectar y evitar errores lógicos, como registrar asistencia de personas no invitadas o duplicadas.


### 4. Hora de llegada en retrasos (Retraso.getHoraLlegada())
- El UML no contemplaba detalles temporales de los retrasos.
- Incluir la hora exacta de llegada en el informe es útil para análisis de puntualidad.


Agregamos todos estos métodos y detalles adicionales para:
- Mejorar la usabilidad
- Respetar principios de diseño limpio y abierto a extensión
- Aportar realismo y utilidad práctica al sistema

Todas las adiciones fueron pensadas para complementar el modelo propuesto sin romper su lógica ni su estructura original. Creemos que estas mejoras fortalecen y enriquecen la solución planteada por el UML.
