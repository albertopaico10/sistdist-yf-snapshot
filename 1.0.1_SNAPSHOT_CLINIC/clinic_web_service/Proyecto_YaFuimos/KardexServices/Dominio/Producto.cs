using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace KardexServices.Dominio
{
    [DataContract]
    public class Producto
    {
        [DataMember]
        public int Id { get; set; }
        [DataMember]
        public string NameProduct { get; set; }
        [DataMember]
        public int Status { get; set; }
        [DataMember]
        public int IdPresentation { get; set; }
        [DataMember]
        public decimal PriceProduct { get; set; }
        [DataMember]
        public string DateCreated { get; set; }
        [DataMember]
        public decimal PriceSale { get; set; }
        [DataMember]
        public string ExpirationDate { get; set; }

    }
}