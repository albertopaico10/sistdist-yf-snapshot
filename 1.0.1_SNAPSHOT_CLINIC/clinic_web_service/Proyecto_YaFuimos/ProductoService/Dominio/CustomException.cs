using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace ProductoService.Dominio
{
    [DataContract]
    public class CustomException
    {
        [DataMember]
        public string Messsage { get; set; }
        [DataMember]
        public string Description { get; set; }
    }
}