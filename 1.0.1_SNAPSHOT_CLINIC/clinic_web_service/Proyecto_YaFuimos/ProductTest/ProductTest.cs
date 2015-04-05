using System.Net;
using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;
using System.Web.Script.Serialization;


namespace ProductTest
{
    [TestClass]
    public class ProductTest
    {
        [TestMethod]
        public void TestCreateProduct()
        {
            string postdata = "{\"NameProduct\":\"TesterKarina\",\"Status\":\"1\",\"IdPresentation\":\"1\",\"PriceProduct\":\"12.5\",\"PriceSale\":\"5.69\",\"ExpirationDate\":\"2015-03-31\"}";
            byte[] data = Encoding.UTF8.GetBytes(postdata);

            HttpWebRequest req = (HttpWebRequest)WebRequest.Create("http://localhost:53924/KardexService.svc/Producto");
            req.Method = "POST";
            req.ContentLength = data.Length;
            req.ContentType = "application/json";

            var reqStream = req.GetRequestStream();
            reqStream.Write(data, 0, data.Length);

            var res = (HttpWebResponse)req.GetResponse();
            StreamReader reader = new StreamReader(res.GetResponseStream());

            string productoJson = reader.ReadToEnd();
            JavaScriptSerializer js = new JavaScriptSerializer();

            Product productoCreado = js.Deserialize<Product>(productoJson);
            Console.Write(productoCreado.NameProduct);

           // Assert.AreEqual("SUCCESS",productoCreado.);
          
        }
    }
}
