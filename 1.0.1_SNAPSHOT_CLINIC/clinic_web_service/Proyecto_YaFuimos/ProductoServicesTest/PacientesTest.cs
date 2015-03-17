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
      
        [TestMethod]
        public void crearPaciente()
        {
            try{
                DateTime dt = DateTime.Now; 
                PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
                PacientesWS.Paciente usuarionuevo = proxy.crearPaciente("juan",
                    null, "46844382", dt, null, null, null,
                    null, dt, dt, 0, 0, 0, null, null);
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
            DateTime dt = DateTime.Now; 
            PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
            PacientesWS.Paciente usuarionuevo = proxy.ModificarPaciente(8002,"juan d",
                null, "46844382", dt, null, null, null,
                null, dt, dt, 0, 0, 0, null, null);
            Assert.AreEqual("juan d", usuarionuevo.Nombre);
        }

        [TestMethod]
        public void eliminarPaciente()
        {
            PacientesWS.PacientesClient proxy = new PacientesWS.PacientesClient();
            proxy.EliminarPaciente(8002);
            PacientesWS.Paciente usuarionuevo = proxy.obtenerPaciente(8002);
            Assert.IsNull(usuarionuevo);

        }
    }
}
