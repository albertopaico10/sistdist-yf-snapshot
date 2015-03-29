using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace ProductoService.Dominio
{
    [DataContract]
    public class DetalleKardex
    {
        [DataMember]
        public int Id { get; set; }
        [DataMember]
        public int IdKardex { get; set; }
        [DataMember]
        public int Cantidad { get; set; }
        [DataMember]
        public int TypeOperation { get; set; }
        [DataMember]
        public int Status { get; set; }
        [DataMember]
        public DateTime DateCreated { get; set; }
        [DataMember]
        public string ComprobanteClase { get; set; }
        [DataMember]
        public int ComprobanteNumber { get; set; }
        [DataMember]
        public double PriceProduct { get; set; }
        [DataMember]
        public double PriceSale { get; set; }

     }
}