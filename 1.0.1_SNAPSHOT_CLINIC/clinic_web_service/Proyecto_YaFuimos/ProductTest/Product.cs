using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace ProductTest
{
    public class Product
    {

        public int Id { get; set; }
      
        public string NameProduct { get; set; }
      
        public int Status { get; set; }
      
        public int IdPresentation { get; set; }

        public decimal PriceProduct { get; set; }
     
        public string DateCreated { get; set; }
   
        public decimal PriceSale { get; set; }
     
        public string ExpirationDate { get; set; }

    }
}
