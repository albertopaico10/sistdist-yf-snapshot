using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using ProductoService.Dominio;
using System.Data.SqlClient;

namespace ProductoService.Persistencia
{
    public class KardexDAO
    {

        public Kardex CrearKardex(Kardex kardex)
        {
            Kardex nuevoKardex = null;
            string sql = "INSERT INTO t_alumno VALUES (@idProduct,@priceKardex,@countProduct,@status," +
            "@totalEntry,@totalEgress,@description,@dateCreated,@priceTotalProduct,@priceTotalSale)";
            string cadena = ConexionUtil.ObtenerCadena();
            using (SqlConnection con = new SqlConnection(cadena))
            {
          
                con.Open();
                using (SqlCommand com = new SqlCommand(sql, con))
                {
                    com.Parameters.Add(new SqlParameter("@idProduct", nuevoKardex.IdProduct));
                    com.Parameters.Add(new SqlParameter("@priceKardex", nuevoKardex.PriceKardex));
                    com.Parameters.Add(new SqlParameter("@countProduct", nuevoKardex.CountProduct));
                    com.Parameters.Add(new SqlParameter("@status", nuevoKardex.Status));
                    com.Parameters.Add(new SqlParameter("@totalEntry",nuevoKardex.TotalEntry));
                    com.Parameters.Add(new SqlParameter("@totalEgress", nuevoKardex.TotalEgress));
                    com.Parameters.Add(new SqlParameter("@description",nuevoKardex.Description ));
                    com.Parameters.Add(new SqlParameter("@dateCreated", nuevoKardex.DateCreated));
                    com.Parameters.Add(new SqlParameter("@priceTotalProduct",nuevoKardex.PriceTotalProducto));
                    com.Parameters.Add(new SqlParameter("@priceTotalSale", nuevoKardex.PriceTotalSale));
                    com.ExecuteNonQuery();
                }
            }
          
            return nuevoKardex;
        }

    }
}