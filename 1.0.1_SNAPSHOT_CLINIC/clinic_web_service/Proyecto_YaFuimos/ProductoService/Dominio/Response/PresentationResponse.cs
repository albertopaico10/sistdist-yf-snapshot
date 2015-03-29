using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace ProductoService.Dominio
{
    [DataContract]
    public class PresentationResponse
    {
        [DataMember]
        public int Id { get; set; }
        [DataMember]
        public string NamePresentation { get; set; }
        [DataMember]
        public int Status { get; set; }
        [DataMember]
        public string DateCreated { get; set; }
        [DataMember]
        public string Result { get; set; }
    }
}