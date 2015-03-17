using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace ProductoServicesTest
{
    [TestClass]
    public class PacientesTest
    {
      
        /*[TestMethod]
        public void crearPaciente()
        {
            try{
                PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
                PacientesWS.Paciente usuarionuevo = proxy.crearPaciente("juan",
                    null, "46844382", new DateTime(), null, null, null,
                    null, new DateTime(), new DateTime(), 0, 0, 0, null, null);
                Assert.AreEqual("juan", usuarionuevo.Nombre);
                Assert.AreEqual("46844382", usuarionuevo.Dni);
            }
            catch (Exception e)
            {
                e.ToString();
            }
            
        }

        [TestMethod]
        public void obtenerPaciente()
        {
            PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
            PacientesWS.Paciente usuarionuevo = proxy.obtenerPaciente(3);
            Assert.AreEqual("Juan Luis", usuarionuevo.Nombre);
        }

        [TestMethod]
        public void modificarPaciente()
        {
            PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
            PacientesWS.Paciente usuarionuevo = proxy.ModificarPaciente(8007,"juan d",
                null, "46844382", new DateTime(), null, null, null,
                null, new DateTime(), new DateTime(), 0, 0, 0, null, null);
            Assert.AreEqual("juan d", usuarionuevo.Nombre);
        }

        [TestMethod]
        public void eliminarPaciente()
        {
            PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
            proxy.EliminarPaciente(7999);
            PacientesWS.Paciente usuarionuevo = proxy.obtenerPaciente(7999);
            Assert.IsNull(usuarionuevo);

        }*/
    }
}
