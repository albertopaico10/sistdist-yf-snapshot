using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;
using System.Xml.Serialization;

namespace ProductoService.Dominio
{
    [DataContract]
    public class ListPresentation
    {
        [DataMember]
        public string strCadenaValues { get; set; }
        [DataMember]
        public string Result { get; set; }

    }
}