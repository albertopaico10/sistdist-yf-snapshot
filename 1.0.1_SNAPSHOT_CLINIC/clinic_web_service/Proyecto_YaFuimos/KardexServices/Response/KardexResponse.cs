using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace KardexServices.Response
{
    [DataContract]
    public class KardexResponse
    {
        [DataMember]
        public int id { get; set; }
        [DataMember]
        public int idProduct { get; set; }
        [DataMember]
        public decimal priceProductKardex { get; set; }
        [DataMember]
        public int countProduct { get; set; }
        [DataMember]
        public int status { get; set; }
        [DataMember]
        public int totalProductEntry { get; set; }
        [DataMember]
        public int totalProductEgress { get; set; }
        [DataMember]
        public string description { get; set; }
        [DataMember]
        public string dateCreated { get; set; }
        [DataMember]
        public decimal priceTotalProduct { get; set; }
        [DataMember]
        public decimal priceTotalSale { get; set; }
        [DataMember]
        public string result { get; set; }
        [DataMember]
        public string messages { get; set; }
    }
}