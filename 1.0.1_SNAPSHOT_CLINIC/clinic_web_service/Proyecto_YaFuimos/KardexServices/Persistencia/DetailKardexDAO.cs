﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using KardexServices.Response;
using KardexServices.Dominio;
using MySql.Data.MySqlClient;

namespace KardexServices.Persistencia
{
    public class DetailKardexDAO
    {
        public DetailKardexResponse saveDetailKardex(DetailKardex beanDetailKardex) {
            DetailKardexResponse beanResponseDetailKardex = new DetailKardexResponse();
            string query = "insert into tb_detail_kardex (idKardex,cantidad,typeOperation," +
            "status,comprobante_clase,comprobante_number,price_Product,price_sale) values (" +
            "@idKardex,@cantidad,@typeOperation,@status,@comprobante_clase," +
            "@comprobante_number,@price_Product,@price_sale)";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            mysqlConnection.Open();
            try
            {
                mysqlCommand = mysqlConnection.CreateCommand();
                mysqlCommand.CommandText = query;
                mysqlCommand.Parameters.AddWithValue("@idKardex", beanDetailKardex.idKardex);
                mysqlCommand.Parameters.AddWithValue("@cantidad", beanDetailKardex.cantidad);
                mysqlCommand.Parameters.AddWithValue("@typeOperation", beanDetailKardex.typeOperation);
                mysqlCommand.Parameters.AddWithValue("@status", beanDetailKardex.status);
                mysqlCommand.Parameters.AddWithValue("@comprobante_clase", beanDetailKardex.comprobanteClase);
                mysqlCommand.Parameters.AddWithValue("@comprobante_number", beanDetailKardex.comprobanteNumber);
                mysqlCommand.Parameters.AddWithValue("@price_Product", beanDetailKardex.priceProduct);
                mysqlCommand.Parameters.AddWithValue("@price_sale", beanDetailKardex.priceSale);
                mysqlCommand.ExecuteNonQuery();
                beanResponseDetailKardex.result = "SUCCESS";
            }
            catch (Exception e)
            {
                beanResponseDetailKardex.result = "ERROR";
                beanResponseDetailKardex.messages = e.Message;
            }

            return beanResponseDetailKardex;

        }

        public List<DetailKardexResponse> listAllDetailKardex(int idKardex)
        {
            
            string query = "select * from tb_detail_kardex where idKardex=@idKardex and status=1";

            MySqlConnection mysqlConnection = new MySqlConnection(ConexionUtil.ObtenerCadenaMysql);

            MySqlCommand mysqlCommand;

            MySqlDataReader mysqlDataReader;

            mysqlConnection.Open();
            
            mysqlCommand = mysqlConnection.CreateCommand();
            mysqlCommand.CommandText = query;
            mysqlCommand.Parameters.AddWithValue("@idKardex", idKardex);

            mysqlDataReader = mysqlCommand.ExecuteReader();
            List<DetailKardexResponse> listDetailKardex = new List<DetailKardexResponse>();
            while (mysqlDataReader.Read())
            {
                DetailKardexResponse beanResponseKardex = new DetailKardexResponse();
                beanResponseKardex.id = mysqlDataReader.GetInt32(0);
                beanResponseKardex.idKardex = mysqlDataReader.GetInt32(1);
                beanResponseKardex.cantidad = mysqlDataReader.GetInt32(2);
                beanResponseKardex.typeOperation = mysqlDataReader.GetInt32(3);
                beanResponseKardex.status = mysqlDataReader.GetInt32(4);
                beanResponseKardex.priceProduct = mysqlDataReader.GetDecimal(8);
                beanResponseKardex.priceSale = mysqlDataReader.GetDecimal(9);
                listDetailKardex.Add(beanResponseKardex);
            }

            return listDetailKardex;
        }
    }
}