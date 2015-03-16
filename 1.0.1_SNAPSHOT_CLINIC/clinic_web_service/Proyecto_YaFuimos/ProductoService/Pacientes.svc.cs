using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using ProductoService.Dominio;
using ProductoService.Persistencia;

namespace ProductoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "Pacientes" in code, svc and config file together.
    public class Pacientes : IPacientes
    {
        private PacienteDAO pacienteDao = null;
        private PacienteDAO PacienteDao
        {
            get
            {
                if (pacienteDao == null)
                    pacienteDao = new PacienteDAO();
                return pacienteDao;
            }
        }


        public Dominio.Paciente crearPaciente(string nombre, string apellido, string dni, DateTime birthDay, string direccion,
            string distrito, string status, string historiaClinicaId, DateTime createDate, DateTime updateDate, int userCreated,
            int userUpdated, int sexo, string nombreReferente, string telefonoReferente)
        {
            Paciente pacienteNuevo = new Paciente
            {
                Nombre = nombre,
                Apellido = apellido,
                Dni = dni,
                BirthDay = birthDay,
                Direccion = direccion,
                Distrito = distrito,
                Status = status,
                HistoriaClinidaId = historiaClinicaId,
                CreatedDate = createDate,
                UpdatedDate = updateDate,
                UserCreated = userCreated,
                UserUpdated = userUpdated,
                Sexo = sexo,
                NombreReferencia = nombreReferente,
                TelefonoReferencia = telefonoReferente
            };

            return PacienteDao.Crear(pacienteNuevo);
        }

        public Dominio.Paciente obtenerPaciente(int codigo)
        {
            return PacienteDao.Obtener(codigo);
        }

        public Dominio.Paciente ModificarPaciente(int codigo, string nombre, string apellido, string dni, DateTime birthDay, string direccion, string distrito, string status, string historiaClinicaId, DateTime createDate, DateTime updateDate, int userCreated, int userUpdated, int sexo, string nombreReferente, string telefonoReferente)
        {
            Paciente pacienteNuevo = new Paciente
            {
                Codigo = codigo,
                Nombre = nombre,
                Apellido = apellido,
                Dni = dni,
                BirthDay = birthDay,
                Direccion = direccion,
                Distrito = distrito,
                Status = status,
                HistoriaClinidaId = historiaClinicaId,
                CreatedDate = createDate,
                UpdatedDate = updateDate,
                UserCreated = userCreated,
                UserUpdated = userUpdated,
                Sexo = sexo,
                NombreReferencia = nombreReferente,
                TelefonoReferencia = telefonoReferente
            };

            return PacienteDao.Modificar(pacienteNuevo);
        }

        public void EliminarPaciente(int codigo)
        {
            Paciente pacienteEliminar = PacienteDao.Obtener(codigo);
            PacienteDao.Eliminar(pacienteEliminar);
        }

        public List<Dominio.Paciente> ListarSesores()
        {
            return PacienteDao.ListarTodos().ToList();
        }
    }
}
