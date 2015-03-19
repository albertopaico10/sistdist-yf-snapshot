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
    [XmlSerializerFormat(Style = OperationFormatStyle.Rpc, Use = OperationFormatUse.Encoded)]
    public interface IProducto
    {

        [OperationContract]
        int crearProducto(string nameProduct, int status, int idPresentacion, decimal priceProduct, string dateCreated,
                               decimal priceSale, string expirationDate);
        [OperationContract]
        ProductoService.Dominio.Producto consultarProducto(int id);

        [OperationContract]
        Boolean validarExistenciaProducto(int idPresentacion,String nombreProduct);
    }


    
}
