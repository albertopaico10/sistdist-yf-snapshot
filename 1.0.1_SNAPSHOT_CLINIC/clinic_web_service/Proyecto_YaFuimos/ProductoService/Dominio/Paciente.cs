using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace ProductoService.Dominio
{
    [DataContract]
    public class Paciente
    {

        [DataMember]
        public int Codigo { get; set; }
        [DataMember]
        public string Nombre { get; set; }
        [DataMember]
        public string Apellido { get; set; }
        [DataMember]
        public string Dni { get; set; }
        [DataMember]
        public DateTime BirthDay { get; set; }
        [DataMember]
        public string Direccion { get; set; }
        [DataMember]
        public string Distrito { get; set; }
        [DataMember]
        public string Status { get; set; }
        [DataMember]
        public string HistoriaClinidaId { get; set; }
        [DataMember]
        public DateTime CreatedDate { get; set; }
        [DataMember]
        public DateTime UpdatedDate { get; set; }
        [DataMember]
        public int UserCreated { get; set; }
        [DataMember]
        public int UserUpdated { get; set; }
        [DataMember]
        public int Sexo { get; set; }
        [DataMember]
        public string NombreReferencia { get; set; }
        [DataMember]
        public string TelefonoReferencia { get; set; }

    }
}