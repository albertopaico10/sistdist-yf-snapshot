using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using ProductoService.Dominio;

namespace ProductoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IPacientes" in both code and config file together.
    [ServiceContract]
    public interface IPacientes
    {
        [OperationContract]
        [FaultContract(typeof(MyExceptionContainer))]
        Paciente crearPaciente(string nombre, string apellido, string dni, DateTime birthDay, string direccion, string distrito, string status, string historiaClinicaId, DateTime createDate, DateTime updateDate, int userCreated, int userUpdated, int sexo, string nombreReferente, string telefonoReferente);
        [OperationContract]
        Paciente obtenerPaciente(int codigo);
        [OperationContract]
        Paciente ModificarPaciente(int codigo, string nombre, string apellido, string dni, DateTime birthDay, string direccion, string distrito, string status, string historiaClinicaId, DateTime createDate, DateTime updateDate, int userCreated, int userUpdated, int sexo, string nombreReferente, string telefonoReferente);
        [OperationContract]
        void EliminarPaciente(int codigo);
        [OperationContract]
        List<Paciente> ListarPacientes();
    }
}
