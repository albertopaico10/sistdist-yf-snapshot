using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace KardexServices.Persistencia
{
    public class ConexionUtil
    {
        public static string ObtenerCadenaMysql
        {
            get{
                return "Server=localhost;Database=db_corazondejesus;User ID=root;Password=root";
            }
            
        }
    }
}