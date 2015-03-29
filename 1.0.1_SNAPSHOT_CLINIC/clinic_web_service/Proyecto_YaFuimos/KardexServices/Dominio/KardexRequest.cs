using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace KardexServices.Dominio
{
    [DataContract]
    public class KardexRequest
    {
        [DataMember]
        public int idProduct { get; set; }
        [DataMember]
        public int typeOperation { get; set; }
        [DataMember]
        public int countProduct { get; set; }
        [DataMember]
        public string comprobanteClase { get; set; }
        [DataMember]
        public int comprobanteNumber { get; set; }

    }
}