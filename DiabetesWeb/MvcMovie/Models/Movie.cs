using System;
using System.ComponentModel.DataAnnotations;
using System.Data.Entity;

namespace MvcMovie.Models
{

    public class Movie
    {
        public int ID { get; set; }
        public string Title { get; set; }

        [Display(Name = "Release Date")]
        [DataType(DataType.Date)]
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime ReleaseDate { get; set; }
        public string Genre { get; set; }

        [Display(Name = "Price (THB)")]
        public decimal Price { get; set; }
    }
    public class Diabetes
    {
        [Key]

        public int admin_ID { get; set; }
        public string admin_name  { get; set; }
        public string admin_email { get; set; }
        //[Display(Name = "Price (THB)")]
        public string password { get; set; }
    }

    public class Knowladge
    {
        [Key]
        public int knowladge_ID { get; set; }
        public string topic { get; set; }
        public string detail { get; set; }   
        public string URL { get; set; }
    }
    public class MovieDBContext : DbContext
    {
        public DbSet<Movie> Movies { get; set; }
        public DbSet<Diabetes> diabetes { get; set; }

        public System.Data.Entity.DbSet<MvcMovie.Models.Knowladge> Knowladges { get; set; }
    }

}