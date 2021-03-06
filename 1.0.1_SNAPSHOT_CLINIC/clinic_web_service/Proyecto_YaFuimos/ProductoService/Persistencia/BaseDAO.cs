﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using NHibernate;

namespace ProductoService.Persistencia
{
    public class BaseDAO<Entidad, Id>
    {
        public Entidad Crear(Entidad entidad)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                sesion.Save(entidad);
                sesion.Flush();
            }
            return entidad;
        }
        
        public Entidad Obtener(Id id)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                return sesion.Get<Entidad>(id);
            }
        }
        
        public Entidad Modificar(Entidad entidad)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                sesion.Update(entidad);
                sesion.Flush();
            }
            return entidad;
        }
        
        public void Eliminar(Entidad entidad)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                sesion.Delete(entidad);
                sesion.Flush();
            }
        }
        
        public ICollection<Entidad> ListarTodos()
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                ICriteria busqueda = sesion.CreateCriteria(typeof(Entidad));
                return busqueda.List<Entidad>();
            }
        }

        public ICollection<Entidad> ListarTodosStatusActive(string table)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                //ICriteria busqueda = sesion.CreateCriteria(typeof(Entidad));
                string query = "from " + table+" where status=1";
                IQuery busqueda = sesion.CreateQuery(query);
                return busqueda.List<Entidad>();
            }
        }


        public ICollection<Entidad> ObtenerProductByName(string name)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                //ICriteria busqueda = sesion.CreateCriteria(typeof(Entidad));
                string query = "from Producto where status=1 and name like '%"+name+"%'";
                IQuery busqueda = sesion.CreateQuery(query);
                return busqueda.List<Entidad>();
            }
        }

        public Boolean validacionExisteNombrePresentacion(string name)
        {
            using (ISession sesion = NHibernateHelper.ObtenerSesion())
            {
                //ICriteria busqueda = sesion.CreateCriteria(typeof(Entidad));
                string query = "from Presentation where status=1 and namePresentation = '" + name + "'";
                IQuery busqueda = sesion.CreateQuery(query);
                int cantidad = busqueda.List<Entidad>().Count;
                Boolean returnValue = false;
                if (cantidad > 0) {
                    returnValue = true;
                }
                return returnValue;
            }
        }

    }
}