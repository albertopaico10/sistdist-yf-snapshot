using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace ProductoService.Dominio
{
    [DataContract]
    public class Kardex
    {
        [DataMember] 
        public int Id { get; set; }
        [DataMember]
        public int IdProduct { get; set; }
        [DataMember]
        public double PriceKardex { get; set; }
        [DataMember]
        public int CountProduct { get; set; }
        [DataMember]
        public int Status { get; set; }
        [DataMember]
        public int TotalEntry { get; set; }
        [DataMember]
        public int TotalEgress { get; set; }
        [DataMember]
        public String Description { get; set; }
        [DataMember]
        public DateTime DateCreated { get; set; }
        [DataMember]
        public double PriceTotalProducto { get; set; }
        [DataMember]
        public int MyProperty { get; set; }
        [DataMember]
        public double PriceTotalSale { get; set; }
        
    }
}