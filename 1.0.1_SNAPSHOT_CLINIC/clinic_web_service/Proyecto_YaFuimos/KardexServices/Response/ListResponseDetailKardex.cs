
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace KardexServices.Response
{
    [DataContract]
    public class ListResponseDetailKardex
    {
        [DataMember]
        public List<DetailKardexResponse> listDetailKardex { get; set; }
        [DataMember]
        public string result { get; set; }
        [DataMember]
        public string messages { get; set; }
    }
}