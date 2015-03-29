using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using ProductoService.Persistencia;
using System.Diagnostics;
using ProductoService.Dominio;
using ProductoService.Dominio.Response;

namespace ProductoService
{
    public class Producto : IProducto
    {
        private ProductoDAO productoDAO = null;
        private ProductoDAO ProductoDAO
        {
            get
            {
                if (productoDAO == null)
                    productoDAO = new ProductoDAO();
                return productoDAO;
            }
        }
        private PresentationDAO presentationDAO = null;
        private PresentationDAO PresentationDAO
        {
            get
            {
                if (presentationDAO == null)
                    presentationDAO = new PresentationDAO();
                return presentationDAO;
            }
        }

        public int crearProducto(string nameProduct, int status, int idPresentacion,
                                      decimal priceProduct, string dateCreated, decimal priceSale,
                                      string expirationDate)
        {
            Debug.WriteLine("NAME PRODUCT : "+nameProduct);
            Console.WriteLine("HHHHHHHH");
            ProductoService.Dominio.Producto productoNuevo = new ProductoService.Dominio.Producto()
            {
                NameProduct = nameProduct,
                Status = status,
                IdPresentation = idPresentacion,
                PriceProduct = priceProduct,
                DateCreated = dateCreated,
                PriceSale = priceSale,
                ExpirationDate = expirationDate
            };
            ProductoDAO.Crear(productoNuevo);
            return 1;
        }

        public Boolean validarExistenciaProducto(int idPresentacion, string nombreProduct)
        {
            return false;
        }

        //Create by : Karina
        //Update by : ------
        //Name : consultarProducto
        //Description : Return a Object from Product
        public Dominio.Producto consultarProducto(int id)
        {
            return ProductoDAO.Obtener(id);
        }

        //Create by : Alberto Paico
        //Update by : Alberto Paico
        //Name : consultarProductoPorNombre
        //Description : Return a Object from Product by Product
        //public ListProduct consultarProductoPorNombre(string name)
        //{
        //    ListProduct beanListProduct = new ListProduct();
        //    try
        //    {
        //        ICollection<ProductoService.Dominio.Producto> iCollectionProducto = ProductoDAO.ObtenerProductByName(name);
        //        Debug.WriteLine("Cantidad de Datos DEBUG: " + iCollectionProducto.Count);
        //    }
        //    catch { 
            
        //    }
        //    return null;
        //}

        //Create by : Cesar
        //Update by : Alberto Paico
        //Name : crearPresentacion
        //Description : This method was created for save all the presentation in DB
        public PresentationResponse crearPresentacion(string namePresentation)
        {
            PresentationResponse presentationResponse= new PresentationResponse();
            try{
                Presentation presentacionNueva = new ProductoService.Dominio.Presentation()
                {
                    NamePresentation = namePresentation,
                    Status = 1
                };
                PresentationDAO.Crear(presentacionNueva);
                presentationResponse.Id=presentacionNueva.Id;
                presentationResponse.NamePresentation=presentacionNueva.NamePresentation;
                presentationResponse.Status=presentacionNueva.Status;
                presentationResponse.DateCreated=presentacionNueva.DateCreated;
                presentationResponse.Result="SUCCESS";
            }
            catch {
                presentationResponse.Result="ERROR";
            }

            return presentationResponse;
        }
        //Create by : Cesar
        //Update by : Alberto Paico
        //Name : consultarPresentacionObj
        //Description : This method was created for save all the presentation in DB
        public PresentationResponse consultarPresentacionObj(int idPresentacion)
        {
            PresentationResponse presentationResponse = new PresentationResponse();
            try
            {
                Presentation beanPresentation = PresentationDAO.Obtener(idPresentacion);
                presentationResponse.Id = beanPresentation.Id;
                presentationResponse.NamePresentation = beanPresentation.NamePresentation;
                presentationResponse.Status = beanPresentation.Status;
                presentationResponse.DateCreated = beanPresentation.DateCreated;
                presentationResponse.Result = "SUCCESS";
            }
            catch
            {
                presentationResponse.Result = "ERROR";
            }

            return presentationResponse;
        }

        //Create by : Cesar
        //Update by : Alberto Paico
        //Name : listarPresentacionObj
        //Description : This method was created for list all the presentation from DB
        public ListPresentation listarPresentacionObj()
        {
            ListPresentation beanListPresentation = new ListPresentation();
            try
            {
                ICollection<Presentation> iCollectionPresentation = PresentationDAO.ListarTodosStatusActive("Presentation");
                Debug.WriteLine("Cantidad de Datos DEBUG: " + iCollectionPresentation.Count);
                Console.WriteLine("Cantidad de Datos : " + iCollectionPresentation.Count);

                List<PresentationResponse> listBeanResponse = new List<PresentationResponse>();
                string response = "{"+"\"response\":[";
                Presentation last=iCollectionPresentation.Last();
                foreach (Presentation beanPresentation in iCollectionPresentation)
                {
                    //--El Ultimo valor
                    if (beanPresentation.Equals(last))
                    {
                        response = response + "{\"Id\":" + beanPresentation.Id + ",";
                        response = response + "\"NamePresentation\":" + "\"" + beanPresentation.NamePresentation + "\",";
                        response = response + "\"Status\":" + beanPresentation.Status + ",";
                        response = response + "\"DateCreated\":" + "\"" + beanPresentation.DateCreated + "\"}";
                        Debug.WriteLine("Datos :  " + beanPresentation.Id + "**** " + beanPresentation.NamePresentation);
                    }
                    else {
                        response = response + "{\"Id\":" + beanPresentation.Id + ",";
                        response = response + "\"NamePresentation\":" + "\"" + beanPresentation.NamePresentation + "\",";
                        response = response + "\"Status\":" + beanPresentation.Status + ",";
                        response = response + "\"DateCreated\":" + "\"" + beanPresentation.DateCreated + "\"},";
                    }
                   
                    Debug.WriteLine("Datos :  " + beanPresentation.Id + "**** " + beanPresentation.NamePresentation);
                }

                response = response + "]}";
                Debug.WriteLine("RESPONSE : ------->>  " + response);
                beanListPresentation.strCadenaValues = response;
                beanListPresentation.Result = "SUCCESS";
            }
            catch {
                beanListPresentation.Result = "ERROR";
            }
            return beanListPresentation;
        }


        //Create by : Cesar
        //Update by : Alberto Paico
        //Name : crearPresentacion
        //Description : This method was created for save all the presentation in DB
        public PresentationResponse actualizarPresentacion(string namePresentation, int status, 
                                            string dateCreated, int idPresentation)
        {
            PresentationResponse presentationResponse = new PresentationResponse();
            try
            {
                Presentation presentacionNueva = new ProductoService.Dominio.Presentation()
                {
                    NamePresentation = namePresentation,
                    Status = status,
                    Id = idPresentation
                };
                PresentationDAO.Modificar(presentacionNueva);
                presentationResponse.Id = presentacionNueva.Id;
                presentationResponse.NamePresentation = presentacionNueva.NamePresentation;
                presentationResponse.Status = presentacionNueva.Status;
                presentationResponse.DateCreated = presentacionNueva.DateCreated;
                presentationResponse.Result = "SUCCESS";
            }
            catch
            {
                presentationResponse.Result = "ERROR";
            }

            return presentationResponse;
        }
    }
}
