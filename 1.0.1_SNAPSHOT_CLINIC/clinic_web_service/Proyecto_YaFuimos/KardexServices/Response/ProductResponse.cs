using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace KardexServices.Response
{
    [DataContract]
    public class ProductResponse
    {
        [DataMember]
        public int id { get; set; }
        [DataMember]
        public string nameProduct { get; set; }
        [DataMember]
        public string namePresentation { get; set; }
        [DataMember]
        public int status { get; set; }
        [DataMember]
        public int idPresentation { get; set; }
        [DataMember]
        public decimal priceProduct { get; set; }
        [DataMember]
        public string dateCreated { get; set; }
        [DataMember]
        public decimal priceSale { get; set; }
        [DataMember]
        public string expirationDate { get; set; }
        [DataMember]
        public string result { get; set; }
        [DataMember]
        public string messages { get; set; }
    }
}