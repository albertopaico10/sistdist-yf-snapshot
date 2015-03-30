using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using KardexServices.Dominio;
using KardexServices.Response;
using MySql.Data.MySqlClient;
using System.Data;

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

        //Método para obtener un Kardex de acuerdo a un producto
        public KardexResponse obtenerKardex(int idProduct)
        {
            KardexResponse beanResponseKardex = new KardexResponse();
            string query = "select k.id, p.nameProduct,pr.namePresentation,k.total_entry,k.total_egress,k.countProduct" +
                            "from tb_kardex k,tb_product p, tb_presentation pr" + 
                            "where k.idProduct = p.id" + 
                            "and p.idPresentation = pr.id" + 
                            "and p.id = @idProduct";

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

                while (mysqlDataReader.Read())
                {
                    beanResponseKardex.id = mysqlDataReader.GetInt32(0);
                    beanResponseKardex.nameProduct = mysqlDataReader.GetString(1);
                    beanResponseKardex.namePresentation = mysqlDataReader.GetString(2);
                    beanResponseKardex.totalProductEntry = mysqlDataReader.GetInt32(3);
                    beanResponseKardex.totalProductEgress = mysqlDataReader.GetInt32(4);
                    beanResponseKardex.countProduct = mysqlDataReader.GetInt32(5);
                }


            }catch(Exception e){
                beanResponseKardex.result = "ERROR";
                beanResponseKardex.messages = e.Message;
            }

            return beanResponseKardex;

        }

        //Método para obtener el detalle de un kardex enviando el código de kardex
        public List<DetailKardexResponse> listarDetalleKardex(int idKardex)
        {
            List<DetailKardexResponse> listaDetalleKardex = new List<DetailKardexResponse>();
            DetailKardexResponse detalleKardex = new DetailKardexResponse();
            string query = "select id,cantidad,typeOperation,date_created,comprobante_clase,comprobante_number,price_sale" +
                            "from tb_detail_kardex" +
                            "where idKardex = @idKardex";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);
            MySqlCommand mysqlCommand;
            MySqlDataReader mysqlDataReader;

            mysqlConnection.Open();

            try{

                mysqlCommand = mysqlConnection.CreateCommand();
                mysqlCommand.CommandText = query;
                mysqlCommand.Parameters.AddWithValue("@idKardex", idKardex);

                mysqlDataReader = mysqlCommand.ExecuteReader();

                while (mysqlDataReader.Read())
                {
                    detalleKardex.id = mysqlDataReader.GetInt32(0);
                    detalleKardex.cantidad = mysqlDataReader.GetInt32(1);
                    detalleKardex.typeOperation = mysqlDataReader.GetInt32(2);
                    detalleKardex.dateCreated = mysqlDataReader.GetDateTime(3);
                    detalleKardex.comprobanteClase = mysqlDataReader.GetString(4);
                    detalleKardex.comprobanteNumber = mysqlDataReader.GetInt32(5);
                    detalleKardex.priceSale = mysqlDataReader.GetDecimal(6);
                    listaDetalleKardex.Add(detalleKardex);
                }

            }catch(Exception e){

                detalleKardex.result = "ERROR";
                detalleKardex.messages = e.Message;
            }

            return listaDetalleKardex;
            
        }


    
    }
}