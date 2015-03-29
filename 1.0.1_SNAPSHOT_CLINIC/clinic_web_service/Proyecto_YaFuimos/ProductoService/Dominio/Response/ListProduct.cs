using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace ProductoService.Dominio.Response
{
    [DataContract]
    public class ListProduct
    {
        [DataMember]
        public string strCadenaValues { get; set; }
        [DataMember]
        public string Result { get; set; }
    }
}