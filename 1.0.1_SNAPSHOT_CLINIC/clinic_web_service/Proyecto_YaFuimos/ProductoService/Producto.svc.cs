using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;
using ProductoService.Persistencia;

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
        public ProductoService.Dominio.Producto crearProducto(string nameProduct, int status, int idPresentacion, 
                                      decimal priceProduct, DateTime dateCreated, decimal priceSale, 
                                      DateTime expirationDate)
        {
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

            return ProductoDAO.Crear(productoNuevo);
        }




        public Dominio.Producto consultarProducto(int id)
        {
            return ProductoDAO.Obtener(id);
        }


        public Dominio.Presentation consultarPresentacion(int id)
        {
            return PresentationDAO.Obtener(id);
        }
    }
}
