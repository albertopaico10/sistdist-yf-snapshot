﻿using System;
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

        public KardexResponse findKardexProductById(string idProduct)
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
                    beanResponseKardex.countProduct = mysqlDataReader.GetInt32(3);
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
        public KardexResponse obtenerKardex(string idProduct)
        {
            KardexResponse beanResponseKardex = new KardexResponse();
            string query = "select k.id, p.nameProduct,pr.namePresentation,k.total_entry,k.total_egress,k.countProduct,k.priceTotalProduct,k.priceTotalSale " +
                            "from tb_kardex k,tb_product p, tb_presentation pr " + 
                            "where k.idProduct = p.id " + 
                            "and p.idPresentation = pr.id " + 
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
                int cantidadRegistros = 0;
                while (mysqlDataReader.Read())
                {
                    beanResponseKardex.id = mysqlDataReader.GetInt32(0);
                    beanResponseKardex.nameProduct = mysqlDataReader.GetString(1);
                    beanResponseKardex.namePresentation = mysqlDataReader.GetString(2);
                    beanResponseKardex.totalProductEntry = mysqlDataReader.GetInt32(3);
                    beanResponseKardex.totalProductEgress = mysqlDataReader.GetInt32(4);
                    beanResponseKardex.countProduct = mysqlDataReader.GetInt32(5);
                    beanResponseKardex.priceTotalProduct = mysqlDataReader.GetDecimal(6);
                    beanResponseKardex.priceTotalSale = mysqlDataReader.GetDecimal(7);
                    cantidadRegistros++;
                }
                if (cantidadRegistros > 0)
                {
                    beanResponseKardex.result = "EXIST";
                }
                else {
                    beanResponseKardex.result = "NOT_EXIST";
                }
                if (beanResponseKardex.countProduct < 5) {
                    beanResponseKardex.messages = "MINIMUN_PRODUCT";
                }

            }catch(Exception e){
                beanResponseKardex.result = "ERROR";
                beanResponseKardex.messages = e.Message;
            }

            return beanResponseKardex;

        }

    }
}