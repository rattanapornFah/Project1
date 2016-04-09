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
    public class KnowladgesController : Controller
    {
        private MovieDBContext db = new MovieDBContext();

        // GET: Knowladges
       
        public ActionResult Index(string topic, string searchString)
        {
            var GenreLst = new List<string>();
            var GenreQry = from d in db.Knowladges orderby d.topic select d.detail; GenreLst.AddRange(GenreQry.Distinct());
            ViewBag.movieGenre = new SelectList(GenreLst);
            var knowladge = from m in db.Knowladges select m;
            if (!String.IsNullOrEmpty(searchString))
            {
                knowladge = knowladge.Where(s => s.detail.Contains(searchString));
            } if (!string.IsNullOrEmpty(topic))
            {
                knowladge = knowladge.Where(x => x.topic == topic);
            }
            return View(knowladge);
        }


        // GET: Knowladges/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Knowladge knowladge = db.Knowladges.Find(id);
            if (knowladge == null)
            {
                return HttpNotFound();
            }
            return View(knowladge);
        }

        // GET: Knowladges/Create
        public ActionResult Create()
        {
            return View();
        }

        // POST: Knowladges/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "knowladge_ID,topic,detail,URL")] Knowladge knowladge)
        {
            if (ModelState.IsValid)
            {
                db.Knowladges.Add(knowladge);
                db.SaveChanges();
                return RedirectToAction("Index");
            }

            return View(knowladge);
        }

        // GET: Knowladges/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Knowladge knowladge = db.Knowladges.Find(id);
            if (knowladge == null)
            {
                return HttpNotFound();
            }
            return View(knowladge);
        }

        // POST: Knowladges/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "knowladge_ID,topic,detail,URL")] Knowladge knowladge)
        {
            if (ModelState.IsValid)
            {
                db.Entry(knowladge).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            return View(knowladge);
        }

        // GET: Knowladges/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            Knowladge knowladge = db.Knowladges.Find(id);
            if (knowladge == null)
            {
                return HttpNotFound();
            }
            return View(knowladge);
        }

        // POST: Knowladges/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            Knowladge knowladge = db.Knowladges.Find(id);
            db.Knowladges.Remove(knowladge);
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
