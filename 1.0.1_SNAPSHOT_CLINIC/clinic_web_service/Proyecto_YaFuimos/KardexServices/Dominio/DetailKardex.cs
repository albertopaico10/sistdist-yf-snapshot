﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Runtime.Serialization;

namespace KardexServices.Dominio
{
    [DataContract]
    public class DetailKardex
    {
        [DataMember]
        public int id { get; set; }
        [DataMember]
        public int idKardex { get; set; }
        [DataMember]
        public int cantidad { get; set; }
        [DataMember]
        public int typeOperation { get; set; }
        [DataMember]
        public int status { get; set; }
        [DataMember]
        public string comprobanteClase { get; set; }
        [DataMember]
        public string comprobanteNumber { get; set; }
        [DataMember]
        public decimal priceProduct { get; set; }
        [DataMember]
        public decimal priceSale{ get; set; }
       
    }
}