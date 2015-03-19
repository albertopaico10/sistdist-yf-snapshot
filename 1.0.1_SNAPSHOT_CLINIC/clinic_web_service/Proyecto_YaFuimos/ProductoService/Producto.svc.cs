using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using ProductoService.Persistencia;
using System.Diagnostics;

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
            Debug.WriteLine("HHHHHHHH");
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
        
        public Dominio.Producto consultarProducto(int id)
        {
            return ProductoDAO.Obtener(id);
        }


        public bool validarExistenciaProducto(int idPresentacion, string nombreProduct)
        {
            return false;
        }
    }
}
