using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using MvcMovie.Models;

namespace MvcMovie.Controllers
{
    public class DiabetesController : Controller
    {
        private MovieDBContext db = new MovieDBContext();

        // GET: Diabetes
        public ActionResult Index()
        {
            return View(db.diabetes.ToList());
        }

        // GET: Diabetes/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Diabetes diabetes = db.diabetes.Find(id);
            if (diabetes == null)
            {
                return HttpNotFound();
            }
            return View(diabetes);
        }

        // GET: Diabetes/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Diabetes/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "admin_ID,admin_name,admin_email,password")] Diabetes diabetes)
        {
            if (ModelState.IsValid)
            {
                db.diabetes.Add(diabetes);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(diabetes);
        }

        // GET: Diabetes/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Diabetes diabetes = db.diabetes.Find(id);
            if (diabetes == null)
            {
                return HttpNotFound();
            }
            return View(diabetes);
        }

        // POST: Diabetes/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "admin_ID,admin_name,admin_email,password")] Diabetes diabetes)
        {
            if (ModelState.IsValid)
            {
                db.Entry(diabetes).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(diabetes);
        }

        // GET: Diabetes/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Diabetes diabetes = db.diabetes.Find(id);
            if (diabetes == null)
            {
                return HttpNotFound();
            }
            return View(diabetes);
        }

        // POST: Diabetes/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Diabetes diabetes = db.diabetes.Find(id);
            db.diabetes.Remove(diabetes);
            db.SaveChanges();
            return RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}
