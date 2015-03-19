using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.ServiceModel.Web;
using System.Text;

namespace ProductoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IService1" in both code and config file together.
    [ServiceContract]
    public interface IProducto
    {

        [OperationContract]
        ProductoService.Dominio.Producto crearProducto(string nameProduct, int status, int idPresentacion, decimal priceProduct, DateTime dateCreated,
                               decimal priceSale, DateTime expirationDate);
        [OperationContract]
        ProductoService.Dominio.Producto consultarProducto(int id);

        [OperationContract]
        ProductoService.Dominio.Presentation consultarPresentacion(int id);

        [OperationContract]
        ProductoService.Dominio.Presentation crearPresentacion(string namePresentation, int status, DateTime dateCreated);
    }


    
}
