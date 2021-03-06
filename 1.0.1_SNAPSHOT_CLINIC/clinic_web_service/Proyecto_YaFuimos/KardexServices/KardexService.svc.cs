﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using KardexServices.Dominio;
using KardexServices.Response;
using KardexServices.Persistencia;
using System.Diagnostics;

namespace KardexServices
{
    public class KardexService : IKardexService
    {
        private KardexDAO dao = new KardexDAO();
        private DetailKardexDAO daoDetail = new DetailKardexDAO();
        private ProductoDAO daoProduct = new ProductoDAO();


        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : listarPresentacionObj
        //Description : This method was created for list all the presentation from DB
        public KardexResponse insertarKardex(Kardex beanRequest)
        {
            KardexResponse beanResponse=new KardexResponse();
            beanResponse = dao.registrarKardex(beanRequest);

            return beanResponse;
        }
        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : listarPresentacionObj
        //Description : This method was created for list all the presentation from DB
        public KardexResponse existProductKardex(string idProduct)
        {
            return dao.findKardexProductById(idProduct);
        }

        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : insertarDetail
        //Description : This method was created for list all the presentation from DB
        public DetailKardexResponse insertarDetail(DetailKardex beanRequest)
        {
            return daoDetail.saveDetailKardex(beanRequest);
        }

        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : insertarDetail
        //Description : This method was created for list all the presentation from DB
        public KardexResponse updateKardex(Kardex beanRequest)
        {
            return dao.actualizarKardex(beanRequest);
        }

        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : insertarDetail
        //Description : This method was created for list all the presentation from DB
        public KardexResponse registrarProcessKardex(KardexRequest beanRequest)
        {
            KardexResponse beanResponse = new KardexResponse();
            //--Find Product
            ProductResponse beanResponseProduct = daoProduct.findProductById(beanRequest.idProduct);
            //--Find Product in Kardex
            KardexResponse beanLocalKardexResponse = new KardexResponse();
            ////beanLocalKardexResponse = dao.findProductById(beanRequest.idProduct.ToString());
            
            Kardex beanKardexRequest = new Kardex();
            //beanKardexRequest.id = beanLocalKardexResponse.id;
            if (beanRequest.idKardex == null || beanRequest.idKardex == 0)
            { 
                //Set Values for Kardex
                
                beanKardexRequest.idProduct = beanRequest.idProduct;
                beanKardexRequest.priceProductKardex = 0;
                beanKardexRequest.countProduct = beanRequest.countProduct;
                beanKardexRequest.status = 1;
                beanKardexRequest.totalProductEntry = 0;
                beanKardexRequest.totalProductEgress = 0;
                beanKardexRequest.priceTotalProduct = beanRequest.countProduct*beanResponseProduct.priceProduct;
                beanKardexRequest.priceTotalSale = 0;
                beanResponse=dao.registrarKardex(beanKardexRequest);
            }
            if (beanResponse.result == "ERROR") {
                return beanResponse;
            }
            //--Recover IdKardex
            beanLocalKardexResponse = dao.findKardexProductById(beanRequest.idProduct.ToString());
            beanKardexRequest.id = beanLocalKardexResponse.id;
            //--Validate if Exist Product in Stock
            if (beanRequest.typeOperation == 2) {
                if (beanRequest.countProduct > beanLocalKardexResponse.countProduct)
                {
                    beanResponse.messages = "INSUFFICIENT_PRODUCT";
                    beanResponse.result = "SUCCESS";
                    return beanResponse;
                }
            }
           
            //--Insert int Detail Kardex
            DetailKardex beanDetailKardexRequest = new DetailKardex();
            beanDetailKardexRequest.idKardex = beanLocalKardexResponse.id;
            beanDetailKardexRequest.cantidad = beanRequest.countProduct;
            beanDetailKardexRequest.typeOperation = beanRequest.typeOperation;
            beanDetailKardexRequest.status = 1;
            beanDetailKardexRequest.comprobanteClase = beanRequest.comprobanteClase;
            beanDetailKardexRequest.comprobanteNumber = beanRequest.comprobanteNumber;
            beanDetailKardexRequest.priceProduct = beanResponseProduct.priceProduct;
            beanDetailKardexRequest.priceSale = beanResponseProduct.priceSale;

            DetailKardexResponse beanResponseDetailKardex = daoDetail.saveDetailKardex(beanDetailKardexRequest);
            
            int totalEntry = 0;
            int totalEgress = 0;
            int countTotalKardex=0;
            decimal priceTotalEntry = 0;
            decimal priceTotalEgress = 0;
            //-- Find Detail for update Master Kardex
            List<DetailKardexResponse> listDetailKardexResponse = daoDetail.listAllDetailKardex(beanLocalKardexResponse.id);
            foreach(DetailKardexResponse beanDetailKardexResponse in listDetailKardexResponse){
                if (beanDetailKardexResponse.typeOperation == 1)
                {
                    totalEntry += beanDetailKardexResponse.cantidad;
                    priceTotalEntry += beanDetailKardexResponse.priceProduct * beanDetailKardexResponse.cantidad;
                }
                else {
                    totalEgress += beanDetailKardexResponse.cantidad;
                    priceTotalEgress += beanDetailKardexResponse.priceSale * beanDetailKardexResponse.cantidad;
                }
            }
            countTotalKardex = totalEntry - totalEgress;
            //--Set Kardex for update
            beanKardexRequest.countProduct=countTotalKardex;
            beanKardexRequest.totalProductEntry=totalEntry;
            beanKardexRequest.totalProductEgress=totalEgress;
            beanKardexRequest.priceTotalProduct=priceTotalEntry;
            beanKardexRequest.priceTotalSale=priceTotalEgress;
            //--Update Master Kardex
            beanResponse = dao.actualizarKardex(beanKardexRequest);
            
            //--Last Validation RN_Minimun 5
            beanLocalKardexResponse = dao.findKardexProductById(beanRequest.idProduct.ToString());
            if (beanLocalKardexResponse.countProduct<5) {
                beanResponse.messages = "MINIMUN_PRODUCT";
            }
            return beanResponse;
        }

        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : findProductByName
        //Description : This method was created for list all the presentation from DB
        public ProductListResponse findProductByName(string nameProduct)
        {
            ProductListResponse beanResponseList = new ProductListResponse();
            List<ProductResponse> beanResponseListProduct = daoProduct.findProductPresentationByNameProduct(nameProduct);

            if (beanResponseListProduct.Count > 0)
            {
                ProductResponse last = beanResponseListProduct.Last();

                string response = "{" + "\"listResponseProduct\":[";

                foreach (ProductResponse beanResponseProduct in beanResponseListProduct)
                {
                    if (beanResponseProduct.Equals(last))
                    {
                        response = response + "{\"id\":" + beanResponseProduct.id + ",";
                        response = response + "\"nameProduct\":" + "\"" + beanResponseProduct.nameProduct + "\",";
                        response = response + "\"namePresentation\":" + "\"" + beanResponseProduct.namePresentation + "\",";
                        response = response + "\"priceSale\":" + "\"" + beanResponseProduct.priceSale + "\",";
                        response = response + "\"expirationDate\":" + "\"" + beanResponseProduct.expirationDate + "\"}";
                    }
                    else
                    {
                        response = response + "{\"id\":" + beanResponseProduct.id + ",";
                        response = response + "\"nameProduct\":" + "\"" + beanResponseProduct.nameProduct + "\",";
                        response = response + "\"namePresentation\":" + "\"" + beanResponseProduct.namePresentation + "\",";
                        response = response + "\"priceSale\":" + "\"" + beanResponseProduct.priceSale + "\",";
                        response = response + "\"expirationDate\":" + "\"" + beanResponseProduct.expirationDate + "\"},";
                    }
                }
                response = response + "]}";
                Debug.WriteLine("RESPONSE : ------->>  " + response);
                beanResponseList.listCadenaProduct = response;
                beanResponseList.result = "SUCCESS_LIST";
            }
            else {
                beanResponseList.result = "PRODUCT_NOT_EXIST";
            }
            
            return beanResponseList;
        }

        //Create by : César Quispe Carrión
        //Update by : César Quispe Carrión
        //Name : getKardex
        //Description : This method was created for get Kardex
        public KardexResponse getKardex(string idProduct)
        {
            return dao.obtenerKardex(idProduct);
        }


        //Create by : César Quispe Carrión
        //Update by : César Quispe Carrión
        //Name : getDetailKardex
        //Description : This method was created for get detail Kardex
        public ListResponseDetailKardex getDetailKardex(string idKardex)
        {
            return daoDetail.listarDetalleKardex(idKardex);
        }

        //Create by : Karina Espejo
        //Name : insertarProducto
        //Description : This method was created for creating a producto into database
        public ProductResponse insertarProducto(Product beanRequest)
        {
            ProductResponse beanResponse = new ProductResponse();
            Boolean value = daoProduct.ObtenerNombrePresentacion(beanRequest.nameProduct, beanRequest.idPresentation);

            if (value == true)
            {
                beanResponse.result = "PRODUCT_EXISTS";

                return beanResponse;
            }
            else {
                beanResponse = daoProduct.registrarProducto(beanRequest);
            }
            
            return beanResponse;
        }


        public ProductListResponse getProduct()
        {
            return daoProduct.listProduct();
        }

        public ProductResponse actualizarProducto(Product beanRequest)
        {
            return daoProduct.actualizarProducto(beanRequest);
        }

        public ProductResponse eliminarProducto(Product beanRequest)
        {
            return daoProduct.eliminarProducto(beanRequest);
        }
    }
}
