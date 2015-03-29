using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using KardexServices.Dominio;
using KardexServices.Response;
using MySql.Data.MySqlClient;

namespace KardexServices.Persistencia
{
    public class KardexDAO
    {
        public KardexResponse registrarKardex(Kardex beanKardex) {
            KardexResponse beanResponseKardex = new KardexResponse();
            string query = "insert into tb_Kardex (idProduct,priceKardex,countProduct,"+
            "status,total_egress,total_entry,description,priceTotalProduct,priceTotalSale) values (" +
            "@idProduct,@priceKardex,@countProduct,@status,@total_egress," +
            "@total_entry,@description,@priceTotalProduct,@priceTotalSale)";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            mysqlConnection.Open();
            try
            {
                mysqlCommand = mysqlConnection.CreateCommand();
                mysqlCommand.CommandText=query;              
                mysqlCommand.Parameters.AddWithValue("@idProduct",beanKardex.idProduct);
                mysqlCommand.Parameters.AddWithValue("@priceKardex", beanKardex.priceProductKardex);
                mysqlCommand.Parameters.AddWithValue("@countProduct", beanKardex.countProduct);
                mysqlCommand.Parameters.AddWithValue("@status", beanKardex.status);
                mysqlCommand.Parameters.AddWithValue("@total_entry", beanKardex.totalProductEntry);
                mysqlCommand.Parameters.AddWithValue("@total_egress", beanKardex.totalProductEgress);
                mysqlCommand.Parameters.AddWithValue("@description", beanKardex.description);
                mysqlCommand.Parameters.AddWithValue("@priceTotalProduct", beanKardex.priceTotalProduct);
                mysqlCommand.Parameters.AddWithValue("@priceTotalSale", beanKardex.priceTotalSale);
                mysqlCommand.ExecuteNonQuery();
                beanResponseKardex.result="SUCCESS";
            }
            catch (Exception e) { 
                beanResponseKardex.result="ERROR";
                beanResponseKardex.messages=e.Message;
            }
            return beanResponseKardex;
        }

        public KardexResponse findProductById(string idProduct)
        {
            KardexResponse beanResponseKardex = new KardexResponse();
            string query = "select * from tb_Kardex where idProduct=@idProduct";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            MySqlDataReader mysqlDataReader;

            mysqlConnection.Open();
            try
            {
                mysqlCommand = mysqlConnection.CreateCommand();
                mysqlCommand.CommandText = query;
                mysqlCommand.Parameters.AddWithValue("@idProduct", idProduct);

                mysqlDataReader = mysqlCommand.ExecuteReader();
                int cantidadRegistros = 0;
                while (mysqlDataReader.Read()) {
                    beanResponseKardex.id = mysqlDataReader.GetInt32(0);
                    cantidadRegistros++;
                }
                if (cantidadRegistros > 0)
                {
                    beanResponseKardex.result = "EXIST";
                }
                else {
                    beanResponseKardex.result = "NOT_EXIST";
                }
                
            }
            catch (Exception e)
            {
                beanResponseKardex.result = "ERROR";
                beanResponseKardex.messages = e.Message;
            }
            return beanResponseKardex;
        }

        public KardexResponse actualizarKardex(Kardex beanKardex)
        {
            KardexResponse beanResponseKardex = new KardexResponse();
            string query = "update tb_Kardex set "+
            "countProduct=@countProduct,total_entry=@total_entry,"+
            "total_egress=@total_egress,priceTotalProduct=@priceTotalProduct,priceTotalSale=@priceTotalSale"+
            " where id=@id";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            mysqlConnection.Open();
            try
            {
                mysqlCommand = mysqlConnection.CreateCommand();
                mysqlCommand.CommandText = query;
                mysqlCommand.Parameters.AddWithValue("@countProduct", beanKardex.countProduct);
                mysqlCommand.Parameters.AddWithValue("@total_entry", beanKardex.totalProductEntry);
                mysqlCommand.Parameters.AddWithValue("@total_egress", beanKardex.totalProductEgress);
                mysqlCommand.Parameters.AddWithValue("@priceTotalProduct", beanKardex.priceTotalProduct);
                mysqlCommand.Parameters.AddWithValue("@priceTotalSale", beanKardex.priceTotalSale);
                mysqlCommand.Parameters.AddWithValue("@id", beanKardex.id);
                
                mysqlCommand.ExecuteNonQuery();
                beanResponseKardex.result = "SUCCESS";
            }
            catch (Exception e)
            {
                beanResponseKardex.result = "ERROR";
                beanResponseKardex.messages = e.Message;
            }
            return beanResponseKardex;
        }
    
    }
}