using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using KardexServices.Response;
using KardexServices.Dominio;
using System.ServiceModel.Web;

namespace KardexServices
{
    [ServiceContract]
    public interface IKardexService
    {
        [OperationContract]
        [WebInvoke(Method="POST",UriTemplate="Kardex", ResponseFormat=WebMessageFormat.Json)]
        KardexResponse insertarKardex(Kardex beanRequest);

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "FindKardex/{idProduct}", ResponseFormat = WebMessageFormat.Json)]
        KardexResponse existProductKardex(string idProduct);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "DetailKardex", ResponseFormat = WebMessageFormat.Json)]
        DetailKardexResponse insertarDetail(DetailKardex beanRequest);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "UpdateKardex", ResponseFormat = WebMessageFormat.Json)]
        KardexResponse updateKardex(Kardex beanRequest);

        [OperationContract]
        [WebInvoke(Method = "POST", UriTemplate = "SaveKardex", ResponseFormat = WebMessageFormat.Json)]
        KardexResponse registrarProcessKardex(KardexRequest beanRequest);

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "FindProductByName/{nameProduct}", ResponseFormat = WebMessageFormat.Json)]
        ProductListResponse findProductByName(string nameProduct);

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "GetKardex/{idProduct}", ResponseFormat = WebMessageFormat.Json)]
        KardexResponse getKardex(string idProduct);

        [OperationContract]
        [WebInvoke(Method = "GET", UriTemplate = "GetDetailKardex/{idKardex}", ResponseFormat = WebMessageFormat.Json)]
        ListResponseDetailKardex getDetailKardex(string idKardex);
    }
}
