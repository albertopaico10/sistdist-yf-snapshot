﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using MySql.Data.MySqlClient;
using KardexServices.Response;
using KardexServices.Dominio;

namespace KardexServices.Persistencia
{
    public class ProductoDAO
    {
        public ProductResponse findProductById(int idProduct)
        {
            ProductResponse beanResponseProducto = new ProductResponse();
            string query = "select * from tb_product where id=@idProduct and status = 1";

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
                    beanResponseProducto.id = mysqlDataReader.GetInt32(0);
                    beanResponseProducto.priceProduct = mysqlDataReader.GetDecimal(4);
                    beanResponseProducto.priceSale = mysqlDataReader.GetDecimal(6);
                }
            }
            catch (Exception e)
            {
                beanResponseProducto.result = "ERROR";
                beanResponseProducto.messages = e.Message;
            }
            return beanResponseProducto;
        }

        public List<ProductResponse> findProductPresentationByNameProduct(string nameProduct)
        {
            List<ProductResponse> listResponseProduct = new List<ProductResponse>();
            
            string query = "select prod.id,nameProduct,namePresentation,price_sale,expiration_date "+
                "from tb_product prod inner join tb_presentation pre on prod.idPresentation=pre.id "+
                "where nameProduct like @nameProduct and prod.status = 1";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            MySqlDataReader mysqlDataReader;

            mysqlConnection.Open();
            
            mysqlCommand = mysqlConnection.CreateCommand();
            mysqlCommand.CommandText = query;
            mysqlCommand.Parameters.AddWithValue("@nameProduct", "%" + nameProduct+"%" );

            mysqlDataReader = mysqlCommand.ExecuteReader();
                
            while (mysqlDataReader.Read())
            {
                ProductResponse beanResponseProducto = new ProductResponse();
                beanResponseProducto.id = mysqlDataReader.GetInt32(0);
                beanResponseProducto.nameProduct = mysqlDataReader.GetString(1);
                beanResponseProducto.namePresentation = mysqlDataReader.GetString(2);
                beanResponseProducto.priceSale = mysqlDataReader.GetDecimal(3);
                beanResponseProducto.expirationDate = mysqlDataReader.GetString(4);
                listResponseProduct.Add(beanResponseProducto);
            }
           
            return listResponseProduct;
        }

        public ProductResponse registrarProducto(Product beanProducto)
        {
            ProductResponse beanResponseProducto = new ProductResponse();
            string query = "insert into tb_product (nameProduct,status,idPresentation," +
            "price_Product,date_created,price_sale,expiration_date) values (" +
            "@nameProduct,@status,@idPresentation,@price_Product,@date_created," +
            "@price_sale,@expiration_date)";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            mysqlConnection.Open();
            try
            {
                mysqlCommand = mysqlConnection.CreateCommand();
                mysqlCommand.CommandText = query;
                mysqlCommand.Parameters.AddWithValue("@nameProduct", beanProducto.NameProduct);
                mysqlCommand.Parameters.AddWithValue("@status", beanProducto.Status);
                mysqlCommand.Parameters.AddWithValue("@idPresentation", beanProducto.IdPresentation);
                mysqlCommand.Parameters.AddWithValue("@price_Product", beanProducto.PriceProduct);
                mysqlCommand.Parameters.AddWithValue("@date_created", beanProducto.DateCreated);
                mysqlCommand.Parameters.AddWithValue("@price_sale", beanProducto.PriceSale);
                mysqlCommand.Parameters.AddWithValue("@expiration_date", beanProducto.ExpirationDate);
                mysqlCommand.ExecuteNonQuery();
                beanResponseProducto.result = "SUCCESS";
            }
            catch (Exception e)
            {
                beanResponseProducto.result = "ERROR";
                beanResponseProducto.messages = e.Message;
            }
            return beanResponseProducto;
        }
    }
}