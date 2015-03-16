using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ProductoService.Persistencia
{
    public class ConexionUtil
    {
        public static string ObtenerCadena()
        {
            return "Server=localhost;Database=db_corazondejesus;User ID=root;Password=karina";
        }
    }
}