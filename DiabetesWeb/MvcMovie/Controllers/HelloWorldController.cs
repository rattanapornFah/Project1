using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MvcMovie.Controllers
{
    public class HelloWorldController : Controller
    {
        // 
        // GET: /HelloWorld/{action} 

        public ActionResult Index()
        {
            return View();
        }

        // 
        // GET: /HelloWorld/Welcome/ 
        //http://localhost:1234/HelloWorld/Welcome?name=Scott&numtimes=4
        //public string Welcome()
        //{
        //    return "This is the Welcome action method...";
        //} 
        //public string Welcome(string name, int numTimes = 1)
        //{
        //    return HttpUtility.HtmlEncode("Hello " + name + 
        //        ", NumTimes is: " + numTimes);
        //}
        //public string Welcome(string name, int ID = 1)
        //{
        //    return HttpUtility.HtmlEncode("Hello " + name + 
        //        ", ID: " + ID);
        //}
        public ActionResult Welcome(string name, int numTimes = 1)
        {
            ViewBag.Message = "Hello " + name;
            ViewBag.NumTimes = numTimes;

            return View();
        }



    }
}